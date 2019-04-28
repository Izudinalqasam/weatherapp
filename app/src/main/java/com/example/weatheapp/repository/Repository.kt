package com.example.weatheapp.repository

import com.example.weatheapp.network.Retrofit

class Repository {

    companion object{
        private var instance: Repository? = null

        fun getInstance(): Repository{
            return instance ?: Repository()
        }
    }

    fun getDataSource() = Retrofit.instance
}