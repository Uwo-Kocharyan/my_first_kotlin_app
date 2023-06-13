package com.example.mvvm.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm.model.User
import com.example.mvvm.model.UserData

class UserViewModel: ViewModel() {

   public val userList : MutableLiveData<List<User>> = MutableLiveData(listOf())
    init {
        userList.value = UserData.getUsers()
    }
    fun updateListUsers() {
        userList.value = UserData.getAnotherUsers()
    }
}