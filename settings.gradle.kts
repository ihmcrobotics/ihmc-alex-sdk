pluginManagement {
   plugins {
      id("us.ihmc.ihmc-build") version "1.3.0"
   }
}

buildscript {
   repositories {
      maven { url = uri("https://plugins.gradle.org/m2/") }
      maven { url = uri("https://robotlabfiles.ihmc.us/repository/") }
      mavenLocal()
   }
   dependencies {
      classpath("us.ihmc:ihmc-build:1.3.0")
      classpath("us.ihmc:ros2-msg-to-pubsub-generator:1.2.4")
   }
}

ProcessBuilder("git", "submodule", "update", "--init", "--recursive").directory(settings.settingsDir).start().waitFor()

val ihmcSettingsConfigurator = us.ihmc.build.IHMCSettingsConfigurator(settings, logger, extra)
ihmcSettingsConfigurator.checkRequiredPropertiesAreSet()
ihmcSettingsConfigurator.configureExtraSourceSets()
ihmcSettingsConfigurator.findAndIncludeCompositeBuilds()
