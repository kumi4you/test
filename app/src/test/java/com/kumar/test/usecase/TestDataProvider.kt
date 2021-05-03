package com.kumar.test.usecase

import com.kumar.test.data.model.Show
import com.kumar.test.data.model.ShowResponse

object TestDataProvider {

    fun getTestData() :List<ShowResponse> {

        val showList = mutableListOf<ShowResponse>()

        val showResponse1 = ShowResponse(
            12.0,
            Show(
                12,
                "",
                "Balloon",
                "Type1",
                "",
                "",
                30,
                ""
            )
        )
        val showResponse2 = ShowResponse(
            2.0,
            Show(
                13,
                "",
                "SpiderMan",
                "Type1",
                "",
                "",
                40,
                ""
            )
        )
        val showResponse3 = ShowResponse(
            12.034,
            Show(
                14,
                "",
                "Batman",
                "Type1",
                "",
                "",
                25,
                ""
            )
        )
        val showResponse4 = ShowResponse(
            16.0,
            Show(
                15,
                "",
                "Title cat",
                "Type1",
                "",
                "",
                70,
                ""
            )
        )
        val showResponse5 = ShowResponse(
            14.203,
            Show(
                16,
                "",
                "Title Dog",
                "Type1",
                "",
                "",
                10,
                ""
            )
        )

        showList.add(showResponse1)
        showList.add(showResponse2)
        showList.add(showResponse3)
        showList.add(showResponse4)
        showList.add(showResponse5)

        return showList

    }
}