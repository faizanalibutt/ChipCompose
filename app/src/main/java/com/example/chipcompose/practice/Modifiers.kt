package com.example.chipcompose.practice

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import com.example.chipcompose.ui.ChipComposeTheme

class Modifiers {

    @Composable
    fun BodyContent() {

    }

    @Preview
    @Composable
    fun MyApp() {
        ChipComposeTheme {
            BodyContent()
        }
    }

    /*@Composable
    fun MyOwnColumn(
        modifier: Modifier = Modifier,
        content: @Composable () -> Unit
    ) {
        Layout(
            modifier = modifier.wrapContentWidth(),
            content = content
        ) { measureables, constraints ->

            val placeables = measureables.map { measureable ->
                measureable.measure(constraints)
            }

            var yPosition = 0

            layout(constraints.maxWidth, constraints.maxHeight) {
                placeables.forEach { placeable ->
                    placeable.placeRelative(x = 0, y = yPosition)

                    yPosition += placeable.height
                }
            }
        }
    }*/

    /*fun Modifier.firstBaselineToTop(
        firstBaselineToTop: Dp
    ) = Modifier.layout { measurable, constraints ->
        val placeable = measurable.measure(constraints)

        check(placeable[FirstBaseline] != AlignmentLine.Unspecified)
        val firstBaseline = placeable[FirstBaseline]

        val placeableY = firstBaselineToTop.toIntPx() - firstBaseline
        val height = placeable.height + placeableY
        layout(placeable.width, height) {
            placeable.placeRelative(0, placeableY)
        }
    }*/

    /*@Composable
    fun MaterialComponents() {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = "Practices",
                        )
                    },
                    actions = {
                        IconButton(onClick = { /* doSomething() */ }) {
                            Icon(Icons.Filled.Facebook, contentDescription = null)
                        }
                    }
                )
            }
        ) { innerPadding ->
            Column(Modifier.padding(innerPadding).padding(8.dp)) {
                Text(
                    text = "AOA, How are you?",
                    style = MaterialTheme.typography.h6,
                )
                Text(
                    text = "I'm, fine how do you do?",
                )
            }
        }
    }*/

    /*@Composable
    fun NewStory() {
        val image = imageResource(id = R.drawable.remove_ads)
        MaterialTheme {
            val typography = MaterialTheme.typography
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                val imageModifier = Modifier
                    .preferredHeight(180.dp)
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(8.dp))

                    Image(
                        image,
                        "getString(R.string.app_name)",
                        imageModifier,
                        contentScale = ContentScale.Fit
                    )
                Spacer(modifier = Modifier.preferredHeight(5.dp))

                Text(
                    "Hello! how you doing? Man I was worried about you." +
                            " what's going on in your life",
                    style = typography.h6,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    "Where is my breakfast?",
                    style = typography.body2
                )
                Text(
                    "Hurrah! I'm fucked.",
                    style = typography.body2
                )
            }
        }

    }*/

    /*@Composable
    fun PhotographerCard(modifier: Modifier = Modifier) {

        Row(
            modifier
                .padding(8.dp)
                .clip(RoundedCornerShape(4.dp))
                .background(MaterialTheme.colors.surface)
                .clickable(onClick = {  /*action ignored*/ })
                .padding(16.dp)
        ) {
            Surface(
                modifier = Modifier
                    .preferredHeight(50.dp)
                    .preferredWidth(50.dp),
                shape = CircleShape,
                color = MaterialTheme.colors.onSurface.copy(alpha = 0.2f)
            ) {
                // Image goes here
            }
            Column(
                modifier = Modifier
                    .padding(start = 8.dp)
                    .align(Alignment.CenterVertically)
            ) {
                Text("Faizan Ali", fontWeight = FontWeight.Bold)
                Providers(AmbientContentAlpha provides ContentAlpha.medium) {
                    Text("3 minutes ago", style = MaterialTheme.typography.body2)
                }
            }
        }
    }*/

}