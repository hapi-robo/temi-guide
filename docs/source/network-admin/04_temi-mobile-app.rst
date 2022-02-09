***************
temi Mobile App
***************

General Network Requirements
============================

- Broadband internet access, which can either come from a Wi-Fi LAN or 4G LTE connection.
- Minimum internet bandwidth of 2 Mbps upload and 2 Mbps download speeds. A slower network speed can cause issues during a telepresence session. See the note below for measurement instructions.
- A connection to temi Cloud. For more details, refer to :ref:`firewall-settings`.

.. admonition:: Recommendations

  Internet bandwidth of `at least` 3 Mbps upload and 3 Mbps download speeds.

.. Note:: One easy way to test internet bandwidth is to connect a PC to the same LAN as the robot and open a web-browser to the following link https://www.speedtest.net/ to run an in-browser bandwidth test.


Quality of Service (QoS) Recommendations
========================================
QoS should be set to prioritize any temi media traffic on the Wi-Fi network and on the uplink to the ISP. When using :ref:`firewall-settings`, give high priority to UDP traffic (media traffic) to and from the device.


Over-the-Air Updates
====================
When temi releases a software update, the app on either iOS or Android should update itself automatically through the App Store or Google Play Store, respectively. App versions can be found by going to the app's ``About`` page.
