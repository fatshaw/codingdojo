package com.fatshaw.codingdojo.exercise.katapotter

import com.fatshaw.codingdojo.exercise.katapotter.domain.Book
import com.fatshaw.codingdojo.exercise.katapotter.domain.BookSet
import com.fatshaw.codingdojo.exercise.katapotter.domain.BookType

class IKataPotterImplStage3 : IKataPotter {

    override fun getPrice(list: List<Book>): Int {
        return newBookSets(list).map { it.calculate() }.sum()
    }

    private fun newBookSets(list: List<Book>): MutableList<BookSet> {
        val bookCount = calculateEachBookCount(list)

        val bookSets = mutableListOf<BookSet>()
        while (hasBooks(bookCount)) {
            val differentBookCount = calculateNextBookSet(bookCount)
            bookSets.add(BookSet(differentBookCount))
        }

        return bookSets

    }

    private fun calculateEachBookCount(list: List<Book>): MutableMap<Book, Int> {
        val bookCount = mutableMapOf<Book, Int>()
        for (book in list) {
            bookCount[book] = bookCount.getOrDefault(book, 0) + 1
        }
        return bookCount
    }

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

    private fun hasBooks(bookCount: Map<Book, Int>) =
        bookCount.values.sum() > 0


}