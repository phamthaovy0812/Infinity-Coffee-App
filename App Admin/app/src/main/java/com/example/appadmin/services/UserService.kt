package com.example.appadmin.services

import retrofit2.http.*
import com.example.appadmin.modals.User

interface UserService {
    @GET("user/{id}")
    suspend fun getUser(@Path("id") userId: Int): User

    @GET("user/")
    suspend fun getAllUser(): List<User>

    @POST("user/create")
    suspend fun createUser(@Body user: User): User

    @PUT("user/update/{id}")
    suspend fun updateUser(@Path("id") userId: Int, @Body user: User): User

    @DELETE("user/delete/{id}")
    suspend fun deleteUser(@Path("id") userId: Int): Boolean

    @PUT("user/disable/{id}")
    suspend fun disableUser(@Path("id") userId: Int): Boolean

    @PUT("user/enable/{id}")
    suspend fun enableUser(@Path("id") userId: Int): Boolean
}