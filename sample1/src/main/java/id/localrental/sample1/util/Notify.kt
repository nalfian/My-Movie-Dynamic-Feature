package id.localrental.sample1.util

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import id.localrental.sample1.model.ResponseError

import java.io.Reader

object Notify {

    fun getMessageError(charStream: Reader): String? {
        val gson = Gson()
        val type = object : TypeToken<ResponseError>() {}.type
        val errorResponse: ResponseError? = gson.fromJson(charStream, type)
        return errorResponse?.errors?.get(0)
    }
}