import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {
	public static void main(String[] args) {

//		Check arguments
		String readLine = LoadData("student.txt");
		if(args[0].equals("a")) {
			System.out.println("Loading data ...");			
			try {

			String i[] = readLine.split(",");
			for(String j : i) { System.out.println(j.trim()); }
			} catch (Exception e){} 
			System.out.println("Data Loaded.");
		}
		else if(args[0].equals("r")) 
		{
			System.out.println("Loading data ...");			
			try {

			String i[] = readLine.split(",");
			Random x = new Random();
				int y = x.nextInt(i.length);
					System.out.println(i[y]);
			} catch (Exception e){} 
			System.out.println("Data Loaded.");			
		}
		else if(args[0].contains("+")){
			System.out.println("Loading data ...");			
			try {
			BufferedWriter s = new BufferedWriter(
					new FileWriter("students.txt", true));
			String t = args[0].substring(1);
	        Date d = new Date();
	        String df = "dd/mm/yyyy-hh:mm:ss a";
	        DateFormat dateFormat = new SimpleDateFormat(df);
	        String fd= dateFormat.format(d);
			s.write(", "+t+"\nList last updated on "+fd);
			s.close();
			} catch (Exception e){}
							
			System.out.println("Data Loaded.");	
		}
		else if(args[0].contains("?")) 
		{
			System.out.println("Loading data ...");			
			try {

			String i[] = readLine.split(",");
			String t = args[0].substring(1);
			for(int idx = 0; idx<i.length; idx++) {
				if(i[idx].trim().equals(t)) {
					System.out.println("We found it!");
				}
			}
			} catch (Exception e){} 
			System.out.println("Data Loaded.");				
		}
		else if(args[0].contains("c")) 
		{
			System.out.println("Loading data ...");			
			try {
			char a[] = readLine.toCharArray();
			boolean in_word = false;
			int count=0;
			for(char c:a) {
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

	}
	public static String LoadData(String filename){
		try {
			BufferedReader s =  new BufferedReader(
					            new InputStreamReader(
								new FileInputStream("students.txt")));
			       String readLine = s.readLine();
			return readLine;
		}
		catch (Exception e){
			return null;
		}
	}
}