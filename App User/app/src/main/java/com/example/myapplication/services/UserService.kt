package com.example.myapplication.services

import com.example.myapplication.modals.User
import retrofit2.Call
import retrofit2.http.*

interface UserService {
    @GET("users/{id}")
    suspend fun getUser(@Path("id") userId: Int): Call<User>

    @GET("users/")
    suspend fun getAllUser(): Call<List<User>>

    @POST("users/update/{id}")
    suspend fun updateUser(@Path("id") userId: Int, @Body user: User): Call<User>

    @DELETE("users/delete/{id}")
    suspend fun deleteUser(@Path("id") userId: Int): Call<Boolean>

    @POST("users/create/")
    suspend fun createUser(@Body user: User): Call<User>

}