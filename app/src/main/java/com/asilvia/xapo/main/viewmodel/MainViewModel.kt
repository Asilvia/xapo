package com.asilvia.xapo.main.viewmodel

import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.asilvia.xapo.shared.model.Repositories
import com.asilvia.xapo.shared.repository.GithubRepositories
import kotlinx.coroutines.launch

class MainViewModel(val githubRepositories: GithubRepositories): ViewModel() {


    private val repositoriesObservable = MutableLiveData<Repositories>()
    private val snackbarObservable = MutableLiveData<String?>()


    fun dispatch(args: Bundle?) {
        getRepositories()
    }

    fun getSnackBarObservable() = snackbarObservable

    fun getRepositoryObservable() = repositoriesObservable

    private fun getRepositories() {
        viewModelScope.launch {
            val listRepositories = runCatching { githubRepositories.getRepositories() }
            listRepositories.onSuccess {
                repositoriesObservable.value = it
            }.onFailure {
                snackbarObservable.value = it.message.toString()
            }
        }
    }

}