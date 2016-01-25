public class Node<T>
{
	public T element;
	public Node<T> next;
	public Node()
	{
		element=null;
		next=null;
	}
	public Node(T e, Node<T> n)
	{
		element =e;
		next  = n;
	}
	public T getElement()
	{
		return element;
	}
	public Node<T> getNext()
	{
		return next;
	}
	public void  setElement(T newElem)
	{
		element=newElem;
	}
	public void setNext(Node<T> newNext)
	{
		next=newNext;
	}
}
