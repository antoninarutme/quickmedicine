package quickmedtest;

import java.util.LinkedList;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CompleteDrugNameTest {
	
	@Test
	public void testAca() throws Exception {
		LinkedList<String> result = new CompleteDrugName().complete("https://dl.dropboxusercontent.com/u/22885397/github/drug%20list.txt", "aca");
		LinkedList<String> list = new LinkedList<String>();
		list.add ("Acamoli Cold Syrup");
		list.add ("Acamoli Forte Syrup Kids");
		list.add ("Acamoli Suppositories");
		list.add ("Acamoli Syrup for Big Kids");
		list.add ("Acarbose");
		assertEquals(list,result);
	}
	
	@Test
	public void testCrot() throws Exception {
		LinkedList<String> result = new CompleteDrugName().complete("https://dl.dropboxusercontent.com/u/22885397/github/drug%20list.txt", "CROT");
		LinkedList<String> list = new LinkedList<String>();
		list.add ("Crotamiton");
		assertEquals(list,result);
	}
	
	@Test
	public void testZyv() throws Exception {
		LinkedList<String> result = new CompleteDrugName().complete("https://dl.dropboxusercontent.com/u/22885397/github/drug%20list.txt", "zYv");
		LinkedList<String> list = new LinkedList<String>();
		list.add ("Zyvoxid");
		assertEquals(list,result);
	}
	
	@Test
	public void shouldReturnEmptyList() throws Exception {
		LinkedList<String> result = new CompleteDrugName().complete("https://dl.dropboxusercontent.com/u/22885397/github/drug%20list.txt", "acm");
		LinkedList<String> list = new LinkedList<String>();
		assertEquals(list,result);
	}
	
	@Test
	public void testSpaces() throws Exception {
		LinkedList<String> result = new CompleteDrugName().complete("https://dl.dropboxusercontent.com/u/22885397/github/drug%20list.txt", "  ");
		LinkedList<String> list = new LinkedList<String>();
		assertEquals(list,result);
	}
}
