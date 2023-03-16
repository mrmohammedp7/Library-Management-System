import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

class BookModel {
    Integer id;
    String name;
    int bookID = 1;
    String[] primaryBooks = new String[]{
            "The Hitchhiker's Guide to the Galaxy",
            "1984",
            "To Kill a Mockingbird",
            "Pride and Prejudice",
            "The Lord of the Rings",
            "The Catcher in the Rye",
            "Brave New World",
            "The Great Gatsby",
            "One Hundred Years of Solitude",
            "The Color Purple",
            "Beloved",
            "The Chronicles of Narnia",
            "The Hunger Games",
            "Harry Potter and the Sorcerer's Stone",
            "The Da Vinci Code",
            "Jurassic Park",
            "Gone with the Wind",
            "The Fault in Our Stars",
            "The Girl with the Dragon Tattoo",
            "The Silence of the Lambs",
            "The 7 Habits of Highly Effective People",
            "How to Win Friends and Influence People",
            "Think and Grow Rich",
            "The Power of Positive Thinking",
            "Man's Search for Meaning",
            "The Art of Happiness",
            "The Alchemist",
            "The Four Agreements",
            "The Secret",
            "The Road Less Traveled",
            "The Power of Now",
            "As a Man Thinketh",
            "The Magic of Thinking Big",
            "Getting Things Done: The Art of Stress-Free Productivity",
            "The One Thing: The Surprisingly Simple Truth Behind Extraordinary Results",
            "Atomic Habits: An Easy & Proven Way to Build Good Habits & Break Bad Ones",
            "The Compound Effect",
            "Mindset: The New Psychology of Success",
            "Awaken the Giant Within",
            "Emotional Intelligence 2.0"};

    Map<Integer, String> books = new HashMap<Integer, String>();
    Map<Integer, String> issuedBooks = new HashMap<Integer, String>();

    BookModel() {

        for (int i = 0; i < primaryBooks.length; i++) {
            books.put(bookID, primaryBooks[i]);
            bookID++;
        }
    }

    void showBooks() {
        for (Integer key : books.keySet()) {
            System.out.println("ID : " + key + "       Name :" + books.get(key));
        }
    }

    void countBooks() {
        System.out.println("The number of books present in the library are " + books.size());
    }

    void addBook() {
        int newBookNum = bookID;
        System.out.println("Enter the book you want to add in the collection.");
        Scanner sc = new Scanner(System.in);
        String newBook = sc.nextLine();
        books.put(bookID, newBook);
    }


    int issueBook() {
        System.out.println();
        int issueBookNum;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the ID of the book that you want to issue:");
        issueBookNum = sc.nextInt();
        if (books.get(issueBookNum) == null) {
            System.out.println("The Book mentioned is not present in the library!");
            return 0;
        }
        issuedBooks.put(issueBookNum, books.get(issueBookNum));
        books.remove(issueBookNum);
        if (!books.containsKey(issueBookNum)) {
            System.out.println("Your Book '" + issuedBooks.get(issueBookNum) + "' has been issued");
        }
        return 0;
    }

    void showIssueBook() {
        if (issuedBooks.isEmpty()) {
            System.out.println("There are no issued books.");
        } else {
            System.out.println("Your issued books are as follows: ");
            for (Integer key : issuedBooks.keySet()) {
                System.out.println("ID : " + key + "       Name :" + issuedBooks.get(key));
            }
        }
    }

    void returnBook() {
        int returnBookNum;
        System.out.println("Enter the ID of the book you want to return");
        for (Integer key : issuedBooks.keySet()) {
            System.out.println(key + ") " + issuedBooks.get(key));
        }
        Scanner sc = new Scanner(System.in);
        returnBookNum = sc.nextInt();
        if (issuedBooks.get(returnBookNum) == null) {
            System.out.println("You haven't issued the Book with this ID to return.");
        } else {
            System.out.println("Your book '" + issuedBooks.get(returnBookNum) + "' has been returned");
            books.put(returnBookNum, issuedBooks.get(returnBookNum));
            issuedBooks.remove(returnBookNum);
        }

    }
}


public class LibraryManagementSystem {
    public static void main(String[] args) {

        BookModel stud = new BookModel();
        int ch;
        int cont;
        while (true) {
            System.out.println();
            System.out.println("Enter any number to perform the task.");
            System.out.println("1. Show all the books present in the library.");
            System.out.println("2. Show all the issued Books.");
            System.out.println("3. Show the number of books available in the library.");
            System.out.println("4. Add a book to the existing set of books in the library.");
            System.out.println("5. Issue a book.");
            System.out.println("6. Return a book.");
            System.out.println("7. Exit.");
            System.out.println();
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter your choice :");
            ch = sc.nextInt();
            switch (ch) {
                case 1:
                    stud.showBooks();
                    break;
                case 2:
                    stud.showIssueBook();
                    break;
                case 3:
                    stud.countBooks();
                    break;
                case 4:
                    stud.addBook();
                    break;
                case 5:
                    stud.issueBook();
                    break;
                case 6:
                    stud.returnBook();
                    break;
                case 7:
                    System.out.println("---------------------------Thankyou! Do Visit Again---------------------------");
                    System.exit(0);

                default:
                    System.out.println("Wrong choice! Enter your choice again.");
                    break;
            }

        }
    }
}

