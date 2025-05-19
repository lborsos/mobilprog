import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner


class MyLifecycleObserver(private val context: Context) : LifecycleEventObserver {
    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        when (event) {
            Lifecycle.Event.ON_START -> {
                Log.d("MyObserver", "MainActivity elindult (ON_START)")
                Toast.makeText(context, "Elindult az Activity", Toast.LENGTH_SHORT).show()
            }
            Lifecycle.Event.ON_STOP -> {
                Log.d("MyObserver", "MainActivity leállt (ON_STOP)")
                Toast.makeText(context, "Leállt az Activity", Toast.LENGTH_SHORT).show()
            }
            else -> {}
        }
    }
}