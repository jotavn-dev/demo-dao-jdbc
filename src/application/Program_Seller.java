package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program_Seller {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		DateTimeFormatter fm1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== TEST 1: seller findById ===");
		
		Seller findById = sellerDao.findById(3);
		
		System.out.println(findById);
		
		System.out.println("\n=== TEST 2: seller findByDepartment ===");
		
		Department department = new Department.Builder()
				.setId(2)
				.setName(null)
				.build();
		
		List<Seller> list = sellerDao.findByDepartment(department);
		
		for (Seller findByDepartment : list) {
			System.out.println(findByDepartment);
		}
		
		System.out.println("\n=== TEST 3: seller findAll ===");
		
		list = sellerDao.findAll();
		
		for (Seller findAll : list) {
			System.out.println(findAll);
		}
		
		System.out.println("\n=== TEST 4: seller Insert ===");
		
		Seller seller = new Seller.Builder()
				.setId(null)
				.setName("Joao Vitor")
				.setEmail("joao@gmail.com")
				.setBirthDate(LocalDate.parse("19/03/1992", fm1))
				.setBaseSalary(2000.0)
				.setDepartment(department)
				.build();
		sellerDao.insert(seller);
		System.out.println("Inserted! New id = " + seller.getId());
		
		System.out.println("\n=== TEST 5: seller Update ===");
		
		seller = sellerDao.findById(2);
		seller.setName("Diego Silva");
		seller.setBaseSalary(7000.0);
		sellerDao.update(seller);
		System.out.println("Update completed");
		
		System.out.println("\n=== TEST 6: seller deleteById ===");
		System.out.print("Enter id for delete test: ");
		int id = scanner.nextInt();
		sellerDao.deleteById(id);
		
		scanner.close();
	}
}
