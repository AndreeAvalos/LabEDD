public class MyGenericListTest {

	public static void main(String[] args) {
		MyList list = new MyList<Contacto>();
		Contacto sarina = new Contacto();
		sarina.firstName = "Sarina";
		sarina.lastName = "Bolaños";
		sarina.gender = 1;
		sarina.age = 27;
		Contacto esvin = new Contacto();
		esvin.firstName = "Esvin";
		esvin.lastName = "González";
		esvin.gender = 0;
		esvin.age = 26;
		Contacto kimberly = new Contacto();
		kimberly.firstName = "Kimberly";
		kimberly.lastName = "Monroy";
		kimberly.gender = 1;
		kimberly.age = 23;
		list.addAtBegin(esvin);
		list.addAtBegin(sarina);
		list.addAtBegin(kimberly);
		System.out.println("En la lista hay: " + list.size + " elementos.");
		list.tour();
	}
	
}

class Contacto {
	String firstName;
	String lastName;
	short gender;
	int age;

	@Override
	public String toString() {
		return firstName + " " + lastName;
	}

}

class MyList<E> {

	MyNode<E> first;
	MyNode<E> last;
	int size;

	public MyList() {
		first = null;
		last = null;
		size = 0;
	}

	public void addAtEnd(E value) {
		MyNode theNew = new MyNode(value);
		size++;
		if (last == null) {
			first = last = theNew;
			return;
		}
		last.next = theNew;
		last = theNew;
	}

	public void addAtBegin(E value) {
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
			System.out.println(":3 " + aux.value.toString());
			aux = aux.next;
		}
	}
	
}

class MyNode <E>{
	MyNode <E> next;
	E value;
	MyNode(E value) {
		this.value = value;
		this.next = null;
	}
}
