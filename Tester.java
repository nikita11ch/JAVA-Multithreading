package Multithreading;
/*
 A typical example of simultaneous threads is that of an online Movie ticket reservation system.
Multiple users are trying to book seats/products at the same time. In this problem, you are writing a Ticker Dispenser in a BOOK MY SHOW APPLICATION SYSTEM.

 */
class TicketDispenser implements Runnable {
    private static final int MAX_SEATS = 200;
    private int allotedSeats;

    public TicketDispenser(int allotedSeats) {
        this.allotedSeats = allotedSeats;
    }

    @Override
    public void run() {
        int seatNumber = allotSeatNumber();
        if (seatNumber != -1) {
            System.out.println(Thread.currentThread().getName() + " allocated seat number " + seatNumber);
        } else {
            System.out.println(Thread.currentThread().getName() + " could not allocate any seat.");
        }
    }

    private synchronized int allotSeatNumber() {
        if (allotedSeats > 0 && allotedSeats <= MAX_SEATS) {
            int allocated = Math.min(allotedSeats, MAX_SEATS);
            allotedSeats -= allocated;
            return allocated;
        } else {
            return -1;
        }
    }
}

public class Tester {
    public static void main(String[] args) {
        TicketDispenser t1 = new TicketDispenser(3);
        TicketDispenser t2 = new TicketDispenser(40);
        TicketDispenser t3 = new TicketDispenser(5);
        TicketDispenser t4 = new TicketDispenser(990);
        TicketDispenser t5 = new TicketDispenser(50);

        Thread thread1 = new Thread(t1, "Thread-1");
        Thread thread2 = new Thread(t2, "Thread-2");
        Thread thread3 = new Thread(t3, "Thread-3");
        Thread thread4 = new Thread(t4, "Thread-4");
        Thread thread5 = new Thread(t5, "Thread-5");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }
}

