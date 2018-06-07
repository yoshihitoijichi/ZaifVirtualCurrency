package net.ijichi.zaifvirtualcurrency.api.service

import android.net.Uri
import net.ijichi.zaifvirtualcurrency.api.ApiUtil
import net.ijichi.zaifvirtualcurrency.api.model.entity.StreamStatus
import net.ijichi.zaifvirtualcurrency.api.model.enum.ExchangeType
import okhttp3.Request
import okhttp3.Response
import okhttp3.WebSocket
import okhttp3.WebSocketListener
import okio.ByteString
import timber.log.Timber


/**
 * StreamStatus service
 * Created by ijichiyoshihito on 2018/06/05.
 */

class StreamService {

    private val normalClosureStatus = 1000
    private var ws: WebSocket? = null

    fun start(exchangeType: ExchangeType, onUpdate: (StreamStatus) -> Unit) {
        Timber.i("start exchangeType:$exchangeType")
        val queryBuilder = Uri.Builder()
        queryBuilder.appendQueryParameter("currency_pair", exchangeType.name.toLowerCase())
        val urlStr = "wss://ws.zaif.jp:8888/stream$queryBuilder"

        val client = ApiUtil.createClient()
        val request = Request.Builder().url(urlStr).build()
        ws = client.newWebSocket(request, object : WebSocketListener() {
            override fun onOpen(webSocket: WebSocket, response: Response) {
                Timber.i("onOpen : $response")
            }

            override fun onMessage(webSocket: WebSocket, text: String) {
                onMessage(text, onUpdate)
            }

            override fun onMessage(webSocket: WebSocket?, bytes: ByteString?) {
                Timber.i("onMessage bytes : $bytes")
            }

            override fun onClosed(webSocket: WebSocket?, code: Int, reason: String?) {
                Timber.i("onClosed code : $code, reason : $reason")
            }

            override fun onFailure(webSocket: WebSocket?, t: Throwable?, response: Response?) {
                t?.printStackTrace()
            }
        })

        client.dispatcher().executorService().shutdown()
    }

    private fun onMessage(message: String, onUpdate: (StreamStatus) -> Unit) {
        val status = try {
            ApiUtil.gson.fromJson(message, StreamStatus::class.java)
        } catch (e: Exception) {
            Timber.e(e)
            return
        }

        onUpdate(status)
    }

    fun disconnect() {
        ws?.close(normalClosureStatus, "disconnect")
    }
}
