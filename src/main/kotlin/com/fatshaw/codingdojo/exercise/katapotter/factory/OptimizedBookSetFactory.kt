package com.fatshaw.codingdojo.exercise.katapotter.factory

import com.fatshaw.codingdojo.exercise.katapotter.domain.Book
import com.fatshaw.codingdojo.exercise.katapotter.domain.BookSet

class OptimizedBookSetFactory : BookSetFactory() {
    fun optimize(bookSets: List<BookSet>): List<BookSet> {
        val optimizedBookSet = bookSets.toMutableList()
        val countOfSetToBeOptimized =
            Integer.min(
                optimizedBookSet.filter { it.differentBookCount == 3 }.count(),
                optimizedBookSet.filter { it.differentBookCount == 5 }.count()
            )

        repeat((0 until countOfSetToBeOptimized).count()) {
            optimizedBookSet.remove(BookSet(3))
            optimizedBookSet.remove(BookSet(5))
            optimizedBookSet.add(BookSet(4))
            optimizedBookSet.add(BookSet(4))
        }
        return optimizedBookSet
    }

    override fun newBookSet(books: List<Book>): List<BookSet> {
        return optimize(super.newBookSet(books))
    }
}