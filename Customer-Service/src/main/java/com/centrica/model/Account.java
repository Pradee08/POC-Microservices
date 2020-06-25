package com.centrica.model;

import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class Account {
	@NotEmpty
	private String id;
	@NotEmpty
	private int customerId;
	@NotEmpty
	private String holderName;
	@NotEmpty
	private String type;
	@NotEmpty
	private String status;
	@NotEmpty
	private String paymentType;
	private Tariff tariffDetails;
	private CorrespondenceAddress address;
}
