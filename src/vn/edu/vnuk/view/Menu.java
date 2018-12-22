package vn.edu.vnuk.view;

import java.util.ArrayList;
import java.util.Scanner;

import vn.edu.vnuk.controller.Observer;
import vn.edu.vnuk.controller.PersonFactory;
import vn.edu.vnuk.controller.Subject;
import vn.edu.vnuk.define.Define;
import vn.edu.vnuk.model.CasualWorker;
import vn.edu.vnuk.model.Lecturer;
import vn.edu.vnuk.model.Person;
import vn.edu.vnuk.model.Staff;

public class Menu {
	
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
				
				case 3: {
					menuThree();
					break;
					
				}
				
				case 4: {
					menuFour();
					break;
				}
				
				case 5: {
					menuFive();
					break;
				}
				
				case 6: {
					menuSix();
					break;
				}
				
				case 7: {
					menuSeven();
					break;
				}
				
				case 8: {
					menuEight();
					break;
				}
				
				case 9: {
					menuNine();
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
					
					case Define.TYPE_OF_CASUAL_WORKER: {
						CasualWorker casualWorker = (CasualWorker)PersonFactory.getPerson(Define.TYPE_OF_CASUAL_WORKER);
						casualWorker.input();
						Define.persons.add(casualWorker);
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
					
					case Define.TYPE_OF_CASUAL_WORKER: {
						CasualWorker casualWorker = (CasualWorker)PersonFactory.getPerson(Define.TYPE_OF_CASUAL_WORKER);
						casualWorker.input();
						Define.persons.add(0, casualWorker);
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
					
					case Define.TYPE_OF_CASUAL_WORKER: {
						CasualWorker casualWorker = (CasualWorker)PersonFactory.getPerson(Define.TYPE_OF_CASUAL_WORKER);
						casualWorker.input();
						Define.persons.add(k - 1, casualWorker);
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
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter employee's number: ");
		int value = Integer.parseInt(sc.nextLine());
		
		ArrayList<Person> persons = new ArrayList<Person>();
		persons = Define.persons;
		
		for(int i = 0; i< Define.persons.size(); i++) {
			if (i == value) {
				persons.get(i).input();
			} else {
				System.out.println("Cannot found user!");
			}
		}
		
		return;
	}
	
	public static void menuThree() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter employee's number: ");
		int value = Integer.parseInt(sc.nextLine());
		
		ArrayList<Person> persons = new ArrayList<Person>();
		persons = Define.persons;
		
		for(int i = 0; i< Define.persons.size(); i++) {
			if(i == value) {
				persons.remove(value);
			} else {
				System.out.println("Cannot found user!");
			}
		}
	}
	
	public static void menuFour() {
		int value;
		while (true) {
			System.out.println("4.1 Show current list of staff. \n" +
							   "4.2 Show list order by salary ASC. \n" +
							   "4.3 Show list order by name alphabetical. \n" +
							   "4.4 Search staff by name. \n" +
							   "4.5 Search staff by year of birth. \n" +
							   "4.6 Return.");
			value = inputSelection(1, 6);
			switch (value) {
				case 1: {
					showListPerson(Define.persons);
					break;
				}
				
				case 2: {
					ArrayList<Person> persons = new ArrayList<Person>();
					persons = Define.persons;
					
					for (int i = 0; i < Define.persons.size() - 1; i++) {
						for (int j = i + 1; j < Define.persons.size(); j++) {
							if (persons.get(i).getSalary() > persons.get(j).getSalary()) {
								Person temp = persons.get(j);
								persons.set(j, persons.get(i));
								persons.set(i, temp);
							}
						}
					}
					showListPerson(persons);
					break;
				}
				
				case 3: {
					
				}
				
				case 4: {
					Scanner sc = new Scanner(System.in);
					System.out.println("Enter a name: ");
					String nameSearch = sc.nextLine();
					sc.close();
					
					ArrayList<Person> persons = new ArrayList<Person>();
					Person person;
					boolean isFound = false;
					
					for (int index = 0; index < Define.persons.size(); index++) {
						person = Define.persons.get(index);
						
						if(person.getName().toLowerCase().contains(nameSearch.toLowerCase())) {
							persons.add(person);
							isFound = true;
						}
					}
					
					if (isFound == false) {
						System.out.println("Cannot found!");
					} else {
						showListPerson(persons);
					}
					break;
				}
				
				case 5: {
					Scanner sc = new Scanner(System.in);
					System.out.println("Enter year of birth: ");
					int yearSearch = Integer.parseInt(sc.nextLine());
					
					ArrayList<Person> persons = new ArrayList<Person>();
					Person person;
					boolean isFound = false;
					
					for (int index = 0; index < Define.persons.size(); index++) {
						person = Define.persons.get(index);
						
						if (person.getYearOfBirth() == yearSearch) {
								persons.add(person);
								isFound = true;
						}
					}
					
					if (isFound == false) {
						System.out.println("Cannot found!");
					} else {
						showListPerson(persons);
					}
					break;
				}
				
				case 6: {
					return;
				}
			}
		}
		
	}
	
	public static void menuFive() {
		while (Define.persons.isEmpty() == false) {
			Define.persons.clear();
		}
		System.out.println("Database cleared!");
	}
	
	public static void menuSix() {
		System.out.println("List of employee and salary:  \n\n");
		showListNameAndSalary(Define.persons);
		
	}
	
	public static void menuSeven() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter new minimum wage (" + Define.newMinimumWage + "): ");
		Define.newMinimumWage = Float.parseFloat(sc.nextLine());
	}
	
	public static void menuEight() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter list of employee's id (separated by ONE blankspace): ");
		String text = sc.nextLine();
		
		String indexs[] = text.split(" ");
		
		int indexTemp;
		Subject subject = new Subject();
		
		for (int index = 0; index < indexs.length; index++) {
			indexTemp = Integer.parseInt(indexs[index]);
			subject.attach((Observer)Define.persons.get(indexTemp));
		}
		
		subject.notifyChange(Define.newMinimumWage);
	}
	
	public static void menuNine() {
		System.out.println("Thank you!");
		System.exit(0);
	}
	
	public static int selectTypeOfEmployee() {
		int value;
		System.out.println("1. Lecturer.  \n" +
						   "2. Staff. \n"  +
						   "3. Casual worker.");
		value = inputSelection(1, 3);
		
		switch (value) {
		case 1: return Define.TYPE_OF_LECTURER;
		case 2: return Define.TYPE_OF_STAFF;
		default: return Define.TYPE_OF_CASUAL_WORKER;
		}
	}
	
	public static void showListPerson(ArrayList<Person> persons) {
		System.out.format("%-6s %-20s %-20s %-10s %-10s %-15s %-15s %-15s %-15s %-15s %n", "N#", "Name", "YearOfBirth", "Hometown", "Type", "C1", "C2", "C3", "C4", "C5");
		for (int index = 0; index < persons.size(); index++) {
			System.out.format("%-6d %-20s %-20d "
					, index
					, persons.get(index).getName()
					, persons.get(index).getYearOfBirth());
			
			switch (persons.get(index).getType()) {
			
			case Define.TYPE_OF_LECTURER: {
				System.out.format("%-10s %-10s %-15s %-15s %-15s %-15s %-15s %n"
						, ((Lecturer)persons.get(index)).getHometown()
						, "Lecturer"
						, ((Lecturer)persons.get(index)).getDepartment()
						, ((Lecturer)persons.get(index)).getQualification()
						, ((Lecturer)persons.get(index)).getAllowance()
						, ((Lecturer)persons.get(index)).getPeriodsInMonth()
						, ((Lecturer)persons.get(index)).getSalaryRatio());
				
				break;
			}
			
			case Define.TYPE_OF_STAFF: {
				System.out.format("%-10s %-10s %-15s %-15s %-15s %-15s %-15s %n"
						, ((Staff)persons.get(index)).getHometown()
						, "Staff"
						, ((Staff)persons.get(index)).getDepartment()
						, ((Staff)persons.get(index)).getPosition()
						, ((Staff)persons.get(index)).getAllowance()
						, ((Staff)persons.get(index)).getWorkDay()
						, ((Staff)persons.get(index)).getSalaryRatio());
				
				break;
			}
			
			case Define.TYPE_OF_CASUAL_WORKER: {
				System.out.format("%-10s %-10s %-15s %-15s %-15s %-15s %-15s %n"
						 , "null"
						 , "Casual Worker"
						 , "null"
						 , "null"
						 , "null"
						 , ((CasualWorker)persons.get(index)).getWorkDay()
						 , ((CasualWorker)persons.get(index)).getEarningPerDay());
			}
			}
		}
		
		System.out.println("\n \n \n" +
						   "C1-5 for Lecturer: Department, Qualification, Allowance, PeriodsInMonth, SalaryRatio.\n" + 
				   		   "C1-5 for Staff: Department, Position, Allowance, WorkDay, SalaryRatio.\n" +
						   "C1-5 for Casual Worker: null, null, null, WorkDay, EarningPerDay.");
	}
	
	public static void showListNameAndSalary(ArrayList<Person> persons) {
		System.out.format("%-6s %-20s %-10s %n", "N#", "Name", "Salary");
		for (int index = 0; index < persons.size(); index++) {
			System.out.format("%-6d %-20s %-10f %n"
						, index
						, persons.get(index).getName()
						, persons.get(index).getSalary());
		}
	}
	
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
	
}



















