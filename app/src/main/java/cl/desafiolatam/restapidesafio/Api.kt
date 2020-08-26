package cl.desafiolatam.restapidesafio

import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("/users")
    fun getLista():Call<List<PojoLista>>
}