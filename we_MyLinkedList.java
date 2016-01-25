public class we_MyLinkedList 
{
	public we_Node head;
	public we_Node tail;
	public we_Node curr;
	public int N;
	public we_MyLinkedList()
	{
		head=null;
		tail=null;
		curr=null;
		N=0;
	}
	public Boolean IsEmpty() //returns true if the set is empty
	{
		if(N==0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public Boolean IsMember(WordEntry o) //: Returns true if o is in the set, false otherwise.
	{
		
		if(IsEmpty())
		{
			return false;
		}
		else
		{
			curr=head;
			for( ;curr.next!=null;curr=curr.next)
			{
				if(curr.element==o)
				{
					return true;
				}
			}
			if(curr.element==o)
			{
				return true;
			}
			return false;
		}
		
	}
	
	public void Insert(WordEntry o)// : Inserts o into the set.
	{

		if(IsEmpty())
		{

			we_Node dummy=new we_Node(o,null);
			head=dummy;
			tail=dummy;
			N=1;
		}
		else
		{

			we_Node dummy=new we_Node(o,null);

			tail.next=dummy;
			tail=dummy;

			N+=1;

		}
	}
	public we_MyLinkedList Union (we_MyLinkedList a)// : Returns a set which is the union of the current set with the set a.
	{
		we_MyLinkedList Uni= new we_MyLinkedList();
		if(N==0)
		{
			Uni=a;
			return Uni;
		}
		curr=head;
		for( ;curr.next!=null;curr=curr.next)
		{
			Uni.Insert(curr.element);
		}
		Uni.Insert(curr.element);
		
		a.curr=a.head;
		for( ;a.curr.next!=null;a.curr=a.curr.next)
		{
			if(!IsMember(a.curr.element))
			{
				Uni.Insert(a.curr.element);
			}
			
		}
		if(!IsMember(a.curr.element))
		{
			Uni.Insert(a.curr.element);
		}
		return Uni;
	}
	
	public we_MyLinkedList Intersection(we_MyLinkedList a)//: Returns a set which is the intersection of the current set with the set a.
	{
		we_MyLinkedList inter=new we_MyLinkedList();
		a.curr=a.head;
		for( ;a.curr.next!=null;a.curr=a.curr.next)
		{
			if(IsMember(a.curr.element))
			{
				inter.Insert(a.curr.element);
			}
			
		}
		if(IsMember(a.curr.element))
		{
			inter.Insert(a.curr.element);
		}
		return inter;
	}
		
	
	
	
}
