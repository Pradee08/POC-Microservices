package com.centrica.model;

import lombok.Data;

@Data
public class Tariff {
	private String tariffName;
	private String supplierName;
	private String cancellationCharge;
	private String endDate;
	private Double unitRate;
	private Double standingCharge;
	private Double personalProjection;
	private Double estimatedAnnualConsumption;
}
