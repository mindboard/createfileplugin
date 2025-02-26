plugins {
    `kotlin-dsl`
    `maven-publish`
}

repositories {
    gradlePluginPortal()
}

group = "com.mindboardapps.gradle.plugin"
version = "1.0.0"

gradlePlugin {
    plugins {
        create("createfileplugin") {
            id = "mindboard.createfileplugin"
            implementationClass = "com.mindboardapps.gradle.plugin.MyCreateFilePlugin"
        }
    }
}

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/mindboard/createfileplugin")
            credentials {
                username = project.findProperty("gpr.user") as String? ?: System.getenv("USERNAME")
                password = project.findProperty("gpr.key") as String? ?: System.getenv("TOKEN")
            }
        }
    }
}
