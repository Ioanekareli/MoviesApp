<h1 align="center">MoviesApp</h1>

# Table of contents

- [Introduction](#introduction)
- [Installation](#installation)
- [Contributing](#contributing)
- [License](#license)
  - [Authors / Copyright](#authors--copyright)
  - [Third-party component licenses](#third-party-component-licenses)
    - [Tools](#tools)
    - [Libraries](#libraries)
  - [License details](#license-details)

# Introduction

* This repository contains the source code of MoviesApp's Android client.
* MoviesApp is movies catalog application, using which consumer can search movies, read description and watch the teasers.
# Installation

The app can be installed using [Android Studio](https://developer.android.com/studio) or the [Gradle Wrapper](https://docs.gradle.org/current/userguide/gradle_wrapper.html) (gradlew) command line tool.

## Using Android Studio

This is the recommended and most straightforward method. First, clone the repository with:

```sh
git clone git@github.com:ioanekareli/MoviesApp.git
```

From Android Studio, select *Import Project*, then select the root folder of the cloned repository.
Click *Make Project* to build the app and download all the required dependencies.
Click *Run app* to install the app on your device or emulator.

## Using the Gradle Wrapper command line tool

The Gradle Wrapper can be built using [Gradle](https://docs.gradle.org/current/userguide/installation.html#installation). You can install Gradle using [Brew](https://brew.sh/):

```sh
brew install gradle
```

To generate the wrapper, execute this task:

```sh
gradle wrapper
```
 
Clone the repository with:

```sh
git clone git@github.com:ioanekareli/MoviesApp.git
```

Enter the project root folder with:

```sh
cd moviesapplication
```

Execute the command:

  
```sh
./gradlew assembleDebug
```
  
This creates an APK named *app-debug.apk* in *moviesApp-android/app/build/outputs/apk/*. The file is already signed with the debug key and aligned with [zipalign](https://developer.android.com/studio/command-line/zipalign), so you can immediately install it on a device.

To build the APK and immediately install it on a running emulator or connected device, instead invoke installDebug:

```sh
./gradlew installDebug
```
  
# Contributing

Contributions are most welcome. 
The MoviesApp project is composed of different repositories—one for each component or service.
# License

## Authors / Copyright

2022, BTU (c) Ioane Kareli, Giorgi Tamarashvili

## Third-party component licenses

### Tools

| Name                                                        | License                   |
| ----------------------------------------------------------- | ------------------------- |
| [Gradle](https://gradle.org/)                         | Apache 2.0                       |
| [Ktlint](https://github.com/pinterest/ktlint) | MIT                       |
| [External Movies API](https://api.themoviedb.org) | OpenSource |

### Libraries

| Name                                                       | License    |
| ---------------------------------------------------------- | ---------- |
| [Retrofit](https://github.com/square/retrofit)      | Apache 2.0        |
| [kotlinx.coroutines](https://github.com/Kotlin/kotlinx.coroutines) | Apache 2.0 |
## License details

The licence for this repository is a [GNU Affero General Public Licence version 3](https://www.gnu.org/licenses/agpl-3.0.html) (SPDX: AGPL-3.0). Please see the [LICENSE](LICENSE) file for full reference.
