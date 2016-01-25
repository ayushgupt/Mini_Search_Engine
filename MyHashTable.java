public class MyHashTable 
{
	public we_MyLinkedList[] table;
	
	MyHashTable() 
	{
        table = new we_MyLinkedList[2000];
        
	}
	public int getHashIndex(String str) //: Create a hash function which maps a string to the index of its word-entry in the hashtable. The implementation of hashtable should support chaining.
	{
		int index=0;
		for(int i=1;i<=str.length();i++)
		{
			index+=(((int)str.charAt(i-1))-96)*Math.pow(10, i-1);
		}
		index=Math.abs(index);
		index=index%2000;
		
		return index;
	}
	void addPositionsForWord(WordEntry w) //: This adds an entry to the hashtable: stringName(w)  positionList(w). If no wordentry exists, then create a new word entry. However, if a wordentry exists, then merge w with the existing word-entry.
	{
		

		int hash_ind=getHashIndex(w.wor);
		
		
		
		
		
		WordEntry we=new WordEntry(w.wor);
		we.addPositions(w.getAllPositionsForThisWord());
		

		if(table[hash_ind]==null)
		{

			table[hash_ind] = new we_MyLinkedList();
			table[hash_ind].Insert(we);
			

			
			
			
			
			
			
			
			return;
		}
		else
		{

			
			table[hash_ind].curr=table[hash_ind].head;
			for(    ;table[hash_ind].curr.next!=null;table[hash_ind].curr=table[hash_ind].curr.next)
			{

				
				if(table[hash_ind].curr.element.wor.equals(we.wor))
				{

					
			table[hash_ind].curr.element.position_ll=table[hash_ind].curr.element.position_ll.Union(we.position_ll);
					

			
					
			
			
			
			
			
					return;
				}
				
			}
			if(table[hash_ind].curr.element.wor.equals(we.wor))
			{

				
	table[hash_ind].curr.element.position_ll=table[hash_ind].curr.element.position_ll.Union(we.position_ll);
				
				
	

	
	
	
				return;
			}

			
			table[hash_ind].Insert(we);

			
			
			
			return;
		}
	}
	
	
	
}
