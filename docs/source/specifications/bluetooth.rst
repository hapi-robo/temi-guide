*********
Bluetooth
*********

Hardware
========
temi Robot uses the Ampak AP6356 Wi-Fi + Bluetooth 4.1 module.


Profiles
========
The following is a list of supported Bluetooth profiles on temi Robots using Firmware version 20201216.xxxxxx.

:download:`Bluetooth Profiles (2021/10/12) <assets/temi_bluetooth_profiles_20211012.csv>`


Master vs. Slave
================

A bluetooth connection consists of:

- **Master** (or "**Source**") device, which scans for other devices and initiates the connection.
- **Slave** (or "**Sink**") device, which advertises its availability and waits for a connection.

By default, temi behaves as a **Slave** device. In ``Settings`` > ``Bluetooth``, you can turn ``ON`` or ``OFF`` temi's Bluetooth module. By turning Bluetooth ``ON`` temi will advertise its availability using it's nickname.

To use temi as a **Master** device, developers will need to use `Android's Bluetooth network stack <https://developer.android.com/guide/topics/connectivity/bluetooth>`_.
