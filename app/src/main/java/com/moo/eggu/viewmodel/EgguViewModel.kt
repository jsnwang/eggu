package com.moo.eggu.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class EgguViewModel: ViewModel() {

    private var _taskList: MutableLiveData<List<Task>> = MutableLiveData(emptyList())
    val taskList: LiveData<List<Task>> get() = _taskList

    val countdownFlow = flow<Int> {
        val start = 10
        var current = start
        emit(current)
        while (current > 0) {
            delay(1000)
            current--
            emit(current)
        }
    }
    var name: String = ""
    var time: String = ""
    private val tmpList = mutableListOf<Task>()

    fun addTask() {
        tmpList.add(Task(name, time))
        _taskList.value = tmpList

        name = ""
        time = ""
    }

    init {
        collectFlow()
    }
    private fun collectFlow() {
        viewModelScope.launch {
            countdownFlow.collect() {time ->
                println("The current time is $time")
            }
        }
    }
}