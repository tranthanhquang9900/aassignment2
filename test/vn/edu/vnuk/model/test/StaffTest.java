package vn.edu.vnuk.model.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import vn.edu.vnuk.define.Define;
import vn.edu.vnuk.model.Staff;
import vn.edu.vnuk.model.Staff.StaffBuilder;


public class StaffTest {
	private final double delta = 0.0001;
	
	Staff s;
	
	@Before
	public void test_builder() {
		s = new Staff.StaffBuilder(Define.latestId, Define.TYPE_OF_STAFF)
				.setName("Quang")
				.setYearOfBirth(1999)
				.setHometown("Da Nang")
				.setDepartment("IBM")
				.setWorkDay(25)
				.setSalaryRatio((float) 2.5)
				.setAllowance(Define.ALLOWANCE_OF_CHIEF)
				.setPosition(Define.POSITION_OF_CHIEF)
				.setYearOfWork(30)
				.setSalaryRatio(Define.DEFAULT_MINIMUM_WAGE)
				.build();
	}
	
	@Test
	public void testBuilderSetAllowanceWithDeputy() {
		s = new  Staff.StaffBuilder(Define.latestId, Define.TYPE_OF_STAFF)
			.setPosition(Define.POSITION_OF_DEPUTY)
			.setAllowance(Define.ALLOWANCE_OF_DEPUTY)
			.build();
	}
	
	@Test
	public void testBuilderSetAllowanceWithMaster() {
		s = new Staff.StaffBuilder(Define.latestId, Define.TYPE_OF_STAFF)
			.setPosition(Define.POSITION_OF_EMPLOYEE)
			.setAllowance(Define.ALLOWANCE_OF_EMPLOYEE)
			.build();
	}
	
	@Test
	public void test_toString() {
		assertEquals(s.toString(),"Staff [hometown=Da Nang, department=IBM, salaryRatio=730.0, allowance=1000, position=Chief, workDay=25, yearOfWork=30, minimumWage=0.0, id=0, yearOfBirth=1999, type=2, name=Quang]" );
	}
	
	@Test
	public void test_Staff() {
		Staff s = new Staff();
		assertNotNull(s);
	}
	
	@Test
	public void test_getID() {
		assertEquals(0 , s.getId());
	}
	
	@Test
	public void test_setName() {
		s.setName("Quan");
		assertEquals("Quan" , s.getName());
	}
	
	@Test
	public void test_setYearOfBirth() {
		s.setYearOfBirth(1999);
		assertEquals(1999 , s.getYearOfBirth());
	}
	
	@Test
	public void test_getType() {
		assertEquals(2 , s.getType());
	}
	
	@Test
	public void test_SetHomeTown() {
		s.setHometown("Da Nang");
		assertEquals("Da Nang" , s.getHometown());
	}
	
	@Test
	public void test_setDepartment() {
		s.setDepartment("IBM");
		assertEquals("IBM" , s.getDepartment());
	}
	
	@Test
	public void test_setWorkDay() {
		s.setWorkDay(50);
		assertEquals(50 , s.getWorkDay() , delta);
	}
	
	@Test
	public void test_setSalaryRatio() {
		s.setSalaryRatio((float) 2.5);
		assertEquals(2.5 , s.getSalaryRatio() , delta);
	}
	
	@Test
	public void test_setAllowanceOfChief() {
		s.setAllowance(Define.ALLOWANCE_OF_CHIEF);
		assertEquals(1000 , s.getAllowance() , delta);
	}
	
	@Test
	public void test_setAllowanceOfDeputy() {
		s.setAllowance(Define.ALLOWANCE_OF_DEPUTY);
		assertEquals(600 , s.getAllowance() , delta);
	}
	
	@Test
	public void test_setAllowanceOfEmployee() {
		s.setAllowance(Define.ALLOWANCE_OF_EMPLOYEE);
		assertEquals(400 , s.getAllowance() , delta);
	}
	
	@Test
	public void test_setPositionOfChief() {
		s.setPosition(Define.POSITION_OF_CHIEF);
		assertEquals("Chief" , s.getPosition());
	}
	
	@Test 
	public void test_setPositionOfDeputy() {
		s.setPosition(Define.POSITION_OF_DEPUTY);
		assertEquals("Deputy" , s.getPosition());
	}
	
	@Test
	public void test_setPositionOfEmployee() {
		s.setPosition(Define.POSITION_OF_EMPLOYEE);
		assertEquals("Employee" , s.getPosition());
	}
	
	@Test
	public void test_setYearsOfWork() {
		s.setYearOfWork(25);
		assertEquals(25 , s.getYearOfWork() , delta);
	}
	
	@Test
	public void test_setBasicSalary() {
		s.setSalaryRatio(25000);
		assertEquals(25000 , s.getSalaryRatio() , delta);
	}
	@Test
	public void test_update() {
		s.update(730);
		assertEquals(730 , s.getSalaryRatio() , delta);
	}
	
	@Test
	public void test_getSalary() {
		assertEquals(1750,s.getSalary() , delta);
	}
}