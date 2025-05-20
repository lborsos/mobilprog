package com.borsos.laszlo.f4mqfm_beadando_mp2_1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val _text = MutableLiveData("")
    val text: LiveData<String> = _text

    fun onTextChanged(newText: String) {
        _text.value = newText
    }
}
