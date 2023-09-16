package com.project.teamfresh.domain.customer.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter @NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tb_keeper")
public class Keeper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 고유 아이디

    private String name; // 담당자명
    private String number; // 담당자 번호

    @ManyToOne
    @JoinColumn(name = "fk_customer")
    private Customer customer; // 고객사 정보
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Builder
    public Keeper(String name, String number) {
        this.name = name;
        this.number = number;
    }
}
