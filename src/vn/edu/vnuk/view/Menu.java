package vn.edu.vnuk.view;


import vn.edu.vnuk.controller.Controller;

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
			value = Controller.inputSelection(1, 9);
			switch (value) {
				case 1: {
					Controller.menuOne();
					break;
				}
				
				case 2: {
					Controller.menuTwo();
					break;
				}
				
				case 3: {
					Controller.menuThree();
					break;
					
				}
				
				case 4: {
					Controller.menuFour();
					break;
				}
				
				case 5: {
					Controller.menuFive();
					break;
				}
				
				case 6: {
					Controller.menuSix();
					break;
				}
				
				case 7: {
					Controller.menuSeven();
					break;
				}
				
				case 8: {
					Controller.menuEight();
					break;
				}
				
				case 9: {
					Controller.menuNine();
					break;
				}
			}
		}
	}
}



















