# ColorManager
A simple and powerful color management Android library. It handles toolbar and status bar color design, and supports animations.

## Set up
###Gradle
Add the following line of code in the dependencies block of your application's build.gradle:<br/>

    compile 'com.azzarcher:colormanager:1.0.0'

## Usage
To manage the color animations and to set the color parameters, just follow the guidelines below:

1. Set up your ColorManager object and set all the needed information.

        ColorManager colorManager = new ColorManager()
            .setToolbar(toolbar)
            .setToolbarColor(toolbarColor)
            .setStatusBarColor(getWindow(), statusBarColor);

2. Perform a color transition on your Toolbar, starting from the color you've set with the `setToolbarColor` method.<br/>

        colorManager.animateToolbar(toColor);

3. Perform a color transition on the status bar, starting from the color you've set with the `setStatusBarColor` method.<br/>

        colorManager.animateStatusBar(toColor);


4. Generate Material Design primaryDark color from a your primary one.<br/>

        ColorManager.generateDarkColorFromPrimary(primaryColor);
