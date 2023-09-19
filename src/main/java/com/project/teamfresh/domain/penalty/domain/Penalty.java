package com.project.teamfresh.domain.penalty.domain;

import com.project.teamfresh.domain.carrier.domain.Driver;
import com.project.teamfresh.domain.compensation.domain.Compensation;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Getter @NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tb_penalty")
public class Penalty extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx; // 인덱스

    private String content; // 패널티 정보

    @OneToOne
    @JoinColumn(name = "fk_compensation")
    private Compensation compensation; // voc 정보
    public void setCompensation(Compensation compensation) {
        this.compensation = compensation;
    }

    @ManyToOne
    @JoinColumn(name = "fk_driver")
    private Driver driver; // 기사 정보
    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    @Builder
    public Penalty(String content) {
        this.content = content;
    }
}
