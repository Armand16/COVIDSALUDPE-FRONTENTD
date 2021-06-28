package com.innovati.covidsaludpe.api

import com.innovati.covidsaludpe.models.PatientRequest
import com.innovati.covidsaludpe.models.RegisterRequest
import com.innovati.covidsaludpe.models.RegisterResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface Api {
    @POST("users/register-patient")
    fun registerUser(
        @Body patient: RegisterRequest
    ):Call<RegisterResponse>
//
//    @FormUrlEncoded
//    @POST("userlogin")
//    fun userLogin(
//        @Field("email") email:String,
//        @Field("password") password: String
//    ):Call<LoginResponse>
}