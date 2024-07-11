package com.sample.app.collections

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.focusRestorer
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.tv.material3.Text
import com.sample.app.Collection
import com.sample.app.HomeItem
import com.sample.app.PositionFocusedItemInLazyLayout

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun CollectionRow16By9(
    collection: Collection,
    modifier: Modifier = Modifier
) {
    val focusRequester = remember { FocusRequester() }

    Column(modifier = modifier) {
        Text(
            text = collection.title,
            modifier = Modifier.padding(start = 88.dp),
            color = Color.White,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            lineHeight = 20.sp,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1
        )
        Spacer(modifier = Modifier.height(16.dp))
        PositionFocusedItemInLazyLayout(parentFraction = 0.05f) {
            LazyRow(
                modifier = Modifier.focusRestorer { focusRequester }
            ) {
                item { Spacer(modifier = Modifier.width(88.dp)) }

                items(count = 10, key = { it }) { homeItemIndex ->
                    HomeItem(
                        index = homeItemIndex,
                        width = 640.dp,
                        aspectRatio = 16f / 9f,
                        focusedScale = 1f,
                        modifier = if (homeItemIndex == 0) Modifier.focusRequester(focusRequester) else Modifier
                    )
                    Spacer(modifier = Modifier.width(32.dp))
                }

                item { Spacer(modifier = Modifier.width(32.dp)) }
            }
        }
    }
}