import java.util.*;
import java.io.*;
class DataParser{
	
	//109.169.248.247 - - [12/Dec/2015:18:25:11 +0100] "GET /administrator/ HTTP/1.1" 200 4263 "-" "Mozilla/5.0 (Windows NT 6.0; rv:34.0) Gecko/20100101 Firefox/34.0" "-"	
		
		static List<String> retrivedData = new ArrayList<String>(); //Used Arraylist instead of Array[] due to Indexing issue.
		static HashSet<String> uniqueIpAddress = new HashSet<String>(); // Used HashSet to Print only Unique Data.
		static HashSet<String> uniqueDates = new HashSet<String>();
		static HashSet<String> serverCode = new HashSet<String>();
	
	
	public static void readData(){
	
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("logs_sm.csv"));
			String line = reader.readLine().trim();
			while (line != null) {
				retrivedData.add(line);
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void getUniqueIpAddresses(){
		for(String ip : retrivedData){
			String temp = ip.split(" - - ")[0];
			uniqueIpAddress.add(temp);
		}
	}
		
	public static void getDates(){
		String temp = "";
		for(String dates : retrivedData){
			temp = dates.split(" +")[3];
			temp = temp.split(":")[0];
			temp = temp.split("\\[")[1];
			uniqueDates.add(temp);
		}
	}
	
	
	public static void getCode(){
		String temp = "";
		for(String code : retrivedData){
			temp = code.split(" +")[8];
			if(temp!="200"){
				serverCode.add(temp);
			}
		}
	}
	
	public static void printData(HashSet<String> printMap){
		for(String i : printMap){
            System.out.println(i);
        }
	}

public static void main(String args[]){
	
		readData();
		
		getUniqueIpAddresses();
		
		getDates();
		
		getCode();
		
		printData(uniqueIpAddress); // Pass the HashSet uniqueIpAddress, uniqueDates, serverCode to Print
		
	}
	
}
