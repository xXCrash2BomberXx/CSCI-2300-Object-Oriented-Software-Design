# Problem 3

In this problem, you are given working code. You will need to redesign it using the strategy design pattern.

## Overview of the code in this directory
In this directory, you will find my solution to homework 1 - the simple library catalog program. I also added a ```public String toString()```  method to the Catalog class. There are two modes for converting a Catalog to a string: verbose and non-verbose. The verbose mode shows more information than non-verbose. 

A simple Driver is included to demonstrate the two modes. The Driver populates a catalog with 3 books and then prints the catalog first in non-verbose mode and then in verbose mode. 

<b>Compile and run the driver to see what the two modes do.</b>

Catalog class also has a method for setting the mode:
```
public void setPrintFormat(boolean verboseString)
```
Calling ```setPrintFormat(true)``` sets the verbose mode, calling ```setPrintFormat(false)``` sets non-verbose mode. When a catalog is created, it defaults to non-verbose mode.

## Redesign instructions
The current design is rigid, because if we want to add new ways of converting a Catalog to a String, we will need to change the Catalog class. Redesign the code using the <b>strategy design pattern</b>. Here, the strategy abstracts a way to convert an ArrayList of CatalogItem objects to a String. This abstraction is defined in the CatalogItemFormat interface (already included with this code): 
```
public interface CatalogItemFormat{
   public String toString(ArrayList<CatalogItem> items);
}
```
Below are the steps you'll need to take to implement the strategy design pattern:
1. Move the two different formatting implementations from Catalog's toString() method to their own classes that implement the CatalogItemFormat interface. 
2. Change the Catalog class such that instead of a boolean variable to determine the String format of the catalog items (```verboseString```), your Catalog class holds a CatalogItemFormat object, defining the formatting strategy. 
3. Update Catalog's ```toString()``` implementation, delegating the converstion to the strategy it is holding (passing the collection of CatalogItem objects currently stored in the Catalog), and returning the String that the strategy returns.
4. Modify Catalog's ```setPrintFormat()```, to support setting of the strategy (instead of the boolean value). 
5. Modify Driver.java: first use the non-verbose strategy and print the catalog to the terminal. Then, set the strategy to verbose and print the catalog.  When you compile your redesigned code and run your updated Driver, the output should be the same as the output you saw before your changes:
```
1: Intro to OOP
2: Hello world
3: Are we ther yet?

1: Intro to OOP, Alan, Turing
2: Hello world, csci, 2300
3: Are we ther yet?, Nicholas, Holdener
```
