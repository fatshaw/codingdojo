package com.fatshaw.codingdojo.exercise.katapotter

import com.fatshaw.codingdojo.exercise.katapotter.domain.Book
import com.fatshaw.codingdojo.exercise.katapotter.domain.BookSet
import com.fatshaw.codingdojo.exercise.katapotter.domain.BookType

class IKataPotterImplStage2 : IKataPotter {
    override fun getPrice(list: List<Book>): Int {
        return newBookSets(list).map { it.calculate() }.sum()
    }

    private fun newBookSets(list: List<Book>): MutableList<BookSet> {
        var firstBookCount = list.filter { it.type == BookType.FIRST }.count()
        var secondBookCount = list.filter { it.type == BookType.SECOND }.count()
        var thirdBookCount = list.filter { it.type == BookType.THIRD }.count()
        var fourthBookCount = list.filter { it.type == BookType.FOURTH }.count()
        var fifthBookCount = list.filter { it.type == BookType.FIFTH }.count()

        val bookSets = mutableListOf<BookSet>()
        while (hasBooks(firstBookCount, secondBookCount, thirdBookCount, fourthBookCount, fifthBookCount)) {
            var count = 0

            if (firstBookCount > 0) {
                count++
                firstBookCount--
            }

            if (secondBookCount > 0) {
                count++
                secondBookCount--
            }

            if (thirdBookCount > 0) {
                count++
                thirdBookCount--
            }

            if (fourthBookCount > 0) {
                count++
                fourthBookCount--
            }

            if (fifthBookCount > 0) {
                count++
                fifthBookCount--
            }

            bookSets.add(BookSet(count))
        }
        return bookSets
    }

    private fun hasBooks(
        firstBookCount: Int,
        secondBookCount: Int,
        thirdBookCount: Int,
        fourthBookCount: Int,
        fifthBookCount: Int
    ) = firstBookCount > 0 || secondBookCount > 0 || thirdBookCount > 0 || fourthBookCount > 0 || fifthBookCount > 0


}