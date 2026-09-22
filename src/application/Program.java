package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
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
				.setBirthDate(new Date())
				.setBaseSalary(2000.0)
				.setDepartment(department)
				.build();
		sellerDao.insert(seller);
		System.out.println("Inserted! New id = " + seller.getId());
	}
}
