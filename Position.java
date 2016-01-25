public class Position 
{
	public PageEntry   Pg;
	public int index;
	 Position(PageEntry p, int wordIndex) //Constructor method
	 {
		 Pg=p;
		 index=wordIndex;
	 }
	 public PageEntry getPageEntry() //Return p
	 {
		 return Pg;
	 }
	 public int getWordIndex()//Return WordIndex
	 {
		 return index;
	 }
}
