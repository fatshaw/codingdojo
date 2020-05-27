package com.fatshaw.codingdojo.exercise.katapotter.factory

import com.fatshaw.codingdojo.exercise.katapotter.domain.Book
import com.fatshaw.codingdojo.exercise.katapotter.domain.BookSet

abstract class AbstractBookSetFactory{
    abstract fun newBookSet(books:List<Book>): List<BookSet>
}