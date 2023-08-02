package com.example.patterns.structural

abstract class TextDecorator(private val decoratedText: Text) : Text {
    override fun draw() {
        decoratedText.draw()
        applyFormatting()
    }

    abstract fun applyFormatting()
}
class BoldTextDecorator(decoratedText: Text) : TextDecorator(decoratedText) {
    override fun applyFormatting() {
        println("Adding bold formatting to the text.")
    }
}

class ItalicTextDecorator(decoratedText: Text) : TextDecorator(decoratedText) {
    override fun applyFormatting() {
        println("Adding italic formatting to the text.")
    }
}
