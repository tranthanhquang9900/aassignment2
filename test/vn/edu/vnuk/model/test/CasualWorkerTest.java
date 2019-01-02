package vn.edu.vnuk.model.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import vn.edu.vnuk.define.Define;
import vn.edu.vnuk.model.CasualWorker;
import vn.edu.vnuk.model.CasualWorker.CasualWorkerBuilder;


public class CasualWorkerTest {
	private final double delta = 0.0001;
	
	CasualWorker C;
	
	@Before
	public void test_builder() {
		C = new CasualWorker.CasualWorkerBuilder(Define.latestId, Define.TYPE_OF_CASUAL_WORKER)
				.setName("Quang")
				.setYearOfBirth(1999)
				.setWorkDay(25)
				.setEarningPerDay(2500)
				.build();
	}
	
	@Test
	public void test_toString() {
		assertEquals(C.toString(),"CasualWorker [workDay=25, earningPerDay=2500.0, id=0, yearOfBirth=1999, type=3], name=Quang]> but was:<CasualWorker [[hometown=Da Nang, department=IBM, salaryRatio=730.0, allowance=1000, position=Chief, workDay=25, yearOfWork=30, minimumWage=0.0, id=0, yearOfBirth=1999, type=2]" );
	}
	
	@Test
	public void test_CasualWorker() {
		CasualWorker s = new CasualWorker();
		assertNotNull(s);
	}
	
	@Test
	public void test_getID() {
		assertEquals(0 , C.getId());
	}
	
	@Test
	public void test_setName() {
		C.setName("Quang");
		assertEquals("Quang" , C.getName());
	}
	
	@Test
	public void test_setYearOfBirth() {
		C.setYearOfBirth(1999);
		assertEquals(1999 , C.getYearOfBirth());
	}
	
	@Test
	public void test_getType() {
		assertEquals(3 , C.getType());
	}
	
	@Test
	public void test_setWorkDay() {
		C.setWorkDay(25);
		assertEquals(25 , C.getWorkDay() , delta);
	}
	
	@Test
	public void test_setEarningPerDay() {
		C.setEarningPerDay(2500);
		assertEquals(2500 , C.getEarningPerDay() , delta);
	}
	
	@Test
	public void test_getSalary() {
		assertEquals(62500,C.getSalary() , delta);
	}
}