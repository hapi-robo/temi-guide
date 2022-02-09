******************
Launcher Shortcuts
******************

Setup
=====
To create a Launcher shortcut for a generic Android package:

Clone the repository:

.. code-block:: Shell

  git clone https://github.com/hapi-robo/temi-shortcut.git
  cd temi-shortcut/


APK Package Name
================
To create a shortcut, you need to have the ``package-name``. For example, the package name for Chrome is ``com.android.chrome``.

If the package is already installed on the device, you can look for it using:

.. code-block:: Shell

  adb shell pm list packages

If the package (or APK) is on your computer, you can run the following script to get the package name:

.. code-block:: Shell

  ./package_name.sh <apk>


Create Shortcut
===============
To create a Launcher shortcut:

.. code-block:: Shell

  ./shortcut.sh <package-name> <shortcut-name>

For example, to create a shortcut for Chrome:

.. code-block:: Shell

  ./shortcut.sh com.android.chrome "Chrome"

The file ``chrome_shortcut.apk`` should then appear in the same directory. Install it onto your device, along with the package that it links to. For this example:

.. code-block:: Shell

  adb install chrome.apk
  adb install chrome_shortcut.apk


Reference
=========

* https://github.com/hapi-robo/temi-shortcut
