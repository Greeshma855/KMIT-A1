import java.util.*;

class sortDisplay
{
	int [] data;

	sortDisplay(int[] data) {
		this.data = data.clone();
	}

	void sort() {
		Arrays.sort(data);
	}

	void display() {
		System.out.println("Data is " + Arrays.toString(data));
	}
}	

class sortThread extends Thread
{
	sortDisplay obj;

	sortThread(sortDisplay data)
	{
		obj = data;
	}

	public void run()
	{
		obj.sort();
    }    
}	

class displayThread extends Thread
{
	sortDisplay obj;

	displayThread(sortDisplay data)
	{
		obj = data;
	}

	public void run()
	{
		obj.display();
    }    
}	
	
class Join 
{
	public static void main(String[]args) throws InterruptedException
	{
		int [] arr = {8, 1, 2, 22, 7, 50, 4, 30, 11};

		sortDisplay obj = new sortDisplay(arr);
		sortThread s = new sortThread(obj);
		s.start();
		s.join();

		displayThread d = new displayThread(obj);
		d.start();	
	}
}
