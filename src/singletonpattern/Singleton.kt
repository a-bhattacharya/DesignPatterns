package com.designpatterns.singletonpattern

class Singleton private constructor() {

    var state: String = "$this set"
    companion object {
        // Private reference to the singleton instance
        @Volatile
        private var INSTANCE: Singleton? = null

        // Function to get or create the singleton instance
        fun getInstance(): Singleton {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: Singleton().also { INSTANCE = it } // double-checked locking
            }
        }
    }
}

object SingletonKotlinWay {
    var state: String = "$this set"
}

/*
    Object declarations can't be local (that is, they can't be nested directly inside a function), but they can be
    nested into other object declarations or non-inner classes.
 */