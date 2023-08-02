package com.example.patterns.creational.di

import com.example.Logger
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun getLogger(): Logger
}
