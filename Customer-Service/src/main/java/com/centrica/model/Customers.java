package com.centrica.model;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;

@Entity
@Data
@Table(name = "customer")
public class Customers {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "ucrn")
	private String ucrn; 

	@Column(name = "title")
	private String title;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "lastname")
	private String lastname;

	@Column(name = "dateof_birth")
	private String dateOfBirth;

	@Column(name = "CREATED_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate = new Date();

	@Column(name = "email")
	private String email;

	@Column(name = "energy_accounts")
	private String energyAccounts;

	@Column(name = "telephone_numbers")
	private String number;

	@Column(name = "phonenumbers_type")
	private String type;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id", referencedColumnName = "address_id")
	private CorrespondenceAddress correspondenceAddress;

}
