package pl.jawegiel.expensetrackerandroid.core.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pl.jawegiel.expensetrackerandroid.data.datasource.ExpenseRemoteDataSource
import pl.jawegiel.expensetrackerandroid.data.datasource.ExpenseRemoteDataSourceImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Binds
    @Singleton
    abstract fun bindExpenseRemoteDataSource(
        impl: ExpenseRemoteDataSourceImpl
    ): ExpenseRemoteDataSource
}
