package application;

import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;


public class Main2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.creaDepartmentDao();
		
		System.out.println("======= TEST 1: INSERT =======");
		Department department = new  Department(null,"Music"); 
		departmentDao.insert(department); 
		System.out.println("Inserted! " + department.getId()); 
		
		System.out.println("======= TEST 2: findById =======");
		department = departmentDao.findById(1);
		System.out.println(department);
		
		System.out.println("======= TEST 3: UPDATE =======");
		department.setName("Food2"); 
		departmentDao.update(department);
		System.out.println("UPDATE sucess. " + department);  
		
		System.out.println("======= TEST 4: DELETE =======");
		System.out.println("Enter with a number:");
		int id = sc.nextInt();
		departmentDao.deleteBy(id);
		System.out.println("DELETE sucess " + id);
		sc.close();
	}
}