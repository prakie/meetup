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
package com.meetup.controller.base;

import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.ResponseEntity;
import org.modelmapper.ModelMapper;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import org.springframework.security.access.annotation.Secured;
import org.springframework.beans.factory.annotation.Autowired;
import com.meetup.db.meetup_db.service.ProductService;
import com.meetup.db.meetup_db.entity.Product;
import com.meetup.db.meetup_db.dtos.ProductDto;

//IMPORT RELATIONS


public class ProductBaseController {
    
    @Autowired
	ProductService productService;

	

	@Autowired
	private ModelMapper modelMapper;



//CRUD METHODS


    //CRUD - CREATE
    @Secured({ "ROLE_PRIVATE_USER" })
	@PostMapping("/product")
	public ResponseEntity<ProductDto> insert(@RequestBody Product obj) {
				
		
		return ResponseEntity.ok().body(convertToDto(productService.insert(obj)));
	}

	
    //CRUD - REMOVE
    @Secured({ "ROLE_PRIVATE_USER" })
	@DeleteMapping("/product/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		Product productSelected = productService.getOne(id);
		
		productService.delete(id);
		return ResponseEntity.ok().build();
	}
	
	
    //CRUD - GET ONE
    @Secured({ "ROLE_PRIVATE_USER" })
	@GetMapping("/product/{id}")
	public ResponseEntity<ProductDto> get(@PathVariable("id") Long id) {
		Product productSelected = productService.getOne(id);
		return ResponseEntity.ok().body(convertToDto(productSelected));
	}
	
	
    //CRUD - GET LIST
    @Secured({ "ROLE_PRIVATE_USER" })
	@GetMapping("/product")
	public ResponseEntity<List<ProductDto>> getList() {
		List<Product> list = productService.getAll();
		List<ProductDto> listDto = list.stream()
				.map(product -> convertToDto(product))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}


    //CRUD - EDIT
    @Secured({ "ROLE_PRIVATE_USER" })
	@PostMapping("/product/{id}")
	public ResponseEntity<ProductDto> update(@RequestBody Product obj, @PathVariable("id") Long id) {
	    
		
		return ResponseEntity.ok().body(convertToDto(productService.insert(obj)));
	}
	


/*
 * CUSTOM SERVICES
 * 
 *	These services will be overwritten and implemented in  Custom.js
 */


	private ProductDto convertToDto(Product product) {
		ProductDto productDto = modelMapper.map(product, ProductDto.class);
		return productDto;
	}
}
