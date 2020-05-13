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
import com.meetup.db.meetup_db.service.CategoryService;
import com.meetup.db.meetup_db.entity.Category;
import com.meetup.db.meetup_db.dtos.CategoryDto;

//IMPORT RELATIONS


public class CategoryBaseController {
    
    @Autowired
	CategoryService categoryService;

	

	@Autowired
	private ModelMapper modelMapper;



//CRUD METHODS


    //CRUD - CREATE
    @Secured({ "ROLE_PRIVATE_USER" })
	@PostMapping("/catgory")
	public ResponseEntity<CategoryDto> insert(@RequestBody Category obj) {
				
		
		return ResponseEntity.ok().body(convertToDto(categoryService.insert(obj)));
	}

	
    //CRUD - REMOVE
    @Secured({ "ROLE_PRIVATE_USER" })
	@DeleteMapping("/catgory/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		Category categorySelected = categoryService.getOne(id);
		
		categoryService.delete(id);
		return ResponseEntity.ok().build();
	}
	
	
    //CRUD - GET ONE
    @Secured({ "ROLE_PRIVATE_USER" })
	@GetMapping("/catgory/{id}")
	public ResponseEntity<CategoryDto> get(@PathVariable("id") Long id) {
		Category categorySelected = categoryService.getOne(id);
		return ResponseEntity.ok().body(convertToDto(categorySelected));
	}
	
	
    //CRUD - GET LIST
    @Secured({ "ROLE_PRIVATE_USER" })
	@GetMapping("/catgory")
	public ResponseEntity<List<CategoryDto>> getList() {
		List<Category> list = categoryService.getAll();
		List<CategoryDto> listDto = list.stream()
				.map(category -> convertToDto(category))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}


    //CRUD - EDIT
    @Secured({ "ROLE_PRIVATE_USER" })
	@PostMapping("/catgory/{id}")
	public ResponseEntity<CategoryDto> update(@RequestBody Category obj, @PathVariable("id") Long id) {
	    
		
		return ResponseEntity.ok().body(convertToDto(categoryService.insert(obj)));
	}
	


/*
 * CUSTOM SERVICES
 * 
 *	These services will be overwritten and implemented in  Custom.js
 */


	private CategoryDto convertToDto(Category category) {
		CategoryDto categoryDto = modelMapper.map(category, CategoryDto.class);
		return categoryDto;
	}
}