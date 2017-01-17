package bank.service;

import java.util.ArrayList;

import bank.DAO.BankDAO;
import bank.DTO.BankDTO;

public class BankService {

	public BankService() {
	}
	
	public boolean deposit(String name, int amount) {
		BankDAO dao = new BankDAO();
		return dao.deposit(name, amount);
		
	}

	public boolean withdraw(String name, int amount) {
		BankDAO dao = new BankDAO();
		return dao.withdraw(name, amount);
	}

	public boolean transfer(String nameSender, String nameReceiver, int amount) {
		BankDAO dao = new BankDAO();
		return dao.transfer(nameSender,nameReceiver, amount);
	}

	public ArrayList<BankDTO> checkAccount(String name) {

		BankDAO dao = new BankDAO();
		return dao.select(name);
	}

}
