package pl.jawegiel.expensetrackerandroid.core.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pl.jawegiel.expensetrackerandroid.data.repository.ExpenseRepositoryImpl
import pl.jawegiel.expensetrackerandroid.domain.repository.ExpenseRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindExpenseRepository(
        expenseRepositoryImpl: ExpenseRepositoryImpl
    ): ExpenseRepository
}
