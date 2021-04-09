package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AttendanceTest.class, ChurchMemberTest.class, TitheTest.class, UserTest.class })
public class AllTests {

}
