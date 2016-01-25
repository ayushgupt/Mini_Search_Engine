public class PageIndex 
{
	public MyLinkedList<WordEntry> ll=new MyLinkedList<WordEntry>();
	public void addPositionForWord(String str, Position p)//If a word entry for str is already present in the page index, then add p to the word entry. Otherwise, create a new word-entry for str with just one position entry p
	{
		
		
		if(ll.IsEmpty())
		{
			WordEntry addw=new WordEntry(str);
			addw.addPosition(p);
			ll.Insert(addw);
		}
		else
		{
			ll.curr=ll.head;
			for( ;ll.curr.next!=null;ll.curr=ll.curr.next)
			{
				if(ll.curr.element.wor.equals(str))
				{
					ll.curr.element.addPosition(p);
					return;
				}
			}
			if(ll.curr.element.wor.equals(str))
			{
				ll.curr.element.addPosition(p);
				return;
			}
			WordEntry addw=new WordEntry(str);
			addw.addPosition(p);
			ll.Insert(addw);
		}

	}
	public MyLinkedList<WordEntry> getWordEntries()//: Return a list of all word entries stored in the page index.
	{
		return ll;
	}
}
