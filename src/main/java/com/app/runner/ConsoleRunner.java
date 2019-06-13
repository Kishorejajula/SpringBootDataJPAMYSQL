package com.app.runner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.model.Product;
import com.app.repository.ProductRepository;
@Component
public class ConsoleRunner implements CommandLineRunner {
	@Autowired
	private ProductRepository repo;

	@Override
	public void run(String... args) throws Exception {
		repo.save(new Product(10,"A",3.3));
		repo.save(new Product(11,"B",4.4));
		repo.save(new Product(12,"C",5.5));
		repo.save(new Product(13,"D",6.6));
		
		//update column
		repo.save(new Product(13,"E",7.7));
		
		//Bulk insert
		List<Product> p=Arrays.asList(
				new Product(101,"R",8.8),
				new Product(102,"Q",1.1),
				new Product(103,"S",2.2),
				new Product(104,"P",9.9)
				);
		repo.saveAll(p);
		
		/*
		 * //Fetch one row
		 * 
		 * Optional<Product> prod=repo.findById(8); if (prod.isPresent()) {//avoid null
		 * pointer Exce Product prd=p.get();
		 * 
		 * }
		 */
		
		//featch all rows
		List<Product> list=repo.findAll();
		list.forEach(System.out::println);
		
		//delete operation
		repo.deleteById(101);

	}

}
