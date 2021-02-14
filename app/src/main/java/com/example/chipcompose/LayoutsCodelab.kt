/*
 * Copyright 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.chipcompose

import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.chipcompose.ui.ChipComposeTheme
import kotlin.math.max

val topics = listOf(
    "Arts & Crafts", "Beauty", "Books", "Business", "Comics", "Culinary",
    "Design", "Fashion", "Film", "History", "Maths", "Music", "People", "Philosophy",
    "Religion", "Social sciences", "Technology", "TV", "Writing","Arts & Crafts", "Beauty", "Books", "Business", "Comics", "Culinary",
    "Design", "Fashion", "Film", "History", "Maths", "Music", "People", "Philosophy",
    "Religion", "Social sciences", "Technology", "TV", "Writing","Arts & Crafts", "Beauty", "Books", "Business", "Comics", "Culinary",
    "Design", "Fashion", "Film", "History", "Maths", "Music", "People", "Philosophy",
    "Religion", "Social sciences", "Technology", "TV", "Writing","Arts & Crafts", "Beauty", "Books", "Business", "Comics", "Culinary",
    "Design", "Fashion", "Film", "History", "Maths", "Music", "People", "Philosophy",
    "Religion", "Social sciences", "Technology", "TV", "Writing","Arts & Crafts", "Beauty", "Books", "Business", "Comics", "Culinary",
    "Design", "Fashion", "Film", "History", "Maths", "Music", "People", "Philosophy",
    "Religion", "Social sciences", "Technology", "TV", "Writing"
)

//@Composable
//fun LayoutsCodelab() {
//    BodyContent()
//}
//
//@Composable
//fun BodyContent(modifier: Modifier = Modifier) {
//    Row(modifier = modifier
//        .background(color = Color.LightGray)
//        .wrapContentHeight()
//        .fillMaxWidth()
//        .horizontalScroll(rememberScrollState()),
//        content = {
//            StaggeredGrid {
//                for (topic in topics) {
//                    Chip(modifier = modifier.padding(8.dp), text = topic)
//                }
//            }
//        })
//
//}
//
//@Composable
//fun StaggeredGrid(
//    modifier: Modifier = Modifier,
//    rows: Int = 3,
//    content: @Composable () -> Unit
//) {
//    Layout(
//        modifier = modifier,
//        content = content
//    ) { measurables, constraints ->
//
//        val rowWidths = IntArray(rows) { 0 } // Keep track of the width of each row
//        val rowHeights = IntArray(rows) { 0 } // Keep track of the height of each row
//        // Don't constrain child views further, measure them with given constraints
//        val placeables = measurables.mapIndexed { index, measurable ->
//            val placeable = measurable.measure(constraints)
//            // Track the width and max height of each row
//            val row = index % rows
//            Log.d("Layout", "Row value is: $row Index: $index")
//            rowWidths[row] += placeable.width
//            Log.d("Layout", "Row width value is: ${rowWidths[row]}, ${placeable.width}")
//            rowHeights[row] = max(rowHeights[row], placeable.height)
//            Log.d("Layout", "Row height value is: ${rowHeights[row]}")
//            placeable
//        }
//
//        for (value in rowWidths)
//            Log.d("Layout", "Row Widths Values: $value")
//
//        for (value in rowHeights)
//            Log.d("Layout", "Row Heights Values: $value")
//
//        // Grid's width is the widest row
//        val width = rowWidths.maxOrNull()
//            ?.coerceIn(constraints.minWidth.rangeTo(constraints.maxWidth)) ?: constraints.minWidth
//        Log.d("Layout", "total width is: $width\nconstraint width min + max is: ${constraints.minWidth} ${constraints.maxWidth}")
//
//        // Grid's height is the sum of the tallest element of each row
//        // coerced to the height constraints
//        val height = rowHeights.sumBy { it }
//            .coerceIn(constraints.minHeight.rangeTo(constraints.maxHeight))
//        Log.d("Layout", "$height")
//
//        // Y of each row, based on the height accumulation of previous rows
//        val rowY = IntArray(rows) { 0 }
//        for (i in 1 until rows) {
//            rowY[i] = rowY[i - 1] + rowHeights[i - 1]
//            Log.d("Layout", "Y of each Row: ${rowY[i]}")
//        }
//
//        // Set the size of the parent layout
//        layout(width, height) {
//            // x co-ord we have placed up to, per row
//            val rowX = IntArray(rows) { 0 }
//
//            placeables.forEachIndexed { index, placeable ->
//                val row = index % rows
//                placeable.placeRelative(
//                    x = rowX[row],
//                    y = rowY[row]
//                )
//                rowX[row] += placeable.width
//                Log.d("Layout", "X position of each element: ${rowX[row]}")
//            }
//        }
//    }
//}

@Suppress("DEPRECATION")
@ExperimentalLayout
@Composable
fun FlowLayout() {
    Column(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        FlowRow(
            mainAxisAlignment = MainAxisAlignment.Center,
            crossAxisSpacing = 4.dp,
            mainAxisSpacing = 4.dp,
            mainAxisSize = SizeMode.Expand,
            content = {
                for (topic in topics) {
                    Chip(modifier = Modifier.padding(4.dp), text = topic)
                }
            })
    }
}

@Composable
fun Chip(modifier: Modifier = Modifier, text: String) {
    Card(
        modifier = modifier,
        border = BorderStroke(color = Color.Black, width = Dp.Hairline),
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            modifier = Modifier.padding(start = 8.dp, top = 4.dp, end = 8.dp, bottom = 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .preferredSize(16.dp, 16.dp)
                    .background(color = MaterialTheme.colors.secondary)
            )
            Spacer(Modifier.preferredWidth(4.dp))
            Text(text = text)
        }
    }
}

@ExperimentalLayout
@Preview
@Composable
fun LayoutsCodelabPreview() {
    ChipComposeTheme {
        FlowLayout()
    }
}