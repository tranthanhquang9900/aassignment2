package vn.edu.vnuk.define;

import java.util.ArrayList;

import vn.edu.vnuk.model.Person;

public class Define {
	public static final int TYPE_OF_LECTURER = 1;
	public static final int TYPE_OF_STAFF = 2;
	public static final int TYPE_OF_CASUAL_WORKER = 3;
	public static final float DEFAULT_MINIMUM_WAGE = 730;
	
	public static int latestId = 0;
	
	public static final int ALLOWANCE_OF_BACHELOR = 300;
	public static final int ALLOWANCE_OF_MASTER = 900;
	public static final int ALLOWANCE_OF_DOCTOR = 2000;
	public static final int ALLOWANCE_OF_CHIEF = 1000;
	public static final int ALLOWANCE_OF_DEPUTY = 600;
	public static final int ALLOWANCE_OF_EMPLOYEE = 400;
	
	public static final int TYPE_OF_BACHELOR = 1;
	public static final int TYPE_OF_MASTER = 2;
	public static final int TYPE_OF_DOCTOR = 3;
	public static final int TYPE_OF_CHIEF = 1;
	public static final int TYPE_OF_DEPUTY = 2;
	public static final int TYPE_OF_EMPLOYEE = 3;
	
	public static final String QUALIFICATION_OF_BACHELOR = "Bachelor";
	public static final String QUALIFICATION_OF_MASTER = "MASTER";
	public static final String QUALIFICATION_OF_DOCTOR = "DOCTOR";
	
	public static final String POSITION_OF_CHIEF = "Chief";
	public static final String POSITION_OF_DEPUTY = "Deputy";
	public static final String POSITION_OF_EMPLOYEE = "Employee";

	
	public static float newMinimumWage = DEFAULT_MINIMUM_WAGE;
	
	public static ArrayList <Person> persons = new ArrayList <>();
}
