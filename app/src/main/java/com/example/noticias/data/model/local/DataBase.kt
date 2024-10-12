package com.example.noticias.data.model.local

import com.example.noticias.data.model.News

class DataBase{
    fun getList(): MutableList<String>{
        val list = list
        return list
    }
    fun newItem(item: String){
        list.add(item)

    }
    companion object{
       private var list: MutableList<String> = mutableListOf("teste")
    }
}