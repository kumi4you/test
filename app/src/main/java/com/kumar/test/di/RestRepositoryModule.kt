package com.kumar.test.di

import com.kumar.test.domain.usecase.GetShowsUseCase
import com.kumar.test.domain.usecase.SortListByScoreUseCase
import com.kumar.test.domain.usecase.SortListByTimeUseCase
import com.kumar.test.domain.usecase.SortListByTitleUseCase
import org.koin.dsl.module


val restRepositoryModule = module {
    single { GetShowsUseCase(get()) }
    single { SortListByTimeUseCase() }
    single { SortListByTitleUseCase() }
    single { SortListByScoreUseCase() }
}