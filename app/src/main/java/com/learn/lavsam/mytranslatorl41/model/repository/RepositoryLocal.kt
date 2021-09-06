package com.learn.lavsam.mytranslatorl41.model.repository

import geekbrains.ru.translator.model.data.AppState
import geekbrains.ru.translator.model.repository.Repository

interface RepositoryLocal<T> : Repository<T> {

    suspend fun saveToDB(appState: AppState)
}