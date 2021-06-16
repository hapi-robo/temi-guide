Text-to-Speech
==============

Single Line of Text
-------------------
Speak with text displayed:

.. code-block:: Java

  Robot sRobot = Robot.getInstance();
  ...
  // When robot is ready
  TtsRequest ttsRequest = TtsRequest.create("Hello World");
  sRobot.speak(ttsRequest);


Speak without text displayed:

.. code-block:: Java

  Robot sRobot = Robot.getInstance();
  ...
  // When robot is ready
  sRobot.speak(TtsRequest.create("Hello World", false));


Multiple Lines of Text
----------------------
``speak()`` is an asynchronous method. Therefore, you cannot do the following to speak multiple lines of text:

.. code-block:: Java

  sRobot.speak(TtsRequest.create("Hello World", false));
  sRobot.speak(TtsRequest.create("What is the weather today?", false));

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
                  sRobot.speak(TtsRequest.create(queue.remove(), false));
              }
          }
      }
  });

  // Command robot to speak
  sRobot.speak(TtsRequest.create(queue.remove(), false));

For a working example, click `here <>`_.



References
----------
- `temi SDK: Speech <https://github.com/robotemi/sdk/wiki/Speech#speak>`_