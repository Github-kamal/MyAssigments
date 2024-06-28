package week1.day2;

public class Library {
	public String addBook(String bookTitle) {
		System.out.println("Book added successfully");
		return bookTitle;

	}

	public void issueBook() {
		System.out.println("Book issued successfully");
	}

	public static void main(String[] args) {
		// Create object for Library class
		Library myLibrary = new Library();
		//Ctrl+2, L - assign return value to local variable  & calling methods addBook 
		String book = myLibrary.addBook("Breath");
		System.out.println("Book name :"+book);
		//To call a method in Java
		myLibrary.issueBook();

	}

}
