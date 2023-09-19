package com.project.teamfresh.domain.customer.domain;

import com.project.teamfresh.global.entity.BaseTime;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tb_customer")
public class Customer extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 고유 아이디

    private String customerId; // 고객사 아이디
    private String name; // 고객사명
    private String number; // 고객사 번호

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Keeper> keeperList; // 담당자 목록
    public void addKeeper(Keeper keeper) {
        keeper.setCustomer(this);
        getKeeperList().add(keeper);
    }

    @Builder
    public Customer(String customerId, String name, String number) {
        this.customerId = customerId;
        this.name = name;
        this.number = number;
        this.keeperList = new ArrayList<>();
    }
}
