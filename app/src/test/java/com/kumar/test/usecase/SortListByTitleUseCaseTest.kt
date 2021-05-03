package com.kumar.test.usecase

import com.kumar.test.data.model.ShowResponse
import com.kumar.test.domain.usecase.SortListByTitleUseCase
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class SortListByTitleUseCaseTest {

    private lateinit var list: List<ShowResponse>

    private val sortListByTitleUseCase = SortListByTitleUseCase()


    @Before
    fun setup() {
        list = TestDataProvider.getTestData()
    }

    @Test
    fun testExecute_sortedList_positive() {

        val sortedList = sortListByTitleUseCase.execute(list)

        val title = sortedList[0].show.name

        Assert.assertEquals("Balloon", title)
    }

    @Test
    fun testExecute_sortedList_negative() {

        val sortedList = sortListByTitleUseCase.execute(list)

        val title = sortedList[0].show.name

        Assert.assertNotEquals("Title Dog", title)
    }

    @Test
    fun testExecute_unsortedList_positive_negativeReply() {

        val title = list[0].show.name

        Assert.assertEquals("Batman", title)
    }


}