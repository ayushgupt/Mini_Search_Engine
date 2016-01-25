public class WordEntry 
{
	public String wor;
	public MyLinkedList<Position> position_ll=new MyLinkedList<Position>();
	WordEntry(String word)//: Constructor method. The argument is the word for which we are creating the word entry.
	{
		wor=word;
	}
	public void addPosition(Position position)//: Add a position entry for str.
	{
		position_ll.Insert(position);
	}
	public void addPositions(MyLinkedList<Position> positions)//Add multiple position entries for str
	{
		position_ll=position_ll.Union(positions);
	}
	public MyLinkedList<Position> getAllPositionsForThisWord()//: Return a linked list of all position entries for str.
	{
		return position_ll;
	}
}
