package com.example.patterns.creational.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.example.Logger
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {
    // Provide the Logger dependency
    @Provides
    @Singleton
    fun provideLogger(): Logger {
        return Logger()
    }
}