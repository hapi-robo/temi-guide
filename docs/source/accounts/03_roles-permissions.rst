*******************
Roles & Permissions
*******************

Each registered robot has at least 1 or more users associated with it. Each user can play one of three roles:

+---------+---------------------------------------------------------------------------+
| Roles   | Access Level                                                              |
+=========+===========================================================================+
| Owner   | Unrestricted access to the robot.                                         |
+---------+---------------------------------------------------------------------------+
| Contact | Limited access to the robot only with call acceptance, see details below. |
+---------+---------------------------------------------------------------------------+
| Member  | Limited access to the robot, see detail below.                            |
+---------+---------------------------------------------------------------------------+


Owner
=====
The user that :ref:`registers the robot <account-robot-registration>` automatically becomes its Owner. This cannot change unless the robot is factory reset.

All phone book contacts on the Owner's mobile phone are automatically added to the robot as a Contact. Contacts will only appear if they have also registered through temi's Mobile App.

[Image of phone books for Android and iOS]

Owners can assign different levels of permission for each Contact, for each robot. Permissions are described below.


Contacts
========
Contacts may be added to the robot by the Owner.

It is possible for a Contact to start a call (i.e. telepresence session) with a robot, but like a telephone, someone will need to accept the call.

[Image of call acceptance vs no call acceptance]


Member
======
A Member is Contact with permission(s) to use the robot. The different permissions are listed in the following table:

.. list-table::
    :widths: 20 50 10
    :header-rows: 1

    * - Permissions
      - Description
      - Default
    * - Hop-In
      - A member can start a telepresence session with a robot without the need for call acceptance.
      - Enabled
    * - Control
      - A member can control a robot using the Control view in temi Center.
      - Enabled
    * - Edit Map
      - A member can edit the map of a robot using temi Center's Map Editor.
      - Enabled
    * - Edit Settings
      - A member can remotely edit the robot's settings using temi Center.
      - Disabled

Permission can only be set in temi Center. When adding a Member through the temi Mobile App, the default permissions are used.

