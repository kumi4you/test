package com.kumar.test.domain.usecase

import com.kumar.test.data.model.ShowResponse

class SortListByTimeUseCase() :UseCase<List<ShowResponse>, List<ShowResponse>>{

    override fun execute(input: List<ShowResponse>): List<ShowResponse> =
        input.sortedBy {
            it.show.runtime
        }

}