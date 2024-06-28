package week1.day2;

public class LibraryManagement {

	public static void main(String[] args) {
		// Create an object for the Library class in the main method of LibraryManagement
		Library myLibrary2 = new Library();
		String book = myLibrary2.addBook("The Alchemist");
		System.out.println("Book Added : "+book);
		myLibrary2.issueBook();

	}

}
