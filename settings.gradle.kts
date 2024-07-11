pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven {
            setUrl("https://androidx.dev/snapshots/latest/artifacts/repository")
        }
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven {
            setUrl("https://androidx.dev/snapshots/latest/artifacts/repository")
        }
    }
}

rootProject.name = "Sample TVCompose App"
include(":app")
 