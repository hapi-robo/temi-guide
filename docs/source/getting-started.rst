Getting Started
===============

The following are instructions for building the most basic Android app that appears in temi's launcher. You can find a working example `here <https://github.com/hapi-robo/temi-app-template>`_.


Create an Empty Activity Project
--------------------------------
Using `Android Studio <https://developer.android.com/studio/>`_, use the ``Empty Activity`` Project Template to create a new project.


build.gradle (app)
++++++++++++++++++
Add temi's SDK. You can find the latest release `here <https://github.com/robotemi/sdk/wiki/Release-Info>`_.

.. code-block:: xml

  dependencies {
    ...
    implementation 'com.robotemi:sdk:0.10.70'
    ...
  }

AndroidManifest.xml
+++++++++++++++++++
Use temi's ``SkillTheme`` to remove Android's default action bar.

.. code-block:: xml

  <application
    ...
    android:theme="@style/SkillTheme">
    ...
  </application>


Add the following ``meta-data`` tag so that the skill will appear in temi's launcher. 

.. code-block:: xml

  <application
    ...
    <meta-data
              android:name="com.robotemi.sdk.metadata.SKILL"
              android:value="@string/app_name" />
      ...
  </application>


MainActivity.java
+++++++++++++++++
Implement ``OnRobotReadyListener`` in the ``MainActivity`` class.

.. code-block:: Java

  public class MainActivity extends AppCompatActivity implements OnRobotReadyListener

Instantiate a ``Robot`` class.

.. code-block:: Java

  @Override
  protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      // Initialize robot instance
      sRobot = Robot.getInstance();
  }

Add and remove ``OnRobotReadyListener`` at the start and end of the app lifecycle.

.. code-block:: Java

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

Log a message to the console and hide temi's top action bar when the ``OnRobotReadyListener`` is called.

.. code-block:: Java

  @Override
  public void onRobotReady(boolean isReady) {
      if (isReady) {
          Log.i(TAG, "Robot is ready");
          sRobot.hideTopBar(); // hide temi's top action bar when skill is active
      }
  }

.. note::
  All of temi's methods will only work correctly after the robot is *ready*. Use ``onRobotReady()`` to verify this. 


References
----------
- `temi SDK Wiki <https://github.com/robotemi/sdk/wiki>`_
