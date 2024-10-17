package com.example.noticias.data.model.local

import com.example.noticias.data.model.News

class DataBase{
    fun readList(): MutableList<String>{
        val list = list
        return list
    }
    fun create(item: String){
        list.add(item)

    }
    companion object{
       private var list: MutableList<String> = mutableListOf()
    }
}