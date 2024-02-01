@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    kotlin("multiplatform")
    id("co.touchlab.kmmbridge")
    id("co.touchlab.skie")
    `maven-publish`
}

kotlin {
    @Suppress("OPT_IN_USAGE")
    targetHierarchy.default()

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            export(project(":analytics"))
            isStatic = true
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(project(":breeds"))
                api(project(":analytics"))
            }
        }
    }
}

//addGithubPackagesRepository()

publishing {
    //val properties = readProperties(project.rootProject.file("local.properties"))
    repositories {
        maven {
            name = "KMMBridgeTest"
            url = uri("https://maven.pkg.github.com/dzertak/KMMBridgeTest")
            credentials {
                username = System.getenv("USERNAME") //?: properties.getProperty("GITHUB_ID")
                password = System.getenv("PASSWORD") //?:properties.getProperty("GITHUB_PACKAGES_TOKEN")
            }
        }
    }
}

kmmbridge {
    mavenPublishArtifacts()
    spm()
}
