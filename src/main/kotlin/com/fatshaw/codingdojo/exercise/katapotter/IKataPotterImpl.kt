package com.fatshaw.codingdojo.exercise.katapotter

import com.fatshaw.codingdojo.exercise.katapotter.domain.Book
import com.fatshaw.codingdojo.exercise.katapotter.domain.BookType

class IKataPotterImpl : IKataPotter {
    override fun getPrice(list: List<Book>): Int {
        var firstBookCount = list.filter { it.type == BookType.FIRST }.count()
        var secondBookCount = list.filter { it.type == BookType.SECOND }.count()
        var thirdBookCount = list.filter { it.type == BookType.THIRD }.count()
        var fourthBookCount = list.filter { it.type == BookType.FOURTH }.count()
        var fifthBookCount = list.filter { it.type == BookType.FIFTH }.count()

        var price = 0

        while (firstBookCount > 0 || secondBookCount > 0 || thirdBookCount > 0 || fourthBookCount > 0 || fifthBookCount > 0) {
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

            if (count == 5) {
                price += (800 * 5 * 0.75).toInt()
            }

            if (count == 4) {
                price += (800 * 4 * 0.8).toInt()
            }

            if (count == 3) {
                price += (800 * 3 * 0.9).toInt()
            }

            if (count == 2) {
                price += (800 * 2 * 0.95).toInt()
            }

            if (count == 1) {
                price += 800
            }
        }


        return price
    }

}