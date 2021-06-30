Hide ActionBar & Pull-Down Bar
==============================

For Kiosk applications, you'll want to hide the temi's `ActionBar <https://developer.android.com/reference/androidx/appcompat/app/ActionBar>`_.

.. image:: _static/img/temi-actionbar.png 
  :width: 800
  :alt: temi ActionBar

temi's ActionBar.

You can hide the ActionBar with the following command.

.. code-block:: Java

  Robot.getInstance().hideTopBar()

But that will still leave a pull-down bar, which users can use to get access to temi's ActionBar.

.. image:: _static/img/temi-pull-down-bar.png 
  :width: 800
  :alt: temi Pull-Down Bar

Using `Robot.getInstance().hideTopBary()` leaves a pull-down bar.


How to
------
To completely hide temi's ActionBar (including the pull-down bar), you'll need to make the following changes.


AndroidManifest.xml
+++++++++++++++++++
Add the following `meta-data` to your `MainActivity`.

.. code-block:: xml

  <activity android:name=".MainActivity">
    ...
    <meta-data
        android:name="com.robotemi.sdk.metadata.UI_MODE"
        android:value="4" />
    ...
  </activity>

  
onRobotReady()
+++++++++++++++++
Add the following code after the robot is ready.

.. code-block:: Java

  @Override
  public void onRobotReady(boolean isReady) {
      if (isReady) {
          Log.i(TAG, "Robot is ready");
          
          try {
            ActivityInfo activityInfo = getPackageManager().getActivityInfo(getComponentName(), PackageManager.GET_META_DATA);
            mRobot.onStart(activityInfo);
          } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
          }
      }
  }


Exit Button
-----------
Now that you've completely removed the ActionBar, you'll need a way to exit the application. For a Kiosk application, you'll probably want to hide the exit button and use a password to prevent the device from being tampered with.

To return to the Launcher menu, use the following command.

.. code-block:: Java

  mRobot.showAppList();

.. note::
  In case you've made a Kiosk app and forgot to include the exit button, one way to get out of it is to call your robot. Calling the robot bring up temi's ActionBar.


Example
-------
* `Hide ActionBar <https://github.com/hapi-robo/temi-guide/tree/master/examples/hide-actionbar>`_


References
----------
* `GitHub Issue #89 <https://github.com/robotemi/sdk/issues/89>`_