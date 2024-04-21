package EducationInstituteCourseEnrollmentSystem_Multithreading;

public class EducationInstitute 
{
	Course[] courses;
	Offer[] offers;
	
	public EducationInstitute(Course[] courses, Offer[] offers) {
		super();
		this.courses = courses;
		this.offers = offers;
	}

	public Course[] getCourses()
	{
		return courses;
	}
	
	public Offer[] getOffers()
	{
		return offers;
	}
	
	public void enrollStudentInCourse(int courseId, String studentName)
	{
		for(int i=0; i<courses.length; i++)
		{
			if(courseId == courses[i].getCourseId())
			{
				System.out.println(studentName+" enrolled in :"+courses[i].getCourseName());
			}
		}
		
	}
}
	
