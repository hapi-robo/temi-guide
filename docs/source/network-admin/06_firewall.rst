.. https://hapirobo.sharepoint.com/:x:/r/sites/hapi-robo/_layouts/15/doc2.aspx?sourcedoc=%7B9F4CB8A6-E544-410E-B1EF-AB44A5743DFB%7D&file=temi_firewall_settings.xlsx&action=default&mobileredirect=true&cid=eab50f22-0111-4f91-aefb-967ccfbe6f33

.. _firewall-settings:

*****************
Firewall Settings
*****************

A list of the IP/FQDNs and port numbers that are used by temi Robots, temi Mobile App, and temi Center are provided in the following CSV file. For changes and previous versions, see :ref:`firewall-changelogs`.

:download:`Latest Firewall Settings (2021/08) <assets/temi_firewall_settings_202108.csv>`

Whitelist only those IP/FQDNs and port numbers that you want to use. 

.. admonition:: Recommendations

  The last column labeled ``Recommended``, in the CSV file, provides the minimum set needed for establishing telepresence sessions and OTA software updates.

The latest firewall settings have been tested on the following software versions using a `Netgate 1100 Security Gateway <https://docs.netgate.com/pfsense/en/latest/solutions/sg-1100/>`_ running `pfSense 21.02.2 <https://www.pfsense.org/>`_.

+---------------------------+------------+
|                           | Version    |
+===========================+============+
| temi Robot (Launcher)     | 15029      |
+---------------------------+------------+
| temi Mobile App (Android) | 1.3.8460   |
+---------------------------+------------+
| temi Mobile App (iOS)     | 1.1.46     |
+---------------------------+------------+


Enabling Firewall
=================

If a firewall is used, you must enable this mode on your device(s). The instructions for each device can be found in the following sections.


temi Robot
----------
Under ``Settings`` > ``General Settings``, turn ``ON`` `Firewall Mode`.

.. figure:: assets/images/firewall/robot-settings.png 
  :alt: Settings

  Tap on ``General Settings`` in the ``Settings`` menu to bring up the General Settings menu. `[Image taken from Launcher OS 14759]`

.. figure:: assets/images/firewall/robot-settings-general-settings.png 
  :alt: General Settings

  Turn ``ON`` `Firewall Mode`. `[Image taken from Launcher OS 14759]`


temi Mobile App
---------------

iOS
^^^
.. figure:: assets/images/firewall/ios-settings.png 
  :width: 320px
  :alt: Settings

  Tap on ``More`` to bring up the Settings page. Then turn ``ON`` `Firewall Mode`. `[Image taken from iOS mobile app 1.1.45]`

Android
^^^^^^^
.. figure:: assets/images/firewall/android-settings.jpg 
  :width: 320px
  :alt: Settings

  Tap on ``More`` to bring up the Settings page. Then turn ``ON`` `Firewall Mode`. `[Image taken from Android mobile app 1.3.8425]`


temi Center
-----------
.. figure:: assets/images/firewall/center-settings.png 
  :alt: Settings

  Hover over the user icon in the top right-hand corner and tap ``Account Settings`` to bring up the Account Settings page. Then enable `Firewall Mode`. `[Image taken from temi Center 2021/07/14]`


.. _firewall-changelogs:

Changelogs
==========
**temi_firewall_settings_202108.csv**

- Fixes a typo in row 29. Previously wrote port 444. It should be port 443.

Previous Versions
-----------------

:download:`Latest Firewall Settings (2021/07) <assets/temi_firewall_settings_202107.csv>`
