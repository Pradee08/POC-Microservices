package com.centrica.model;

import java.util.List;



import lombok.Data;

@Data
public class Customer {
	private Integer id;
	private String ucrn;
	private String title;
	private String firstName;
	private String lastname;
	private String dateOfBirth;
	private String email;
	private List<String> energyAccounts;
	private List<PhoneNumber>telephoneNumbers;
	private CorrespondenceAddress correspondenceAddress;
}
