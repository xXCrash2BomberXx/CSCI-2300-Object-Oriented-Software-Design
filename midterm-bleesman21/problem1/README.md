# Problem 1

You are writing a small program that simulates a robot moving in a 2-dimensional space. A location in this space is represented with a Point2D class, which is already in this directory. Add a Robot class to represent the robot's movement. This class shoud keep track of the robot's current position and all previously visited points. When a robot object is created, it should start out at point (0,0).

The class should provide the following methods:
```
/*
 * Modify the robot's current location, moving distanceX in the x direction
 * and distanceY in the y direction
 */
public void move(int distanceX, int distanceY)

/*
 * Returns the robot's current location
 */
public Point2D getCurrentLocation()

/*
 * Returns all previosly visited locations, in the order in which the robot
 * visited them. The last value in this list must include the robot's current
 * location.
 */
public ArrayList<Point2D> getVisitedPath()
```

The Driver code in this directory should work with your Robot class. You should not modify the Driver, just write the Robot class as described above and ensure it works with the Driver code. 
