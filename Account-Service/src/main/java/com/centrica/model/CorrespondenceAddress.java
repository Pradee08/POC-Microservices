package com.centrica.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "address")
public class CorrespondenceAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "address_id")
	private Integer id;

	@Column(name = "flat_number")
	private String flatNumber;

	@Column(name = "house_number")
	private String houseNumber;

	@Column(name = "address_line1")
	private String addressLine1;

	@Column(name = "address_line2")
	private String addressLine2;

	@Column(name = "postal_town")
	private String postalTown;

	@Column(name = "county")
	private String county;

	@Column(name = "country")
	private String country;

	@Column(name = "postcode")
	private String postcode;

}
