import java.util.*;

public class Synonym{

     public static void main(String []args){

		// TODO Auto-generated method stub
		
        Map<String, Set<String>> reqdMap = new HashMap<String, Set<String>>();

      //Form the set corresponding to apple.
        Set<String> wordset1 = new HashSet<String>();
        wordset1.add("GoodMorning");
        wordset1.add("Shubhodaya");
        wordset1.add("Shubhohday");
        wordset1.add("Bonjour");
        
        Set<String> wordset2 = new HashSet<String>();
        wordset2.add("GoodEvening");
        wordset2.add("Shubha sange");
        wordset2.add("Susandhya");
        wordset2.add("Bonsoir");
      


        reqdMap.put("GoodMorning", wordset1);
        reqdMap.put("GoodEvening", wordset2);

		Boolean temp = true;
		Scanner myscan = new Scanner(System.in);
		
		System.out.println("Enter the word: ");
		String word = myscan.next();
		Set<String>	set=reqdMap.get(word);
		if (set!=null) {
			System.out.println(reqdMap.get(word));
		}
		else {
			System.out.println("Not found-To add synonyms press y else n");
			Set<String> s = new HashSet<String>();
			while (myscan.hasNext()) {
				String string = myscan.next();
				if (string.equals("n")) {
					break;
				}else {
					System.out.println("enter the new synonym");
					string = myscan.next();
					s.add(string);
				}

				System.out.println("To continue adding press y else n");
			
				if (!s.isEmpty()) {
					reqdMap.put(word, s);
				}
			}
			System.out.println("New synonyms added"+reqdMap.get(word));
		}	 
	}
}