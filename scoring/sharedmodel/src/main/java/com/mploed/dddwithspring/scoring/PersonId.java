package com.mploed.dddwithspring.scoring;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PersonId {
	private String personId;

	public PersonId(String personId) {
		this.personId = personId;
	}

	@Override
	public String toString() {
		return personId;
	}

	private PersonId(PersonIdBuilder builder) {
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
			byte[] shaHash = messageDigest.digest(builder.toString().getBytes());
			this.personId = convertByteArrayToHexString(shaHash);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

	private static String convertByteArrayToHexString(byte[] arrayBytes) {
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0; i < arrayBytes.length; i++) {
			stringBuffer.append(Integer.toString((arrayBytes[i] & 0xff) + 0x100, 16)
					.substring(1));
		}
		return stringBuffer.toString();
	}
	
	public static class PersonIdBuilder {
		private final String firstName;
		private final String lastName;
		private String street;
		private String postCode;
		private String city;

		public PersonIdBuilder(String firstName, String lastName) {
			this.firstName = firstName;
			this.lastName = lastName;
		}

		public PersonIdBuilder street(String street) {
			this.street = street;
			return this;
		}

		public PersonIdBuilder postCode(String postCode) {
			this.postCode = postCode;
			return this;
		}

		public PersonIdBuilder city(String city) {
			this.city = city;
			return this;
		}

		@Override
		public String toString() {
			return "PersonId{" +
					"firstName='" + firstName + '\'' +
					", lastName='" + lastName + '\'' +
					", street='" + street + '\'' +
					", postCode='" + postCode + '\'' +
					", city='" + city + '\'' +
					'}';
		}

		public PersonId build() {
			return new PersonId(this);
		}
	}
}
