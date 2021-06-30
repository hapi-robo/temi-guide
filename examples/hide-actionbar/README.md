# temi App Template
This is an Android Studio template project that includes the most basic changes for the app to run on temi.

## Changes
The following is a list of additions made to the basic Android Studio "Empty Activity" Project Template. A more detailed description can be found in [temi's SDK wiki](https://github.com/robotemi/sdk/wiki).

### build.gradle (app)
Add temi's SDK.
```
dependencies {
	...
	implementation 'com.robotemi:sdk:0.10.70'
	...
}
```

### AndroidManifest.xml
Use temi's `SkillTheme` to remove Android's default action bar.
```xml
<application
	...
	android:theme="@style/SkillTheme">
	...
</application>
```

Add `meta-data` tag so that the skill appears in temi's launcher. 
```xml
<application
	...
	<meta-data
            android:name="com.robotemi.sdk.metadata.SKILL"
            android:value="@string/app_name" />
    ...
</application>
```

### MainActivity.java
Implements `OnRobotReadyListener` on `MainActivity` class.
```java
public class MainActivity extends AppCompatActivity implements OnRobotReadyListener
```

Instantiate a `Robot` class.
```java
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // Initialize robot instance
    sRobot = Robot.getInstance();
}
```

Add and remove `OnRobotReadyListener` at the start and end of Android app lifecycle.
```java
@Override
protected void onStart() {
    super.onStart();

    // Add robot event listeners
    sRobot.addOnRobotReadyListener(this);
}

@Override
protected void onStop() {
    super.onStop();

    // Remove robot event listeners
    sRobot.removeOnRobotReadyListener(this);
}
```

Log a message to the console and hide temi's top action bar when the `OnRobotReadyListener` is called.
```java
@Override
public void onRobotReady(boolean isReady) {
    if (isReady) {
        Log.i(TAG, "Robot is ready");
        sRobot.hideTopBar(); // hide temi's top action bar when skill is active
    }
}
```

## References
* [temi SDK](https://github.com/robotemi/sdk)