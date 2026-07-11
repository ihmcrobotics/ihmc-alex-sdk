import us.ihmc.jros2.generator.jros2GenTask

plugins {
   id("us.ihmc.ihmc-build")
   id("us.ihmc.jros2.generator") version "1.4.0"
}

ihmc {
   group = "us.ihmc"
   version = "0.4.0"
   vcsUrl = "https://github.com/ihmcrobotics/ihmc-alex-sdk"
   openSource = true

   configureDependencyResolution()
   resourceDirectory("main", "../../alex-models")
   resourceDirectory("main", "../../alex-ros2")
   ihmc.sourceSet("main").resources.exclude("/ihmc_hands_ros2")
   javaDirectory("main", "../../alex-ros2/alex_msgs/src/main/generated-java")
   configurePublications()
}

mainDependencies {
   api("us.ihmc:ihmc_hands_ros2:0.3.0")
}

tasks.register<jros2GenTask>("generateMessages") {
   description = "Generate Alex ROS 2 interfaces using jros2"
   group = "build"

   packagePaths = listOf(
      projectDir.resolve("alex-ros2/alex_msgs").absolutePath,
   )

   outputDir = projectDir.resolve("alex-ros2/alex_msgs/src/main/generated-java").absolutePath
}
