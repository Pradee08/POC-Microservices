package com.centrica.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.centrica.model.Account;
import com.centrica.model.Accounts;
import com.centrica.model.Tariff;
import com.centrica.repository.AccountRepository;

@Service
public class AccountService {

	@Autowired
	private AccountRepository repo;

	public void add(Account account) {
		Accounts accounts = new Accounts();
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setAmbiguityIgnored(true);
		accounts = mapper.map(account, Accounts.class);
		accounts.setSupplierName(account.getTariffDetails().getSupplierName());
		accounts.setUnitRate(account.getTariffDetails().getUnitRate());
		accounts.setStandingCharge(account.getTariffDetails().getStandingCharge());
		accounts.setPersonalProjection(account.getTariffDetails().getPersonalProjection());
		accounts.setEstimatedAnnualConsumption(account.getTariffDetails().getEstimatedAnnualConsumption());
		accounts.setCancellationCharge(account.getTariffDetails().getCancellationCharge());
		accounts.setEndDate(account.getTariffDetails().getEndDate());
		accounts.setTariffName(account.getTariffDetails().getTariffName());
		repo.save(accounts);
		return;
	}

	public Account retrieve(String id) {
		Account account = new Account();
		Accounts accountList = repo.findById(id).get();
		ModelMapper mapper = new ModelMapper();
		Tariff tariffDetails = new Tariff();
		account = mapper.map(accountList, Account.class);
		tariffDetails.setUnitRate(accountList.getUnitRate());
		tariffDetails.setSupplierName(accountList.getSupplierName());
		tariffDetails.setTariffName(accountList.getTariffName());
		tariffDetails.setStandingCharge(accountList.getStandingCharge());
		tariffDetails.setPersonalProjection(accountList.getPersonalProjection());
		tariffDetails.setEstimatedAnnualConsumption(accountList.getEstimatedAnnualConsumption());
		tariffDetails.setCancellationCharge(accountList.getCancellationCharge());
		tariffDetails.setEndDate(accountList.getEndDate());
		account.setTariffDetails(tariffDetails);
		return account;

	}

	public void update(Account account, String id, Account existAccount) {
		ModelMapper mapper = new ModelMapper();
		if (existAccount.getId().equals(id)) {
			existAccount = mapper.map(account, Account.class);
			Accounts accounts = new Accounts();
			ModelMapper mapper1 = new ModelMapper();
			mapper1.getConfiguration().setAmbiguityIgnored(true);
			accounts = mapper1.map(existAccount, Accounts.class);
			accounts.setSupplierName(existAccount.getTariffDetails().getSupplierName());
			accounts.setUnitRate(existAccount.getTariffDetails().getUnitRate());
			accounts.setStandingCharge(existAccount.getTariffDetails().getStandingCharge());
			accounts.setPersonalProjection(existAccount.getTariffDetails().getPersonalProjection());
			accounts.setEstimatedAnnualConsumption(existAccount.getTariffDetails().getEstimatedAnnualConsumption());
			accounts.setCancellationCharge(existAccount.getTariffDetails().getCancellationCharge());
			accounts.setEndDate(existAccount.getTariffDetails().getEndDate());
			accounts.setTariffName(existAccount.getTariffDetails().getTariffName());
			repo.save(accounts);
		}
		return;
	}

	public void delete(String id) {
		repo.deleteById(id);
	}
}
