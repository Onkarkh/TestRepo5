import java.util.*;
import java.io.*;
class DataParser{
	
	//109.169.248.247 - - [12/Dec/2015:18:25:11 +0100] "GET /administrator/ HTTP/1.1" 200 4263 "-" "Mozilla/5.0 (Windows NT 6.0; rv:34.0) Gecko/20100101 Firefox/34.0" "-"	
		
		static String[] retrivedData = new String[20];
		static String[] ipAddress = new String[20];
		static String[] dates = new String[20];
		static String[] code = new String[20];
	
	
	public static void readData(){
	
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("logs_sm.txt"));
			String line = reader.readLine().trim();
			int i = 0;
			while (line != null) {
				retrivedData[i] = line;
				i++;
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	
	public static void getIpAddress(){
		for(int i = 0; i<=retrivedData.length; i++){
			ipAddress.add(retrivedData[i].split(" - - ")[0]);
		}	
	}
	
	public static void getDates(){
		String[] temp = new String[20];
		for(int i = 0; i<retrivedData.length; i++){
			temp[i] = retrivedData[i].split(" +")[3];
			temp[i] = temp[i].split(":")[0];
			dates[i] = temp[i].split("\\[")[1];
		}
		
	}
	
	public static void getCode(){
		String[] temp = new String[20];
		for(int j = 0; j<retrivedData.length; j++){
			code[j] = retrivedData[j].split(" +")[8];
		}
	}
	

public static void main(String args[]){
	
		readData();
		
		getIpAddress();
		
		getDates();
		
		getCode();
		
		printData();
		
	}
	
}
