package com.fatshaw.codingdojo.exercise.katapotter.domain

data class Book(val type: BookType)

enum class BookType {
    FIRST,
    SECOND,
    THIRD,
    FOURTH,
    FIFTH,
    SIXTH,
    SEVENTH
}