public class SearchEngine
{
	public InvertedPageIndex inv_pg_index;
	public MyLinkedList<PageEntry> All_pages;
	public SearchEngine() 
	{
		inv_pg_index=new InvertedPageIndex();
		All_pages=new MyLinkedList<PageEntry>();
	}
	public void add_Pg(String str)
	{
		PageEntry nw_pg=new PageEntry(str);
		inv_pg_index.addPage(nw_pg);
		All_pages.Insert(nw_pg);
	}
	public void query_word(String str)
	{
		 MyLinkedList<Position> pos=inv_pg_index.getPositions(str);
		 if(pos==null)
		 {
			 System.out.println("This word does not exist in any file...!!!");
			 return;
		 }
		 else
		 {
			 String[] pages=new String[100];
			 double[] relv=new double[100];
			 int count=0;
			 pos.curr=pos.head;
			 for(;pos.curr.next!=null;pos.curr=pos.curr.next)//covering all the positions
			 {
				 int ayush=0;
				 for(int i=0;i<count;i++)//seeing if it is already in my pages result...!!!
				 {
					 if(pages[i].equals(pos.curr.element.Pg.Pg_name))
					 {
						 relv[i]+=Math.pow((pos.curr.element.index), -2);
						 ayush=1;
						 break;
					 }
				 }
				 if(ayush==0)
				 {
					 pages[count]=pos.curr.element.Pg.Pg_name;
					 relv[count]+=Math.pow((pos.curr.element.index), -2);
					 count+=1;
				 }
			 }
			 
			 int ayush=0;
			 for(int i=0;i<count;i++)//seeing if it is already in my pages result...!!!
			 {
				 if(pages[i].equals(pos.curr.element.Pg.Pg_name))
				 {
					 relv[i]+=Math.pow((pos.curr.element.index), -2);
					 ayush=1;
					 break;
				 }
			 }
			 if(ayush==0)
			 {
				 pages[count]=pos.curr.element.Pg.Pg_name;
				 relv[count]+=Math.pow((pos.curr.element.index), -2);
				 count+=1;
			 }
			 
			 String[] final_list = new String[count];
			 double mini=relv[0];
			 for(int i=0;i<count;i++)
			 {
				 if(relv[i]<mini)
				 {
					 mini=relv[i];
				 }
			 }
			 mini=mini-10;
			 for(int i=0;i<count;i++)
			 {
				 double max=relv[0];
				 int max_pos=0;
				 for(int j=0;j<count;j++)
				 {
					 if(relv[j]>max)
					 {
						 max=relv[j];
						 max_pos=j;
					 }
				 }
				 final_list[i]=pages[max_pos];
				 relv[max_pos]=mini;
			 }
			 for(int i=0;i<count;i++)
			 {
				 System.out.print(final_list[i]+",");
			 }
			 System.out.println(" ");
		 }
	}
	
	void query_word_position(String a,String b)
	{
		
		inv_pg_index.getPositions(a,b);
		
	}
	

	public void performAction(String actionMessage) 
	{
		String[] tokens = actionMessage.split(" ");
		String a1;
		a1=tokens[0];
		if(a1.equals("addPage"))
		{
			
			boolean add=true;
			if(All_pages.head==null)
			{
				add=true;
			}
			else
			{
				All_pages.curr=All_pages.head;
				for(;All_pages.curr.next!=null; All_pages.curr=All_pages.curr.next)
				{
					if(All_pages.curr.element.Pg_name.equals(tokens[1]))
					{
						add=false;
					}
				}
				if(All_pages.curr.element.Pg_name.equals(tokens[1]))
				{
					add=false;
				}
				
			}
			
			if(add)
			{
				System.out.println("Added Page:"+tokens[1]);
				add_Pg(tokens[1]);
			}
			else
			{
				System.out.print("Not Able Add file:"+tokens[1]);
				System.out.println("  : This Page Already Exists");
			}
			
			
		}
		else if(a1.equals("queryFindPagesWhichContainWord"))
		{
			System.out.print("queryFindPagesWhichContainWord:"+tokens[1]+":  ");
			query_word(tokens[1].toLowerCase());
			
		}
		
		else if(a1.equals("queryFindPositionsOfWordInAPage"))
		{
			System.out.print("queryFindPositionsOfWordInAPage:"+tokens[1]+" in "+tokens[2]+":  ");
			boolean notfound=true;
			if(All_pages.head==null)
			{
				notfound=true;
			}
			else
			{
				All_pages.curr=All_pages.head;
				for(;All_pages.curr.next!=null; All_pages.curr=All_pages.curr.next)
				{
					if(All_pages.curr.element.Pg_name.equals(tokens[2]))
					{
						notfound=false;
					}
				}
				if(All_pages.curr.element.Pg_name.equals(tokens[2]))
				{
					notfound=false;
				}
				
			}
			
			if(!notfound)
			{
				query_word_position(tokens[1].toLowerCase(),tokens[2]);
				
			}
			else
			{
				System.out.println("Such a File is not indexed in the Database");
			}
			
		}
	}
}
