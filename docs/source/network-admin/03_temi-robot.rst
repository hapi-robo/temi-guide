**********
temi Robot
**********

General Network Requirements
============================

- Broadband internet access.
- Minimum internet bandwidth of 2 Mbps upload and 2 Mbps download speeds. A slower network speed can cause issues during a telepresence session. See the note below for measurement instructions.
- A static IP address or a DHCP server to obtain IPv4 address(es) for temi's wireless interface.
- A connection to temi Cloud. For more details, refer to :ref:`firewall-settings`.

.. admonition:: Recommendations

  Internet bandwidth of `at least` 3 Mbps upload and 3 Mbps download speeds.

.. Note:: One easy way to test internet bandwidth is to connect a PC to the same LAN as the robot and open a web-browser to the following link https://www.speedtest.net/ to run an in-browser bandwidth test.


.. _temi-robot-wifi-requirements:

Wi-Fi Requirements
==================

- Satisfactory Wi-Fi coverage across the device's operating environment. Ideal signal strength (i.e. RSSI) range is -30 dBm to -65 dBm measured using temi's ``Network Settings`` page. See :ref:`measuring-wifi-signal-strength` for measurement instructions.
- 802.11a/b/g/n (at 2.4 GHz) or 802.11a/n/ac (at 5.0 GHz) Wi-Fi network coverage over the area where the robot will be used.
- Wi-Fi Security can be Open or WPA/WPA2 PSK Personal (recommended). WPA/WPA2 Enterprise is not fully supported at this time (2021/07).
  
  - For WPA/WPA2 PSK, Wi-Fi Encryption can be either TKIP or AES. 

- Hidden networks are supported on non-DFS frequencies only.


Wi-Fi Roaming
-------------
Roaming is when a wireless client leaves one :term:`BSSID` and authenticates/associates with a new BSSID. If the device is to be used for telepresence in a large environment, roaming becomes critical as it can affect control, voice, and video quality as the device transitions between access points.

.. admonition:: Important

  During boot, the robot will randomly connect to an authenticated Wi-Fi access-point with a signal strength that is stronger than or equal to -70 dBm. During run-time, if the signal strength falls below -70 dBm and there is an authenticated access-point in the environment with a stronger signal, the robot will automatically switch to that access point.

The following are general recommendations to minimize roaming interuptions:

- 5.0 GHz is highly recommended and using (n) is preferred
  
  - 5.0 GHz is generally less contentious. 
  - 802.11n provides the highest possible bandwidth without beam-forming (ac). Beam-forming can impact roam times, which can impact voice and video quality for roaming clients.

- Turn **OFF** the following access-point features, if/when available:
  
  - Load-balancing
  
    - Load-balancing can impact roam times, which can impact voice and video quality for roaming clients. 
    - Load balancing can also make streaming video jittery with dropped frames.

  - Dynamic Transmit Power Control
  - Dynamic Channel Assignment
  - 802.11b support

- Turn **ON** the following access-point features, if/when available:

  - 802.11 k/r/v support


Quality of Service (QoS) Recommendations
========================================
QoS should be set to prioritize any temi media traffic on the Wi-Fi network and on the uplink to the ISP. When using :ref:`firewall-settings`, give high priority to UDP traffic (media traffic) to and from the device.


DHCP
====
temi Robot can use DHCP to obtain its configurations. The DHCP hostnames for each robot are not unique, therefore it is recommended to identify robots by their MAC addresses. The MAC address for temi Robot's Wi-Fi inferface can be found under ``Settings`` > ``About`` > ``Wi-Fi MAC Address`` (Launcher OS 14759).


Captive Portals
===============
It is recommended to avoid using captive portals with temi Robot. If the robot is temporarily relocated or rebooted, the captive portal may require the sign-in process to be repeated when it reconnects to the network.

Instead, it is recommended to whitelist the temi Robot's Wi-Fi interface when deploying at a facility where a captive portal is in place. If the temi Robot's Wi-Fi interface is whitelisted, captive portal registration is not needed. Many captive portals allow a whitelist of MAC addresses to be specified. The MAC address for temi Robot's Wi-Fi inferface can be found under ``Settings`` > ``About`` > ``Wi-Fi MAC Address`` (Launcher OS 14759).


Glossary
========

.. glossary::

  BSSID
    For a definition of BSSID, see `Wikipedia Service set (802.11 network) <https://en.wikipedia.org/wiki/Service_set_(802.11_network)#SSID>`_.


.. References
.. ==========
.. - `temi Robot Wi-Fi Module AP6356 Datasheet <https://rockchip.fr/ampak/AP6356_datasheet_V1.0_07252014.pdf>`_
.. - `Roaming over Wi-Fi <https://wlanprofessionals.com/roaming-over-wi-fi/>`_
