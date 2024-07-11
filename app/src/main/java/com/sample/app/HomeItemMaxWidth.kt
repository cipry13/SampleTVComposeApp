package com.sample.app

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.tv.material3.Border
import androidx.tv.material3.Card
import androidx.tv.material3.CardContainerDefaults
import androidx.tv.material3.CardDefaults
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.ShapeDefaults
import androidx.tv.material3.StandardCardContainer
import androidx.tv.material3.Text

@Composable
fun HomeItemMaxWidth(
    index: Int,
    aspectRatio: Float,
    modifier: Modifier = Modifier
) {
    StandardCardContainer(
        imageCard = {
            Card(
                onClick = {},
                interactionSource = it,
                shape = CardDefaults.shape(shape = ShapeDefaults.ExtraSmall),
                colors = CardDefaults.colors(containerColor = Color.Transparent),
                scale = CardDefaults.scale(focusedScale = 1f),
                border = CardDefaults.border(
                    focusedBorder = Border(
                        border = BorderStroke(width = 2.dp, color = Color.Red),
                        shape = ShapeDefaults.ExtraSmall
                    )
                ),
                content = {
                    Box(
                        modifier = Modifier
                            .padding(start = 136.dp)
                            .fillMaxWidth()
                            .aspectRatio(aspectRatio)
                            .background(color = Color.Blue)
                            .clip(ShapeDefaults.ExtraSmall),
                    )
                }
            )
        },
        title = {
            Text(
                text = "HomeItemMaxWidth $index",
                maxLines = 1,
                style = MaterialTheme.typography.titleSmall,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
            )
        },
        modifier = modifier.fillMaxWidth(),
        contentColor = CardContainerDefaults.contentColor(
            contentColor = Color.White.copy(alpha = 0.7f),
            focusedContentColor = Color.White
        )
    )
}
