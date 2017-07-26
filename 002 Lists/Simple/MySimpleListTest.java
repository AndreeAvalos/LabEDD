public class MySimpleListTest {

	public static void main(String[] args) {
		MySimpleList list = new MySimpleList();
		int a = 0;
		while(a++ < 10000){
			list.addAtEnd("Elemento " + a);
		}
		System.out.println("En la lista hay: " + list.size + " elementos.");
	}
	
}

class MySimpleList {

	MyNode first;
	MyNode last;
	int size;

	public MySimpleList() {
		first = null;
		last = null;
		size = 0;
	}

	public void addAtEnd(String value) {
		MyNode theNew = new MyNode(value);
		size++;
		if (last == null) {
			first = last = theNew;
			return;
		}
		last.next = theNew;
		last = theNew;
	}

	public void addAtBegin(String value) {
		MyNode theNew = new MyNode(value);
		size++;
		if (first == null) {
			first = last = theNew;
			return;
		}
		theNew.next = first;
		first = theNew;
	}

	public void tour() {
		MyNode aux = first;
		while(aux != null) {
			System.out.println(":3 " + aux.value);
			aux = aux.next;
		}
	}
	
}

class MyNode {
	MyNode next;
	String value;
	MyNode(String value) {
		this.value = value;
		this.next = null;
	}
}
