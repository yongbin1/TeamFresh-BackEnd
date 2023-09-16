package com.project.teamfresh.domain.carrier.domain;

import com.project.teamfresh.domain.penalty.domain.Penalty;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "tb_driver")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 고유 아이디

    private String name; // 기사명
    private String number; // 기사 번호

    @ManyToOne
    @JoinColumn(name = "fk_carrier")
    private Carrier carrier; // 운송사 정보
    public void setCarrier(Carrier carrier) {
        this.carrier = carrier;
    }

    @OneToMany(mappedBy = "driver", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Penalty> penaltyList; // 패널티 목록
    public void addPenalty(Penalty penalty) {
        penalty.setDriver(this);
        this.penaltyList.add(penalty);
    }

    @Builder
    public Driver(String name, String number) {
        this.name = name;
        this.number = number;
        this.penaltyList = new ArrayList<>();
    }
}
