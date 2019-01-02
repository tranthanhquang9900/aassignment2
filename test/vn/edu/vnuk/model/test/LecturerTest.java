package vn.edu.vnuk.model.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import vn.edu.vnuk.define.Define;
import vn.edu.vnuk.model.Lecturer.LecturerBuilder;
import vn.edu.vnuk.model.Lecturer;

public class LecturerTest {
	
	private final double delta = 0.0001;
	
	Lecturer l;
	
	@Test
	public void test_set_getHomeTown() {
		l.setHometown("Da Nang");
		assertEquals(l.getHometown(),"Da Nang");
	}
	
	@Test
	public void test_set_getDepartment() {
		l.setDepartment("C");
		assertEquals(l.getDepartment(), "C");
	}

	@Test
	public void test_set_getPeriodInMonth() {
		l.setPeriodsInMonth(9);
		assertEquals(l.getPeriodsInMonth(), 9);
	}
	
	@Test
	public void test_set_YearOfBirth() {
		l.setYearOfBirth(1999);
		assertEquals(l.getYearOfBirth(), 1999);
	}
	
	@Test
	public void test_set_getMinimumWage() {
		l.setMinimumWage(Define.DEFAULT_MINIMUM_WAGE);
		assertEquals(l.getMinimumWage(),Define.DEFAULT_MINIMUM_WAGE,delta);
	}
	
	@Test
	public void test_set_getQualification() {
		l.setQualification (Define.QUALIFICATION_OF_MASTER);
		assertEquals(l.getQualification(), Define.QUALIFICATION_OF_MASTER);
	}
	
	@Test
	public void test_set_getAllowance() {
		l.setAllowance(Define.ALLOWANCE_OF_MASTER);
		assertEquals(l.getAllowance(), Define.ALLOWANCE_OF_MASTER);
	}
	
	@Test
	public void test_set_getYearWorked() {
		l.setYearOfWork(8);
		assertEquals(l.getYearOfWork(), 8);
	}
	
	@Test
	public void test_set_get_SalaryRatio() {
		l.setSalaryRatio(2);
		assertEquals(l.getSalaryRatio(), 2, delta);
	}
	
	@Before
	public void setUp() {
		LecturerBuilder builder = new LecturerBuilder(Define.latestId, Define.TYPE_OF_MASTER);
		
		builder
				.setYearOfBirth(1999)
				.setHometown("Da Nang")
				.setDepartment("C")
				.setSalaryRatio(2)
				.setAllowance(Define.ALLOWANCE_OF_MASTER)
				.setYearOfWork(8)
				.setQualification(Define.QUALIFICATION_OF_MASTER)
				.setMinimumWage(Define.DEFAULT_MINIMUM_WAGE)
				.build();
	}
	
	@Test
	public void test_toString() {
		l.toString();
		assertEquals(l.toString(), "Lecturer [homeTown=Da Nang, department=C , qualification=Master , allowance= 900, periodsInMonth=9 , salaryRatio=2 , yearWorked= 8]");
	}
}