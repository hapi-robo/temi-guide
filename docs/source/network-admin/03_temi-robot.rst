**********
temi Robot
**********

General Network Requirements
============================

- Broadband internet access.
- Minimum internet bandwidth of 2 Mbps upload and 2 Mbps download speed. See :ref:`box <temi-robot-how-to-measure-bandwidth>` below for measurement instructions.
- A static IP address or a DHCP server to obtain IPv4 address(es) for temi's wireless interface.
- A connection to temi Cloud. For more details, refer to :ref:`firewall-requirements`.

.. admonition:: Recommendations

  Bandwidth of 3 Mbps upload and 3 Mbps download speed

.. _temi-robot-how-to-measure-bandwidth:

.. admonition:: How to measure bandwidth

  One way easy way to test internet bandwidth is to connect a PC to the same LAN as the robot and open a web-browser to the following link https://www.speedtest.net/. Then run the test.


Wi-Fi Requirements
==================

- Satisfactory Wi-Fi coverage across the device's operating environment. Ideal signal strength (i.e. RSSI) range is -30 dBm to -65 dBm measured using temi's ``Network Settings`` page. See :ref:`measuring-wifi-signal-strength` for measurement instructions.
- 802.11a/b/g/n (at 2.4 GHz) or 802.11a/n/ac (at 5.0 GHz) Wi-Fi network coverage over the area where the robot will be used.
- Wi-Fi Security can be Open or WPA/WPA2 PSK Personal (recommended). WPA/WPA2 Enterprise is not fully supported at this time (2021/07).
  
  - For WPA/WPA2 PSK, Wi-Fi Encryption can be TKIP or AES. 

- Hidden networks are supported on non-DFS frequencies only.


Wi-Fi Roaming
-------------
Roaming is when a wireless client leaves one BSSID and authenticates/associates with a new BSSID. If the device is to be used for telepresence in a large environment, roaming becomes critical as it can affect control, voice, and video quality as the device transitions between access points.

The following are general recommendations to minimize roaming interuptions:

- 5.0 GHz is highly recommended and using (n) is preferred
  
  - 5.0 GHz is generally less contentious. 
  - 802.11n provides the highest possible bandwidth without beam-forming (ac). Beam-forming can impact roam times, which can impact voice and video quality for roaming clients.

- Turn **OFF** the following access-point features, if/when available
  
  - Load-balancing
  
    - Load-balancing can impact roam times, which can impact voice and video quality for roaming clients. 
    - Load balancing can also make streaming video jittery with dropped frames.

  - Dynamic Transmit Power Control
  - Dynamic Channel Assignment
  - 802.11b support

- Turn **ON** the following access-point features, if/when available

  - 802.11 k/r/v support


Quality of Service (QoS) Recommendations
========================================
[In progress]


Over-the-Air Updates
====================
When temi releases a software update, the robot will automatically update itself. When the update begins, the robot will display a `Software Update` dialog screen. Software versions can be found under ``Settings`` > ``About``. The 3 most important ones are: ``Launcher OS``, ``Robox OS``, and ``Firmware``.

The update process should only take a few minutes and the robot will restart itself when the update has completed. Robot settings such as Wi-Fi configurations will be preserved across software updates and should not require user interaction.

.. DANGER:: Do not attempt to turn-off the robot during a software update. If the software update is taking longer than expected, call customer support.

Application updates are not required, but strongly recommended. Failure to update your robot's software may result in loss of feature. 


DHCP
====

temi Robot can use DHCP to obtain its configurations. The DHCP hostnames for each robot are not unique, therefore it is recommended to identify robots by their MAC addresses. The MAC address for temi's Wi-Fi network inferface can be found under ``Settings`` > ``About`` >> ``Wi-Fi MAC Address`` (Launcher OS 14759).


Captive Portal Detection
========================
[In progress]


References
==========

- `temi Robot Wi-Fi Module AP6356 Datasheet <https://rockchip.fr/ampak/AP6356_datasheet_V1.0_07252014.pdf>`_
- `Roaming over Wi-Fi <https://wlanprofessionals.com/roaming-over-wi-fi/>`_
