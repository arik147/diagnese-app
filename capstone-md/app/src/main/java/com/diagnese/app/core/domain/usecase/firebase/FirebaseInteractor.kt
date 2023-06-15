package com.diagnese.app.core.domain.usecase.firebase

import com.diagnese.app.core.data.state.Resource
import com.diagnese.app.core.domain.data.User
import com.diagnese.app.core.domain.repository.IAuthRepository
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DataSnapshot
import javax.inject.Inject

class FirebaseInteractor @Inject constructor(private val firebaseRepository: IAuthRepository) : FirebaseUseCase {


    override val firebaseUser: FirebaseUser?
        get() = firebaseRepository.user

    override suspend fun login(email: String, password: String): Resource<FirebaseUser> {
        return firebaseRepository.login(email, password)
    }

    override suspend fun register(
        email: String,
        password: String,
        user: User
    ): Resource<FirebaseUser> {
        return firebaseRepository.register(email, password, user)
    }

    override suspend fun loginWithGoogle(credential: AuthCredential): Resource<AuthResult> {
        return firebaseRepository.loginWithGoogle(credential)
    }

    override suspend fun getUser(): DataSnapshot {
        return firebaseRepository.getUser()
    }


    override fun logout() {
       firebaseRepository.logout()
    }


}