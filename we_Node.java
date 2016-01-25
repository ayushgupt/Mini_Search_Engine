public class we_Node 
{
	public WordEntry element;
	public we_Node next;
	public we_Node()
	{
		element=null;
		next=null;
	}
	public we_Node(WordEntry e, we_Node n)
	{
		element =e;
		next  = n;
	}
	public WordEntry getElement()
	{
		return element;
	}
	public we_Node getNext()
	{
		return next;
	}
	public void  setElement(WordEntry newElem)
	{
		element=newElem;
	}
	public void setNext(we_Node newNext)
	{
		next=newNext;
	}
}
