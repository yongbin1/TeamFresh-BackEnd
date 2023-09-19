package com.project.teamfresh.domain.customer.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tb_customer")
public class Customer {

    @Id
    private Long id; // 고유 아이디

    private String name; // 고객사명
    private String number; // 고객사 번호

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Keeper> keeperList; // 담당자 목록
    public void addKeeper(Keeper keeper) {
        keeper.setCustomer(this);
        getKeeperList().add(keeper);
    }

    @Builder
    public Customer(String name, String number) {
        this.name = name;
        this.number = number;
        this.keeperList = new ArrayList<>();
    }
}
