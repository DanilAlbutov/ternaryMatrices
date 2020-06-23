package TAthirdMatrix;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MainClass {

	public static String[] var = new String[21];
	
	public static void fillArr() {
		for (int i = 0; i < var.length; i++) {
			var[i] = "-";
		}
		
	}
	
	public static String addToString(String s) {
		s += "" + ((char) 34);
		for (int i = 0; i < var.length; i++) {
			s += var[i];
		}
		s += "" + ((char) 34);
		return s;
	}
	
	public static void splitChange(String str) {
		String curret = "";
		String curretNum = "";
		for (int i = 0; i < str.length(); i++) {
			if (str.toCharArray()[i] == '!' || str.toCharArray()[i] == 'a' || str.toCharArray()[i] == 'x') {
				if (str.toCharArray()[i] == '!') {
					curret += str.toCharArray()[i];
					i++;
					curret += str.toCharArray()[i];
					if (!(str.length() < i + 1)) {	
						while ( str.length() > i + 1 && !(str.toCharArray()[i+1] == '!' 
								|| str.toCharArray()[i+1] == 'a' 
								|| str.toCharArray()[i+1] == 'x')) {
							i++;
							curretNum += str.toCharArray()[i];
							
						}
					}
					if (curret.equals("!a")) {
						var[4 - (Integer.parseInt(curretNum) )] = "0";
					}
					if (curret.equals("a")) {
						var[4 - (Integer.parseInt(curretNum) )] = "1";
					}
					if (curret.equals("!x")) {
						var[Integer.parseInt(curretNum) + 3] = "0";
					}
					if (curret.equals("x")) {
						var[Integer.parseInt(curretNum) + 3] = "1";
					}
					curret = "";
					curretNum = "";
				} else {
					if (str.toCharArray()[i] == 'a') {
						curret += str.toCharArray()[i];
						if (!(str.length() < i + 1)) {						
							while (str.length() > i + 1 && !(str.toCharArray()[i+1] == '!' 
									|| str.toCharArray()[i+1] == 'a' 
									|| str.toCharArray()[i+1] == 'x')) {
								i++;
								curretNum += str.toCharArray()[i];
								
							}
						}
						if (curret.equals("!a")) {
							var[4 - Integer.parseInt(curretNum)] = "0";
						}
						if (curret.equals("a")) {
							var[4 - Integer.parseInt(curretNum) ] = "1";
						}
						if (curret.equals("!x")) {
							var[Integer.parseInt(curretNum) + 3] = "0";
						}
						if (curret.equals("x")) {
							var[Integer.parseInt(curretNum) + 3] = "1";
						}
						curret = "";
						curretNum = "";
					} else {
						if (str.toCharArray()[i] == 'x') {
							curret += str.toCharArray()[i];
							if (!(str.length() < i + 1)) {	
								while (str.length() > i + 1 && !(str.toCharArray()[i+1] == '!' 
										|| str.toCharArray()[i+1] == 'a' 
										|| str.toCharArray()[i+1] == 'x') ) {
									i++;
									curretNum += str.toCharArray()[i];
									
								}
							}
							if (curret.equals("!a")) {
								var[ 4 - Integer.parseInt(curretNum)] = "0";
							}
							if (curret.equals("a")) {
								var[4 - Integer.parseInt(curretNum)] = "1";
							}
							if (curret.equals("!x")) {
								var[Integer.parseInt(curretNum) + 3] = "0";
							}
							if (curret.equals("x")) {
								var[Integer.parseInt(curretNum) + 3] = "1";
							}
							curret = "";
							curretNum = "";
						}
					}
				}
			}
		}		
	}
	
	
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("C:\\Users\\Данил\\Desktop\\input.txt"));
		String s = "";
		String finalStr = "";
		
		while (sc.hasNextLine()) {
			s += sc.nextLine() ;			
		}	
		sc.close();
		StringTokenizer st = new StringTokenizer(s, " v");
		int i = 0;
		while (st.hasMoreTokens()) {
			fillArr();
			String curret = st.nextToken();
			splitChange(curret);
			finalStr = addToString(finalStr) + ",";			
			i++;
		}
		
		System.out.print("[" + finalStr + "]");
	}

}
