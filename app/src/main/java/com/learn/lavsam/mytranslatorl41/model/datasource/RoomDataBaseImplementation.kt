package com.learn.lavsam.mytranslatorl41.model.datasource

import com.learn.lavsam.mytranslatorl41.model.data.AppState
import com.learn.lavsam.mytranslatorl41.model.data.DataModel
import com.learn.lavsam.mytranslatorl41.room.HistoryDao
import com.learn.lavsam.mytranslatorl41.utils.convertDataModelSuccessToEntity
import com.learn.lavsam.mytranslatorl41.utils.mapHistoryEntityToSearchResult

class RoomDataBaseImplementation(private val historyDao: HistoryDao) :
    DataSourceLocal<List<DataModel>> {

    override suspend fun getData(word: String): List<DataModel> {
        return mapHistoryEntityToSearchResult(historyDao.all())
    }

    override suspend fun saveToDB(appState: AppState) {
        convertDataModelSuccessToEntity(appState)?.let {
            historyDao.insert(it)
        }
    }
}
