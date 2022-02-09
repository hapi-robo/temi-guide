******************************
Hide ActionBar & Pull-Down Bar
******************************

For Kiosk applications, you'll want to hide the temi's `ActionBar <https://developer.android.com/reference/androidx/appcompat/app/ActionBar>`_.

.. figure:: assets/hide-actionbar/temi-actionbar.png 
  :alt: temi ActionBar

  temi's ActionBar.

You can hide the ActionBar with the following command.

.. code-block:: Java

  Robot.getInstance().hideTopBar()

But that will still leave a pull-down bar, which users can use to get access to temi's ActionBar.

.. figure:: assets/hide-actionbar/temi-pull-down-bar.png 
  :alt: temi Pull-Down Bar

  temi's pull-down bar. By pulling down on this, the user can reveal temi's ActionBar.

How To
======
To completely hide temi's ActionBar (including the pull-down bar), you'll need to make the following changes.


AndroidManifest.xml
-------------------
Add the following ``meta-data`` to your ``MainActivity``.

.. code-block:: xml

  <activity android:name=".MainActivity">
    ...
    <meta-data
        android:name="com.robotemi.sdk.metadata.UI_MODE"
        android:value="4" />
    ...
  </activity>

  
onRobotReady()
--------------
Add the following code after the robot is ready.

.. code-block:: Java

  @Override
  public void onRobotReady(boolean isReady) {
      if (isReady) {
          try {
            ActivityInfo activityInfo = getPackageManager().getActivityInfo(getComponentName(), PackageManager.GET_META_DATA);
            Robot.getInstance().onStart(activityInfo);
          } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
          }
      }
  }


Exit Button
===========
Now that you've completely removed the ActionBar, you will need a way to exit the application. For a Kiosk application, you'll probably want to hide the exit button and use a password to prevent the device from being tampered with.

To return to the Launcher menu, use the following command.

.. code-block:: Java

  Robot.getInstance().showAppList();

.. Tip::
  In case you've made a Kiosk app and forgot to include the exit button, one way to get out of it is to call your robot. Starting a telepresence session with the robot (from temi Mobile App or temi Center) will bring up temi's ActionBar.


Example
=======
* `Hide ActionBar <https://github.com/hapi-robo/temi-guide/tree/master/examples/hide-actionbar>`_


References
==========
* `GitHub Issue #89 <https://github.com/robotemi/sdk/issues/89>`_