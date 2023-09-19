package com.project.teamfresh.domain.carrier.domain;

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
@Table(name = "tb_carrier")
public class Carrier extends BaseTime {

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
