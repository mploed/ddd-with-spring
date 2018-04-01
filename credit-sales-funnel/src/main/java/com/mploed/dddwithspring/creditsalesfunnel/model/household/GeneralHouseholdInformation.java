package com.mploed.dddwithspring.creditsalesfunnel.model.household;

import java.io.Serializable;

public class GeneralHouseholdInformation implements Serializable {
	private int adultsInHousehold;
	private int childrenInHousehold;
	private String iban;
	private String bic;

	public int getAdultsInHousehold() {
		return adultsInHousehold;
	}

	public void setAdultsInHousehold(int adultsInHousehold) {
		this.adultsInHousehold = adultsInHousehold;
	}

	public int getChildrenInHousehold() {
		return childrenInHousehold;
	}

	public void setChildrenInHousehold(int childrenInHousehold) {
		this.childrenInHousehold = childrenInHousehold;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public String getBic() {
		return bic;
	}

	public void setBic(String bic) {
		this.bic = bic;
	}
}
