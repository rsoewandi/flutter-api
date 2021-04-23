package com.flutter.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.flutter.api.model.Mstaff;
import com.flutter.api.repository.MstaffRepository;
import com.flutter.api.security.CustomPasswordEncoder;

@Component
public class DatabaseInitializer implements CommandLineRunner {
	
	@Autowired
	MstaffRepository mstaffRepo;

	@Autowired
	CustomPasswordEncoder passwordEncode;

	@Override
	public void run(String... args) throws Exception {
		if(mstaffRepo.count() == 0) {
			mstaffRepo.save(new Mstaff(null,"staff1",passwordEncode.encode("password"),"Aldi Sumanto"));
			mstaffRepo.save(new Mstaff(null,"staff2",passwordEncode.encode("password"),"Berry Siso"));
			mstaffRepo.save(new Mstaff(null,"staff3",passwordEncode.encode("password"),"Cintya Agusto"));
		}
		
	}

}
