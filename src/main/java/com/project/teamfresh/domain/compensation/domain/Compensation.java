package com.project.teamfresh.domain.compensation.domain;

import com.project.teamfresh.domain.penalty.domain.Penalty;
import com.project.teamfresh.domain.voc.domain.VOC;
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
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Getter @NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tb_compensation")
public class Compensation extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx; // 인덱스

    private String content; // 배상 정보
    private Integer price; // 배상 금액

    @OneToOne
    @JoinColumn(name = "fk_voc")
    private VOC voc; // voc 정보
    public void setVoc(VOC voc) {
        this.voc = voc;
    }

    @OneToOne(mappedBy = "compensation", cascade = CascadeType.ALL, orphanRemoval = true)
    private Penalty penalty;
    public void setPenalty(Penalty penalty) {
        penalty.setCompensation(this);
        this.penalty = penalty;
    }

    @Builder
    public Compensation(String content, Integer price) {
        this.content = content;
        this.price = price;
    }
}
