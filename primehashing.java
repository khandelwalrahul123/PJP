import java.util.Scanner;

/*for lowercase strings*/
public class primehashing {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner( System.in );
		System.out.println("Enter the String: ");
		String inpString =input.nextLine();
		inpString=inpString.toLowerCase();
		int[] primemap ={2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101};
		
		String outString = "";
		
		for(int i = 0;i<inpString.length();i++){
		    int hashvalue = primemap[inpString.charAt(i) - 'a'];
		    String temp = Integer.toString(hashvalue);
		    outString = outString.concat(temp);
		}
		System.out.println("Output String is: " + outString);

	}

}
