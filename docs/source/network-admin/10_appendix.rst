.. |wifi| image:: assets/images/appendix/wifi-icon.png
  :width: 1em

.. |info| image:: assets/images/appendix/info-icon.png
  :width: 1em

********
Appendix
********

.. _measuring-wifi-signal-strength:

Measuring Wi-Fi Signal Strength
===============================

.. Attention:: Wi-Fi signal strength must be measured using the wireless device that will be using Wi-Fi. For example, do not measure Wi-Fi signal strength using a smartphone when the Wi-Fi signal will be used by the robot. The antennas on the smartphone and robot are different, which will make the Wi-Fi signal strength measurements different.

Use the following instructions to measure Wi-Fi signal strength on the robot.

.. Important:: Remember to check the robot's Wi-Fi signal strength across its entire operating environment. Signal strength changes depending on where the robot is in the environment, and in general signal strength decreases the further you are away from the Wi-Fi access point.

.. figure:: assets/images/appendix/home-screen.png 
  :alt: Home screen

  Tap on the Wi-Fi icon |wifi| in the top left-hand corner of the screen to bring up the Wi-Fi network selection menu.

.. figure:: assets/images/appendix/wifi-network-selection.png 
  :alt: Wi-Fi network selection menu

  Tap on the information icon |info| on the right-hand side of the connected network to bring up the network settings page.

.. figure:: assets/images/appendix/wifi-connection-details.png 
  :alt: Wi-Fi network connection details

  Here you should see a line displaying the ``Signal strength`` in the units of `dBm`. This represents the Wi-Fi signal strength for the robot.


Installing Android CA System Certificates
=========================================
temi cannot be used with WPA-Enterprise and/or environments requiring 802.1X EAP authentication (2021/07).

Instructions for installing Android CA System Certificates manually over ADB can be found `here <https://github.com/hapi-robo/temi-guide/tree/master/scripts/ca_certificates>`_. This should be applicable to temi and any other Android device.
