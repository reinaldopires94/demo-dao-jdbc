package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== TEST 1: seller findById ===");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n=== TEST 2: seller findByDepartmentId ===");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for (Seller obj : list) {
			System.out.println(obj); 
		} 
		
		System.out.println("\n=== TEST 3: seller findAll ===");  
		list = sellerDao.findAll(); 
		for (Seller obj : list) {
			System.out.println(obj); 
		}
		
		System.out.println("\n=== TEST 4: INSERT ===");
		Seller seller2 = new Seller(null, "Romeo", "romeo@gmail.com", new Date(), 4000.8, department);
		sellerDao.insert(seller2);
		System.out.println("Inserted! New id = " + seller2.getId());
		
		System.out.println("\n=== TEST 5: seller UPDATE ===");
		seller = sellerDao.findById(1);
		seller.setName("Michael Jackson");
		sellerDao.update(seller);
		System.out.println("UPDATE sucess. " + seller);
		
		System.out.println("\n=== TEST 6: seller DELETE ===");
		System.out.println("Enter Id for delete user:");
		int id = sc.nextInt();
		sellerDao.deleteBy(id);
		System.out.println("DELETE sucess " + id);
		sc.close();
	}
}