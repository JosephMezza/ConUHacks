
import java.util.Scanner;



public class CalendarDriver{
	public static void main (String [] args){

		boolean d = false;
		Scanner keys = new Scanner(System.in);

		System.out.println("********************************************"
				+ "\n\tWelcome to Plan your Exam!"
				+ "\n********************************************");
		do{
			System.out.println();
		
		System.out.println("Are you a teacher (Enter 0) (password required) or a student (Enter 1) ?");
		int user = keys.nextInt();



		//teacher -------------

		//option initialized

		int option_No = 0;
		boolean b = false;

		//password initialized
		int pass_Try = 0;
		int trial_No = 1;

		//exam initialized
		int exam_Entry = 0;

		// teachers and students initialized




		Student[] stu = new Student[10];
		stu[0] = new Student(1,"Maira",5);
		stu[1] = new Student(2,"Alexandru",5);
		stu[2] = new Student(3,"Jonathan",5);
		stu[3] = new Student(4,"Joseph",5);
		stu[4] = new Student(5, "Aiman Hanna",5);
		stu[5] = new Student(6,"Kool-Aid Man",5);

		boolean[] b0 = {false, true, false, true, false};
		Student[] s0 = {stu[0], stu[1], stu[3]};

		boolean[] b1 = {true, false, true, false, false};
		Student[] s1 = {stu[0], stu[1], stu[3], stu[4]};

		boolean[] b2 = {true, true, false, true, false};
		Student[] s2 = {stu[5], stu[1], stu[4]}; 

		boolean[] b3 = {false, true, false, true, false};
		Student[] s3 = {stu[2], stu[5]}; 

		Teacher[] tea = new Teacher[4];
		tea[0] = new Teacher("Lincoln", 1400, 1530, b0, s0 );
		tea[1] = new Teacher("Bush", 1300, 1530, b1, s1);
		tea[2] = new Teacher("Roosevelt", 1000, 1130, b2 ,s2);
		tea[3] = new Teacher("Nixon", 1200, 1330, b3, s3);
		
		Exams e2=new Exams(1200, 1400, 3);
		Exams e3=new Exams(1155,1255, 6);
		
		tea[0].setExam(e3);
		tea[1].setExam(e2);
		
		System.out.println(stu[0].getExam());
		

		Exams forCopy = new Exams(0,0,0);
		

		//tecaher count initialized
		int tcount = 0;

		if(user ==0){

			final String pass = "teacher"; //change pass

			for(pass_Try =0; pass_Try<3; pass_Try++) {

				System.out.print("Please enter the password: ");
				String password = keys.next();

				if (password.equals(pass)) {
					System.out.println("Access granted.");
					b = true;
					break;
				}

				else {
					System.out.println("Wrong Password.");
					System.out.println();

					if (trial_No == 12)
					{
						System.out.print("Program detected suspicious activities and will terminate immediately!");
						System.exit(0);
					}
					trial_No++;
				}
			}

			do {

				System.out.println("Which teacher are you? (Please enter number)"
						+ "\n\t0.   Lincoln"
						+ "\n\t1.   Bush"
						+ "\n\t2.   Roosevelt"
						+ "\n\t3.   Nixon"
						+ "\n\t4.   Reagan");
				int tNum= keys.nextInt(); 

				for (int i =1; i<=1;) {
					System.out.print("What do you want to do?"
							+ "\n\t1.   Enter new exam"
							+ "\n\t2.   Change the date and time of an exam"
							+ "\n\t3.   Display all dates of all exams for specific class"
							+ "\n\t4.   Display all student request dates for an exam"
							+ "\n\t5.   Quit"
							+ "\nPlease enter your choice > ");
					option_No = keys.nextInt();

					System.out.println();

					if( option_No > 0 && option_No <= 5) {
						i++;
					}
				}
				// ************************  OPTION 1 *********************************
				if(option_No ==1) {

					for(int c =0; c<1;){

						System.out.println();

						System.out.println ("Please enter an Exam day:"
								+"\n\tMonday   \t Enter 1"
								+"\n\tTuesday  \t Enter 2"
								+"\n\tWednesday\t Enter 3"
								+"\n\tThursday \t Enter 4"
								+"\n\tFriday   \t Enter 5"
								+"\n\tSaturday \t Enter 6"
								+"\n\tSunday   \t Enter 7");

						int dayOfWeek = keys.nextInt();
						
						tea[tNum].setExam_Day(dayOfWeek);
						System.out.println("Please enter the start time, then press enter and the the end date in army format: ");
						int startTime = keys.nextInt();
						tea[tNum].setExam_St(startTime);
						int endTime = keys.nextInt();
						tea[tNum].setExam_End(endTime);
						Exams e1= new Exams(startTime, endTime, dayOfWeek );
						tea[tNum].setExam(e1);
					
						if((dayOfWeek >= 1 && dayOfWeek <= 7)&&(startTime>=0&&startTime>830)&&(endTime>=0&&endTime<2200)){

							for(int t =0; t<tea.length; t++){
								if(t != tNum){
									boolean check = (tea[tNum].getExam_End() >= tea[t].getExam_End() && tea[tNum].getExam_St()<= tea[t].getExam_End())
											|| (tea[tNum].getExam_St() >= tea[t].getExam_St() && tea[tNum].getExam_End()<= tea[t].getExam_End())
											|| tea[tNum].getExam_St() <= tea[t].getExam_St() && tea[tNum].getExam_End()>= tea[t].getExam_End();
									if(check == true){
										tcount++;
									}
								}
								if(t == tNum){
									continue;
									
								}

							}
							if(tcount ==0) {
								
								forCopy.setExamStart(startTime);
								forCopy.setExamEnd(endTime);
								forCopy.setExamDay(dayOfWeek);
								System.out.println(tea[tNum].getExams());
								c++;
							}

						}

						else {
							System.out.println("Sorry that is not a valid day of the week!");
						}  
						if(tcount !=0) {
							System.out.println("Sorry that is not a valid day of the week!");
						}
					}
					System.out.println();
					System.out.print("Would you like to go back to main menu (Enter \"true\")\n"
							+ "OR\n"
							+ "Quit the system (Enter \"false\"):");

					boolean choice = keys.nextBoolean();
					System.out.println();

					if (choice == true) {
						b = false;
					}
					else if(choice == false) {
						break;
					}
				}
					// ************************  OPTION 2 *********************************
					if(option_No ==2) {
						for(int c =0; c<1;){

							System.out.println();

							System.out.println ("Please enter an Exam day:"
									+"\n\tMonday   \t Enter 1"
									+"\n\tTuesday  \t Enter 2"
									+"\n\tWednesday\t Enter 3"
									+"\n\tThursday \t Enter 4"
									+"\n\tFriday   \t Enter 5"
									+"\n\tSaturday \t Enter 6"
									+"\n\tSunday   \t Enter 7");

							int dayOfWeek = keys.nextInt();
							
							tea[tNum].setExam_Day(dayOfWeek);
							System.out.println("Please enter the start time, then press enter and the the end date in army format: ");
							int startTime = keys.nextInt();
							tea[tNum].setExam_St(startTime);
							int endTime = keys.nextInt();
							tea[tNum].setExam_End(endTime);
							Exams e1= new Exams(startTime, endTime, dayOfWeek); 
							tea[tNum].setExam(e1);
						
							if((dayOfWeek >= 1 && dayOfWeek <= 7)&&(startTime>=0&&startTime>830)&&(endTime>=0&&endTime<2200)){

								for(int t =0; t<tea.length; t++){
									if(t != tNum){
										boolean check = (tea[tNum].getExam_End() >= tea[t].getExam_End() && tea[tNum].getExam_St()<= tea[t].getExam_End())
												|| (tea[tNum].getExam_St() >= tea[t].getExam_St() && tea[tNum].getExam_End()<= tea[t].getExam_End())
												|| tea[tNum].getExam_St() <= tea[t].getExam_St() && tea[tNum].getExam_End()>= tea[t].getExam_End();
										if(check == true){
											tcount++;
										}
									}
									if(t == tNum){
										continue;
										
									}

								}
								if(tcount ==0) {
									forCopy.setExamStart(startTime);
									forCopy.setExamEnd(endTime);
									forCopy.setExamDay(dayOfWeek);
									c++;
									System.out.println();
									System.out.println("the exam now starts at "+forCopy.getExamStart()+" "
									+ " and ends at "+ forCopy.getExamEnd() 
									+ " on day number "+ forCopy.getExamDay() +" of the week!");
								}

							}

							else {
								System.out.println("Sorry that is not a valid day of the week!");
							}  
							if(tcount !=0) {
								System.out.println("Sorry that is not a valid day of the week!");
							}
						}
						System.out.println();
						System.out.print("Would you like to go back to main menu (Enter \"true\")\n"
								+ "OR\n"
								+ "Quit the system (Enter \"false\"):");

						boolean choice = keys.nextBoolean();
						System.out.println();

						if (choice == true) {
							b = false;
						}
						else if(choice == false) {
							break;
						}
						}

				// ************************  OPTION 3*********************************
				if(option_No ==3) {
					System.out.println(tea[tNum]);
				}

				// ************************  OPTION 4 *********************************
				if(option_No ==4) {
				}

				// *************************  OPTION 5 *********************************
				else if(option_No == 5) {
					System.out.println();
					System.out.println("************************************");
					System.out.println("Thanks for using Exam Modifier!");
					System.out.println("************************************");
					System.exit(0);
				}

			}while (b == false);
		}
		// student ---------------
		if (user == 1){

			System.out.print("Please Enter your student ID: ");
			int stuID = keys.nextInt();




			System.out.print("What do you want to do?"
					+ "\n\t1. Display exam dates and times"
					+ "\n\t2. Request a date for an exam"
					+ "\n\t5. Quit"
					+ "\nPlease enter your choice > ");

			int choice = keys.nextInt();

			if(choice == 1){

				System.out.println(stu[stuID-1].getExam());
			}

			else if(choice == 2){

				System.out.println ("Please enter an Exam day:"
						+"\n\tMonday   \t Enter 1"
						+"\n\tTuesday  \t Enter 2"
						+"\n\tWednesday\t Enter 3"
						+"\n\tThursday \t Enter 4"
						+"\n\tFriday   \t Enter 5"
						+"\n\tSaturday \t Enter 6"
						+"\n\tSunday   \t Enter 7");
				int prefDay = keys.nextInt();





			}



		}
		System.out.println();
		System.out.print("Would you like to go back to main menu (Enter \"true\")\n"
				+ "OR\n"
				+ "Quit the system (Enter \"false\"):");

		boolean choice = keys.nextBoolean();
		System.out.println();

		if (choice == true) {
			d = false;
		}
		else if(choice == false) {
			System.exit(0);
		}
		
		}while(d==false);
	}
}