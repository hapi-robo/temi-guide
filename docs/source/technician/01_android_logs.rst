************
Android Logs
************

To get Android logs:

#. Open the Technician Tools
#. Enable technician logs: Select ``Debug message`` > ``Plant a Timber tree``
#. Connect to the robot over ADB
#. Reproduce the issue
#. Collect the ``logcat`` logs:

   .. code-block:: Shell

     adb logcat -v time > logcat.txt
   
   Wait a few seconds for logs to fill up, then press ``CTRL+c`` to stop. Check to make sure that the most recent timestamp is in the log. Then do the same thing for ``bugreport`` logs:

   .. code-block:: Shell

     adb shell bugreport > bugreport.txt

   Wait a few seconds for the logs to fill up, then press ``CTRL+c`` to stop.

   You should now have two log-files ``logcat.txt`` and ``bugreport.txt`` on your computer.
#. Disable technician logs: Select ``Debug message`` > ``Plant a Timber tree``
