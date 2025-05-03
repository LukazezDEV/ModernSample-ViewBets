import org.gradle.api.JavaVersion

object Configs{
    const val namespace = "io.github.lukazezdev.viewbetsapp"
    const val minSdk = 24
    const val compileSdk = 35
    const val targetSdk = 35
    val javaVersion = JavaVersion.VERSION_17

    object App{
        const val versionCode = 2
        const val versionName = "2.0-luka"
        const val applicationId = namespace
    }
}