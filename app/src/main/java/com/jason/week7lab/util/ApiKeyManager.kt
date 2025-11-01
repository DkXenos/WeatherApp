package com.jason.week7lab.util

object ApiKeyManager {
    private var apiKey: String = ""

    fun setApiKey(key: String) {
        apiKey = key
    }

    fun getApiKey(): String {
        return apiKey
    }

    fun hasApiKey(): Boolean {
        return apiKey.isNotEmpty()
    }
}

