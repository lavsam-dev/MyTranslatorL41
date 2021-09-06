package geekbrains.ru.translator.model.datasource

import com.learn.lavsam.mytranslatorl41.model.datasource.DataSourceLocal
import com.learn.lavsam.mytranslatorl41.room.HistoryDao
import geekbrains.ru.translator.model.data.AppState
import geekbrains.ru.translator.model.data.DataModel
import geekbrains.ru.translator.utils.convertDataModelSuccessToEntity
import geekbrains.ru.translator.utils.mapHistoryEntityToSearchResult

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
