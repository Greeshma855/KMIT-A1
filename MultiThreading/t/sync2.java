class counterThread extends Thread{
	int val;
	int operation;
	static counter obj = new counter();
	counterThread(int cnt, int op){
		val = cnt;
		operation = op;
	}

	public void run(){
		if(operation == 1)	{
			obj.increment(val);                 
		}
		else if(operation == 2)	{
			obj.decrement(val);             
		}
	}
}

class counter{
	int cnt = 1000;
	int getCnt(){
		return cnt;
	}

	void setCnt(int ct){
		cnt = ct;
	}
  void increment(int val)	{
		String str = Thread.currentThread().getName();
		System.out.println(str + " In increment");
		try{
			synchronized(this) {
				int cnt = getCnt();
				System.out.println(str + " Got the initial cnt as " + cnt);
				cnt += val;
				Thread.sleep(2000);
				System.out.println(str + " increment cnt is " + val);
				setCnt(cnt);
				show();
			}
			System.out.println(str + " count " + getCnt());
		}
		catch(Exception e) {}
	}
	void show()	{
		synchronized(this) {
		  String str = Thread.currentThread().getName();
		  System.out.println(str+" In Show  ");
		  System.out.println(str+" total cnt is: " + getCnt());
		}
	}
	void decrement(double val){
		String str=Thread.currentThread().getName();
		System.out.println(str+" In decrement");
		try{
		  synchronized(this) {
			int cnt = getCnt();
			System.out.println(str + " Got the count as " + cnt);
			System.out.println(str + " decrement count is "+ val);
			cnt -= val;
			setCnt(cnt);
			show();
		  }
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args){
		counterThread u1 = new counterThread(1000, 1);
		counterThread u2 = new counterThread(1500, 2);
		u1.start();
		u2.start();
	}
}