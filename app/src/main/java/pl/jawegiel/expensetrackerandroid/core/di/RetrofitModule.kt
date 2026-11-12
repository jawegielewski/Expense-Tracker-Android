package pl.jawegiel.expensetrackerandroid.core.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pl.jawegiel.expensetrackerandroid.data.datasource.ExpenseRemoteDataSource
import pl.jawegiel.expensetrackerandroid.data.datasource.ExpenseRemoteDataSourceImpl
import pl.jawegiel.expensetrackerandroid.data.remote.ExpenseApiService
import pl.jawegiel.expensetrackerandroid.data.remote.RetrofitClient
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RetrofitModule {

    @Binds
    @Singleton
    abstract fun bindExpenseRemoteDataSource(
        impl: ExpenseRemoteDataSourceImpl
    ): ExpenseRemoteDataSource

    companion object {
        @Provides
        @Singleton
        fun provideExpenseApiService(): ExpenseApiService {
            return RetrofitClient.apiService
        }
    }
}
