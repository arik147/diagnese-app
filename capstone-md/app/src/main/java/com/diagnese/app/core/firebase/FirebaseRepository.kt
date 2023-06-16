package com.diagnese.app.core.firebase

import com.diagnese.app.core.data.state.Resource
import com.diagnese.app.core.domain.data.User
import com.diagnese.app.core.domain.repository.IAuthRepository
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class FirebaseRepository @Inject constructor(
    private val firebaseAuth: FirebaseAuth,
    private val firebaseDatabase : FirebaseDatabase
    ) : IAuthRepository {

    override val user: FirebaseUser?
        get() = firebaseAuth.currentUser

    override suspend fun login(email: String, password: String): Resource<FirebaseUser> {
        return try {
            val result = firebaseAuth.signInWithEmailAndPassword(email, password).await()
            return Resource.Success(result.user!!)
        } catch (e : Exception){
           Resource.Error(e.toString())
        }
    }

    override suspend fun register(
        email: String,
        password: String,
        user: User
    ): Resource<FirebaseUser> {
        return try {
                val result = firebaseAuth.createUserWithEmailAndPassword(email, password).await()
                firebaseDatabase.getReference("Users").child(firebaseAuth.currentUser!!.uid).setValue(user).await()
                return Resource.Success(result.user!!)
            } catch (e : Exception){
                Resource.Error(e.toString())
            }

    }

    override suspend fun loginWithGoogle(credential: AuthCredential): Resource<AuthResult> {
        return try {

            val googleSignIn = firebaseAuth.signInWithCredential(credential).await()
            Resource.Success(googleSignIn)

        } catch (e : Exception){
            e.printStackTrace()
            Resource.Error(e.toString())
        }
    }

    override suspend fun getUser(): DataSnapshot {
        return try {
            val users = firebaseDatabase.getReference("Users").child(firebaseAuth.uid ?: "").get().await()
            users
        }catch (e : Exception){
            e.printStackTrace()
             throw e
        }
    }


    override fun logout() {
        firebaseAuth.signOut()
    }


}