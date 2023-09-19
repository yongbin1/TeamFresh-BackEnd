package com.project.teamfresh.domain.carrier.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tb_carrier")
public class Carrier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 고유 아이디

    private String carrierId; // 운송사 아이디
    private String name; // 운송사명
    private String number; // 운송사 번호

    @OneToMany(mappedBy = "carrier", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Driver> driverList; // 기사 목록
    public void addDriver(Driver driver) {
        driver.setCarrier(this);
        this.driverList.add(driver);
    }

    @Builder
    public Carrier(String carrierId, String name, String number) {
        this.carrierId = carrierId;
        this.name = name;
        this.number = number;
        this.driverList = new ArrayList<>();
    }
}
