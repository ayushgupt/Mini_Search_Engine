public class InvertedPageIndex 
{
	MyHashTable hash_table=new MyHashTable();
	public void addPage(PageEntry p)	//Add a new page entry p to the inverted page index
	{
		PageIndex pg_ind=p.getPageIndex();
		MyLinkedList<WordEntry> llofwe=pg_ind.getWordEntries();
		llofwe.curr=llofwe.head;
		for(;llofwe.curr.next!=null;llofwe.curr=llofwe.curr.next)
		{

			hash_table.addPositionsForWord(llofwe.curr.element);
			
		}

			hash_table.addPositionsForWord(llofwe.tail.element);
	}
	 public Myset<PageEntry> getPagesWhichContainWord(String str)//: Return a set of page-entries of webpages which contain the word str.
	 {
		 
		 
		 Myset<PageEntry> dum=new Myset<PageEntry>();
		 
		 
		 int num=hash_table.getHashIndex(str);
		 we_MyLinkedList list=hash_table.table[num];
		 
		 if(list==null)
		 {
			 return null;
		 }
		 else if(list.IsEmpty())
		 {
			 return null;
		 }
		 else
		 {
			 
			 
			 list.curr=list.head;
				for( ;list.curr.next!=null;list.curr=list.curr.next)
				{
					if(list.curr.element.wor.equals(str))
					{
						MyLinkedList<Position> result=list.curr.element.getAllPositionsForThisWord();
						result.curr=result.head;
						for(;result.curr.next!=null;result.curr=result.curr.next)
						{
							if(!dum.IsMember(result.curr.element.Pg))
							{
								dum.Insert(result.curr.element.Pg);
								
							}
						}
						if(!dum.IsMember(result.curr.element.Pg))
						{
							dum.Insert(result.curr.element.Pg);
							
						}
						 return dum ;
					}
				}
				
				if(list.curr.element.wor.equals(str))
				{

					MyLinkedList<Position> result=list.curr.element.getAllPositionsForThisWord();
					result.curr=result.head;
					for(;result.curr.next!=null;result.curr=result.curr.next)
					{
						if(!dum.IsMember(result.curr.element.Pg))
						{
							dum.Insert(result.curr.element.Pg);
						}
					}
					if(!dum.IsMember(result.curr.element.Pg))
					{
						dum.Insert(result.curr.element.Pg);
					}
					 return dum ;
				}
				
			return null;
		 }
		
	 }
	 
	 
	 
	 public MyLinkedList<Position> getPositions(String str)//: Return a set of page-entries of webpages which contain the word str.
	 {  
		 int num=hash_table.getHashIndex(str);
		 we_MyLinkedList list=hash_table.table[num];
		 
		 if(list==null)
		 {
			 return null;
		 }
		 else if(list.IsEmpty())
		 {
			 return null;
		 }
		 else
		 {
			 list.curr=list.head;
				for( ;list.curr.next!=null;list.curr=list.curr.next)
				{
					if(list.curr.element.wor.equals(str))
					{
						return list.curr.element.position_ll;
					}
				}
				if(list.curr.element.wor.equals(str))
				{
					return list.curr.element.position_ll;
				}	
			return null;
		 }
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 public void getPositions(String str,String b)//: Return position of a word in a linked-list.
	 {
		 //System.out.print("IT ENTERED HERE");
		 MyLinkedList<Position> duma=new MyLinkedList<Position>();
		 int num=hash_table.getHashIndex(str);
		 //System.out.print(num);
		 we_MyLinkedList list=hash_table.table[num];
		 if(list==null||list.IsEmpty())
		 {
			 System.out.println(b+"does not have the word "+str);
			 return;
		 }
		 else
		 {
			 list.curr=list.head;
				for( ;list.curr.next!=null;list.curr=list.curr.next)
				{
					//System.out.print("IT ENTERED HERE");
					if(list.curr.element.wor.equals(str))
					{
						duma=list.curr.element.position_ll;
						
						duma.curr=duma.head;
						for( ;duma.curr.next!=null;duma.curr=duma.curr.next)
						{
							if(duma.curr.element.Pg.Pg_name.equals(b))
							{
								 System.out.print(duma.curr.element.index +",");
							}
						}
						if(duma.curr.element.Pg.Pg_name.equals(b))
						{
							 System.out.print(duma.curr.element.index +",");
						}
						System.out.println("");
						
						
						return;
					}
				}
				if(list.curr.element.wor.equals(str))
				{

					duma=list.curr.element.position_ll;
					
					duma.curr=duma.head;
					for( ;duma.curr.next!=null;duma.curr=duma.curr.next)
					{
						if(duma.curr.element.Pg.Pg_name.equals(b))
						{
							 System.out.print(duma.curr.element.index +",");
						}
					}
					if(duma.curr.element.Pg.Pg_name.equals(b))
					{
						 System.out.print(duma.curr.element.index +",");
					}
					System.out.println("");
					
					
					return;
				}
				
				 System.out.println(b+" does not have the word "+str);
				 return;
		 }
	 }
	 
	 
}
