package app.sosocom.data.remote.api

import app.sosocom.data.remote.model.DataLoveResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface LoveCalculatorApi {
    @GET("/getPercentage")
    suspend fun getPercentage(
        @Header("X-RapidAPI-Host") host: String,
        @Header("X-RapidAPI-Key") key: String,
        @Query("sname") sName: String,
        @Query("fname") fName: String
    ): Response<DataLoveResponse>
}