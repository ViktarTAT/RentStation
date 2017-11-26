package by.htp.rentStation.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {

	public static void printMenu(){
		Print.print("1. viev catalog");
		Print.print("2. viev catalog rent");
		Print.print("3. to rent");
		Print.print("4. viev orders");
		Print.print("9. exit");
	}
	
	public static void printMenuOder(){
		Print.print("Enter id unit:");
		Print.print(" OR 9 validate order");
	}
	
	public static int readConsole() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp = "";
		try {
			temp = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return convertInt(temp);
	}
	
	private static int convertInt(String temp){
		int x = Integer.parseInt(temp);
		return x;
	}
}
