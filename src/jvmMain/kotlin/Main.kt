// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import day10.ScreenState
import day10.solvePart2
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.onEach

@Composable
@Preview
fun App() {
    val state = day10.solvePart2().onEach { delay(30) }.collectAsState(ScreenState(emptyList(), 1))
    MaterialTheme {

        Column {
            state.value.screen.forEach {
                Row {
                    it.forEach {
                        if (it == '.') {
                            Box(modifier = Modifier.size(10.dp).background(Color.Black))
                        } else if (it == '#') {
                            Box(modifier = Modifier.size(10.dp).background(Color.Cyan))
                        }
                    }
                }
            }
        }
    }

}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        solvePart2()
        App()
    }
}
