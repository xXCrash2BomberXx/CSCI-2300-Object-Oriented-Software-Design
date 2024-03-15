# Problem 2

This directory contains a gradle project which implements a ShiftCipher class, similar to homework 3.  The included ShiftCipher implementation contains bugs. The main method of the application tests ShiftCipher, forcing us to visually examine the output to determine if the tests pass or fail. 

In the first test:
* The main method instantiates a ShiftCipher with a shift value 2
* Then, it uses the created ShiftCipher object to encode the word 'hello' and prints it to the terminal
* Finally, the encoded 'hello' gets decoded back and printed to the terminal

Visually examining the output, we don't see any problems or errors. 

In the second test:
* The main method instantiates a ShiftCipher with a shift value 1
* Then, it uses the created ShiftCipher object to encode the string 'z'.
* Finally, the encoded 'z' gets decoded back and printed to the terminal. 

Visually examining the output, we see that 'z' gets encoded to '{', which is incorrect, thus the test fails (based on our visual examination of the output).

Use ```gradle run``` command to run the application and to see the output.

Implement a JUnit style test that catches this bug. . I already included the file you'll need to use: app/src/test/java/cipher/ShiftCipherTest.java. Place your test implementation in that file, under the comment ```// add your test implementation below```.

Use ```gradle test``` command to see the outcome of your test case. Your test case should fail, exposing the bug described above. 
