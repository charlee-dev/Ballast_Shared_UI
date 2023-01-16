package com.adrianwitaszak.ballastsharedui

import androidx.compose.ui.window.Application
import com.adrianwitaszak.ballastsharedui.root.RootContent
import platform.UIKit.UIViewController


@Suppress("FunctionName", "unused") // Used in iOS
fun RootViewController(): UIViewController = Application("Ballast Shared UI") {
    RootContent()
}
