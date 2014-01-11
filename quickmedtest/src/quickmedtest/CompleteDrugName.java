package quickmedtest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class CompleteDrugName {
	
	public LinkedList<String> complete (String f, String s) {
		LinkedList<String> list = new LinkedList<String>();
		try
		{
			File file = new File(f);
		    FileReader fr = new FileReader (file);
		    BufferedReader br = new BufferedReader (fr);
		    try
		    {
		        String line = br.readLine();
		        while (line != null) {
		            if (line.toLowerCase().startsWith(s.toLowerCase()))
		            	list.add(line);
		            line = br.readLine();
		        }
		        br.close();
		        fr.close();
		    }
		    catch (IOException exception)
		    {
		        System.out.println ("Reading error " + exception.getMessage());
		    }
		}
		catch (FileNotFoundException exception)
		{
		    System.out.println ("File not found");
		}
		System.out.println (list);
		return list;
	}
}
