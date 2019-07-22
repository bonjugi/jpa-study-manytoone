package dev.bonjugi.jpastudy.member.entity;

import lombok.*;

import javax.persistence.Embeddable;

@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class Address {
	private String city;
	private String street;
	private String zipcode;

	public Address(String city, String street, String zipcode) {
		if (zipcode.isEmpty() || city.isEmpty() || street.isEmpty())
			throw new IllegalStateException("주소 정보가 부족합니다.");

		this.city = city;
		this.street = street;
		this.zipcode = zipcode;

	}

	public boolean inSeoul(){
		return city.equals("Seoul") &&
				(zipcode.startsWith("100") ||  zipcode.startsWith("110") || zipcode.startsWith("120"));
	}
}
