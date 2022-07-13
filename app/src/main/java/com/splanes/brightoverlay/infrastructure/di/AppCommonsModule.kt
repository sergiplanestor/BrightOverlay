package com.splanes.brightoverlay.infrastructure.di

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

/*
 * Created on 05/07/2022 at 19:08
 * @author Sergi Planes
 * @since 1.0.0
 */

@Module
@InstallIn(SingletonComponent::class)
object AppCommonsModule {

    @Provides
    fun preferences(@ApplicationContext context: Context): SharedPreferences =
        context.getSharedPreferences("BrightOverlay", Context.MODE_PRIVATE)

}