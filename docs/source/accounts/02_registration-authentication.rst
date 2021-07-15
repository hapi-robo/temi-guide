*****************************
Registration & Authentication
*****************************

temi consists of 3 major components that users and system administrators will interact with: (1) temi Robot, (2) temi Mobile App, (3) temi Center.

Account Registration
====================
To start using temi, you must first register yourself as a user. To do this, you will need:

- Smartphone (Android or iOS) with a mobile phone number valid in the following countries...
- An internet connection. If you are behind a Firewall, refer to :ref:`firewall-settings`.

Download the temi Mobile App onto your smartphone:

- `iOS <https://apps.apple.com/jp/app/temi/id1332976710?l=en>`_
- `Android <https://play.google.com/store/apps/details?id=com.robotemi>`_

When activating the temi Mobile App for the first time, you will be asked for your mobile phone number, name, and email address. 

- The mobile phone number will act as the unique identifier for your account.
- Name can be changed after registration.
- Email cannot be changed after registration. Registering again using the same mobile phone number but different email address will cause errors.

.. Important:: 
  
  The temi Mobile App is central to using temi Robot and temi Center.

    - It acts as a registration system for temi Robot 
    - It acts as an authentication mechanism for temi Center 

.. _account-robot-registration:

Robot Registration
==================
You must use the temi Mobile App to register (or provision) a robot.

When powering on a temi Robot for the first time (or after a factory reset), you will need need to register the robot using the mobile app. As you follow the on-screen setup instructions, you will eventually shown a QR code, which you need to scan using the temi Mobile App. This process links the robot to the registered user of the mobile app. The user that is registered to the temi Mobile App automatically becomes the Owner of the robot. This cannot be changed later, unless you factory reset the robot.

[Image of robot registration Robot/Phone]

temi Center Authentication
==========================
You must use the temi Mobile App to log in to `temi Center <https://center.robotemi.com/>`_.

Tapping on the ``Login`` button will display a QR code, which you need to scan using the temi Mobile App. This process authenticates you as the registered user of the temi Mobile App, and logs you into system.

[Image of temi Center authentication PC/Phone]