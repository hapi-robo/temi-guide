***************
Getting Started
***************

The following are instructions for building a basic Android app that appears in temi's launcher.


Changes to an Empty Activity Project
====================================
Using `Android Studio <https://developer.android.com/studio/>`_, start with the ``Empty Activity`` Project Template and make the following changes.


build.gradle (app)
------------------
Add temi's SDK. You can find the latest release information `here <https://github.com/robotemi/sdk/wiki/Release-Info>`_.

.. code-block:: groovy

  dependencies {
    ...
    implementation 'com.robotemi:sdk:0.10.70'
    ...
  }


proguard-rules.pro
------------------
If you are using `minification, obfuscation, or optimization <https://developer.android.com/studio/build/shrink-code>`_ of any kind, add the following line.

.. code-block::

  -keep class com.robotemi.sdk.** { *; }


AndroidManifest.xml
-------------------
Use temi's ``SkillTheme`` to remove the app's default `ActionBar <https://developer.android.com/reference/androidx/appcompat/app/ActionBar>`_.

.. code-block:: xml

  <application
    ...
    android:theme="@style/SkillTheme">
    ...
  </application>


Add the following ``meta-data`` tag so that the skill will appear in temi's launcher. 

.. code-block:: xml

  <application>
    ...
    <meta-data
      android:name="com.robotemi.sdk.metadata.SKILL"
      android:value="@string/app_name" />
    ...
  </application>


MainActivity.java
-----------------
Implement ``OnRobotReadyListener`` in the ``MainActivity`` class.

.. code-block:: Java

  public class MainActivity extends AppCompatActivity implements OnRobotReadyListener

Instantiate a ``Robot`` class.

.. code-block:: Java
  :linenos:
  :emphasize-lines: 9

  Robot mRobot;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      // Initialize robot instance
      mRobot = Robot.getInstance();
  }


Add and remove ``OnRobotReadyListener`` at the start and end of the app lifecycle.

.. code-block:: Java
  :linenos:
  :emphasize-lines: 6, 14

  @Override
  protected void onStart() {
      super.onStart();

      // Add robot event listeners
      mRobot.addOnRobotReadyListener(this);
  }

  @Override
  protected void onStop() {
      super.onStop();

      // Remove robot event listeners
      mRobot.removeOnRobotReadyListener(this);
  }

.. _sdk-robot-ready:

onRobotReady()
==============
In ``MainActivity.java``, log a message to the console and hide temi's ActionBar when the ``OnRobotReady()`` is called.

.. code-block:: Java

  @Override
  public void onRobotReady(boolean isReady) {
      if (isReady) {
          mRobot.hideTopBar(); // hide temi's top action bar when skill is active
      }
  }

.. Attention::
  temi's methods will only work correctly after the robot is *ready*. Use ``onRobotReady()`` to verify this.


Example
=======
* `Hello World <https://github.com/hapi-robo/temi-guide/tree/master/examples/hello-world>`_


References
==========
* `temi SDK Wiki <https://github.com/robotemi/sdk/wiki>`_
