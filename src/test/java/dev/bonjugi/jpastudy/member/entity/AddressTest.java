package dev.bonjugi.jpastudy.member.entity;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AddressTest {

	@Test
	public void Address는_city_street_zipcode를_필수로갖는다(){
		Address address = new Address("Seoul","Euljiro","100-10");
		assertThat(address.getCity()).isEqualTo("Seoul");
		assertThat(address.getStreet()).isEqualTo("Euljiro");
		assertThat(address.getZipcode()).isEqualTo("100-10");
	}

	@Test
	public void inSeoul_테스트_city가_Seoul이_아닐때(){
		Address address = new Address("No-Seoul","Euljiro","100-10");
		assertThat(address.inSeoul()).isFalse();
	}

	@Test
	public void inSeoul_테스트_zipcode가_100_110_120이_아닐때(){
		Address address = new Address("Seoul","Euljiro","130-10");
		assertThat(address.inSeoul()).isFalse();
	}

	@Test
	public void inSeoul_테스트(){
		Address address = new Address("Seoul","Euljiro","100-10");
		assertThat(address.inSeoul()).isTrue();
	}
}