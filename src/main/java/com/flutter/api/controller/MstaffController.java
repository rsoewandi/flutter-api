package com.flutter.api.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flutter.api.request.AddMstaffRequest;
import com.flutter.api.service.MstaffService;

@RestController
@RequestMapping(value="/api/mstaff")
public class MstaffController {
	
	@Autowired
	private MstaffService mstaffService;
	
	@PostMapping("/add")
	public ResponseEntity<HashMap<String, Object>> add(@RequestBody AddMstaffRequest request){
		return new ResponseEntity<>(mstaffService.add(request), HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<HashMap<String, Object>> getAll(){
		return new ResponseEntity<>(mstaffService.getAll(), HttpStatus.OK);
	}
	
	
}
