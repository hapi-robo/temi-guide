**************************
Frequently Asked Questions
**************************

`Q: Are there signal strength requirements for temi Mobile App and/or temi Center?`

  First some background information: Signal strength for the robot is provided because the robot moves around in the environment. The signal strength changes depending on where it is. Access points have a tendency to automatically lower connection bandwidth if the signal strength is below a threshold.

  In general, a user that is using the temi Mobile App and/or temi Center (on a PC) will not continuously move around the environment like the robot. In general, the signal strength will remain the same. So if the bandwidth requirement is met for these devices, there should be no issue.

`Q: What is the range of activity achievable by temi? Can we cover a radius of 50 m from the home base?`

  The range of activity is limited by Wi-Fi signal strength and this is dependent on hundreds of environmental factors. See :ref:`temi-robot-wifi-requirements` for details.

`Q: The recommendation is to use 5 GHz for Wi-Fi connection, but I understand that 5 GHz has a shorter range in comparison to 2.4 GHz.`

  It is true that for the same amount of power 5 GHz has a shorter range than 2.4 GHz, but that is not important here. What is important is the Wi-Fi signal strength. If the signal strength meets the requirements, the robot can use either 2.4 GHz or 5.0 GHz.

`Q: When trying to start an app, I get the following error: "This feature is not available while temi is offline"`

  .. figure:: assets/images/faq/offline-error.jpg
    :alt: Offline error

    This error message may appear when selecting an app while temi is not connected to the internet.

  This error generally means that temi is unable to connect to the internet. 
  
  #. temi is not connected to a Wi-Fi access point.
  #. Access point / router is not connected to the internet.
  #. temi's API server (api.temi.cloud) may be down for maintenance.