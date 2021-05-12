package kr.co.tabling.builder

import kr.co.tabling.service.RetroFitService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

object RetroFitBuilder {
    val DOMAIN = "https://picsum.photos/v2/"

    val builder = OkHttpClient.Builder()

    val service: RetroFitService
        get() {
            val retrofit = Retrofit.Builder()
                .baseUrl(DOMAIN)
                .addConverterFactory(JacksonConverterFactory.create())
                .client(builder.build())
                .build()

            return retrofit.create<RetroFitService>(RetroFitService::class.java!!)
        }
}


