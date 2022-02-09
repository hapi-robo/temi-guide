*************
Factory Reset
*************

The temi Robot has 2 types of factory resets:

- Launcher Reset
- Tablet Factory Reset


Launcher Reset
==============
This is the factory reset you may have seen in the Robot's ``Settings`` menu. This will safely remove the robot from the owner's account, clear the Robox OS of the current map and all currently saved locations, and remove all saved Wi-Fi settings. Things that will not be removed, include (but are not limited to):

- Apps that were installed via ADB and all associated data
- Android accounts

This can be accomplished by selecting ``Settings`` > ``Factory Reset``. Note that this is equivalent to clearing the storage data and cache of the ``com.roboteam.teamy.usa`` package:

.. code-block:: Shell
  
  adb shell pm clear com.roboteam.teamy.usa


Tablet Factory Reset
====================
This is the factory reset most Android users are familiar with. This will remove all data from the tablet and return it to the original factory state. This is equivalent to using the native Android settings menu and selecting ``Factory data reset``.

.. Attention:: This may not safely remove the robot from the owner's account. It will also not clear the Robox OS of its map and saved locations.

This can be accomplished with the following command:

.. code-block:: Shell
  
  adb shell am broadcast -a android.intent.action.MASTER_CLEAR

Again, this will return the robot's tablet to the factory state. You will still have a usable temi Launcher, but it may be an older version. So make sure to select ``Software Upgrade`` in the ``Settings`` menu to update temi's Launcher.
