package com.dorsetcollege.httpdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fetchJson()
    }

    private fun fetchJson() {

        Log.i("HTTPDEMO", "LOADING JSON")

        var url = "https://my-json-server.typicode.com/johnrowley/demojson/posts"

        Log.i("HTTPDEMO", "url = $url")


        val request = Request.Builder().url(url).build()

        val client = OkHttpClient()

        client.newCall(request).enqueue(object: Callback {

            override fun onFailure(call: Call, e: IOException) {
                println("FAiled to load json")
            }

            override fun onResponse(call: Call, response: Response) {
                println("successfully loaded json")

                val body = response?.body?.string()
                println(body)

                if (body != null) {
                    Log.i("HTTPDEMO", body)
                }

            }



        })


    }
}