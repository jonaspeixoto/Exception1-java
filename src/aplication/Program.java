package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entites.Resevation;
import model.exceptions.DomainException;

public class Program {
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		try {
			System.out.print("Room number: ");
			int number = sc.nextInt();
			System.out.print("CheckIn date (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next());		
			System.out.print("CheckOut date (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next());
			
			
			Resevation resevation = new Resevation(number, checkIn, checkOut);
			System.out.println("Resevation: " + resevation);
			System.out.print("Enter in the data to update the reservation ");
			System.out.print("CheckIn date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());		
			System.out.print("CheckOut date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
	
			resevation.updateDates(checkIn, checkOut);
			System.out.println("Resevation: " + resevation);				
		}
		
		catch (ParseException e) {
			System.out.println("Invalid date format");
		}
		catch (DomainException e) {
			System.out.println("Error in reservation" + e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Unexpected error");
		}

		
		
		
		sc.close();
	}
}
