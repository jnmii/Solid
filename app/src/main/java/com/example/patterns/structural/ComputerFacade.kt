package com.example.patterns.structural

// Facade for the home theater system
class HomeTheaterFacade(private val tv: TV, private val dvdPlayer: DVDPlayer, private val soundSystem: SoundSystem) {

    fun watchMovie(movie: String) {
        tv.turnOn()
        dvdPlayer.play(movie)
        soundSystem.setVolume(70)
        soundSystem.setSurroundSound()
    }

    fun stopMovie() {
        dvdPlayer.stop()
        tv.turnOff()
        soundSystem.setVolume(0)
    }

    fun listenToMusic() {
        tv.turnOff()
        dvdPlayer.stop()
        soundSystem.setVolume(50)
    }

    fun turnOff() {
        tv.turnOff()
        dvdPlayer.stop()
        soundSystem.setVolume(0)
        soundSystem.turnOff()
    }
}

// Subsystem components
class TV {
    fun turnOn() {
        println("TV is turned on.")
    }

    fun turnOff() {
        println("TV is turned off.")
    }
}

class DVDPlayer {
    fun play(movie: String) {
        println("Playing movie: $movie")
    }

    fun stop() {
        println("DVD player stopped.")
    }
}

class SoundSystem {
    fun setVolume(volume: Int) {
        println("Volume set to $volume.")
    }

    fun setSurroundSound() {
        println("Surround sound is enabled.")
    }

    fun turnOff() {
        println("Sound system is turned off.")
    }
}

fun main() {
    val tv = TV()
    val dvdPlayer = DVDPlayer()
    val soundSystem = SoundSystem()

    val homeTheater = HomeTheaterFacade(tv, dvdPlayer, soundSystem)

    homeTheater.watchMovie("Avengers")
    println()
    homeTheater.listenToMusic()
    println()
    homeTheater.stopMovie()
}

