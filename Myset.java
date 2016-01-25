public class Myset<T> 
{
	MyLinkedList<T> ll ;
	Myset()
	{
		ll=new MyLinkedList<T>();
	}
	public Boolean IsEmpty() //returns true if the set is empty
	{
		if(ll.N==0)
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
			ll.curr=ll.head;
			for( ;ll.curr.next!=null;ll.curr=ll.curr.next)
			{
				if(ll.curr.element==o)
				{
					return true;
				}
			}
			if(ll.curr.element==o)
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
			ll.head=dummy;
			ll.tail=dummy;
			ll.N=1;
		}
		else
		{
			Node<T> dummy=new Node<T>(o,null);
			ll.tail.next=dummy;
			ll.tail=dummy;
			ll.N+=1;
		}
	}
	
	
	
		
	
	public Myset<T> Union (Myset<T> a)// : Returns a set which is the union of the current set with the set a.
	{
		Myset<T> Uni= new Myset<T>();
		if(ll.N==0)
		{
			Uni=a;
			return Uni;
		}
		ll.curr=ll.head;
		for( ;ll.curr.next!=null;ll.curr=ll.curr.next)
		{
			Uni.Insert(ll.curr.element);
		}
		Uni.Insert(ll.curr.element);
		
		a.ll.curr=a.ll.head;
		for( ;a.ll.curr.next!=null;a.ll.curr=a.ll.curr.next)
		{
			if(!IsMember(a.ll.curr.element))
			{
				Uni.Insert(a.ll.curr.element);
			}
			
		}
		if(!IsMember(a.ll.curr.element))
		{
			Uni.Insert(a.ll.curr.element);
		}
		return Uni;
	}
	
	public Myset<T> Intersection(Myset<T> a)//: Returns a set which is the intersection of the current set with the set a.
	{
		Myset<T> inter=new Myset<T>();
		a.ll.curr=a.ll.head;
		for( ;a.ll.curr.next!=null;a.ll.curr=a.ll.curr.next)
		{
			if(IsMember(a.ll.curr.element))
			{
				inter.Insert(a.ll.curr.element);
			}
			
		}
		if(IsMember(a.ll.curr.element))
		{
			inter.Insert(a.ll.curr.element);
		}
		return inter;
	}
		
	
}
