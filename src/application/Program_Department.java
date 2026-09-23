package application;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program_Department {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("\n=== TEST 1: department findById ===");
		
		Department findById = departmentDao.findById(3);
		System.out.println(findById);
		
		System.out.println("\n=== TEST 2: department findAll ===");
		
		List<Department> findAll = departmentDao.findAll();
		
		for (Department department : findAll) {
			System.out.println(department);
		}
		
		System.out.println("\n=== TEST 3: department Insert ===");
		
		Department department = new Department.Builder()
				.setId(null)
				.setName("Tools")
				.build();
		
		departmentDao.insert(department);
		
		System.out.println("New id = " + department.getId());
		
		System.out.println("\n=== TEST 4: department Update ===");
		
		department = departmentDao.findById(5);
		department.setName("T-shirts");
		
		departmentDao.update(department);
		
		System.out.println("Name modified with sucess! -> " + department.getName());
		
		System.out.println("\n=== TEST 5: department Delete ===");
		
		System.out.print("Enter id for delete test: ");
		int id = scanner.nextInt();
		
		departmentDao.deleteById(id);
		
		scanner.close();
	}
}
