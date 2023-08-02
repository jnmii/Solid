package com.example.patterns.creational

interface Shape {
    fun draw()
}

class Circle : Shape {
    override fun draw() {
        println("Drawing a circle")
    }
}

class Rectangle : Shape {
    override fun draw() {
        println("Drawing a rectangle")
    }
}
