package com.learn.lavsam.mytranslatorl41.model.datasource

import com.learn.lavsam.mytranslatorl41.model.data.AppState

interface DataSourceLocal<T> : DataSource<T> {

    suspend fun saveToDB(appState: AppState)
}