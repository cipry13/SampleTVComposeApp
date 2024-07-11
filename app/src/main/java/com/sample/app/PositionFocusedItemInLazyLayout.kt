package com.sample.app

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.gestures.BringIntoViewSpec
import androidx.compose.foundation.gestures.LocalBringIntoViewSpec
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import kotlin.math.abs

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PositionFocusedItemInLazyLayout(
    parentFraction: Float = 0.3f,
    childFraction: Float = 0f,
    content: @Composable () -> Unit
) {
    // a bring into view spec that pivots around the center of the scrollable container
    val bringIntoViewSpec = object : BringIntoViewSpec {
        override fun calculateScrollDistance(
            // initial position of item requesting focus
            offset: Float,
            // size of item requesting focus
            size: Float,
            // size of the lazy container
            containerSize: Float
        ): Float {
            val trailingEdgeOfItemRequestingFocus = offset + size

            val sizeOfItemRequestingFocus =
                abs(trailingEdgeOfItemRequestingFocus - offset)
            val childSmallerThanParent = sizeOfItemRequestingFocus <= containerSize
            val initialTargetForLeadingEdge =
                parentFraction * containerSize -
                        (childFraction * sizeOfItemRequestingFocus)
            val spaceAvailableToShowItem = containerSize - initialTargetForLeadingEdge

            val targetForLeadingEdge =
                if (childSmallerThanParent &&
                    spaceAvailableToShowItem < sizeOfItemRequestingFocus
                ) {
                    containerSize - sizeOfItemRequestingFocus
                } else {
                    initialTargetForLeadingEdge
                }

            return offset - targetForLeadingEdge
        }
    }

    // LocalBringIntoViewSpec will apply to all scrollable components in the hierarchy.
    CompositionLocalProvider(
        value = LocalBringIntoViewSpec provides bringIntoViewSpec,
        content = content
    )
}