class Node {
	public int data;
	public Node next;
	public Node (int val) {
		data = val;
		next = null;
	}
}
public class LinkedList {
	private Node head;
	private Node current;
	public LinkedList () {
		head = current = null;
	}
	
public boolean empty () {
		return head == null;
	}
public LinkedList mergeP(LinkedList l2){
	

	if(l2.head.data!=-1&&this.head.data==-1)return l2;
    if(l2.head.data==-1 )return this;
	l2.findFirst();
	while(!l2.last()){
if(!Board.locs[l2.retrieve()].isEmpty()&&Board.locs[l2.retrieve()].getPiece().getColor()!=Board.getCurrentPlayer().getColor())
{
	this.insert(l2.retrieve());
	}
l2.findNext();

	}
	if(!Board.locs[l2.retrieve()].isEmpty()&&Board.locs[l2.retrieve()].getPiece().getColor()!=Board.getCurrentPlayer().getColor())
		this.insert(l2.retrieve());
       return this;
}
    public LinkedList merge(LinkedList l2){
    	if(head==null && l2.head==null)
    		return null;
    	if(head==null)
    		return l2;
    	if(l2==null)
    		return this;
    	Node p=head;
    	while(p.next!=null){
    		p=p.next;
    	}
    	p.next=l2.head;
       return this;   	
    }
    public void display(){
    	Node q = head;
    	while(q.next!=null){
    		System.out.print(q.data+" , ");
    		q=q.next;
    	}
		System.out.print(q.data);
		System.out.println();


    }
    
    public boolean last () {
    	if(current==null)return true;
		return current.next == null;
	}
	public boolean full () {
		return false;
	}
	public void findFirst () {
		current = head;
	}
	public void findNext () {
		current = current.next;
	}
	public int retrieve () {
		return current.data;
	}
	public void update (int val) {
		current.data = val;
	}
	public void insert (int val) {
		Node tmp;
		if (empty()) {
			current = head = new Node (val);
		}
		else {
			tmp = current.next;
			current.next = new Node (val);
			current = current.next;
			current.next = tmp;
		}
	}
	public void remove () {
		if (current == head) {
			head = head.next;
		}
		else {
			Node tmp = head;
			while (tmp.next != current)
				tmp = tmp.next;
			tmp.next = current.next;
		}
		if (current.next == null)
			current = head;
		else
			current = current.next;
	}
}
