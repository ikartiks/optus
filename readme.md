# Optus readme

Dear reviewer, kindly go through this file before reviewing this project.

Below certain assumptions made before development

  - For point 3 of scenario 2 I am directly navigating the user to destination location
  - Since the design choice is mine I have added a small anim rather than using sliding menu or tab bar
  - There are 2 different application ids as requested & I have tested both the apps on emulator and 2 devices, min supported sdk is 15(ICE_CREAM_SANDWICH_MR1), however I have tested on Nogut+ devices
  - The app does support device rotation and config change, as of now its limited to not recreating activity. Seperate layouts can be provided for the same, however since I had not been mentioned about any time constraints I am submitting the project within 1 day. This can be done in future.

### Tech

Optus only uses android support libraries & gson as of now:

* [Kotlin](https://kotlinlang.org/) - Most developers are now switching to this language as it is the newly supported language for android with benifites much greater than traditional java. To know more click on the link.
Some of the things that I have used kotlin for is 
    - consice code
    - null safety
    - data binding (eliminates need of third party libraries)
    - It is now the preferred language by all developers worldwide as well as by Google
    - kindly note I have adopted this language since a year and am equally proficient in java

* [My library](https://github.com/ikartiks/kartiksCustomViewsGradle/) - I would encourage you to go through this one as well, since it supports gifs and custom fonts by default (although custom font support has been added in support library for android, I had wirttten this code much prior to that)

### Installation

Steps mentioned below, but do let me know if you are having troubles with it.

```sh
use the git clone url in Android Studio
Once cloned select default gradle wrapper 
in apps build.gradle file, you will have to change the location of keystore to make release build with different application id (its a local path so cannot be done from my end)
```

### Todos
 - Optimise if required


### Additional Info
   - Kindly note I have had experience working on backend, frontend, and noSql technologies as well

