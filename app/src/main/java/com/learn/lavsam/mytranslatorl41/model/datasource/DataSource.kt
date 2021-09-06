package com.learn.lavsam.mytranslatorl41.model.datasource

interface DataSource<T> {

    suspend fun getData(word: String): T
}
