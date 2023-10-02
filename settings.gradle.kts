pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven {
            credentials {
                username = providers.gradleProperty("repositoryUsername").get()
                password = providers.gradleProperty("repositoryIdentityToken").get()
            }
            url = uri("https://repositories.tomtom.com/artifactory/maven")
        }
        maven { url = uri("https://jitpack.io") }
    }
}

rootProject.name = "TomTomExample"
include(":app")
 