package application;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		SellerDao sellerdao = DaoFactory.createSellerDao();
		
		Seller seller = sellerdao.findById(3);
		System.out.println(" === TEST 1: Seller findById === ");
		System.out.println(seller);

		List<Seller> list = sellerdao.findByDepartment(new Department(2, null));
		System.out.println("\n === TEST 2: Seller findByDepartment === ");
		for (Seller obj : list)
		System.out.println(obj);

		list = sellerdao.findAll();
		System.out.println("\n === TEST 3: Seller findAll === ");
		for (Seller obj : list)
		System.out.println(obj);
		
		Seller newseller = new Seller(null, "Greg", "greg@gmail.com", LocalDate.now(), 4000.00, new Department(2, null));
		System.out.println("\n === TEST 4: Seller insert === ");
		sellerdao.insert(newseller);
		System.out.println("Inserted! New Seller ID: " + newseller.getId());
		
		System.out.println("\n === TEST 5: Seller update === ");
		seller = sellerdao.findById(1);
		seller.setName("Martha Wayne");
		sellerdao.update(seller);
		System.out.println("Seller Updated!");

		System.out.println("\n === TEST 6: Seller delete === ");
		System.out.println("Enter id for delete test: ");
		int d = sc.nextInt();
		sellerdao.deleteById(d);
		System.out.println("Seller deleted!");
		
		
		sc.close();

	}

}
