package com.project.teamfresh.domain.compensation.domain;

import com.project.teamfresh.domain.voc.domain.VOC;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter @NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tb_compensation")
public class Compensation {

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

    @Builder
    public Compensation(String content, Integer price) {
        this.content = content;
        this.price = price;
    }
}
