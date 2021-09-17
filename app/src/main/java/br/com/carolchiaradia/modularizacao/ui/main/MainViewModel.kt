package br.com.carolchiaradia.modularizacao.ui.main

import androidx.lifecycle.MutableLiveData
import br.com.carolchiaradia.domain.model.Product
import br.com.carolchiaradia.domain.usecases.GetProductsUseCase
import br.com.carolchiaradia.modularizacao.viewmodel.BaseViewModel
import br.com.carolchiaradia.modularizacao.viewmodel.StateMachineSingle
import br.com.carolchiaradia.modularizacao.viewmodel.ViewState
import io.reactivex.Scheduler
import io.reactivex.rxkotlin.plusAssign

class MainViewModel (
    private val GetProductsUseCase: GetProductsUseCase,
    private val uiScheduler : Scheduler ): BaseViewModel() {

    val state = MutableLiveData<ViewState<List<Product>>>().apply {
        value = ViewState .Loading
    }

    fun getProducts (forceUpdate: Boolean = false) {
        disposables += GetProductsUseCase.execute( forceUpdate = forceUpdate)
            .compose(StateMachineSingle())
            .observeOn( uiScheduler )
            .subscribe(
                {
                    state.postValue( it)
                },
                {
                    state.postValue( ViewState .Failed( it))
                }
            )
    }
}