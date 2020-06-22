package com.centrica.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "account")
public class Accounts {

	@Id
	@Column(name = "id", columnDefinition = "VARCHAR(40)")
	private String id;

	@Column(name = "customer_id")
	private int customerId;

	@Column(name = "holder_name")
	private String holderName;

	@Column(name = "type")
	private String type;

	@Column(name = "status")
	private String status;

	@Column(name = "payment_type")
	private String paymentType;

	@Column(name = "tariff_name")
	private String tariffName;

	@Column(name = "supplier_name")
	private String supplierName;

	@Column(name = "cancellation_charge")
	private String cancellationCharge;

	@Column(name = "end_date")
	private String endDate;

	@Column(name = "unit_rate")
	private Double unitRate;

	@Column(name = "standing_charge")
	private Double standingCharge;

	@Column(name = "personal_projection")
	private Double personalProjection;

	@Column(name = "estimated_annual_consumption")
	private Double estimatedAnnualConsumption;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id", referencedColumnName = "address_id")
	private CorrespondenceAddress address;

}
