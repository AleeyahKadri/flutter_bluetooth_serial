buildscript {
    repositories {
        google()
        jcenter()
    }

    dependencies {
        classpath("com.android.tools.build:gradle:4.1.0")
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

rootProject.buildDir = file("../build")
subprojects {
    buildDir = File(rootProject.buildDir, name)
}
subprojects {
    evaluationDependsOn(":app")
}

tasks.register<Delete>("clean") {
    delete(rootProject.buildDir)
}
