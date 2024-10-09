package com.example.motivation.ui

import android.content.Context
import android.content.SharedPreferences

class SecurityPreferences(context: Context) {

    private val security: SharedPreferences = context.getSharedPreferences("Motivation", Context.MODE_PRIVATE)

    fun StoreString(key: String, str: String) {
        security.edit().putString(key, str).apply()
    }

    fun getString(key: String): String {
        return security.getString(key, "") ?: ""
    }


}