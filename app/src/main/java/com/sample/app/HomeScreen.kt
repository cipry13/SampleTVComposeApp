package com.sample.app

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.focusRestorer
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.sample.app.collections.CollectionRow16By6
import com.sample.app.collections.CollectionRow16By9
import com.sample.app.collections.CollectionRow3By4
import com.sample.app.collections.CollectionRow4By3

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    val columnFocusRequester = remember { FocusRequester() }

    val collections = HomeCollections

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.Black)
    ) {
        Box(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .fillMaxHeight(0.24f)
                .fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .height(1.dp)
                    .fillMaxWidth()
                    .background(color = Color.Green)
            )
        }

        PositionFocusedItemInLazyLayout(parentFraction = 0.24f) {
            LazyColumn(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .fillMaxSize()
                    .focusRestorer { columnFocusRequester }
            ) {
                item { Spacer(modifier = Modifier.height(132.dp)) }

                items(count = collections.count()) { index ->
                    val collection = collections[index]

                    when (collection.type) {
                        CollectionType.COLLECTION_3_4 -> {
                            CollectionRow3By4(
                                modifier = if (index == 0) Modifier.focusRequester(
                                    columnFocusRequester
                                ) else Modifier
                            )
                        }

                        CollectionType.COLLECTION_4_3 -> {
                            CollectionRow4By3(
                                modifier = if (index == 0) Modifier.focusRequester(
                                    columnFocusRequester
                                ) else Modifier
                            )
                        }

                        CollectionType.COLLECTION_16_6 -> {
                            CollectionRow16By6(
                                modifier = if (index == 0) Modifier.focusRequester(
                                    columnFocusRequester
                                ) else Modifier
                            )
                        }

                        CollectionType.COLLECTION_16_9 -> {
                            CollectionRow16By9(
                                collection = collection,
                                modifier = if (index == 0) Modifier.focusRequester(
                                    columnFocusRequester
                                ) else Modifier
                            )
                        }

                        CollectionType.COLLECTION_MAX_WIDTH -> {
                            HomeItemMaxWidth(
                                index = 0,
                                aspectRatio = 16f / 6f,
                                modifier = if (index == 0) Modifier.focusRequester(
                                    columnFocusRequester
                                ) else Modifier
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(32.dp))
                }
                item { Spacer(modifier = Modifier.height(24.dp)) }
            }
        }
    }
}