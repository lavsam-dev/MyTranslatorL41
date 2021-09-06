package com.learn.lavsam.mytranslatorl41.model.repository

import com.learn.lavsam.mytranslatorl41.model.data.AppState

interface RepositoryLocal<T> : Repository<T> {

    suspend fun saveToDB(appState: AppState)
}