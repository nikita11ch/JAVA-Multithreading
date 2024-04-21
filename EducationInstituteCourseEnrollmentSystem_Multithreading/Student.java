package EducationInstituteCourseEnrollmentSystem_Multithreading;

public class Student {
	private String studentName;
	private EducationInstitute educationInstitute;

	public Student(String studentName, EducationInstitute educationInstitute) {
		super();
		this.studentName = studentName;
		this.educationInstitute = educationInstitute;
	}

	public void viewCoursesAndFees()
	{
		Course[] courses = educationInstitute.getCourses();
		for(Course course : courses)
		{
			System.out.println(course.getCourseId()+" : "+course.getCourseName()+" : "+course.getCourseFee());
		}
	}
	
	public void viewOffers()
	{
		Offer[] offers = educationInstitute.getOffers();
		
		for(Offer offer : offers)
		{
			System.out.println(offer.getOfferText());
		}
		
		
	}
	
	public void enrollInCourse(int courseId)
	{
		educationInstitute.enrollStudentInCourse(courseId, studentName);
	}	
}
