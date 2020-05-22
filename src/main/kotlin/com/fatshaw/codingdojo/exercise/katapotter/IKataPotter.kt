package com.fatshaw.codingdojo.exercise.katapotter

import com.fatshaw.codingdojo.exercise.katapotter.domain.Book

interface IKataPotter {
    fun getPrice(list: List<Book>): Int
}