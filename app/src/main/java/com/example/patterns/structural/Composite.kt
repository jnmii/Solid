package com.example.patterns.structural

// Base interface for FileSystemComponent
interface FileSystemComponent {
    fun getName(): String
    fun display(indent: Int)
}

// Concrete implementation for File
class File(private val name: String) : FileSystemComponent {
    override fun getName(): String {
        return name
    }

    override fun display(indent: Int) {
        println("${" ".repeat(indent)}File: $name")
    }
}

// Concrete implementation for Directory
class Directory(private val name: String) : FileSystemComponent {
    private val components = mutableListOf<FileSystemComponent>()

    override fun getName(): String {
        return name
    }

    override fun display(indent: Int) {
        println("${" ".repeat(indent)}Directory: $name")
        for (component in components) {
            component.display(indent + 2)
        }
    }

    fun addComponent(component: FileSystemComponent) {
        components.add(component)
    }

    fun removeComponent(component: FileSystemComponent) {
        components.remove(component)
    }
}
fun main() {
    // Create some files
    val file1 = File("file1.txt")
    val file2 = File("file2.txt")
    val file3 = File("file3.txt")

    // Create a directory and add files to it
    val dir1 = Directory("Documents")
    dir1.addComponent(file1)
    dir1.addComponent(file2)

    // Create another directory and add a file and a subdirectory to it
    val dir2 = Directory("Photos")
    dir2.addComponent(file3)
    dir2.addComponent(dir1)

    // Display the entire file system hierarchy
    dir2.display(0)
}

