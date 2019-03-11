package com.cg.mvc.beans;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Cust")
public class Customer {
		@Id
		private String mobileNumber;
		private String name;
		@Embedded
		private Wallet wallet;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getMobileNumber() {
			return mobileNumber;
		}
		public void setMobileNumber(String mobileNumber) {
			this.mobileNumber = mobileNumber;
		}
		public Wallet getWallet() {
			return wallet;
		}
		public void setWallet(Wallet wallet) {
			this.wallet = wallet;
		}
		public Customer(String name, String mobileNumber, Wallet wallet) {
			super();
			this.name = name;
			this.mobileNumber = mobileNumber;
			this.wallet = wallet;
		}
		public Customer() {
			super();
		}

}