package com.learn.lavsam.mytranslatorl41.model.datasource

import geekbrains.ru.translator.model.data.AppState
import geekbrains.ru.translator.model.datasource.DataSource

interface DataSourceLocal<T> : DataSource<T> {

    suspend fun saveToDB(appState: AppState)
}