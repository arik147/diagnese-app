package com.diagnese.app.pages.settings

import androidx.lifecycle.ViewModel
import com.diagnese.app.core.domain.usecase.firebase.FirebaseUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SettingsMenuViewModel @Inject constructor(private val firebaseUseCase: FirebaseUseCase): ViewModel() {

    fun logout(){
        firebaseUseCase.logout()
    }


}