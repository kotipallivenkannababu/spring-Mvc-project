package coreJe;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@ToString
public class Book {
private int id;
private String name;
private double salary;
private string author;

} 

public class BookClient{
	public static void main(String[] args) {
		Book book= new Book(123,"Spring", 2343.87, "Rod johnson");
		System.out.println(book);
		
	}
}
