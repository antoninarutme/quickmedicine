package quickmedtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;

public class CompleteDrugName {
	
	   public LinkedList<String> complete (String f, String s) {
			LinkedList<String> list = new LinkedList<String>();
			try {
				URL url = new URL(f);
				InputStream ins = url.openStream();
				InputStreamReader insr = new InputStreamReader (ins);
				BufferedReader br = new BufferedReader (insr);
				try
					{
					   String line = br.readLine();
					   while (line != null) {
					       if (line.toLowerCase().startsWith(s.toLowerCase()))
					            list.add(line);
					        line = br.readLine();
					   }
					   br.close();
					   insr.close();
					 }
				catch (IOException exception)
					{
					   System.out.println ("Reading error " + exception.getMessage());
					}
			}
			catch (MalformedURLException e) {}
			catch (IOException e) {}
			System.out.println (list);
			return list;
		}
}
