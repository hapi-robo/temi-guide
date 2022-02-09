*********
SLAM Bags
*********

To get SLAM bags:

#. Open the Technician Tools
#. Start recording: Select ``ROBOX`` > ``Start SLAM Recording``
#. Move the robot around the area of interest
#. Stop recording: Select ``ROBOX`` > ``Stop SLAM Recording``
#. Wait 30 seconds and copy the SLAM bags over to your computer:

   .. code-block:: Shell

     adb pull /sdcard/temi/xxx_debug_logs.tar.gz .

   You should now have ``xxx_debug_logs.tar.gz`` on  your computer.
