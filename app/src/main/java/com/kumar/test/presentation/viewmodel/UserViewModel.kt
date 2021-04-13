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

    private val errorHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        onError(throwable)
    }

    private fun getUserList() {
        viewModelScope.launch(errorHandler) {
            getUsersUseCase.execute().collect {
                _userList.postValue(it)
            }
        }
    }


    private fun onError(throwable: Throwable) {
        Log.e("Error", "Error getting the user list", throwable)
    }


}

