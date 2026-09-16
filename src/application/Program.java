package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

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
	}

}
