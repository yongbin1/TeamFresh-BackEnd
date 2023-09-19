package com.project.teamfresh.domain.voc.domain;

import com.project.teamfresh.domain.compensation.domain.Compensation;
import com.project.teamfresh.domain.voc.domain.enums.ImputationParty;
import com.project.teamfresh.global.entity.BaseTime;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Getter @NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tb_voc")
public class VOC extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx; // 인덱스

    @Enumerated(EnumType.STRING)
    private ImputationParty imputationParty; // 귀책 당사자
    private String imputationContent; // 귀책 내용
    private Boolean driverCheck; // 기사 확인 여부
    public void checkDriver() {
        this.driverCheck = true;
    }
    private Boolean objection; // 이의 제기 여부
    public void checkObjection() {
        this.objection = true;
    }

    @OneToOne(mappedBy = "voc", cascade = CascadeType.ALL, orphanRemoval = true)
    private Compensation compensation;
    public void setCompensation(Compensation compensation) {
        compensation.setVoc(this);
        this.compensation = compensation;
    }

    @Builder
    public VOC(ImputationParty imputationParty, String imputationContent, Boolean driverCheck, Boolean objection) {
        this.imputationParty = imputationParty;
        this.imputationContent = imputationContent;
        this.driverCheck = driverCheck;
        this.objection = objection;
    }
}
