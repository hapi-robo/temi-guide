********************
Security and Privacy
********************

.. _adb-security:

Android Debug Bridge
====================
`Android Debug Bridge (ADB) <https://developer.android.com/studio/command-line/adb>`_ is a tool that let's developers communicate with the temi Robot. One can enable this feature under ``Settings`` > ``Developer Tools``, then tap `ADB Port Opening`. This will open port ``5555`` on the robot. To disable this feature and close the port, you must reboot the robot.

.. Caution:: 

  Enabling temi's ADB port posses some risks. There exists malware/viruses that specifically target this port. If there are devices on the network that have such malware, temi Robot can be infected. We recommend the following:

    - Only connect temi Robot to a closed network that is malware-free for development.
    - Never enable the ADB port in production or on a public network.

  It is impossible to know if the ADB port was accidentally opened. When in doubt, reboot the robot to close the port. 


Auditing
========
temi has had security reviews by `McAfee <https://www.mcafee.com/blogs/other-blogs/mcafee-labs/call-an-exorcist-my-robots-possessed/>`_ (2020/05) and `Firedome <https://firedome.io/>`_ (2021). As of release 124 (Launcher OS 14759), temi Robot comes installed with the Firedome client for continuous security monitoring.


.. Confidentiality
.. ===============
.. [In progress]


Privacy Policy
==============

For more information, see temi's Privacy Policies:

- `USA <https://www.robotemi.com/privacy-policy/>`_
- `Japan <https://www.robotemi.jp/privacy-policy/>`_

Privacy policies of 3rd-party services used by temi:

.. list-table::
    :widths: 20 20 30
    :header-rows: 1

    * - Services
      - Company
      - Privacy Policy
    * - Video Call
      - Agora
      - https://www.agora.io/en/compliance/



Infrastructure
==============

The status of temi Cloud can be reviewed online at http://status.robotemi.com/.

.. [In progress]

.. - Levels of access
.. - Update protocol
.. - Certificates
.. - Password storage
.. - Data backup
