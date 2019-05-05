package gabriellee.project.mvpdagger.injection.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import gabriellee.project.mvpdagger.base.BaseView

@Module
@Suppress("unused")
object ContextModule {

    /**
     * Provides the Context
     * @Param baseView the BaseView used to provides the context
     * @return the Context to be provided
     */
    @Provides
    @JvmStatic
    internal fun provideContext(baseView: BaseView): Context {
        return baseView.getContext()
    }

    /**
     * Provides the application context
     * @param context Context in which the application is running
     * @return the Application Context to be provided
     */
    @Provides
    @JvmStatic
    internal fun provideApplication(context: Context): Application{
        return context.applicationContext as Application
    }
}