********************
Network Architecture
********************

[Add diagram]

The temi network consists of the following components:

.. glossary::

	temi Robot
		A robot with autonomous navigation and remote telepresence capabilities.
	
	temi Mobile
		A mobile app (`iOS <https://apps.apple.com/jp/app/temi/id1332976710?l=en>`_ and `Android <https://play.google.com/store/apps/details?id=com.robotemi>`_) that can start a telepresence session with temi Robot.
	
	temi Center
		A `web-browser application <https://center.robotemi.com/>`_ that can remotely manage and start a telepresence sessions with temi Robot.
	
	temi Cloud
		Stores user information and connects temi Robot to temi Mobile and temi Center.

When the temi Robot is connected to the internet, it connects to temi Cloud to signal its state. When temi `Clients` (i.e. temi Mobile, temi Center) are started, it also connects to temi Cloud to determine which robots are available. temi Cloud assists both temi Robots and temi Clients in establishing telepresence sessions. It is also used to send software updates, upload diagnotics information, and manage temi Robots and user permissions. 
