import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PageEntry 
{
	public String Pg_name;
	public PageIndex Pg_index;
	
	public PageIndex getPageIndex()//: This method returns the page index of this web-page.
	{
		return Pg_index;
	}
	
	PageEntry(String pageName)//The argument is the name of the document. Read this file, and create the page index.
	{
		Pg_name=pageName;
		Pg_index=new PageIndex();
		BufferedReader br = null;
		try {
			String actionString;
//			br = new BufferedReader(new FileReader("prac"));
//			while ((actionString = br.readLine()) != null) 
			
				String content = new String(Files.readAllBytes(Paths.get(Pg_name)) );
				actionString=content.toLowerCase();
				actionString=actionString.replaceAll("[^a-z^1-9\\s^+]"," ");
				//System.out.println(actionString);
				String delim = "[\\s\\t]+"; //insert here all delimitators
				String[] tokens = actionString.split(delim);
				for(int i=0;i<tokens.length;i++)
				{
					if(tokens[i].trim().length()>0 && !tokens[i].equals("a") && !tokens[i].equals("an") && !tokens[i].equals("the") && !tokens[i].equals("they") && !tokens[i].equals("these") && !tokens[i].equals("this") && !tokens[i].equals("for") && !tokens[i].equals("is") && !tokens[i].equals("are") && !tokens[i].equals("was") && !tokens[i].equals("of") && !tokens[i].equals("or") && !tokens[i].equals("and") && !tokens[i].equals("does") && !tokens[i].equals("will") && !tokens[i].equals("whose"))
					{
						if (tokens[i].equals("stacks")) 
						{
							tokens[i]="stack";
						}
						if (tokens[i].equals("structures")) 
						{
							tokens[i]="structure";
						}
						if (tokens[i].equals("applications")) 
						{
							tokens[i]="application";
						}
						Position p=new Position(this,i+1);
						Pg_index.addPositionForWord(tokens[i],p);
					}
				}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}	
		
		
	
		
	}
	
}
