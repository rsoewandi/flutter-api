package com.flutter.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.flutter.api.request.AddMstaffRequest;

import lombok.Data;


@Data
@Entity
@Table
public class Mstaff {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long mstaffpk;
	
	@Column
	private String staffid;
	
	@Column
	private String password;
	
	@Column
	private String staffname;

//	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//	@OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "mdeptfk", referencedColumnName = "mdeptpk")
//	private Mdept mdept;
//	
//	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//	@OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "mshiftfk", referencedColumnName = "mshiftpk")
//	private Mshift mshift;
	
	public Mstaff(){
		
	}

	public Mstaff(Long mstaffpk, String staffid, String password, String staffname) {
		super();
		this.mstaffpk = mstaffpk;
		this.staffid = staffid;
		this.password = password;
		this.staffname = staffname;
	}
	
	public Mstaff(AddMstaffRequest req) {
		super();
		this.staffid = req.getStaffid();
		this.password = req.getPassword();
		this.staffname = req.getStaffname();
	}
	
}