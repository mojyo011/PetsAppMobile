package br.com.petsappmobile.http

import br.com.petsappmobile.model.RespostaLogin
import br.com.petsappmobile.model.Usuario
import com.google.gson.Gson
import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody

class HttpHelper {

    fun login(email: String, password: String) : RespostaLogin{

        //criando url do endpoint no servidor
        val URL = "http://192.168.1.106:8000/api/v1/login"

        //criando um cliente http
        val client = OkHttpClient()

        val gson = Gson()

        val usuarioRequest = Usuario()
        usuarioRequest.email = email
        usuarioRequest.password = password

        val requestBody = gson.toJson(usuarioRequest)
        println(">>>>>>>>>>>>>>>>$$$$$$$$$$$" + requestBody)

        //construindo a requisição http para o servidor
        val headerHttp = MediaType.parse("application/json; charset=utf-8")
        val body = RequestBody.create(headerHttp, requestBody)

        val request = Request.Builder().url(URL).post(body).build()
        val response = client.newCall(request).execute()

        //extraindo o json do body da resposta
        val responseBody = response.body()?.string()


        var respostaLogin = RespostaLogin()

        //criando um objeto usuario

        //transformando o corpo da requisição em string

//        var gson = Gson()

        //transformando em uma classe do kotlin
        respostaLogin = gson.fromJson(responseBody, RespostaLogin::class.java)

        println(responseBody)
        return respostaLogin
    }
}