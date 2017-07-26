public class MyDoubleListTest {

	public static void main(String[] args) {
		MyDoubleList list = new MyDoubleList();
		list.addAtEnd("A");
		list.addAtEnd("B");
		list.addAtEnd("C");
		list.addAtEnd("D");
		list.addAtEnd("E");
		System.out.println("El primero es: " + list.getCurrent()); // 1er
		System.out.println("El segundo es: " + list.getNext()); // 2do
		list.getPrev(); // 1er
		System.out.println("El anterior al primero debería de ser 'null' y es: " + list.getPrev()); // null
		list.getNext(); // 2do
		System.out.println("El tercero es: " + list.getNext()); // 3er
		System.out.println("El cuarto es: " + list.getNext()); // 4to
		System.out.println("El quinto y último es: " + list.getNext()); // 5to
		System.out.println("El siguiente después del último debería de ser 'null' y es: " + list.getNext()); // null
		System.out.println("\nEsvin sos un crack... xD");
	}
	
}

class MyDoubleList {

	private MyNode first;
	private MyNode last;
	private MyNode current;
	int size;

	public MyDoubleList() {
		first = null;
		last = null;
		size = 0;
	}

	public void addAtEnd(String value) {
		MyNode theNew = new MyNode(value);
		size++;
		if (last == null) {
			first = last = current = theNew;
			return;
		}
		last.next = theNew;
		theNew.prev = last;
		last = theNew;
	}

	public void addAtBegin(String value) {
		MyNode theNew = new MyNode(value);
		size++;
		if (first == null) {
			first = last = current = theNew;
			return;
		}
		theNew.next = first;
		first.prev = theNew;
		first = theNew;
	}

	public String getNext() {
		if(current == null)
			return null;
		if(current.next == null)
			return null;
		current = current.next;
		return current.value;
	}

	public String getPrev() {
		if(current == null)
			return null;
		if(current.prev == null)
			return null;
		current = current.prev;
		return current.value;
	}

	public String getCurrent() {
		if(current == null)
			return null;
		return current.value;
	}
	
}

class MyNode {
	MyNode next;
	MyNode prev;
	String value;
	MyNode(String value) {
		this.value = value;
		this.next = null;
		this.prev = null;
	}
}
