package com.ravi.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@Table(name = "MP_REST_TRAVELLER")
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class TravellerEntity {
	
	//data property
	
	@Id
	@SequenceGenerator(name = "gen1", sequenceName = "TID_SEQ1",initialValue = 1001,allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	private Integer tid;
	
	@NonNull
	@Column(length = 30)
	private String tname;
	
	@NonNull
	@Column(length = 30)
	private String taddrs;
	
	@NonNull
	@Column(length = 30)
	private String startPlace;
	
	@NonNull
	@Column(length = 30)
	private String destPlace;
	
	@NonNull 
	private Double budget;
	
	//Meta data properties
	
	@CreationTimestamp
	@Column(insertable = true,updatable = false)
	private LocalDateTime registeredOn;
	
	@UpdateTimestamp
	@Column(insertable = false,updatable = true)
	private LocalDateTime lastUpdatedOn;
	
	@Version
	private Integer updateCount;
	
	@Column(length = 30,insertable = true,updatable = false)
	private String createdBy;
	
	@Column(length = 30,insertable = false,updatable = true)
	private String updatedBy;
	
	@Column(length = 30)
	private String active_SW="ACTIVE";
	

}
