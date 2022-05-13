package com.leotorrealba.jettrivia.data

data class DataOrExeption<T, Boolean, E : Exception>(
    var data: T? = null,
    var loading: Boolean? = null,
    var e: E? = null
)
