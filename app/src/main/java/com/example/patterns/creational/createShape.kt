package com.example.patterns.creational

import java.util.Locale

object ShapeFactory {
    fun createShape(type: String): Shape? {
        return when (type.lowercase(Locale.ROOT)) {
            "circle" -> Circle()
            "rectangle" -> Rectangle()
            else -> null
        }
    }
}
