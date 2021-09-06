package com.learn.lavsam.mytranslatorl41.view.history

import com.learn.lavsam.mytranslatorl41.model.data.AppState
import com.learn.lavsam.mytranslatorl41.model.data.DataModel
import com.learn.lavsam.mytranslatorl41.model.repository.Repository
import com.learn.lavsam.mytranslatorl41.model.repository.RepositoryLocal
import com.learn.lavsam.mytranslatorl41.viewmodel.Interactor

class HistoryInteractor(
    private val repositoryRemote: Repository<List<DataModel>>,
    private val repositoryLocal: RepositoryLocal<List<DataModel>>
) : Interactor<AppState> {

    override suspend fun getData(word: String, fromRemoteSource: Boolean): AppState {
        return AppState.Success(
            if (fromRemoteSource) {
                repositoryRemote
            } else {
                repositoryLocal
            }.getData(word)
        )
    }
}