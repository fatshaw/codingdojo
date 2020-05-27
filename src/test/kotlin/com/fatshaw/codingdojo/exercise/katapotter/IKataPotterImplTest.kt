package com.fatshaw.codingdojo.exercise.katapotter

import com.fatshaw.codingdojo.exercise.katapotter.domain.Book
import com.fatshaw.codingdojo.exercise.katapotter.domain.BookType
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class IKtataPotterImplTest {

    private val kataPotter: IKataPotter = IKataPotterImplStage5()

    @Nested
    inner class SimpleTest {


        @Test
        fun `cost 800 cents when buy one book`() {
            assertThat(kataPotter.getPrice(listOf(
                Book(
                    BookType.FIRST
                )
            ))).isEqualTo(800)
        }

        @Test
        fun `cost 800*2 cents when buy two identical books`() {
            assertThat(kataPotter.getPrice(listOf(
                Book(
                    BookType.FIRST
                ),
                Book(BookType.FIRST)
            ))).isEqualTo(800 * 2)
        }

        @Test
        fun `cost 800*2*95% cents when buy two different books`() {
            assertThat(
                kataPotter.getPrice(
                    listOf(
                        Book(BookType.FIRST),
                        Book(BookType.SECOND)
                    )
                )
            ).isEqualTo((800 * 2 * 0.95).toInt())
        }

        @Test
        fun `cost 800*3*90% cents when buy three different books`() {
            assertThat(
                kataPotter.getPrice(
                    listOf(
                        Book(BookType.FIRST),
                        Book(BookType.SECOND),
                        Book(BookType.THIRD)
                    )
                )
            ).isEqualTo((800 * 3 * 0.9).toInt())
        }

        @Test
        fun `cost 800*4*80% cents when buy four different books`() {
            assertThat(
                kataPotter.getPrice(
                    listOf(
                        Book(BookType.FIRST),
                        Book(BookType.SECOND),
                        Book(BookType.THIRD),
                        Book(BookType.FOURTH)
                    )
                )
            ).isEqualTo((800 * 4 * 0.8).toInt())

            assertThat(
                kataPotter.getPrice(
                    listOf(
                        Book(BookType.FIRST),
                        Book(BookType.SECOND),
                        Book(BookType.THIRD),
                        Book(BookType.FIFTH)
                    )
                )
            ).isEqualTo((800 * 4 * 0.8).toInt())
        }

        @Test
        fun `cost 800*5*75% cents when buy five different books`() {
            assertThat(
                kataPotter.getPrice(
                    listOf(
                        Book(BookType.FIRST),
                        Book(BookType.SECOND),
                        Book(BookType.THIRD),
                        Book(BookType.FOURTH),
                        Book(BookType.FIFTH)
                    )
                )
            ).isEqualTo((800 * 5 * 0.75).toInt())
        }

        @Test
        fun `cost 800 + 800*5*75% cents when buy six books with five is different`() {
            assertThat(
                kataPotter.getPrice(
                    listOf(
                        Book(BookType.FIRST),
                        Book(BookType.SECOND),
                        Book(BookType.THIRD),
                        Book(BookType.FOURTH),
                        Book(BookType.FIFTH),
                        Book(BookType.FIRST)
                    )
                )
            ).isEqualTo((800 + 800 * 5 * 0.75).toInt())
        }

        @Test
        fun `cost 800*2*95% + 800*5*75% cents when buy five different books and two different books`() {
            assertThat(
                kataPotter.getPrice(
                    listOf(
                        Book(BookType.FIRST),
                        Book(BookType.SECOND),
                        Book(BookType.THIRD),
                        Book(BookType.FOURTH),
                        Book(BookType.FIFTH),
                        Book(BookType.FIRST),
                        Book(BookType.SECOND)
                    )
                )
            ).isEqualTo((800 * 2 * 0.95 + 800 * 5 * 0.75).toInt())
        }
    }

    @Nested
    inner class EdgeCaseTest {


        @Test
        fun `edge case when buy five different books and three different books`() {
            assertThat(
                kataPotter.getPrice(
                    listOf(
                        Book(BookType.FIRST),
                        Book(BookType.SECOND),
                        Book(BookType.THIRD),
                        Book(BookType.FOURTH),
                        Book(BookType.FIFTH),
                        Book(BookType.FIRST),
                        Book(BookType.SECOND),
                        Book(BookType.THIRD)
                    )
                )
            ).isEqualTo((800 * 4 * 0.8 + 800 * 4 * 0.8).toInt())
        }

        @Test
        fun `edge case when buy three sets of five different books and two sets of four different books`() {
            assertThat(
                kataPotter.getPrice(
                    listOf(
                        Book(BookType.FIRST),
                        Book(BookType.SECOND),
                        Book(BookType.THIRD),
                        Book(BookType.FOURTH),
                        Book(BookType.FIFTH),
                        Book(BookType.FIRST),
                        Book(BookType.SECOND),
                        Book(BookType.THIRD),
                        Book(BookType.FOURTH),
                        Book(BookType.FIFTH),
                        Book(BookType.FIRST),
                        Book(BookType.SECOND),
                        Book(BookType.THIRD),
                        Book(BookType.FOURTH),
                        Book(BookType.FIFTH),
                        Book(BookType.FIRST),
                        Book(BookType.SECOND),
                        Book(BookType.THIRD),
                        Book(BookType.FOURTH),
                        Book(BookType.FIFTH),
                        Book(BookType.FIRST),
                        Book(BookType.SECOND),
                        Book(BookType.THIRD)
                    )
                )
            ).isEqualTo((3 * (800 * 5 * 0.75) + 2 * (800 * 4 * 0.8)).toInt())
        }
    }
}