package vn.edu.vnuk.view;

import java.util.ArrayList;
import java.util.Scanner;

import vn.edu.vnuk.controller.PersonFactory;
import vn.edu.vnuk.define.Define;
import vn.edu.vnuk.model.Lecturer;
import vn.edu.vnuk.model.Person;
import vn.edu.vnuk.model.Staff;

public class Menu {
	
	
	public static int inputSelection(int min, int max) {
		Scanner sc = new Scanner(System.in);
		int value = min - 1;
		boolean check = false;
		
		System.out.println("Input selection (" + min + " - " + max +")");
		
		while (check == false) {
			System.out.println("Input : ");
			value = Integer.parseInt(sc.nextLine());
			
			if (value < min || value > max)
				System.out.println("Wrong input!");
			else
				check = true;
		}
		return value;
	}
	
	public static void mainMenu() {
		int value;
		while (true) {
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
				
				case 4: {
					menuFour();
					break;
				}
			}
		}
	}
	
	public static void menuOne() {
		int value;
		while (true) {
			System.out.println("1.1 Add new staff to list's bottom. \n" +
							   "1.2 Add new staff to list's top. \n" +
							   "1.3 Add new staff after SPECIFIC postion. \n" +
							   "1.4 Add new staff to list's bottom from file staff.txt. \n" +
							   "1.5 Add new casual worker from file labor.txt. \n" +
							   "1.6 Return.	");
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
					case Define.TYPE_OF_STAFF: {
						Staff staff = (Staff)PersonFactory.getPerson(Define.TYPE_OF_STAFF);
						staff.input();
						Define.persons.add(staff);
						break;
					}
					}
					break;
				}
			
				case 2: {
					switch (selectTypeOfEmployee()) {
					case Define.TYPE_OF_LECTURER: {
						 Lecturer lecturer = (Lecturer)PersonFactory.getPerson(Define.TYPE_OF_LECTURER);
						 lecturer.input();
						 Define.persons.add(0, lecturer);
						 break;
					}
					case Define.TYPE_OF_STAFF: {
						Staff staff = (Staff)PersonFactory.getPerson(Define.TYPE_OF_STAFF);
						staff.input();
						Define.persons.add(0, staff);
						break;
					}
					}
					break;
				}
			
				case 3: {
					Scanner sc = new Scanner(System.in);
					System.out.println("Enter k position: ");
					int k = sc.nextInt();
					
					switch (selectTypeOfEmployee()) {
					case Define.TYPE_OF_LECTURER: {
						 Lecturer lecturer = (Lecturer)PersonFactory.getPerson(Define.TYPE_OF_LECTURER);
						 lecturer.input();
						 Define.persons.add(k - 1, lecturer);
						 break;
					}
					case Define.TYPE_OF_STAFF: {
						Staff staff = (Staff)PersonFactory.getPerson(Define.TYPE_OF_STAFF);
						staff.input();
						Define.persons.add(k - 1, staff);
						break;
					}
					}
					break;
				}
				
				case 6: {
					return;
				}
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
		int value;
		while (true) {
			System.out.println("4.1 Show current list of staff. \n" +
							   "4.2 Show list order by salary ASC. \n" +
							   "4.3 Show list order by name alphabetical. \n" +
							   "4.4 Search staff by name. \n" +
							   "4.5 Search staff by year of birth. \n");
			value = inputSelection(1, 5);
			switch (value) {
				case 1: {
					showListPerson(Define.persons);
					break;
				}
				
				case 4: {
					
				}
				case 5: {
					Scanner sc = new Scanner(System.in);
					System.out.println("Enter year of birth: ");
					int yearOfBirth = sc.nextInt();
					
					ArrayList<Person> persons = new ArrayList<Person>();
					Person person;
					boolean isFound = false;
					
					for (int index = 0; index < Define.persons.size(); index++) {
						person = Define.persons.get(index);
						
						if (person.getType() == Define.TYPE_OF_LECTURER || person.getType() == Define.TYPE_OF_STAFF) {
							if (person.getYearOfBirth() == yearOfBirth) {
								persons.add(person);
								isFound = true;
							}
						}
					}
					
					if (isFound == false) {
						// in khong tim thay
					} else {
						showListPerson(persons);
					}
				}
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
		System.out.println("1. Lecturer  \n" +
						   "2. Staff.");
		value = inputSelection(1, 2);
		
		switch (value) {
		case 1: return Define.TYPE_OF_LECTURER;
		default: return Define.TYPE_OF_STAFF;
		}
	}
	
	public static void showListPerson(ArrayList<Person> persons) {
		System.out.format("%-4s %-20s %-8s %-8s %-4s %-6s %-6s %-6s %-6s %-6s %n", "STT", "Ten", "Nam Sinh", "Que Quan", "Loai", "C1", "C2", "C3", "C4", "C5");
		for (int index = 0; index < persons.size(); index++) {
			System.out.format("%-4d %-20s %-8d "
					, index
					, persons.get(index).getName()
					, persons.get(index).getYearOfBirth());
			
			switch (persons.get(index).getType()) {
			case Define.TYPE_OF_LECTURER: {
				System.out.format("%-8s %-4s %-6s %-6s %-6d %-6d %-6f %n"
						, ((Lecturer)persons.get(index)).getHometown()
						, "GV"
						, ((Lecturer)persons.get(index)).getDepartment()
						, ((Lecturer)persons.get(index)).getQualification()
						, ((Lecturer)persons.get(index)).getAllowance()
						, ((Lecturer)persons.get(index)).getPeriodsInMonth()
						, ((Lecturer)persons.get(index)).getSalaryRatio());
				
				break;
			}
			
			case Define.TYPE_OF_STAFF: {
				System.out.format("%8s %4s %6s %6s %6d %6d %6f %n"
						, ((Staff)persons.get(index)).getHometown()
						, "NV"
						, ((Staff)persons.get(index)).getDepartment()
						, ((Staff)persons.get(index)).getPosition()
						, ((Staff)persons.get(index)).getAllowance()
						, ((Staff)persons.get(index)).getWorkDay()
						, ((Staff)persons.get(index)).getSalaryRatio());
				
				break;
			}
			}
		}
	}
}



















