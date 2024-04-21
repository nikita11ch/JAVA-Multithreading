package EducationInstituteCourseEnrollmentSystem_Multithreading;

public class Main {

	public static void main(String[] args) throws InterruptedException 
	{
		Course [] courses = new Course[3];
		courses[0] = new Course(1, "Java", 1000);
		courses[1] = new Course(2, ".NET", 1200);
		courses[2] = new Course(3, "Python", 900);
		
		Offer [] offers = new Offer[2];
		offers[0]= new Offer("Special discount: Get 20% off on all courses!");
		offers[1] = new Offer("Limited time offer: Enroll in any two courses and get one course free!");
		
		EducationInstitute ei = new EducationInstitute(courses, offers);
		
		Student virat = new Student("Virat", ei);
		Student dhoni = new Student("Dhoni", ei);
		Student sachin = new Student("Sachin", ei);
		
		Thread t1 = new Thread()
		{
		 @Override
		 public void run()
		 {
			 System.out.println("Available courses and Fess :");
			 virat.viewCoursesAndFees();
			 virat.viewOffers();
			 virat.enrollInCourse(1);
		 }		
			
		};
		
		
		Thread t2 = new Thread()
		{
		 @Override
		 public void run()
		 {
			 System.out.println("Available courses and Fess :");
			 dhoni.viewCoursesAndFees();
			 dhoni.viewOffers();
			 dhoni.enrollInCourse(2);
		 }		
			
		};
		
		Thread t3 = new Thread()
		{
		 @Override
		 public void run()
		 {
			 System.out.println("Available courses and Fess :");
			 sachin.viewCoursesAndFees();
			 sachin.viewOffers();
			 sachin.enrollInCourse(3);
		 }		
			
		};
		
        t1.start();		
		t1.join();
		System.out.println("------------------------------");
		t2.start();
		t2.join();
		System.out.println("------------------------------");
		t3.start();
		
	}

}