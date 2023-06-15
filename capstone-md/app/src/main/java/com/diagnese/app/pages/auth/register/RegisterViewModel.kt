package com.diagnese.app.pages.auth.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.diagnese.app.core.data.state.Resource
import com.diagnese.app.core.domain.data.User
import com.diagnese.app.core.domain.usecase.firebase.FirebaseUseCase
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(private val firebaseUseCase: FirebaseUseCase) : ViewModel() {

    private val _registerState = MutableStateFlow<Resource<FirebaseUser>?>(null)

    fun register(email: String, password : String, user : User) = viewModelScope.launch {
        _registerState.value = Resource.Loading()
        val result = firebaseUseCase.register(email, password , user)
        _registerState.value = result
        }

    fun getUser(){
        viewModelScope.launch {
            firebaseUseCase.getUser()
        }
    }
}
