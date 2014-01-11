package quickmedtest;

import java.util.LinkedList;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class CompleteDrugNameTest {
	
	@Test
	public void testAca() throws Exception {
	LinkedList<String> result = new CompleteDrugName().complete("C:/Users/Owner/workspace/quickmedtest/src/quickmedtest/drug list.txt", "aca");
	LinkedList<String> list = new LinkedList<String>();
	list.add ("Acamoli Forte Syrup Kids");
	list.add ("Acamoli Suppositories");
	list.add ("Acamoli Syrup for Big Kids");
	list.add ("Acarbose");
	list.add ("nurofen");
	assertEquals(list,result);
	}
	
	@Test
	public void testCrot() throws Exception {
	LinkedList<String> result = new CompleteDrugName().complete("C:/Users/Owner/workspace/quickmedtest/src/quickmedtest/drug list.txt", "CROT");
	LinkedList<String> list = new LinkedList<String>();
	list.add ("Crotamiton");
	assertEquals(list,result);
	}
	
	@Test
	public void testZyv() throws Exception {
	LinkedList<String> result = new CompleteDrugName().complete("C:/Users/Owner/workspace/quickmedtest/src/quickmedtest/drug list.txt", "zYv");
	LinkedList<String> list = new LinkedList<String>();
	list.add ("Zyvoxid");
	assertEquals(list,result);
	}
	
}
