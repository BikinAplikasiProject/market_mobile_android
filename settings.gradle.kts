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
include(":control:provider")
include(":control:igniter")
include(":core")
include(":core:main")
include(":core:network")
include(":core:ui")
include(":modcommon")
include(":modcommon:account")
include(":modcommon:example")
include(":modseller")
include(":modseller:dashboard")
include(":modbuyer")
include(":modbuyer:dashboard")
include(":modwebadmin")
include(":modwebadmin:dashboard")
