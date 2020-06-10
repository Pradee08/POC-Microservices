package com.centrica.model;

import java.util.List;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class Customer {
	
	private Integer id;
	@NotEmpty
	private String ucrn;
	@NotEmpty
	private String title;
	@NotEmpty
	private String firstName;
	@NotEmpty
	private String lastname;
	private String dateOfBirth;
	@NotEmpty
	@Email
	private String email;
	@NotEmpty
	private List<String> energyAccounts;
	private List<PhoneNumber>telephoneNumbers;
	private CorrespondenceAddress correspondenceAddress;

}
