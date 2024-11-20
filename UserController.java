package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.CountryModel;
import com.example.demo.service.CountryServices;

@RestController
@RequestMapping("/all")
public class CountryController {
	
	@Autowired
	CountryServices countryServices;
	
	
	@GetMapping("/getCountries")
	public List<CountryModel> getCountry() {
		return countryServices.getAllCountries() ;
		
	}
	
	@GetMapping("/getbyid/{id}")
	public ResponseEntity getCountryById(@PathVariable int id) {
		CountryModel country= countryServices.getCountrybyId(id) ;
		if(country!=null) {
			return new ResponseEntity<CountryModel>(country, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/getbyName/{countryName}")
	public ResponseEntity getCountryByName(@PathVariable String countryName) {
		CountryModel country= countryServices.getCountryByName(countryName) ;
		if(country!=null) {
			return new ResponseEntity<CountryModel>(country, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	@PostMapping("/addCountry")
	public CountryModel addCountry(@RequestBody CountryModel countryModel) {
		return countryServices.addCountry(countryModel);
	}
	
	@PutMapping("/updateCountry/{id}")
	public ResponseEntity<CountryModel> updateCountry(@PathVariable(value="id") int id,@RequestBody CountryModel countryModel) {
		try {
		CountryModel existingCountry = countryServices.getCountrybyId(id);
		existingCountry.setCountryName(countryModel.getCountryName());
		existingCountry.setCountryCapital(countryModel.getCountryCapital());
		CountryModel countryModelUpdate= countryServices.updateCountry(existingCountry);
		return new ResponseEntity<CountryModel>(countryModelUpdate,HttpStatus.OK);
	}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		
		
	}
	@DeleteMapping("/deleteCountry/{id}")
	public AddResponse deleteCountry(@PathVariable(value ="id") int id) {
		
		return countryServices.deleteCountry(id);
	}
	
	
}




/*
GET     -->   http://localhost:8081/all/getCountries  ---> get all countries 						  
GET     -->   http://localhost:8081/all/getbyid/1     ---> need to give country id					
GET     -->   http://localhost:8081/all/getbyName/india ---> by  giving country name we will get the country details  
POST    -->   http://localhost:8081/all/addCountry     ----> for adding a country					
PUT     -->   http://localhost:8081/all/updateCountry  ---> for updating the country					
DELETE  -->   http://localhost:8081/all/deleteCountry/1 ---> deleting the country using id
 */
