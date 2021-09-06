package com.learn.lavsam.mytranslatorl41.di

import androidx.room.Room
import com.learn.lavsam.mytranslatorl41.model.data.DataModel
import com.learn.lavsam.mytranslatorl41.model.datasource.RetrofitImplementation
import com.learn.lavsam.mytranslatorl41.model.datasource.RoomDataBaseImplementation
import com.learn.lavsam.mytranslatorl41.model.repository.Repository
import com.learn.lavsam.mytranslatorl41.model.repository.RepositoryImplementation
import com.learn.lavsam.mytranslatorl41.model.repository.RepositoryImplementationLocal
import com.learn.lavsam.mytranslatorl41.model.repository.RepositoryLocal
import com.learn.lavsam.mytranslatorl41.room.HistoryDataBase
import com.learn.lavsam.mytranslatorl41.view.history.HistoryInteractor
import com.learn.lavsam.mytranslatorl41.view.history.HistoryViewModel
import com.learn.lavsam.mytranslatorl41.view.main.MainInteractor
import com.learn.lavsam.mytranslatorl41.view.main.MainViewModel
import org.koin.dsl.module

val application = module {
    single { Room.databaseBuilder(get(), HistoryDataBase::class.java, "HistoryDB").build() }
    single { get<HistoryDataBase>().historyDao() }
    single<Repository<List<DataModel>>> { RepositoryImplementation(RetrofitImplementation()) }
    single<RepositoryLocal<List<DataModel>>> {
        RepositoryImplementationLocal(
            RoomDataBaseImplementation(get())
        )
    }
}

val mainScreen = module {
    factory { MainViewModel(get()) }
    factory { MainInteractor(get(), get()) }
}

val historyScreen = module {
    factory { HistoryViewModel(get()) }
    factory { HistoryInteractor(get(), get()) }
}
