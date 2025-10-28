plugins {
   id("us.ihmc.ihmc-build")
}

ihmc {
   group = "us.ihmc"
   version = "0.3.1"
   vcsUrl = "https://github.com/ihmcrobotics/ihmc-alexander-sdk"
   openSource = true

   // Include SDK content as classpath resources
   configureDependencyResolution()
   resourceDirectory("main", "../../alexander-models")
   resourceDirectory("main", "../../alexander-ros2")
   ihmc.sourceSet("main").resources.exclude("/ihmc_hands_ros2")
   resourceDirectory("main", "../../alexander-ros2/alexander_msgs/src/main/generated-idl")
   javaDirectory("main", "../../alexander-ros2/alexander_msgs/src/main/generated-java")
   configurePublications()
}

mainDependencies {
   api("us.ihmc:ihmc_hands_ros2:source")
   api("us.ihmc:ros2-common-interfaces:1.2.4") {
      exclude(group = "org.junit.jupiter", module = "junit-jupiter-api")
      exclude(group = "org.junit.jupiter", module = "junit-jupiter-engine")
      exclude(group = "org.junit.platform", module = "junit-platform-commons")
      exclude(group = "org.junit.platform", module = "junit-platform-launcher")
   }
}

val generator = us.ihmc.ros2.rosidl.ROS2InterfaceGenerator()
val msg_packages = listOf("alexander_msgs")

tasks.register("generateMessages") {
   doFirst {
      delete("alexander-ros2/alexander_msgs/src/main/generated-idl")
      delete("alexander-ros2/alexander_msgs/src/main/generated-java")
      delete("build/tmp/generateMessages")

      var foundDependency = false

      copy {
         for (file in configurations.runtimeClasspath.get().files)
         {
            if (file.name.contains("ros2-common-interfaces"))
            {
               from(zipTree(file))
               foundDependency = true
            }
            into(file("build/tmp/generateMessages/ros2-common-interfaces"))
         }
      }

      if (!foundDependency)
      {
         throw GradleException("Could not find ros2-common-interfaces in configurations.runtimeClasspath!")
      }

      generator.addPackageRootToIDLGenerator(file("build/tmp/generateMessages/ros2-common-interfaces/rcl_interfaces").toPath())
      generator.addPackageRootToIDLGenerator(file("build/tmp/generateMessages/ros2-common-interfaces/common_interfaces").toPath())
      generator.addPackageRootToIDLGenerator(file("alexander-ros2").toPath())

      generator.addCustomIDLFiles(file("build/tmp/generateMessages/ros2-common-interfaces/").toPath())

      generator.generate(file("build/tmp/generateMessages/generated-idl").toPath(),
                         file("build/tmp/generateMessages/generated-ros1").toPath(),
                         file("build/tmp/generateMessages/generated-java").toPath())

      for (packag in msg_packages) {
         copy {
            from("build/tmp/generateMessages/generated-idl/$packag")
            into("alexander-ros2/alexander_msgs/src/main/generated-idl/$packag")
         }

         copy {
            from("build/tmp/generateMessages/generated-java/$packag")
            into("alexander-ros2/alexander_msgs/src/main/generated-java/$packag")
         }
      }

      us.ihmc.ros2.rosidl.ROS2InterfaceGenerator.convertDirectoryToUnixEOL(file("alexander-ros2/alexander_msgs/src/main/generated-idl").toPath())
      us.ihmc.ros2.rosidl.ROS2InterfaceGenerator.convertDirectoryToUnixEOL(file("alexander-ros2/alexander_msgs/src/main/generated-java").toPath())
   }
}