package Multithreading;

class Customer implements Runnable
{
    private int availableSeat = 1;
    private int wantedSeat;
    
    public Customer(int wantedSeat)
    {
    	this.wantedSeat = wantedSeat;
    }
    
	@Override
	public void run() 
	{
		String name = null;
	    
		//t1   t2
		
		if(availableSeat >= wantedSeat)
		{
			name = Thread.currentThread().getName();
			System.out.println(wantedSeat + " seat booked for :"+name);
			availableSeat = availableSeat - wantedSeat;
		}
		else
		{
			name = Thread.currentThread().getName();
			System.err.println("Sorry "+name+" seat is not available");
		}			
	}	
}

public class RailwayReservation {

	
	public static void main(String[] args) 
	{
		Customer c1 = new Customer(1);
		
		Thread t1 = new Thread(c1, "Person1");
		Thread t2 = new Thread(c1, "Person2");
		
		t1.start();  t2.start();
	}

}