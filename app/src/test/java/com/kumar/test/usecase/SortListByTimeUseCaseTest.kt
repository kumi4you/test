package com.kumar.test.usecase

import com.kumar.test.data.model.Show
import com.kumar.test.data.model.ShowResponse
import com.kumar.test.domain.usecase.SortListByTimeUseCase
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class SortListByTimeUseCaseTest {

    private lateinit var list: List<ShowResponse>

    private val sortListByTimeUseCase = SortListByTimeUseCase()


    @Before
    fun setup() {
        list = TestDataProvider.getTestData()
    }

    @Test
    fun testExecute_positive() {

        val sortedList = sortListByTimeUseCase.execute(list)

        val time = sortedList[0].show.runtime

        Assert.assertEquals(10, time)
    }

    @Test
    fun testExecute_sortedList_negative() {

        val sortedList = sortListByTimeUseCase.execute(list)

        val title = sortedList[0].show.runtime

        Assert.assertNotEquals(13, title)
    }

    @Test
    fun testExecute_unsortedList_positive_negativeReply() {

        val title = list[0].show.runtime

        Assert.assertNotEquals(10, title)
    }

}