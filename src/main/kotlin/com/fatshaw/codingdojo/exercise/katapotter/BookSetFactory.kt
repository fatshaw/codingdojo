package com.fatshaw.codingdojo.exercise.katapotter

import com.fatshaw.codingdojo.exercise.katapotter.domain.Book
import com.fatshaw.codingdojo.exercise.katapotter.domain.BookDiscountSet

class BookSetFactory {

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

    fun newBookSets(books: List<Book>): MutableList<BookDiscountSet> {
        val bookCount = calculateEachBookCount(books)

        val bookSets = mutableListOf<BookDiscountSet>()
        while (hasBooks(bookCount)) {
            val differentBookCount = calculateNextBookSet(bookCount)
            bookSets.add(BookDiscountSet(differentBookCount))
        }
        return bookSets
    }

}