package com.diagnese.app.core.domain.repository

import com.diagnese.app.core.data.state.Resource
import com.diagnese.app.core.domain.data.User
import com.google.android.gms.auth.api.identity.BeginSignInResult
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseReference
import kotlinx.coroutines.flow.Flow

interface IAuthRepository {

    val user : FirebaseUser?

    suspend fun login(email : String, password : String) : Resource<FirebaseUser>

    suspend fun register(email : String, password: String, user: User) : Resource<FirebaseUser>

    suspend fun loginWithGoogle(credential: AuthCredential) : Resource<AuthResult>


   suspend fun getUser() : DataSnapshot

    fun logout()
}