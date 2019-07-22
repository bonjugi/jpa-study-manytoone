package dev.bonjugi.jpastudy.member.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@EqualsAndHashCode
@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Team {

	@Id @GeneratedValue
	private Long id;

	private String name;

	public Team(String name) {
		this.name = name;
	}
}