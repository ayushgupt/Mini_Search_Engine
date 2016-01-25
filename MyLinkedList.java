public class MyLinkedList<T> 
{
	public Node<T> head;
	public Node<T> tail;
	public Node<T> curr;
	public int N;
	public MyLinkedList()
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
	public Boolean IsMember(T o) //: Returns true if o is in the set, false otherwise.
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
	
	public void Insert(T o)// : Inserts o into the set.
	{
		if(IsEmpty())
		{
			Node<T> dummy=new Node<T>(o,null);
			head=dummy;
			tail=dummy;
			N=1;
		}
		else
		{
			Node<T> dummy=new Node<T>(o,null);
			tail.next=dummy;
			tail=dummy;
			N+=1;
		}
	}
	public MyLinkedList<T> Union (MyLinkedList<T> a)// : Returns a set which is the union of the current set with the set a.
	{
		MyLinkedList<T> Uni= new MyLinkedList<T>();
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
	
	public MyLinkedList<T> Intersection(MyLinkedList<T> a)//: Returns a set which is the intersection of the current set with the set a.
	{
		MyLinkedList<T> inter=new MyLinkedList<T>();
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
