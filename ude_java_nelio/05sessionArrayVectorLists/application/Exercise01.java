package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Room;

public class Exercise01 {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("How many rooms will be rented? ");
		int numRents = sc.nextInt();
		
		Room[] vectorRooms = new Room[10];		
		
		sc.nextLine();
		for(int i=0; i < numRents; i++) {
			System.out.printf("%nRent #%d:%n", (i+1));
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Email: ");
			String email = sc.nextLine();
			System.out.print("Room: ");
			int roomNumber = sc.nextInt();
			sc.nextLine();
			
			vectorRooms[roomNumber] = new Room(name, email);
		}
		
		System.out.printf("%nBusy Rooms:%n");		
		for(int i=0; i < vectorRooms.length; i++) {
			if(vectorRooms[i] != null) {
				System.out.printf("%d: %s, %s%n", i, vectorRooms[i].getName(), vectorRooms[i].getEmail());
			}
		}
		

		sc.close();
	}

}
