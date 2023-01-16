package com.adrianwitaszak.ballastsharedui

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform