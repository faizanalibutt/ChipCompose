package com.example.chipcompose

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.ExperimentalLayout
import androidx.compose.ui.platform.setContent
import com.example.chipcompose.ui.ChipComposeTheme

class MainActivity : AppCompatActivity() {

    @ExperimentalLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChipComposeTheme {
                LayoutsCodelab()
            }
        }
    }

}