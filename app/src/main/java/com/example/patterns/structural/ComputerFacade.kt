package com.example.patterns.structural

class ComputerFacade(private val cpu: CPU, private val memory: Memory, private val hardDisk: HardDisk) {
    fun startComputer() {
        cpu.start()
        memory.load()
        hardDisk.read()
        println("Computer is started and ready to use.")
    }

    fun shutdownComputer() {
        cpu.shutdown()
        memory.clear()
        hardDisk.write()
        println("Computer is shut down.")
    }
}
// Complex subsystems

class CPU {
    fun start() {
        println("CPU is starting...")
    }

    fun shutdown() {
        println("CPU is shutting down...")
    }
}

class Memory {
    fun load() {
        println("Memory is loading...")
    }

    fun clear() {
        println("Memory is cleared...")
    }
}

class HardDisk {
    fun read() {
        println("Hard Disk is reading...")
    }

    fun write() {
        println("Hard Disk is writing...")
    }
}