package br.com.carolchiaradia.modularizacao.di

import br.com.carolchiaradia.modularizacao.ui.main.MainListAdapter
import br.com.carolchiaradia.modularizacao.ui.main.MainViewModel
import com.squareup.picasso.Picasso
import io.reactivex.android.schedulers.AndroidSchedulers
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {

    single { Picasso.get() }

    factory { MainListAdapter(picasso = get ()) }

    viewModel { MainViewModel(
        GetProductsUseCase = get(),
        uiScheduler = AndroidSchedulers.mainThread()
    )
    }
}