package com.example.mvvmsampleapp

import android.app.Application
import com.example.mvvmsampleapp.data.db.AppDatabase
import com.example.mvvmsampleapp.data.network.MyApi
import com.example.mvvmsampleapp.data.network.NetworkConnectionInterceptor
import com.example.mvvmsampleapp.data.preferences.PreferenceProvider
import com.example.mvvmsampleapp.data.repositories.QuotesRepository
import com.example.mvvmsampleapp.data.repositories.UserRepository
import com.example.mvvmsampleapp.ui.auth.AuthViewModelFactory
import com.example.mvvmsampleapp.ui.home.profile.ProfileViewModelFactory
import com.example.mvvmsampleapp.ui.home.quotes.QuotesViewModelFactory
import com.jakewharton.threetenabp.AndroidThreeTen
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class MVVMApplication : Application(), KodeinAware {

    override fun onCreate() {
        super.onCreate()
        AndroidThreeTen.init(this)
    }

    override val kodein = Kodein.lazy {
        import(androidXModule(this@MVVMApplication))


        bind() from singleton { NetworkConnectionInterceptor(instance()) }
        bind() from singleton { MyApi(instance()) }
        bind() from singleton { AppDatabase(instance()) }
        bind() from singleton { PreferenceProvider(instance()) }
        bind() from singleton { UserRepository(instance(), instance()) }
        bind() from singleton { QuotesRepository(instance(), instance(), instance()) }
        bind() from provider { AuthViewModelFactory(instance()) }
        bind() from provider { ProfileViewModelFactory(instance()) }
        bind() from provider { QuotesViewModelFactory(instance()) }
    }
}