package dev.bonjugi.jpastudy.member.entity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback(false)
public class MemberTest {

	@PersistenceContext
	private EntityManager em;

	@Test
	public void 등록하면_조회가_가능하다(){

		// given
		Member bonjugi = new Member("bonjugi");
		em.persist(bonjugi);

		// when
		Member find = em.find(Member.class, bonjugi.getId());

		// then
		assertThat(find).isEqualTo(bonjugi);
	}


	@Test
	public void 멤버는_주소를_가질수있다(){

		// given
		Member bonjugi = new Member("bonjugi");
		Address address = new Address("Seoul","Euljiro","100-10");
		em.persist(bonjugi);

		// when - IDENTITY 전략이라서 쓰기지연이 발생하지 못하고, update 발생한다.
		bonjugi.changeAddress(address);
		Member find = em.find(Member.class, bonjugi.getId());

		// then
		assertThat(find.getAddress()).isEqualTo(address);
	}
}