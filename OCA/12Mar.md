include few tricky examples that have inner and outer try,catch and finally blocks
catch blocks order matter? exception heirarchy
the catch block should be aranged from grand children to parent
like Arithmetic Exception
Runtime Exception
Exception

the order does not matter when the exceptions are all of same level or in other words don;t have parent child relation ship
eg: Null pointer exception, Array Index Out of bounds, Arithmetic Exception
in here order does not matter.

user defined exceptions
based on the checked and unchecked exception
include an example of user defined exception
the ude will have a constructor and it should have a string parameter, will be used as the error message to pass to the parent class

printStackTrace?? what is this

import java.io.*;
class Exception
{
    public static void main(String[] args) {
        try
        {
            System.out.println(10/0);
        }
        catch(IOException a) //this is checked excpetion is never thrown - does not compile
        {
            System.out.println("e");
        }
    }
}

class Exception
{
    public static void main(String[] args) {
        try
        {
            System.out.println(10/0);
        }
        catch(ArithmeticException | NullPointerException a)
        {
            System.out.println("e");
        }
    }
}

ASSERT
the assert is a statement which is assuemed to be true.
if deposit is -5000, it gets deducted. we don't want it

Assert statements are part of the byte code and we need to enable it to see the assertion (-ea --> enable assertion)

class AssertionDemo 
{
	int addPos(int x, int y)
  	{
    	assert(x > 0);
    	assert(y > 0) : "Y is less than zero " + y;
    	return x + y;
  	}

	public static void main(String [] args) 
	{
    	AssertionDemo ad = new AssertionDemo();
    	System.out.println("output is " + ad.addPos(2, -3));
  	}	
}

java -ea AssertionDemo
Exception in thread "main" java.lang.AssertionError: Y is less than zero -3
        at AssertionDemo.addPos(AssertionDemo.java:6)
        at AssertionDemo.main(AssertionDemo.java:13)