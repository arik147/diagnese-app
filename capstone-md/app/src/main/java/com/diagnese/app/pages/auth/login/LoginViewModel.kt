package com.diagnese.app.pages.auth.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.diagnese.app.core.data.state.Resource
import com.diagnese.app.core.domain.usecase.firebase.FirebaseUseCase
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val firebaseUseCase: FirebaseUseCase) : ViewModel() {

   private val _loginState = MutableStateFlow<Resource<FirebaseUser>?>(null)
   val loginState : StateFlow<Resource<FirebaseUser>?> = _loginState


    private val _googleSignInState = MutableStateFlow<Resource<AuthResult>?>(null)
    val googleSignInState : StateFlow<Resource<AuthResult>?> = _googleSignInState


    fun login(email : String, password : String) = viewModelScope.launch {
        _loginState.value = Resource.Loading()
        val result = firebaseUseCase.login(email, password)
        _loginState.value = result
    }

    fun loginWithGoogle(credential: AuthCredential) = viewModelScope.launch {
       _googleSignInState.value = Resource.Loading()
        val result = firebaseUseCase.loginWithGoogle(credential)
        _googleSignInState.value = result
    }


}