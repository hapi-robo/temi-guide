.. _adb-commands:

************
ADB Commands
************

==============
Connect to ADB
==============
Connect to specific device:

.. code-block:: Shell

  adb -s <ip-address> shell

Enable ADB over Wi-Fi:

.. code-block:: Shell

  adb tcpip 5555


==============
Input & Output
==============
Copy Android → PC:

.. code-block:: Shell
  
  adb pull <remote> <local>


Copy PC → device:

.. code-block:: Shell
  
  adb push <local> <remote>

Logcat on Linux:

.. code-block:: Shell

  adb logcat > <log-name>.txt

Logcat on Windows:

.. code-block:: Shell

  adb logcat | out-file <log-name>.txt -encoding utf8


===================
Package Information
===================
List installed packages:

.. code-block:: Shell

  adb shell pm list packages

Use ``grep`` to filter the output, e.g.:

.. code-block:: Shell

  adb shell pm list packages | grep "roboteam"

Package path:

.. code-block:: Shell

  adb shell pm path <package-name>

Package settings:

.. code-block:: Shell

  /data/data/<package-name>

Shared preferences:

.. code-block:: Shell

  /data/data/<package-name>/shared_prefs/<filename>.xml

Get all activities or current activity in app:

.. code-block:: Shell

  adb shell dumpsys package <package-name>


==================
Device Information
==================
Hardware information:

.. code-block:: Shell

  adb shell getprop

Get SDK version:

.. code-block:: Shell

  adb shell getprop ro.build.version.sdk
  

=========================
Start & Stop Applications
=========================
Start application / activity:

.. code-block:: Shell

  adb shell am start -n com.package.name/.ActivityName

Stop application:

.. code-block:: Shell

  adb shell am force-stop com.package.name


Open Android Play Store:

.. code-block:: Shell
  
  adb shell am start -n com.android.vending/com.google.android.finsky.activities.MainActivity

Open Android Settings menu:

.. code-block:: Shell
  
  adb shell am start -a android.settings.SETTINGS

Open Android Wi-Fi settings menu:

.. code-block:: Shell
  
  adb shell am start -a android.settings.WIFI_SETTINGS

Open Android Bluetooth settings menu:

.. code-block:: Shell
  
  adb shell am start -a android.settings.BLUETOOTH_SETTINGS

Open Android cast settings menu:

.. code-block:: Shell
  
  adb shell am start -a android.settings.CAST_SETTINGS


=========================
Install & Remove Packages
=========================
Reinstall package:

.. code-block:: Shell
  
  adb install -r <apk-file>

Uninstall package:

.. code-block:: Shell

  adb shell pm uninstall <com.example.app>

Uninstall package (root):

.. code-block:: Shell
  
  adb shell pm uninstall --user 0 <package-name>

Install if the `testOnly` attribute is enabled:

.. code-block:: Shell
  
  adb install -t <apk-file>


===============
Cache & Storage
===============
Clear package storage and cache:

.. code-block:: Shell
  
  adb shell pm clear <package-name>

Clear Launcher storage and cache:

.. code-block:: Shell

  adb shell pm clear com.roboteam.teamy.usa

Clear Keyboard storage and cache:

.. code-block:: Shell

  adb shell pm clear com.google.android.inputmethod.japanese


=============
Media Capture
=============
Screenshot:

.. code-block:: Shell

  adb shell screencap -p /path/to/screenshot.png

Screen video recording:

.. code-block:: Shell

  adb shell screenrecord /path/to/video.mp4

To change resolution and rotate screen:

.. code-block:: Shell

  adb shell screenrecord --size 640x480 --rotate /path/to/video.mp4

=====
Ports
=====
To see which app has an open port (TCP):
.. code-block:: Shell

  cat /proc/net/tcp
  sl  local_address rem_address   st tx_queue rx_queue tr tm->when retrnsmt   uid  timeout inode  
  0: 0100007F:1C23 00000000:0000 0A 00000000:00000000 00:00000000 00000000  1001        0 2111 1 e22cc000 300 0 0 2 -1  

where,

  * ``0100007F:1C23`` is the ``IP-address``:``port`` in hex notation, here is 127.0.0.1:7203
  * ``00000000:0000`` is the remote address empty (listening)
  * ``1001`` is the UID of the app

Use `this <https://www.browserling.com/tools/hex-to-ip>`_ tool for converter hex notation to an IP address.

To identify app by UID:

.. code-block:: Shell

  /data/system/packages.xml

For details, see `here <https://android.stackexchange.com/questions/8452/how-can-i-find-app-name-by-uid>`_:


==========
References
==========
* `ADB Cheat Sheet <https://www.automatetheplanet.com/adb-cheat-sheet/>`_
* `List All Activities <https://stackoverflow.com/questions/6547703/list-all-activities-within-an-apk-from-the-shell>`_
* `Examine Shared Preferences <https://stackoverflow.com/questions/1243079/how-to-examine-sharedpreferences-from-adb-shell>`_
* `Status of system services <https://stackoverflow.com/questions/11201659/whats-the-android-adb-shell-dumpsys-tool-and-what-are-its-benefits>`_
* `Connect to Wi-Fi with ADB <https://developer.android.com/things/hardware/wifi-adb>`_
