package com.kumar.test.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kumar.test.data.model.UserResponse
import com.kumar.test.domain.usecase.GetUsersUseCase
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class UserViewModel(private val getUsersUseCase: GetUsersUseCase) : ViewModel() {

    private val _userList = MutableLiveData<List<UserResponse>>()
    val userList: LiveData<List<UserResponse>> get() = _userList

    private val _selectedUser = MutableLiveData<UserResponse>()
    val selectedUser: LiveData<UserResponse> get() = _selectedUser

    private val errorHandler = CoroutineExceptionHandler { _, throwable ->
        onError(throwable)
    }

    fun getUserList() {
        viewModelScope.launch(errorHandler) {
            getUsersUseCase.execute().collect {
            Log.e("Kumi", "response: $it")

             //   processResponse(it)
            }
        }
    }

    private fun processResponse(list: List<UserResponse>) {
        _userList.postValue(list)

        if (list.isNotEmpty()){
            _selectedUser.postValue(list[0])
        }
    }


    private fun onError(throwable: Throwable) {
        Log.e("Error", "Error getting the user list", throwable)
    }

    fun onItemSelect(selectedUser: UserResponse) {
    _selectedUser.postValue(selectedUser)
    }


}

