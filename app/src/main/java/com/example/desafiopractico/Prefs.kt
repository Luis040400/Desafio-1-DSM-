package com.example.desafiopractico

import android.content.Context

class Prefs(context: Context) {

    val SHARED_NAME = "Mydbtb"
    val SHARED_USER_NAME = "username"
    val SHARE_USER_PASSWORD = "password"

    val storage = context.getSharedPreferences(SHARED_NAME,0)

    fun saveName(usuario:String){
        storage.edit().putString(SHARED_USER_NAME,usuario).apply()
    }

    fun saveContraseña(contraseña:String){
        storage.edit().putString(SHARE_USER_PASSWORD,contraseña).apply()
    }
    fun getName():String{
        return storage.getString(SHARED_USER_NAME,"")!!
    }
    fun getPassword():String{
        return storage.getString(SHARE_USER_PASSWORD,"")!!
    }

    fun wipe(){
        storage.edit().clear().apply()
    }
}