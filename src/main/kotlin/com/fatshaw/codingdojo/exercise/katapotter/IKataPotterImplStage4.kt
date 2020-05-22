package com.fatshaw.codingdojo.exercise.katapotter

import com.fatshaw.codingdojo.exercise.katapotter.domain.Book

class IKataPotterImplStage4 : IKataPotter {

    override fun getPrice(list: List<Book>): Int {
        return newBookSets(list).map { it.calculate() }.sum()
    }

    private fun newBookSets(list: List<Book>) =
        BookSetFactory().newBookSets(list)

}