package com.example.chipcompose

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.chipcompose.ui.*
import kotlin.math.ceil

class ChipGroup {

    val foodTypes = listOf(
        "Arts & Crafts", "Beauty", "Books", "Business", "Comics", "Culinary",
        "Design", "Fashion", "Film", "History", "Maths", "Music", "People", "Philosophy",
        "Religion", "Social sciences", "Technology", "TV", "Writing", "Arts & Crafts",
        "Beauty", "Books", "Business", "Comics", "Culinary",
        "Design", "Fashion", "Film", "History", "Maths", "Music", "People", "Philosophy",
        "Religion", "Social sciences", "Technology", "TV", "Writing"
    )

    @Suppress("DEPRECATION")
    @ExperimentalLayout
    @Composable
    fun CustomChipGroup(
        modifier: Modifier = Modifier,
        lists: List<String> = foodTypes,
        backgroundColor: Color = chrimson,
        chipColor: Color = Color.White
    ) {
        Column(
            modifier = modifier
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
                    for (foodType in lists) {
                        Chip(
                            modifier = modifier.wrapContentWidth().padding(2.dp),
                            text = foodType,
                            backgroundColor = backgroundColor,
                            textColor = chipColor
                        )
                    }
                })
        }
    }

    @Composable
    fun Chip(
        modifier: Modifier = Modifier,
        text: String,
        backgroundColor: Color = purple200,
        textColor: Color = Color.White,
        onClick: () -> Unit = { Log.d("Layout", text) }
    ) {
        Card(
            shape = RoundedCornerShape(16.dp),
            backgroundColor = backgroundColor,
            modifier = modifier,
        ) {
            Row(
                modifier = Modifier
                    .clickable { onClick() }
                    .padding(start = 8.dp, top = 4.dp, end = 8.dp, bottom = 4.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(text = text, color = textColor)
            }
        }
    }

    @ExperimentalLayout
    @Preview
    @Composable
    fun ShowChipGroup() {
        CustomChipGroup()
    }
}