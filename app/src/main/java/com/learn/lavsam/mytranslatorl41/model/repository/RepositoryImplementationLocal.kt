package com.learn.lavsam.mytranslatorl41.model.repository

import com.learn.lavsam.mytranslatorl41.model.data.AppState
import com.learn.lavsam.mytranslatorl41.model.data.DataModel
import com.learn.lavsam.mytranslatorl41.model.datasource.DataSourceLocal

class RepositoryImplementationLocal(private val dataSource: DataSourceLocal<List<DataModel>>) :
    RepositoryLocal<List<DataModel>> {

    override suspend fun getData(word: String): List<DataModel> {
        return dataSource.getData(word)
    }

    override suspend fun saveToDB(appState: AppState) {
        dataSource.saveToDB(appState)
    }
}