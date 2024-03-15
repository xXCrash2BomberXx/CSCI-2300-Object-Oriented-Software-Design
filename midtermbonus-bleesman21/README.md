# Problem 1

Your goal is to write a (collection of) `print` function(s) that will print an `ArrayList<Integers>` in a given range. This class' methods should mimic the styling of python's `range` function if that is easier to understand. The class should have at least these functionalities:
```
/*
    * Provided three arguments to the range
        * start
        * stop
        * step
*/
String print (int start, int stop, int step)

/*
    * Provided two arguments to the range
        * start
        * stop
        * step = 1
*/
String print (int start, int stop)

/*
    * Provided one argument to the range
        * start = 0
        * stop
        * step = 1
*/
String print (int stop)

/*
    * Provided no arguments to the range
        * start = 0
        * stop = the size of the ArrayList
        * step = 1
*/
String print ()
```

The Driver code in this directory should work with your `ArrayListSlice` class. You should not modify the Driver, just write the `ArrayListSlice` class as described above and ensure it works with the Driver code.