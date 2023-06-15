package com.diagnese.app.pages.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.diagnese.app.core.domain.usecase.firebase.FirebaseUseCase
import com.google.firebase.database.DataSnapshot
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(private val firebaseUseCase: FirebaseUseCase) : ViewModel() {

    init {
        getUser()
    }
    private val _user = MutableLiveData<DataSnapshot?>()
    val user : LiveData<DataSnapshot?> = _user


    private fun getUser() = viewModelScope.launch {
        val result = firebaseUseCase.getUser()
        _user.value = result
    }

}