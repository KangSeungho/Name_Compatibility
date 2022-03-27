package app.sosocom.data.utils.base

import android.util.Log
import app.sosocom.domain.utils.ErrorType
import app.sosocom.domain.utils.RemoteErrorEmitter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException

open class BaseDataSource {
    companion object {
        private const val MESSAGE_KEY = "message"
        private const val ERROR_KEY = "error"
    }

    suspend inline fun <T> safeApiCall(emitter: RemoteErrorEmitter, crossinline callFunction: suspend () -> T): T? {
        var myObject: T? = null
        try {
            myObject = withContext(Dispatchers.IO) { callFunction.invoke() }
        } catch (e: Exception) {
            withContext(Dispatchers.Main) {
                Log.e("BaseRemoteRepo", "Call error: ${e.localizedMessage}", e.cause)
                when(e) {
                    is HttpException -> {
                        if(e.code() == 401) emitter.onError(ErrorType.SESSION_EXPIRED)
                        else {
                            val body = e.response()?.errorBody()
                            emitter.onError(getErrorMessage(body))
                        }
                    }
                    is SocketTimeoutException -> emitter.onError(ErrorType.TIMEOUT)
                    is IOException -> emitter.onError(ErrorType.NETWORK)
                    else -> emitter.onError(ErrorType.UNKNOWN)
                }
            }
        }

        return myObject
    }

    inline fun <T> safeApiCallNoContext(emitter: RemoteErrorEmitter, callFunction: () -> T): T? {
        var myObject: T? = null
        try {
            myObject = callFunction.invoke()
        } catch (e: Exception) {
            Log.e("BaseRemoteRepo", "Call error: ${e.localizedMessage}", e.cause)
            when(e) {
                is HttpException -> {
                    if(e.code() == 401) emitter.onError(ErrorType.SESSION_EXPIRED)
                    else {
                        val body = e.response()?.errorBody()
                        emitter.onError(getErrorMessage(body))
                    }
                }
                is SocketTimeoutException -> emitter.onError(ErrorType.TIMEOUT)
                is IOException -> emitter.onError(ErrorType.NETWORK)
                else -> emitter.onError(ErrorType.UNKNOWN)
            }
        }

        return myObject
    }

    fun getErrorMessage(responseBody: ResponseBody?): String {
        return try {
            val jsonObject = JSONObject(responseBody!!.string())
            when {
                jsonObject.has(MESSAGE_KEY) -> jsonObject.getString(MESSAGE_KEY)
                jsonObject.has(ERROR_KEY) -> jsonObject.getString(ERROR_KEY)
                else -> "Something wrong happened"
            }
        } catch (e: Exception) {
            "Something wrong happened"
        }
    }
}