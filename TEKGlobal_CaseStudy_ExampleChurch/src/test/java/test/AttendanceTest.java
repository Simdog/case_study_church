package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.tekglobal.casestudyexample.models.User;
import com.tekglobal.casestudyexample.services.UserService;

public class AttendanceTest {
	static UserService userS;
	
	int sId;
	String uEmail;
	User uExpected;
	
	@Before
	public static void setUp () {
		userS = new UserService();
		System.out.println("BeforeClass");
	}
	
	@Before
	public void beforeTest() {
		System.out.println("BeforeTest");
	}
	
	@Test
	public void testGetUserByEmail() {
		User actual = userS.findByEmail(this.uEmail);
		assertEquals(this.uExpected.getEmail(), actual);
	}
	
}


