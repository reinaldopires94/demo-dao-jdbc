package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

 
public class Main2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.creaDepartmentDao();
		
		System.out.println("\n======= TEST 1: INSERT =======");
		Department department = new  Department(null,"Music"); 
		departmentDao.insert(department); 
		System.out.println("Inserted! " + department.getId() + " - " + department.getName()); 
		
		System.out.println("\n======= TEST 2: findById =======");
		department = departmentDao.findById(1);
		System.out.println(department);
		
		System.out.println("\n======= TEST 3: UPDATE =======");
		department.setName("Food2"); 
		departmentDao.update(department);
		System.out.println("UPDATE sucess. " + department);  
		
		System.out.println("\n======= TEST 4: findAll =======");
		List<Department> list = new ArrayList<Department>();
		list = departmentDao.findAll();
		for(Department l : list) {
			System.out.println(l);
		}

		System.out.println("\n======= TEST 5: DELETE =======");
		System.out.println("Enter with a number:");
		int id = sc.nextInt();
		departmentDao.deleteBy(id);
		System.out.println("DELETE sucess " + id);
		sc.close();
	}
}