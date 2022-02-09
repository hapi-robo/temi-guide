**************
Text-to-Speech
**************

Single Line of Text
===================
Speak with text displayed:

.. code-block:: Java

  Robot sRobot = Robot.getInstance();
  ...
  // When robot is ready
  TtsRequest ttsRequest = TtsRequest.create("Hello World", true);
  sRobot.speak(ttsRequest);


Speak without text displayed:

.. code-block:: Java

  Robot sRobot = Robot.getInstance();
  ...
  // When robot is ready
  TtsRequest ttsRequest = TtsRequest.create("Hello World", false);
  sRobot.speak(ttsRequest);


Multiple Lines of Text
======================
``speak()`` is an asynchronous method. Therefore, you *cannot* do the following to speak multiple lines of text:

.. code-block:: Java

  sRobot.speak(TtsRequest.create("Hello World"));
  sRobot.speak(TtsRequest.create("What is the weather today?"));

To speak multiple lines of text, you must wait for the robot to finish speaking the first line of text before starting the second line of text. To check when the robot has finished speaking, you can use the `TtsListener <https://github.com/robotemi/sdk/wiki/Speech#ttsListener>`_ interface. For example:

.. code-block:: Java

  // Declare a queue of phrases
  final Queue<String> queue = new LinkedList<>();
  queue.add("Hello World");
  queue.add("What is the weather today?");

  // Register TTS listener
  sRobot.addTtsListener(new Robot.TtsListener() {
      @Override
      public void onTtsStatusChanged(@NotNull TtsRequest ttsRequest) {
          if (ttsRequest.getStatus() == TtsRequest.Status.COMPLETED) {
              if (!queue.isEmpty()) {
                  sRobot.speak(TtsRequest.create(queue.remove()));
              }
          }
      }
  });

  // Command robot to speak
  sRobot.speak(TtsRequest.create(queue.remove()));


Languages
=========
The 3rd parameter (```Language``) of ``Tts.create()`` allows the user to set the language of the TTS system, independent of the system's language settings. This may be useful if a developer wants to create an app with TTS that supports multiple languages within the app without having to switch system language settings.

For example, to command the robot to speak in Japanese while the system's language is set to English:

.. code-block:: Java

  Robot sRobot = Robot.getInstance();
  ...
  // When robot is ready
  TtsRequest ttsRequest = TtsRequest.create("Hello World", false, TtsRequest.Language.JA_JP);
  sRobot.speak(ttsRequest);


.. important::

  When using the ``language`` parameter, TTS may redirect to a different TTS service provider. For example in Japanese: 
  
  When the parameter is set to ``TtsRequest.Language.SYSTEM`` (or not set at all), the robot will use `Google's Text-to-Speech <https://cloud.google.com/text-to-speech/>`_ service. 
  
  When the parameter is set to ``TtsRequest.Language.JA_JP``, the device will use `Microsoft's Speech-to-Text service <https://azure.microsoft.com/en-us/services/cognitive-services/text-to-speech/>`_.
  
  Since these are different service providers, this may have an impact on latency.

  Please note that this may also affect :ref:`firewall-settings`.


Example
=======
* `Text-to-Speech <https://github.com/hapi-robo/temi-guide/tree/master/examples/text-to-speech>`_


References
==========
* `temi SDK: Speech <https://github.com/robotemi/sdk/wiki/Speech>`_

