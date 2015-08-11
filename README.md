# ColorManager
A simple color manager for Android. It handles toolbar and status bar color design, and supports animations.

## Set up
###Gradle
Add the following line of code in the dependencies block of your application's build.gradle:<br/>

    compile 'com.azzarcher:colormanager:1.0.3'

## Usage
To manage the color animations and to set the color parameters, just follow the guidelines below:

1. Set up your ColorManager object and set all the needed information in the `onCreate` method.

        ColorManager colorManager = new ColorManager()
            .setToolbar(toolbar)
            .setToolbarColor(toolbarColor)
            .setStatusBarColor(getWindow(), statusBarColor);
    
    This code works for both Lollipop toolbars and support library toolbars. Remember to set the action bar with, respectively, `setActionBar(toolbar)` or `setSupportActionBar(toolbar)`. Use the `NoActionBar` version of your themes in styles.xml.

2. Perform a color transition on your Toolbar, starting from the color you've set with the `setToolbarColor` method. The following code should be pasted in the `onStart` method.<br/>

        colorManager.animateToolbar(toColor);

3. Perform a color transition on the status bar, starting from the color you've set with the `setStatusBarColor` method. The following code should be pasted in the `onStart` method.<br/>

        colorManager.animateStatusBar(toColor);


4. Generate Material Design primaryDark color from your primary one with the static `generateDarkColorFromPrimary` method.<br/>

        ColorManager.generateDarkColorFromPrimary(primaryColor);

## Feedbacks
Feel free to email me about your feedbacks and suggestions for this library maintainance.
