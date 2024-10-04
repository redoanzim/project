import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {
	public static void main(String[] args) {

//		Check arguments
		String readLine = LoadData("Student.txt");
		if( args == null || args.length != 1){
			System.out.println("Wrong Argument");
		}
		if(args[0].equals("a")) {
			System.out.println("Loading data ...");			
			try {
			String split[] = readLine.split(",");
			for(String word : split) { System.out.println(word.trim()); }
			} catch (Exception e){} 
			System.out.println("Data Loaded.");
		}
		else if(args[0].equals("r")) 
		{
			System.out.println("Loading data ...");			
			try {

			String split[] = readLine.split(",");
			Random random = new Random();
				int randoNum = random.nextInt(split.length);
					System.out.println(split[randoNum]);
			} catch (Exception e){} 
			System.out.println("Data Loaded.");			
		}
		else if(args[0].contains("+")){
			System.out.println("Loading data ...");			
			try {
			BufferedWriter filereader = new BufferedWriter(
									    new FileWriter("students.txt", true));
			String newword = args[0].substring(1);
	        Date date = new Date();
	        String datetype = "dd/mm/yyyy-hh:mm:ss a";
	        DateFormat dateFormat = new SimpleDateFormat(datetype);
	        String format= dateFormat.format(date);
			filereader.write(", "+newword+"\nList last updated on "+format);
			filereader.close();
			} catch (Exception e){}
							
			System.out.println("Data Loaded.");	
		}
		else if(args[0].contains("?")) 
		{
			System.out.println("Loading data ...");			
			try {
			String split[] = readLine.split(",");
			boolean done = false;
			String words = args[0].substring(1);
			for(int idx = 0; idx<split.length && !done; idx++) {
				if(split[idx].trim().equals(words)) {
					System.out.println("We found it!");
						done=true;
				}
			}
			} catch (Exception e){} 
			System.out.println("Data Loaded.");				
		}
		else if(args[0].equals("c"))
		{
			System.out.println("Loading data ...");			
			try {
			char charArray[] = readLine.toCharArray();
			boolean in_word = false;
			int count=0;
			for(char c:charArray) {
				if(c ==' ') 
				{
					if (!in_word) {	count++; in_word =true;	}
					else { in_word=false;}			
				}
			}
			System.out.println(count +" word(s) found " );
			} catch (Exception e){} 
			System.out.println("Data Loaded.");				
		}
		else{
			System.out.println("Wrong Argument");
		}
	}
	public static String LoadData(String filename){
		try {
			BufferedReader filereader = new BufferedReader(
										new InputStreamReader(
									    new FileInputStream(filename)));
			String readLine = filereader.readLine();
			return readLine;

		}
		catch (Exception e){
			return null;
		}

	}

}