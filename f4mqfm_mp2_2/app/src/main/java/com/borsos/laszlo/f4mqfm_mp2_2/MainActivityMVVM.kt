package com.borsos.laszlo.f4mqfm_mp2_2

import MyLifecycleObserver
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.borsos.laszlo.f4mqfm_mp2_2.ui.theme.F4mqfm_mp2_2Theme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import com.borsos.laszlo.f4mqfm_mp2_2.MyScreen as MyScreen2


class MainActivityMVVM : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val observer = MyLifecycleObserver(this)
        lifecycle.addObserver(observer)

        setContent {
            F4mqfm_mp2_2Theme {
                MyScreen2()
            }
        }
    }
}

//@Composable
//fun MyScreen(viewModel: MainViewModel = viewModel()) {
//    val text by viewModel.text.collectAsState()
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(32.dp),
//        verticalArrangement = Arrangement.Center
//    ) {
//        Text(text = text, modifier = Modifier.padding(bottom = 16.dp))
//        TextField(
//            value = text,
//            onValueChange = { viewModel.onTextChange(it) },
//            modifier = Modifier.padding(bottom = 16.dp)
//        )
//        Button(onClick = {
//            viewModel.onTextChange(text) // átmásolás, bár már valós időben megy
//            viewModel.updateAfterDelay()
//        }) {
//            Text("Másol és indít háttérfolyamatot")
//        }
//    }
//}


@Composable
fun MyScreen() {
    var input by remember { mutableStateOf("") }
    var output by remember { mutableStateOf("") }
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = output, modifier = Modifier.padding(bottom = 16.dp))
        TextField(
            value = input,
            onValueChange = { input = it },
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Button(onClick = {
            output = input
            scope.launch {
                delay(3000)
                output = "Szöveg frissítve 3 másodperc után"
            }
        }) {
            Text("Másol és indít háttérfolyamatot")
        }
    }
}
