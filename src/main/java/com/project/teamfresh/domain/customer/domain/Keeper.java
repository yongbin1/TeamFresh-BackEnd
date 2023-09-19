package com.project.teamfresh.domain.customer.domain;

import com.project.teamfresh.global.entity.BaseTime;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Getter @NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tb_keeper")
public class Keeper extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 고유 아이디

    private String keeperId; // 담당자 아이디
    private String name; // 담당자명
    private String number; // 담당자 번호

    @ManyToOne
    @JoinColumn(name = "fk_customer")
    private Customer customer; // 고객사 정보
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Builder
    public Keeper(String keeperId, String name, String number) {
        this.keeperId = keeperId;
        this.name = name;
        this.number = number;
    }
}
