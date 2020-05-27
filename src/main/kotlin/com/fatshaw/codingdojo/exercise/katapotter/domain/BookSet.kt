package com.fatshaw.codingdojo.exercise.katapotter.domain

data class BookSet(val differentBookCount: Int) {

    companion object {
        private const val PRICE_FOR_ONE_BOOK = 800
        private val DISCOUNT: Map<Int, Double> = mapOf(
            1 to 1.00,
            2 to 0.95,
            3 to 0.90,
            4 to 0.80,
            5 to 0.75
        )
    }

    fun calculate(): Int {
        return (DISCOUNT.getOrDefault(differentBookCount, 1.0) * differentBookCount * PRICE_FOR_ONE_BOOK).toInt()
    }
}