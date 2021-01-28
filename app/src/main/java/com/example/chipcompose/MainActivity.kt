package com.example.chipcompose

import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ScrollableRow
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.math.max

class MainActivity : AppCompatActivity() {

    val topics = listOf(
        "Arts & Crafts", "Beauty", "Books", "Business", "Comics", "Culinary",
        "Design", "Fashion", "Film", "History", "Maths", "Music", "People", "Philosophy",
        "Religion", "Social sciences", "Technology", "TV", "Writing"
    )

    @Composable
    fun ChipViews() {
        BodyContent(Modifier, Color.White)
    }

    @Composable
    fun BodyContent(modifier: Modifier = Modifier, color: Color) {
        ScrollableRow(modifier = modifier
            .background(color = color)
            .fillMaxWidth(),
            content = {
                StaggeredGrid {
                    for (topic in topics) {
                        Chip(modifier = Modifier.padding(8.dp), text = topic)
                    }
                }
            })
    }

    @Composable
    fun StaggeredGrid(
        modifier: Modifier = Modifier,
        rows: Int = 3,
        content: @Composable () -> Unit
    ) {
        Layout(
            modifier = modifier,
            content = content
        ) { measurables, constraints ->

            val rowWidths = IntArray(rows) { 0 }
            val rowHeights = IntArray(rows) { 0 }

            val placeables = measurables.mapIndexed { index, measurable ->
                val placeable = measurable.measure(constraints)
                val row = index % rows
                rowWidths[row] += placeable.width
                rowHeights[row] = max(rowHeights[row], placeable.height)
                placeable
            }

            val width = rowWidths.maxOrNull()
                ?.coerceIn(constraints.minWidth.rangeTo(constraints.maxWidth))
                ?: constraints.minWidth


            val height = rowHeights.sumBy { it }
                .coerceIn(constraints.minHeight.rangeTo(constraints.maxHeight))

            val rowY = IntArray(rows) { 0 }
            for (i in 1 until rows) {
                rowY[i] = rowY[i - 1] + rowHeights[i - 1]
            }

            // Set the size of the parent layout
            layout(width, height) {
                val rowX = IntArray(rows) { 0 }

                placeables.forEachIndexed { index, placeable ->
                    val row = index % rows
                    placeable.placeRelative(
                        x = rowX[row],
                        y = rowY[row]
                    )
                    rowX[row] += placeable.width
                }
            }
        }
    }

    @Composable
    fun Chip(modifier: Modifier = Modifier, text: String) {
        Card(
            modifier = modifier,
            backgroundColor = Color.Blue,
            shape = RoundedCornerShape(8.dp)
        ) {
            Row(
                modifier = Modifier.padding(start = 8.dp, top = 4.dp, end = 8.dp, bottom = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = text, color = Color.White)
            }
        }
    }

    @Preview
    @Composable
    fun LayoutsPreview() {
        ChipViews()
    }

}