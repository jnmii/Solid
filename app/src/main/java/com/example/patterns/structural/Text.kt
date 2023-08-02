package com.example.patterns.structural

interface Text {
    fun draw()
}

class PlainText(private val content: String) : Text {
    override fun draw() {
        println(content)
    }
}
