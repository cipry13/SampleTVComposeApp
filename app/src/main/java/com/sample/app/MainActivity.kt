package com.sample.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.focusRestorer
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.tv.foundation.PivotOffsets
import androidx.tv.foundation.lazy.list.TvLazyColumn
import androidx.tv.foundation.lazy.list.TvLazyRow
import androidx.tv.material3.Border
import androidx.tv.material3.CardDefaults
import androidx.tv.material3.CardLayoutDefaults
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.ShapeDefaults
import androidx.tv.material3.StandardCardLayout
import androidx.tv.material3.Text
import com.sample.app.ui.theme.SampleTVComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SampleTVComposeAppTheme {
                HomeScreen()
            }
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    val columnFocusRequester = remember { FocusRequester() }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.Black)
    ) {
        TvLazyColumn(
            pivotOffsets = PivotOffsets(0.15f),
            modifier = Modifier
                .align(Alignment.BottomStart)
                .fillMaxHeight(0.40f)
                .focusRequester(columnFocusRequester)
                .focusRestorer { columnFocusRequester }
        ) {
            items(count = 20) { _ ->
                HomeCollectionRow()
                Spacer(modifier = Modifier.height(32.dp))
            }
            item { Spacer(modifier = Modifier.height(24.dp)) }
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun HomeCollectionRow(
    modifier: Modifier = Modifier
) {
    val focusRequester = remember { FocusRequester() }

    Box(modifier = modifier) {
        TvLazyRow(
            pivotOffsets = PivotOffsets(0.05f),
            modifier = Modifier
                .focusRequester(focusRequester)
                .focusRestorer { focusRequester }
        ) {
            item { Spacer(modifier = Modifier.width(32.dp)) }

            items(
                count = 10,
                key = { it }
            ) { homeItemIndex ->
                HomeItem(index = homeItemIndex)
                Spacer(modifier = Modifier.width(16.dp))
            }

            item { Spacer(modifier = Modifier.width(32.dp)) }
        }
    }
}

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun HomeItem(
    index: Int,
    modifier: Modifier = Modifier
) {
    StandardCardLayout(
        imageCard = {
            CardLayoutDefaults.ImageCard(
                onClick = {},
                interactionSource = it,
                shape = CardDefaults.shape(shape = ShapeDefaults.ExtraSmall),
                colors = CardDefaults.colors(containerColor = Color.Transparent),
                border = CardDefaults.border(
                    focusedBorder = Border(
                        border = BorderStroke(width = 2.dp, color = Color.Red),
                        shape = ShapeDefaults.ExtraSmall
                    )
                ),
                content = {
                    Box(
                        modifier = modifier
                            .width(164.dp)
                            .background(color = Color.Blue)
                            .aspectRatio(16f / 9f)
                            .clip(ShapeDefaults.ExtraSmall),
                    )
                }
            )
        },
        title = {
            Text(
                text = "Title $index",
                maxLines = 1,
                style = MaterialTheme.typography.titleSmall,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
            )
        },
        modifier = modifier,
        contentColor = CardLayoutDefaults.contentColor(
            contentColor = Color.White.copy(alpha = 0.7f),
            focusedContentColor = Color.White
        )
    )
}