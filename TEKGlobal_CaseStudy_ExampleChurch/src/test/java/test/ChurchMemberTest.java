package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


import com.tekglobal.casestudyexample.models.ChurchMember;
import com.tekglobal.casestudyexample.models.User;
import com.tekglobal.casestudyexample.services.ChurchMemberService;

public class ChurchMemberTest {
	static ChurchMemberService memberS;
	
	Long sId;
	String uEmail;
	User uExpected;
	
	@Before
	public static void setUp () {
		memberS = new ChurchMemberService();
		System.out.println("BeforeClass");
	}
	
	@Before
	public void beforeTest() {
		System.out.println("BeforeTest");
	}
	
	@Test
	public void testGetUserById() {
		ChurchMember actual = memberS.get(this.sId);
		assertEquals(this.uExpected.getEmail(), actual);
	}
	
}


