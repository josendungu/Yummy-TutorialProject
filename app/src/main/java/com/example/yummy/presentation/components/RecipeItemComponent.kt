package com.example.yummy.presentation.components


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.example.yummy.common.Constants
import com.example.yummy.common.util.loadPicture
import com.example.yummy.domain.model.RecipeDetail

@Composable
fun RecipeItemComponent(
    recipe: RecipeDetail,
    onClick: () -> Unit
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp, horizontal = 30.dp)
            .clickable { onClick() },
        shape = MaterialTheme.shapes.small,
        backgroundColor = MaterialTheme.colors.primary,
        elevation = 7.dp,
    ) {
        Column {
            val image = loadPicture(
                url = recipe.featured_image,
                defaultImage = Constants.DEFAULT_RECIPE_IMAGE
            ).value

            image?.let {
                Image(
                    bitmap = it.asImageBitmap(),
                    contentDescription = "",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    contentScale = ContentScale.Crop
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp, bottom = 12.dp, start = 7.dp, end = 7.dp)
            ) {
                Text(
                    text = recipe.title,
                    modifier = Modifier
                        .fillMaxWidth(0.85f)
                        .wrapContentWidth(Alignment.Start),
                    style = MaterialTheme.typography.h5,
                    color = Color.White
                )

                Text(
                    text = recipe.rating.toString(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(Alignment.End)
                        .align(Alignment.CenterVertically),
                    style = MaterialTheme.typography.h6,
                    color = Color.White
                )
            }
        }
    }

}


