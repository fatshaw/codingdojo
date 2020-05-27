package com.fatshaw.codingdojo.exercise.katapotter

import com.fatshaw.codingdojo.exercise.katapotter.domain.Book
import com.fatshaw.codingdojo.exercise.katapotter.factory.AbstractBookSetFactory
import com.fatshaw.codingdojo.exercise.katapotter.factory.OptimizedBookSetFactory

class IKataPotterImplStage5 : IKataPotter {

    var bookSetFactory: AbstractBookSetFactory = OptimizedBookSetFactory()

    override fun getPrice(list: List<Book>): Int {
        return newBookSets(list).map { it.calculate() }.sum()
    }

    private fun newBookSets(list: List<Book>) =
        bookSetFactory.newBookSet(list)

}