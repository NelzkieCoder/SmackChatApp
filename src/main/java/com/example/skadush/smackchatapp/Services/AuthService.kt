package com.example.skadush.smackchatapp.Services

import android.app.VoiceInteractor
import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.skadush.smackchatapp.Utilities.URL_REGISTER
import org.json.JSONObject

object AuthService {
    fun registerUser(context: Context, email: String, password: String, complete: (Boolean) -> Unit) {
        val url = null;

        val jsonBody = JSONObject()
        jsonBody.put("email", email)
        jsonBody.put("password", password)
        val requestBody = jsonBody.toString()


        // TODO: search about this "object" in kotlin and how it works
        val registerRequest = object : StringRequest(Request.Method.POST, URL_REGISTER, Response.Listener {
            complete(true)
        }, Response.ErrorListener { error ->
            Log.d("ERROR", "Could not register User $error")
            complete(false)
        }) {
            override fun getBodyContentType(): String {
                return "application/json; charset=utf-8"
            }

            override fun getBody(): ByteArray {
                return requestBody.toByteArray()
            }

        }

        Volley.newRequestQueue(context).add(registerRequest)
    }

}