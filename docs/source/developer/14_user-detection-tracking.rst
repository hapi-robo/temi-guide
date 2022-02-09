*************************
User Detection & Tracking
*************************

The temi SDK allows the developer to `detect` when a person is standing in front and/or interacting with the robot. In addition to this, there are methods that can be used to `track` a person when he/she is within its field of view.

  * **Detection Mode**. Senses the presence of 1 or more persons within the field of view of the RGB camera. 
  * **Tracking Mode**. Configures the robot in `Constraint Follow Mode <https://github.com/robotemi/sdk/wiki/Follow#constraintBeWith>`_. The robot will turn its base and tilt its screen to follow a person when that person is detected.

Usage
=====
For detection and/or tracking to work properly, the app must be set to `Kiosk Mode <https://github.com/robotemi/sdk/wiki/Kiosk-Mode>`_.

The app must have `Settings Permissions` in order to use
`setDetectionModeOn <https://github.com/robotemi/sdk/wiki/Detection-&-Interaction#setdetectionmodeon->`_ and `setTrackUserOn() <https://github.com/robotemi/sdk/wiki/Detection-&-Interaction#setTrackUserOn>`_, which are used to turn on detection mode and tracking mode, respectively. To enable `Settings Permissions` and other permissions, refer to :doc:`20_permissions`.

+--------------------+------------------+-----------------------------------------------------+
| setDetectionMode() | setTrackUserOn() | Result                                              |
+====================+==================+=====================================================+
| True               | True             | Detection mode is on and tracking is on             |
+--------------------+------------------+-----------------------------------------------------+
| True               | False            | Detection mode is on and tracking is off            |
+--------------------+------------------+-----------------------------------------------------+
| False              | True             | Detection mode is **on** and tracking is on         |
+--------------------+------------------+-----------------------------------------------------+
| False              | False            | Detection mode is off and tracking is off           |
+--------------------+------------------+-----------------------------------------------------+

For example, to enable detection mode and tracking mode, add the following code after the robot is ready.

.. code-block:: Java

  @Override
  public void onRobotReady(boolean isReady) {
      if (isReady) {
          Robot.getInstance().setDetectionModeOn(true, 2.0f);
          Robot.getInstance().setTrackUserOn(true);
      }
  }

setDetectionModeOn()
====================
Enables or disables detection mode. Optionally, you can configure the detection range.

Syntax
------
.. code-block:: Java

  setDetectionModeOn(enable, maxRange);

:enable: Boolean value that enables (``true``) or disables (``false``) detection mode. 
:maxRange: A floating-point value that can be set between 0.5 and 2.0 (units are in meters). Do not expect accurate results. The sensor that is used for detection is not calibrated for this type of application. You should expect different robots to show different results.


setTrackUserOn()
================
Enables or disables tracking mode. Alternatively, `tracking` can be enabled/disabled by going to ``Settings`` > ``General Settings`` > ``Tracking User``. 

Syntax
------
.. code-block:: Java

  setTrackUserOn(enable);

:enable: Boolean value that enables (``true``) or disables (``false``) tracking mode. 

.. note::
  If ``setTrackUserOn(true)`` is used, tracking will still be enabled even after the application exits. You can verify this by going to ``Settings`` > ``General Settings`` > ``Tracking User``. 


Example
=======
* `User-Detection <https://github.com/hapi-robo/temi-guide/tree/master/examples/user-detection>`_


References
==========
* `temi SDK: Detection & Interaction <https://github.com/robotemi/sdk/wiki/Detection-&-Interaction>`_
* `Permissions <https://github.com/robotemi/sdk/wiki/permission>`_
