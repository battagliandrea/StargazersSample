# StargazersSample
Sample app in which you can insert github owner and repository name to see the Stargazers list

![image](http://andreadev.com/github/image4.png)

# Import project

- open your **Terminal** app
- run command: `git clone <github-repository-url>`
- open **Android Studio** app
- select **Import Project from Gradle**

# Project specifications

- Kotlin version 1.2.0 
- minSdkVersion 17
- RxJava2
- Dagger2
- Retrofit2
- evernote/Android-State

# Test

I user Espresso to manage app test. [Espresso doc ](https://developer.android.com/training/testing/espresso/index.html)

To test this project you have to:

- Create the test configuration with a custom runner: android.support.test.runner.AndroidJUnitRunner
- Open Run menu | Edit Configurations
- Add a new Android Tests configuration
- Choose a module
- Add a Specific instrumentation runner: android.support.test.runner.AndroidJUnitRunner

or execute the following Gradle command:
   
- ./gradlew connectedAndroidTest

# Support 

You can write me to [battaglia.andry@gmail.com](battaglia.andry@gmail.com)

# License

[https://www.apache.org/licenses/LICENSE-2.0](https://www.apache.org/licenses/LICENSE-2.0)