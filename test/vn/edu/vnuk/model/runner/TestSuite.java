package vn.edu.vnuk.model.runner;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import vn.edu.vnuk.model.test.CasualWorkerTest;
//import vn.edu.vnuk.model.test.LecturerTest;
//import vn.edu.vnuk.model.test.PersonTest;
import vn.edu.vnuk.model.test.StaffTest;


@RunWith(Suite.class)

@Suite.SuiteClasses({
   CasualWorkerTest.class,
   //LecturerTest.class,
   //PersonTest.class,
   StaffTest.class
})

public class TestSuite {  
} 
