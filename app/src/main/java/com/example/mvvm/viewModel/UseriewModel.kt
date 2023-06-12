package com.example.mvvm.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm.model.User
import com.example.mvvm.model.UserData

class UseriewModel: ViewModel() {

    var userList : MutableLiveData<List<User>> = MutableLiveData(listOf())

    //инициализируем список и заполняем его данными пользователей
    init {
        userList.value = UserData.getUsers()
    }
    fun getListUsers() = userList

    //для обновления списка передаем второй список пользователей
    fun updateListUsers() {
        userList.value = UserData.getAnotherUsers()
    }
}