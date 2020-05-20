package michaelbukachi.fragmentscenariotest.dagger

object Injector {
    private var component: ApplicationComponent? = null

    fun initialize(component: ApplicationComponent) {
        this.component = component
    }

    fun get(): ApplicationComponent {
        return component ?: throw UninitializedPropertyAccessException("component should be set")
    }
}