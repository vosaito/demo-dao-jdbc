package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		DepartmentDao departmentdao = DaoFactory.createDepartmentDao();

		Department dp = departmentdao.findById(3);
		System.out.println(" === TEST 1: Department findById === ");
		System.out.println(dp);

		List<Department> list = departmentdao.findAll();
		System.out.println("\n === TEST 3: Department findAll === ");
		for (Department obj : list)
		System.out.println(obj);

		Department newdp = new Department(null, "Music");
		System.out.println("\n === TEST 4: Department insert === ");
		departmentdao.insert(newdp);
		System.out.println("Inserted! New Department ID: " + newdp.getId());

		System.out.println("\n === TEST 5: Department update === ");
		dp = departmentdao.findById(1);
		dp.setName("Food");
		departmentdao.update(dp);
		System.out.println("Department Updated!");

		System.out.println("\n === TEST 6: Department delete === ");
		System.out.println("Enter id for delete test: ");
		int d = sc.nextInt();
		departmentdao.deleteById(d);
		System.out.println("Department deleted!");
		
		sc.close();
	}

}
