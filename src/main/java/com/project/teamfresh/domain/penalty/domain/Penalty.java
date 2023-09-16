package com.project.teamfresh.domain.penalty.domain;

import com.project.teamfresh.domain.carrier.domain.Driver;
import com.project.teamfresh.domain.voc.domain.VOC;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter @NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tb_penalty")
public class Penalty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx; // 인덱스

    private String content; // 패널티 정보

    @OneToOne(mappedBy = "penalty", cascade = CascadeType.ALL, orphanRemoval = true)
    private VOC voc; // voc 정보

    @ManyToOne
    @JoinColumn(name = "fk_driver")
    private Driver driver; // 기사 정보
    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    @Builder
    public Penalty(String content, VOC voc) {
        this.content = content;
        this.voc = voc;
    }
}
