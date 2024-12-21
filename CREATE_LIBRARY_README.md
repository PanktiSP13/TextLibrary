# Creating and Publishing an Android Library

This document outlines the steps to create and publish an Android library. 
Below is a guide based on the process followed to create and publish the **TextModifier** library.

## Steps to Create an Android Library

### 1. Create a New Project
- Start by creating a new Android project in Android Studio.

### 2. Create a New Module
- Add a new module by selecting **Android Library**.

### 3. Include the Module in the Project
- Update the `settings.gradle` file to include the module:
  ```gradle
  include ':mylibrary'
  ```
- Add the module to your app's `build.gradle` file:
  ```gradle
  implementation project(':mylibrary')
  ```

### 4. Add Code to the Library
- Write and test the code in the library module.
- Test the library's functionality by accessing it from the `MainActivity` or another component in your app.

### 5. Prepare for Publishing
- Once the library works as expected, prepare it for publishing.
- Add the following to the library module's `build.gradle` file:

#### a. Apply the Maven Publish Plugin
```gradle
plugins {
    id 'maven-publish'
}
```

#### b. Update `settings.gradle` for JitPack
- Add the following under dependency resolution management:
  ```gradle
  repositories {
      maven { url "https://jitpack.io" }
  }
  ```

#### c. Register Artifacts
```gradle
tasks.register("prepareArtifacts") {
    dependsOn("assembleRelease")
}
```

#### d. Configure Publishing
```gradle
publishing {
    publications {
        create<MavenPublication>("release") {
            afterEvaluate {
                from(components["release"])
            }
            groupId = "com.github.PanktiSP13"
            artifactId = "TextLibrary"
            version = "1.0.2"
        }
    }
}
```

### 6. Build and Publish Locally
- Run the following commands in the Android Studio terminal:
  ```bash
  ./gradlew assembleRelease
  ./gradlew publishReleasePublicationToMavenLocal
  ```
- Ensure the build succeeds.

### 7. Push to GitHub
- Push your code to GitHub.
- Create a new tag for the release:
  ```bash
  git tag 1.0.0
  git push origin 1.0.0
  ```

### 8. Publish on JitPack
- Visit [JitPack](https://jitpack.io) and search for your GitHub repository.
- Locate the recently released code and click **Get it!**

### 9. Update Dependency in App
- Remove the module from `settings.gradle` and `build.gradle` in the app module.
- Add the library as a dependency:
  ```gradle
  dependencies {
      implementation "com.github.PanktiSP13:TextLibrary:1.0.2"
  }
  ```

### 10. Test the Published Library
- Run your app and verify the library functions as expected.

## Conclusion
By following these steps, you can successfully create and publish an Android library.
