package com.borsos.laszlo.finalprojectapplication

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SensorActivity : AppCompatActivity(), SensorEventListener {

    private lateinit var sensorManager: SensorManager
    private var temperatureSensor: Sensor? = null

    private lateinit var textViewX: TextView
    private lateinit var textViewY: TextView
    private lateinit var textViewZ: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sensor)

        textViewX = findViewById(R.id.textViewX)
        textViewY = findViewById(R.id.textViewY)
        textViewZ = findViewById(R.id.textViewZ)

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        temperatureSensor = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE)

        if (temperatureSensor == null) {
            textViewX.text = "Temperature sensor not available"
            textViewY.text = ""
            textViewZ.text = ""
        }
    }

    override fun onResume() {
        super.onResume()
        temperatureSensor?.let {
            sensorManager.registerListener(this, it, SensorManager.SENSOR_DELAY_NORMAL)
        }
    }

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)
    }

    override fun onSensorChanged(event: SensorEvent?) {
        event?.let {
            val temperature = event.values[0]
            textViewX.text = "Temperature X: $temperature °C"
            textViewY.text = "Temperature Y: $temperature °C"
            textViewZ.text = "Temperature Z: $temperature °C"
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        //...
    }
}
