package dev.bonjugi.jpastudy.member.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
	private Address address;

	public void changeAddress(Address address){
		this.address = address;
	}

    public Member(final String name) {
        this.name = name;
    }
}