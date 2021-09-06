package com.learn.lavsam.mytranslatorl41.model.repository

interface Repository<T> {

    suspend fun getData(word: String): T
}
