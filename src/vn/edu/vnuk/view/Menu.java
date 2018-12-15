package vn.edu.vnuk.view;

import java.util.Scanner;

import vn.edu.vnuk.controller.PersonFactory;
import vn.edu.vnuk.define.Define;
import vn.edu.vnuk.model.Lecturer;

public class Menu {
	
	
	public static int inputSelection(int min, int max) {
		Scanner sc = new Scanner(System.in);
		int value = min - 1;
		boolean check = false;
		
		System.out.println("Input selection (" + min + " - " + max +")");
		
		while (check == false) {
			System.out.println("Input : ");
			value = sc.nextInt();
			
			if (value < min || value > max)
				System.out.println("Wrong input!");
			else
				check = true;
		}
		return value;
	}
	
	public static void mainMenu() {
		int value;
		System.out.println("1. Add new staff. \n" +
				   		   "2. Edit staff information. \n" +
				   		   "3. Delete staff. \n" +
				   		   "4. Show list of staff. \n" +
				   		   "5. Clear database. \n" +
				   		   "6. Show list of salary. \n" +
				   		   "7. Update minimum wage. \n" +
				   		   "8. Nhap danh sach ma can bo subscribe luong co ban \n" +
				   		   "9. Exit.");
		value = inputSelection(1, 9);
		switch (value) {
		case 1: {
			menuOne();
			break;
		}
		}
	}
	
	public static void menuOne() {
		int value;
		System.out.println("1.1 Add new staff to list's bottom. \n" +
						   "1.2 Add new staff to list's top. \n" +
						   "1.3 Add new staff after SPECIFIC postion. \n" +
						   "1.4 Add new staff to list's bottom from file staff.txt. \n" +
						   "1.5 Add new casual worker from file labor.txt. \n" +
						   "1.6 Return.");
		value = inputSelection(1, 6);
		switch (value) {
		case 1: {
			switch (selectTypeOfEmployee()) {
			case Define.TYPE_OF_LECTURER: {
				 Lecturer lecturer = (Lecturer)PersonFactory.getPerson(Define.TYPE_OF_LECTURER);
				 lecturer.input();
				 Define.persons.add(lecturer);
				 break;
			}
			
			}
			break;
		}
		}
		
	}
	
	public static void menuTwo() {
		System.out.println("Enter employee's number: ");
	}
	
	public static void menuThree() {
		System.out.println("Enter employee's number: ");
	}
	
	public static void menuFour() {
		System.out.println("4.1 Show current list of staff. \n" +
						   "4.2 Show list order by salary ASC. \n" +
						   "4.3 Show list order by name alphabetical. \n" +
						   "4.4 Search staff by name. \n" +
						   "4.5 Search staff by year of birth. \n");
		int value = inputSelection(1, 5);
		switch (value) {
		case 1: {
			for (int index = 0; index < Define.persons.size(); index++) {
				Define.persons.get(index).toString();
			}
			break;
		}
		}
		
	}
	
	public static void menuFive() {
		System.out.println("Database cleared!");
	}
	
	public static void menuSix() {
		System.out.println("List of employee and salary: ");
	}
	
	public static void menuSeven() {
		System.out.println("Enter new minimum wage: ");
	}
	
	public static void menuEight() {
		System.out.println("Enter employee's id: ");
	}
	
	public static void menuNine() {
		System.out.println("Thank you!");
	}
	
	public static int selectTypeOfEmployee() {
		Scanner sc = new Scanner(System.in);
		int value;
		System.out.println("1. Lecturer  " +
						   "2. Staff.");
		value = inputSelection(1, 2);
		
		switch (value) {
		case 1: return Define.TYPE_OF_LECTURER;
		default: return Define.TYPE_OF_STAFF;
		}
	}
}