***********
temi Center
***********

.. _temi-center-network-requirements:

General Network Requirements
============================

- Broadband internet access. Wired connection preferred, over a CAT-5 ethernet cable.
- Minimum internet bandwidth of 2 Mbps upload and 2 Mbps download speeds. A slower network speed can cause issues during a telepresence session. See the note below for measurement instructions.
- A connection to temi Cloud. For more details, refer to :ref:`firewall-settings`.

.. admonition:: Recommendations

  Internet bandwidth of `at least` 3 Mbps upload and 3 Mbps download speeds.

.. Note:: One easy way to test internet bandwidth is to connect a PC to the same LAN as the robot and open a web-browser to the following link https://www.speedtest.net/ to run an in-browser bandwidth test.


Quality of Service (QoS) Recommendations
========================================
QoS should be set to prioritize any temi media traffic on the Wi-Fi network and on the uplink to the ISP. When using :ref:`firewall-settings`, give high priority to UDP traffic (media traffic) to and from the device.


.. Move to another section???
.. PC Hardware Requirements
.. ========================

.. - Processor

..   - 2-core 1.6GHz for video-only (minimum)
..   - 4-core 1.6GHz for screen-sharing (recommended)
..   - Intel i3/i5/i7 or AMD equivalent

.. - Memory

..   - 8GB RAM (minimum)

.. - Speaker / Microphone

..   - Built-in, USB plug-in, or wireless Bluetooth

.. - Webcam

..   - Built-in, USB plug-in, or HD camcorder with video-capture card


.. Web-browsers
.. ============

.. temi Center is supported on the following web-browsers:

.. - `Google Chrome <https://www.google.com/chrome/>`_
.. - `Apple Safari <https://www.apple.com/safari/>`_

.. .. Caution:: Some web-browser's like Google Chrome have an `automatic language translation` feature. Do not use this feature with temi Center. Instead, select the preferred language in temi Center. Using `automatic language translation` may result in text/buttons not being shown correctly.
