package com.example.view

import kotlinx.html.HTML

internal interface View {
    fun html() : HTML.() -> Unit
}