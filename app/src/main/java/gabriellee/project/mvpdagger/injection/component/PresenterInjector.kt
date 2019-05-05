package gabriellee.project.mvpdagger.injection.component

import dagger.BindsInstance
import dagger.Component
import dagger.Module
import gabriellee.project.mvpdagger.base.BaseView
import gabriellee.project.mvpdagger.injection.module.ContextModule
import gabriellee.project.mvpdagger.injection.module.NetworkModule
import gabriellee.project.mvpdagger.ui.PostPresenter
import javax.inject.Singleton

@Singleton
@Component(modules = [(ContextModule::class), (NetworkModule::class)])
interface PresenterInjector {

    /**
     * Injects required dependencies into the specified Post Presenter.
     * @param postPresenter PostPresenter in which to inject the dependencies
     */
    fun inject(postPresenter: PostPresenter)

    @Component.Builder
    interface Builder {
        fun build(): PresenterInjector

        fun networkModule(networkModule: NetworkModule): Builder
        fun contextModule(contextModule: ContextModule): Builder

        @BindsInstance
        fun baseView(baseView: BaseView): Builder
    }

}