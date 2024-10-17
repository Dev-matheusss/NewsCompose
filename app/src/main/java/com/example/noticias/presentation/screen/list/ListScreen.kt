package com.example.noticias.presentation.screen.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.noticias.R
import com.example.noticias.data.model.News
import com.example.noticias.data.model.local.DataBase

@Composable
fun ListScreen(
    navigateTo: () -> Unit = {}
){
    val dataBase = DataBase()
    val newsList = dataBase.readList()
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(
            count = newsList.size,
        ) { inteiro ->
            val item = newsList[inteiro]
            NewItem(navigateTo,inteiro, News(title = item))
        }
    }
}

fun isPair(value: Int) = value % 2 == 0


@Composable
fun NewItem(
    navigateTo: () -> Unit,
    inteiro: Int,
    news: News
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(percent = 5))
            .background(
                if (isPair(inteiro)) {
                    Color.White
                } else {
                    colorResource(R.color.purple_200)
                }
            )
            .padding(8.dp)
    ) {
        Text(text = news.title)
        Text(text = news.description)
        Text(text = news.message)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Button(
                onClick = {
                    navigateTo()
                }
            ) {
                Text(stringResource(id = R.string.button_ver))
            }
        }
    }


}

@Composable
@Preview(showBackground = true)
fun ListScreenPreview() {
    ListScreen()
}

