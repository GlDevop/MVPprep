package gabriellee.project.mvpdagger.base

import gabriellee.project.mvpdagger.injection.component.DaggerPresenterInjector
import gabriellee.project.mvpdagger.injection.component.PresenterInjector
import gabriellee.project.mvpdagger.injection.module.ContextModule
import gabriellee.project.mvpdagger.injection.module.NetworkModule
import gabriellee.project.mvpdagger.ui.PostPresenter

abstract class BasePresenter<out V : BaseView> (protected val view: V) {

    init {
        inject()
    }

    /**
     * The injector used to inject required dependencies
     */
    private val injector: PresenterInjector = DaggerPresenterInjector
        .builder()
        .baseView(view)
        .contextModule(ContextModule)
        .networkModule(NetworkModule)
        .build()

    /**
     * This method may be called when the presenter view is created
     */
    open fun onViewCreated(){}

    /**
     * This method may be called when the presenter view is destroyed
     */
    open fun onViewDestroyed(){}

    /**
     * Injects the required dependencies
     */
    private fun inject() {
        when (this) {
            is PostPresenter -> injector.inject(this)
        }
    }
}