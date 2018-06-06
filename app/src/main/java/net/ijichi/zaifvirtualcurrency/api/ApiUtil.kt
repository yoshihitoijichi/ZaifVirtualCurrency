package net.ijichi.zaifvirtualcurrency.api

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import net.ijichi.zaifvirtualcurrency.MySharedPreferences.accessToken
import net.ijichi.zaifvirtualcurrency.api.model.enum.TradeType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber
import java.util.concurrent.TimeUnit

/**
 * api utility
 * Created by ijichiyoshihito on 2018/01/09.
 */
object ApiUtil{

    enum class UrlType(val url: String){
        BIT_FLYER("https://api.bitflyer.jp"),
        COIN_CHECK("https://coincheck.com"),
        ZAIF("https://api.zaif.jp/api/1/")
    }

    val gson: Gson
        get() {
            val typeAdapters = mapOf(
                TradeType.adapter
            )

            return GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .let {
                    typeAdapters.forEach { e ->
                        it.registerTypeAdapter(e.key, e.value)
                    }
                    it
                }
                .create()
        }


    fun <T> generateCaller(clazz: Class<T>, urlType: UrlType): T {
        val httpClient = createClient()
        val baseUrl = urlType.url

        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(httpClient)
            .build()

        return retrofit.create(clazz)
    }

    fun createClient(): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        httpClient.followRedirects(true)
        httpClient.readTimeout(60, TimeUnit.SECONDS)
        httpClient.connectTimeout(60, TimeUnit.SECONDS)
//        httpClient.addInterceptor { chain ->
//            chain.request().let {
//                val builder = it.newBuilder()
//                builder.addHeader("Content-Type", "application/json; charset=utf-8")
//                builder.addHeader("X-App-Key", "jU_1eJ-0RcGLpTO-Pb803I1jbDjXZ4eM")
//                accessToken?.let {
//                    Timber.i("accessToken = $it")
//                    builder.addHeader("Authorization", it)
//                }
//                chain.proceed(builder.method(it.method(), it.body()).build())
//            }
//        }
        return httpClient.build()
    }

}