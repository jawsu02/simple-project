
# app-automation-tests

PP App automation framework for IOS and Android extended to Web and API's

#### Running App Tests 
*on IOS Simulators:*  **gradle clean build cucumberIOSSimulatorTests**

*on IOS Devices:* **gradle clean build cucumberIOSDeviceTests**

*on Android emulators:* **gradle clean build cucumberAndroidEmulatorTests**

*on Android Devices:* **gradle clean build cucumberAndroidDeviceTests**

#### Running API Tests 
**gradle clean build RunApiTests**

#### Running Web Tests 
**gradle clean build RunWebTests**

###### Things to Note before running app tests

* make sure appium server is up and running
* Device and OS is updated accordingly in config.properties while executing device tests

#### IOS real device setup
* Make sure the provision profile for the App / device is in place
* Make sure WebDriverAgentRunner is configured with provision profile

#### Install Instructions for App tests
* Install Homebrew (https://brew.sh)
* Install Java 8 (http://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html)
* Install gradle using brew(https://gradle.org/install/)
* Install node using brew (brew install node)
* Download Intellij 
* Download Android SDK
* Install xcode command line tools
* Install Appium desktop app (https://github.com/appium/appium-desktop)
* Install Appium command line using below commands in terminal
  * npm install -g appium
  * npm install wd
* Install appium doctor using below commands in terminal
  * npm install -g appium-doctor
* Install ios app deploying packages
  * brew install libimobiledevice
  * npm install -g ios-deploy
  * brew install ios-deploy
  * brew install carthage
* Set path variables in ~/.bash_profile
  * export ANDROID_HOME=/Users/{firstName.LastName}/Library/Android/sdk
  * export PATH=$PATH:$ANDROID_HOME/platform-tools
  * export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_162.jdk/Contents/Home
  * export PATH=$PATH:$JAVA_HOME/bin
  * export GRADLE_HOME=/usr/local/Cellar/gradle/4.5



#### Install Instructions for API only (Mac)
* Install Homebrew (https://brew.sh)
* Install Java 8 (http://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html)
* Install gradle using brew(https://gradle.org/install/)
* Install node using brew (brew install node)
* Download Intellij 
* Set path variables in ~/.bash_profile
  * export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_162.jdk/Contents/Home
  * export PATH=$PATH:$JAVA_HOME/bin
  * export GRADLE_HOME=/usr/local/Cellar/gradle/4.5

#### Install Instructions for API Only (Windows)
* Install Java 8 SDK (http://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html)
* Install chocolatey (https://chocolatey.org/install)
* Install gradle using chocolatey(choco install gradle)
* Download Intellij 
* Set up environment variables
    * create a JAVA_HOME user variable with the path of java installation direction
    * create a GRADLE_HOME user variable with the path of gradle installation direction
    * Append environment variable PATH with %JAVA_HOME%\bin;%GRADLE_HOME%\bin(https://www.bryanlor.com/blog/gradle-tutorial-how-install-gradle-windows)