*************
Organizations
*************

.. Note:: The following information was validated on April 13, 2022.

Starting with release 128, activated users and robots will be divided into Organizations.

In the following, a *Member* is someone that can use the robot. A Member can play one of the following roles in an Organization:

#. Root Admin
#. Admin
#. Collaborators
#. Guests


Roles
=====
.. list-table:: temi Roles
  :widths: 20 20 20 20 20
  :header-rows: 1

  * - Capability
    - Guest
    - Collaborator
    - Admin
    - Root Admin
  * - Can add robots to Organization
    - No
    - Yes
    - Yes
    - Yes
  * - Can add Users to Organization via Organization Settings
    - No
    - No
    - Yes
    - Yes
  * - Can add Users to Organization via Robot Members Settings
    - No
    - Yes
    - Yes
    - Yes
  * - Can assign Robots to Members
    - No
    - Yes
    - Yes
    - Yes
  * - Can edit Roles of Members
    - No
    - No
    - Yes
    - Yes
  * - Permission of Members that can be edited
    - None
    - Guests
    - Admins, Collaborators, Guests
    - Admins, Collaborators, Guests
  * - Robot access
    - Selected by Admin and/or Collaborators
    - Selected by Admin
    - All
    - All
  * - Can leave Organization
    - Yes
    - Yes
    - Yes
    - Only through Transfer of Ownership


.. Note:: Robots are added to an Organization during robot activation.

Root Admin
----------
- Each Organization will always have one (and only one) Root Admin.
- When activating a temi account, the User is automatically assigned an Organization and is made the Root Admin of that Organization.
- Root Admin’s cannot leave an Organization, unless they assign their Organization to another Admin.
- Roles and permissions of the Root Admin cannot be changed by any User.

Admin
-----
Each Organization can have multiple Admins. Admins can do everything a Root Admin can do except:

- Edit the roles and permissions of the Root Admin

Collaborator
------------
Each Organization can have multiple Collaborators. Collaborators have access only to robots that have been granted by an Admin. They can change the roles and permissions of Guest users only.

Guest
-----
Each Organization can have multiple Guests. Guests have access only to robots that have been granted by an Admin, and/or Collaborators. They have no access to Organization settings, and therefore cannot change the roles and permissions of other Members in the Organization.


Permission
==========
Each robot has the following permissions settings:

#. Add Members
#. Hop-in temi
#. Control temi
#. Edit Map
#. Edit Settings

Admin
-----
Root Admins and Admins can edit all permission, i.e. (1) - (5)

- If (1) is enabled, all other permissions are automatically enabled and locked.
- If (1) is disabled, permissions (2) - (5) can selectively be disabled. Collaborators will not be able to edit the permission of this robot.

Collaborator
------------
Collaborators can edit permissions: (2) - (5)

.. Note:: As indicated above, this can only be done when (1) is disabled.

.. Caution:: It is possible for Collaborators to disable (1) for themselves. If this is done, this User will lose all access to managing the permission of this robot.

Guest
-----
Guests cannot edit any permissions.
