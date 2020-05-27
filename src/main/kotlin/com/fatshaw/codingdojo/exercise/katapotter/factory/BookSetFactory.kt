package com.fatshaw.codingdojo.exercise.katapotter.factory

import com.fatshaw.codingdojo.exercise.katapotter.domain.Book
import com.fatshaw.codingdojo.exercise.katapotter.domain.BookSet

open class BookSetFactory : AbstractBookSetFactory() {

    private fun calculateNextBookSet(
        bookCount: MutableMap<Book, Int>
    ): Int {
        var differentBookCount = 0
        for (it in bookCount) {
            if (it.value > 0) {
                bookCount[it.key] = it.value - 1
                differentBookCount++
            }
        }

        return differentBookCount
    }

    private fun hasBooks(bookCount: Map<Book, Int>) = bookCount.values.sum() > 0

    private fun calculateEachBookCount(list: List<Book>): MutableMap<Book, Int> {
        val bookCount = mutableMapOf<Book, Int>()
        for (book in list) {
            bookCount[book] = bookCount.getOrDefault(book, 0) + 1
        }
        return bookCount
    }

    override fun newBookSet(books: List<Book>): List<BookSet> {
        val bookCount = calculateEachBookCount(books)

        val bookSets = mutableListOf<BookSet>()
        while (hasBooks(bookCount)) {
            val differentBookCount = calculateNextBookSet(bookCount)
            bookSets.add(BookSet(differentBookCount))
        }
        return bookSets
    }

}