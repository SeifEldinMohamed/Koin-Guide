package com.seif.koinguide.di

import com.seif.koinguide.MainActivity
import org.koin.core.qualifier.named
import org.koin.dsl.module

val activityModule = module {
    // these dependencies will live as long as teh activity they are injected to lives
    scope<MainActivity> {
        scoped(qualifier = named("hello")) { "Hello" }
        scoped(qualifier = named("bye")) { "Bye" }
    }
    // we used qualifiers, so we can differentiate between these two strings
}