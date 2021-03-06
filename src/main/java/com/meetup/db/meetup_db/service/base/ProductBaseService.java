/* 
* Generated by
* 
*      _____ _          __  __      _     _
*     / ____| |        / _|/ _|    | |   | |
*    | (___ | | ____ _| |_| |_ ___ | | __| | ___ _ __
*     \___ \| |/ / _` |  _|  _/ _ \| |/ _` |/ _ \ '__|
*     ____) |   < (_| | | | || (_) | | (_| |  __/ |
*    |_____/|_|\_\__,_|_| |_| \___/|_|\__,_|\___|_|
*
* The code generator that works in many programming languages
*
*			https://www.skaffolder.com
*
*
* You can generate the code from the command-line
*       https://npmjs.com/package/skaffolder-cli
*
*       npm install -g skaffodler-cli
*
*   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *
*
* To remove this comment please upgrade your plan here: 
*      https://app.skaffolder.com/#!/upgrade
*
* Or get up to 70% discount sharing your unique link:
*       https://app.skaffolder.com/#!/register?friend=5ebb8450bbf7210dd3bd61b3
*
* You will get 10% discount for each one of your friends
* 
*/
package com.meetup.db.meetup_db.service.base;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;


import com.meetup.db.meetup_db.entity.Product;

import com.meetup.db.meetup_db.repositories.ProductRepository;

@Service
@Transactional
public class ProductBaseService {

	
	@Autowired
	ProductRepository productRepository;


    // CRUD METHODS
    
    // CRUD - CREATE
    
	public Product insert(Product product) {
		return productRepository.save(product);
	}
	
	// CRUD - REMOVE
    
	public void delete(Long id) {
		productRepository.delete(id);
	}

	// CRUD - GET ONE
    	
	public Product getOne(Long id) {
		return productRepository.findOne(id);
	}

    	
    // CRUD - GET LIST
    	
	public List<Product> getAll() {
		List<Product> list = new ArrayList<>();
		productRepository.findAll().forEach(list::add);
		return list;
	}
	

}
