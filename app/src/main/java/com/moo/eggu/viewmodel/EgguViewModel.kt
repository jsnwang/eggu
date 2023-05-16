package com.moo.eggu.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EgguViewModel: ViewModel() {

    private var _taskList: MutableLiveData<List<Task>> = MutableLiveData(emptyList())
    val taskList: LiveData<List<Task>> get() = _taskList

    var name: String = ""
    var time: Int = 0

    private val tmpList = mutableListOf<Task>()

    fun addTask() {
        tmpList.add(Task(name, time))
        _taskList.value = tmpList

        name = ""
        time = 0
    }
}