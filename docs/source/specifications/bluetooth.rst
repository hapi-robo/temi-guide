*********
Bluetooth
*********

Hardware
========
temi Robot v1/v2 is equipped with a Bluetooth 4.1 module whereas v3 is equipped with a Bluetooth 5.1 module.


Profiles
========
The following is a list of supported Bluetooth profiles on temi Robot v1/v2 using Firmware version 20201216.xxxxxx.
temi Robot v3 uses Firmware version 20221014.xxxxxx.

:download:`V1 & V2 Bluetooth Profiles (2021/10/12) <assets/v1_v2_temi_bluetooth_profiles_20211012.csv>`

:download:`V3 Bluetooth Profiles (2022/11/22) <assets/v3_temi_bluetooth_profiles_20221122.pdf>`


Master vs. Slave
================

A bluetooth connection consists of:

- **Master** (or "**Source**") device, which scans for other devices and initiates the connection.
- **Slave** (or "**Sink**") device, which advertises its availability and waits for a connection.


**V1 & V2:**

By default, temi behaves as a **Slave** device. In ``Settings`` > ``Bluetooth``, you can turn ``ON`` or ``OFF`` temi's Bluetooth module. By turning Bluetooth ``ON`` temi will advertise its availability using it's nickname.
To use temi as a **Master** device, developers will need to use `Android's Bluetooth network stack <https://developer.android.com/guide/topics/connectivity/bluetooth>`_.


**V3:**

Turning bluetooth ``ON`` or ``OFF`` is similar to a v1 or v2 robot. However, it is possible to directly select **Slave** or **Master** in the bluetooth settings page.
*Refer to the following.*

.. csv-table::
   :header: "Robot", "Bluetooth Speaker/Headphone", "Bluetooth Headset"
   :widths: 12, 25, 25
   :align: left

   "V1 & V2", "X", "X"
   "V3", "O", "O"
  