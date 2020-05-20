
public class Exams{

	private int examDay; //Sunday = 1, Saturday = 7.
	private int examStart;
	private int examEnd;

	
	public int getExamStart() {
		return examStart;
	}
	public void setExamStart(int examStart) {
		this.examStart = examStart;
	}
	public int getExamEnd() {
		return examEnd;
	}
	public void setExamEnd(int examEnd) {
		this.examEnd = examEnd;
	}
  
  public void setExamDay(int examDay)
  {
    
    this.examDay=examDay;
    
  }
  
  public String getExamDayString()
  {
    String s1="";
    if (examDay==1)
      s1="Sunday";
    else if (examDay==2)
      s1="Monday";
    else if (examDay==3)
      s1="Tuesday";
    else if (examDay==4)
      s1="Wednesday";
    else if (examDay==5)
      s1="Thursday";
    else if (examDay==6)
      s1="Friday";
    else if (examDay==7)
      s1="Saturday";
    return s1;
  }
   public int getExamDay()
  {
    return examDay;
  }
  
  public Exams(int examStart, int examEnd, int examDay){
    this.examStart = examStart;
    this.examEnd = examEnd;
    this.examDay = examDay;
  }
  public Exams (Exams e1)
  {
	  this.examDay=e1.examDay;
	  this.examStart=e1.examStart;
	  this.examEnd=e1.examEnd;
  }
  
  
  

  
  

}