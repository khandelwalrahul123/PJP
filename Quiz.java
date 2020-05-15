import java.io.IOException;
import java.util.Scanner;

class Timer implements Runnable{

	public void run() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		}
	
	}
}
class Question{
	 private String question; 
	 private String opt1, opt2, opt3, opt4; 
	 private Integer correctOpt; 
	 
	 public void setData(String q,String o1,String o2,String o3,String o4,Integer c){
		 question = q;
		 opt1 = o1;
		 opt2 = o2;
		 opt3 = o3;
		 opt4 = o4;
		 correctOpt = c;
	 }
	 public Integer getCorrectOpt(){
		 return correctOpt;
	 }
	 public void printQs() {
		 System.out.println(question+"\n a."+opt1+"\n b."+opt2+"\n c."+opt3+"\n d."+opt4);
	 }
}

public class Quiz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Question questions[] = new Question[5];
    	for(int i=0;i<5;i++) {
    		questions[i] = new Question();
    	}
    	questions[0].setData("Who was the first Indian woman in Space?", "Kalpana Chawla", 
    			"Sunita Williams", "Koneru Humpy", "None of the above",1);
    	questions[1].setData("Who was the first Man to Climb Mount Everest Without Oxygen?", "Junko Tabei", 
    			"Reinhold Messner", "Peter Habeler", "Phu Dorji",4);
    	questions[2].setData("Who built the Jama Masjid", "Jahangir", 
    			"Akbar", "Shah Jahan", "Aurangjeb",3);
    	questions[3].setData("Who is the first Indian to win a Nobel Prize?", "Rabindranath Tagore", 
    			"CV Raman", "Mother Theresa", "Hargobind Khorana",1);
    	questions[4].setData("How many ODI World Cups has India won?", "1", 
    			"2", "3", "4",2);
    	
		
		System.out.println("Starting Quiz...");
		System.out.println("You have 10 seconds to answer each question and if unable to do so quiz ends");
		
		for(int i = 0;i<5;i++) {
			questions[i].printQs();
			
			System.out.println("Enter answer in integer i.e (1-4): ");
				
			Timer t = new Timer();
			
			Thread thread = new Thread(t);
			thread.start();
			
			Scanner scanner = new Scanner(System.in);
			int answer = 0;
			while(thread.isAlive()) {
				try {
					if(System.in.available() > 0) {
						answer = scanner.nextInt();
						thread.interrupt();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}				
			}
			if(answer == 0) {
				System.out.println("\nTime's Up!!\n\n");
				break;
			}
			else {
				if(answer == questions[i].getCorrectOpt()) {
					System.out.println("Correct Answer!");
				}
				else {
					System.out.println("Wrong Answer!");
				}
			}	
		}
		System.out.println("\nQuiz Ended!\n");
		
		
	}

}