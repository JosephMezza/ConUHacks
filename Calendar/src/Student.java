import java.util.Scanner;
public class Student{

    private int ID;
  // check id after it's made that it is not the same as another student's, use array 
    private String name;
    private int numClasses;
  	public Exams[] e1;
  	
    public int getID() {
		return ID;
	}
  
    public Student(int ID, String name, int numClasses){
    this.ID = ID;
    this.name = name;
    e1=new Exams[numClasses];
    for(int i=0;i<numClasses;i++)
    	e1[i]=null;
    this.numClasses=numClasses;
  }
  
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
  public void setNumClasses(int num){
    numClasses = num;
  }
  public int getNumClasses(){
    return (numClasses);
  }
  
	public void setExamStudent(Exams e1) {
	
		for(int i=0;i<numClasses;i++)
		{
			if(this.e1[i]==null)
			{
				this.e1[i]=new Exams(e1);
				break;
			}
		}
	
	
	}
	
	public String getExam(){
		String s1="";
		for(int i=0; i<e1.length;i++) {
			if(e1[i]!=null)
			s1=s1+ "The exam "+(i+1)+" is "+ e1[i].getExamDayString()+
					", and it starts at: "+e1[i].getExamStart()+", and it finishes at: "
					+e1[i].getExamEnd()+"\n";
			else 
				break;
		}
		return s1;
	    }
  
  

  }