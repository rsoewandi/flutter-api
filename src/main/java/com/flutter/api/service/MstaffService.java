package com.flutter.api.service;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flutter.api.exception.ValidationException;
import com.flutter.api.model.Mstaff;
import com.flutter.api.repository.MstaffRepository;
import com.flutter.api.request.AddMstaffRequest;
import com.flutter.api.security.CustomPasswordEncoder;
import com.flutter.api.utils.UtilsOther;

@Service
public class MstaffService {
	
	private final static Logger logger = LoggerFactory.getLogger(MstaffService.class);
	
	@Autowired
	MstaffRepository mstaffRepo;
	
	@Autowired
	private CustomPasswordEncoder passwordEncoder;
	
	public HashMap<String, Object> add(AddMstaffRequest request){
		HashMap<String, Object> response = new HashMap<String, Object>();
		try {
			String encodePass = passwordEncoder.encode(request.getPassword());
			request.setPassword(encodePass);
			mstaffRepo.save(new Mstaff(request));
		} catch (Exception e) {
			String errMsg = "Error save mstaff";
			logger.error("MstaffService - add = " + errMsg);
			logger.error(e.getMessage());
			throw new ValidationException(errMsg);
		}
		UtilsOther.successMap(response);
		return response;
	}
	
	public HashMap<String, Object> getAll(){
		HashMap<String, Object> response = new HashMap<String, Object>();
		List<Mstaff> listStaff = mstaffRepo.findAll();

		response.put("data", listStaff);
		UtilsOther.successMap(response);
		return response;
	}
}
