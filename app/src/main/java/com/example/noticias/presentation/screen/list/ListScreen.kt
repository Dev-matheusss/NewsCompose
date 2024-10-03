package com.example.noticias.presentation.screen.list

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.noticias.data.model.News

@Composable
@Preview
fun ListScreen() {
    val newsList = List(500) { new ->
        News(
            title = "Titulo ${new}",
            description = "Descricao ${new}",
            message = "Mensagem ${new}",
            false
        )
    }

    LazyColumn {
        items(
           count =  newsList.size
        ) {
            Text(
                text = newsList[it].title,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
fun CardNews(news: News) {

}

