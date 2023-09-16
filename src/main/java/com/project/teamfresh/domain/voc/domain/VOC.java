package com.project.teamfresh.domain.voc.domain;

import com.project.teamfresh.domain.penalty.domain.Penalty;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter @NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tb_voc")
public class VOC {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx; // 인덱스

    private String imputationParty; // 귀책 당사자
    private String imputationContent; // 귀책 내용
    private Boolean driverCheck; // 기사 확인 여부
    private Boolean objection; // 이의 제기 여부

    @OneToOne(mappedBy = "voc", cascade = CascadeType.ALL, orphanRemoval = true)
    private Penalty penalty; // 패널티 정보

    @Builder
    public VOC(String imputationParty, String imputationContent, Boolean driverCheck, Boolean objection, Penalty penalty) {
        this.imputationParty = imputationParty;
        this.imputationContent = imputationContent;
        this.driverCheck = driverCheck;
        this.objection = objection;
        this.penalty = penalty;
    }
}
