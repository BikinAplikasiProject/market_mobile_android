pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "Base Compose"
include(":app")
include(":control")
include(":control:module")
include(":core")
include(":core:main")
include(":core:network")
include(":core:ui")
include(":modules")
include(":modules:uikit")
include(":modules:common")
