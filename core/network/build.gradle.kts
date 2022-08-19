plugins {
    id("com.apollographql.apollo3").version("3.1.0")
}

android {
    externalNativeBuild {
        cmake {
            path("CMakeLists.txt")
        }
    }
}

dependencies {
    api(project(":core:main"))
}

apollo {
    packageName.set("com.iddevops.core.network")
}