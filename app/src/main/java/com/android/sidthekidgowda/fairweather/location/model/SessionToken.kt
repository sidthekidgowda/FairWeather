package com.android.sidthekidgowda.fairweather.location.model

import com.google.android.libraries.places.api.model.AutocompleteSessionToken

object SessionToken {

    private var sessionToken: AutocompleteSessionToken? = null

    fun getToken(): AutocompleteSessionToken {

        if (null == sessionToken) {
            sessionToken = AutocompleteSessionToken.newInstance()
        }
        return sessionToken!!
    }

    fun invalidateSessionToken() {
        sessionToken = null
    }
}