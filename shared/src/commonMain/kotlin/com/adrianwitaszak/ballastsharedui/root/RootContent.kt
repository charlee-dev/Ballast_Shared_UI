package com.adrianwitaszak.ballastsharedui.root

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.adrianwitaszak.ballastsharedui.theme.MyApplicationTheme

@Composable
internal fun RootContent() {
    val coroutineScope = rememberCoroutineScope()
    val vm = remember(coroutineScope) { RootViewModel(coroutineScope) }
    val state by vm.observeStates().collectAsState()

    MyApplicationTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "Counter",
                        style = MaterialTheme.typography.h2,
                        modifier = Modifier.padding(16.dp)
                    )
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Button(
                            onClick = { vm.trySend(RootContract.Inputs.Decrement()) }
                        ) {
                            Text("-")
                        }
                        Text(
                            text = state.count.toString(),
                            modifier = Modifier.padding(horizontal = 16.dp)
                        )
                        Button(
                            onClick = { vm.trySend(RootContract.Inputs.Increment()) }
                        ) {
                            Text("+")
                        }
                    }
                }
            }
        }
    }
}
