package com.kumar.test.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kumar.test.data.model.ShowResponse
import com.kumar.test.domain.usecase.GetShowsUseCase
import com.kumar.test.domain.usecase.SortListByScoreUseCase
import com.kumar.test.domain.usecase.SortListByTimeUseCase
import com.kumar.test.domain.usecase.SortListByTitleUseCase
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class ShowViewModel(
    private val getShowsUseCase: GetShowsUseCase,
    private val sortListByTimeUseCase: SortListByTimeUseCase,
    private val sortListByScoreUseCase: SortListByScoreUseCase,
    private val sortListByTitleUseCase: SortListByTitleUseCase,
) : ViewModel() {

    private val _showList = MutableLiveData<List<ShowResponse>>()
    val showList: LiveData<List<ShowResponse>> get() = _showList

    private val _selectedShow = MutableLiveData<ShowResponse>()
    val selectedShow: LiveData<ShowResponse> get() = _selectedShow

    private val errorHandler = CoroutineExceptionHandler { _, throwable ->
        onError(throwable)
    }

    fun getShowList(showName: String) {
        viewModelScope.launch(errorHandler) {
            getShowsUseCase.execute(showName).collect {
                processResponse(it)
            }
        }
    }

    private fun processResponse(list: List<ShowResponse>) {
        _showList.postValue(list)

        if (list.isNotEmpty()) {
            _selectedShow.postValue(list[0])
        }
    }


    private fun onError(throwable: Throwable) {
        Log.e("Error", "Error getting the show list", throwable)
    }

    fun onItemSelect(selectedUser: ShowResponse) {
        _selectedShow.postValue(selectedUser)
    }

    fun sortByTitle() {
        _showList.value?.let {
            _showList.postValue(sortListByTitleUseCase.execute(it))
        }

    }

    fun sortByScore() {
        _showList.value?.let {
            _showList.postValue(sortListByScoreUseCase.execute(it))
        }

    }

    fun sortByTime() {
        _showList.value?.let {
            _showList.postValue(sortListByTimeUseCase.execute(it))
        }
    }


}

