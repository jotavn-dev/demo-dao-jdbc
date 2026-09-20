package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		DateTimeFormatter df01 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Department obj = new Department.Builder()
								.setId(1)
								.setName("Books")
								.build();
		
		System.out.println(obj);
		
		Seller seller = new Seller.Builder()
				.setId(21)
				.setName("Bob")
				.setEmail("bob@gmail.com")
				.setBirthDate(LocalDate.parse("20/09/2026", df01))
				.setBaseSalary(3000.0)
				.build();
		
		System.out.println(seller);
	}
}
