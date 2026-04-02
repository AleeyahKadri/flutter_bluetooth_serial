import java.util.Properties

include(":app")

val flutterProjectRoot = rootProject.projectDir.parentFile.toPath()

val plugins = Properties()
val pluginsFile = File(flutterProjectRoot.toFile(), ".flutter-plugins")
if (pluginsFile.exists()) {
    pluginsFile.reader(Charsets.UTF_8).use { reader ->
        plugins.load(reader)
    }
}

plugins.forEach { name, path ->
    val pluginDirectory = flutterProjectRoot.resolve(path.toString()).resolve("android").toFile()
    include(":$name")
    project(":$name").projectDir = pluginDirectory
}
