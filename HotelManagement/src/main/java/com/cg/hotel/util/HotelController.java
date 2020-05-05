/**
 * 
 */
package com.cg.hotel.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.hotel.model.Hotel;
import com.cg.hotel.service.HotelService;

/**
 * @author HBMS
 * HotelController.java
 * May 2, 2020
 */

@RestController
public class HotelController {
	
	@Autowired
	private HotelService service;
	
	@GetMapping("/hotels")
	public List<Hotel> findAll(){
		System.out.println("Inside findALl() method of HotelController");
		return service.findAll();
	}
	
	@PostMapping("/hotel/add")
	public void createHotel(@RequestBody Hotel hotel) {
		service.createHotel(hotel);
	}
	
	@DeleteMapping("hotel/delete/{name}")
	public void deleteHotel(@PathVariable String name) {
		service.deleteHotel(name);
	}
	
	@PutMapping("hotel/update/{name}")
	public void updateHotel(@RequestBody Hotel hotel) {
		service.updateHotel(hotel);
	}
}