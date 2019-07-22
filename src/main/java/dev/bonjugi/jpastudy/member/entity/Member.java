package dev.bonjugi.jpastudy.member.entity;

import lombok.*;

import javax.persistence.*;


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

    @ManyToOne
    private Team team;

    public void changeAddress(Address address){
       this.address = address;
    }

    public Member(String name) {
       this.name = name;
    }

    // 연관관계 편의 메소드
    public void setTeam(Team team) {
       this.team = team;
    }
}