package com.sample.app.collections

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.focusRestorer
import androidx.compose.ui.unit.dp
import com.sample.app.HomeItem
import com.sample.app.PositionFocusedItemInLazyLayout

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun CollectionRow3By4(
    modifier: Modifier = Modifier
) {
    val focusRequester = remember { FocusRequester() }

    Box(modifier = modifier) {
        PositionFocusedItemInLazyLayout(parentFraction = 0.05f) {
            LazyRow(
                modifier = Modifier.focusRestorer { focusRequester }
            ) {
                item { Spacer(modifier = Modifier.width(88.dp)) }

                items(count = 10, key = { it }) { homeItemIndex ->
                    HomeItem(
                        index = homeItemIndex,
                        width = 240.dp,
                        aspectRatio = 3f / 4f,
                        modifier = if (homeItemIndex == 0) Modifier.focusRequester(focusRequester) else Modifier
                    )
                    Spacer(modifier = Modifier.width(32.dp))
                }

                item { Spacer(modifier = Modifier.width(32.dp)) }
            }
        }
    }
}