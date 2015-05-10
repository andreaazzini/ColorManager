# ColorManager
A simple and powerful color management Android library. It handles toolbar and/or status bar color design, and supports animations.

## Set up
<b>Gradle</b><br/>
Add the following line of code in the dependencies block of your application's build.gradle:<br/>
```java
compile 'com.azzarcher:colormanager:1.0.0'
```

## Usage
<ol>
  <li>Set up your ColorManager object and set all the needed information.<br/>
  ```java
  ColorManager colorManager = new ColorManager()
      .setToolbar(toolbar)
      .setToolbarColor(toolbarColor)
      .setStatusBarColor(getWindow(), statusBarColor);
  ```
  </li>
  <li>Perform a color transition on your Toolbar, starting from the color you've set with the `setToolbarColor` method.<br/>
  ```
  colorManager.animateToolbar(toColor);
  ```
  </li>
  <li>Perform a color transition on the status bar, starting from the color you've set with the `setStatusBarColor` method.<br/>
  ```
  colorManager.animateStatusBar(toColor);
  ```
  </li>
  <li>Generate Material Design primaryDark color from a your primary one.<br/>
  ```
  ColorManager.generateDarkColorFromPrimary(primaryColor);
  ```
  </li>
