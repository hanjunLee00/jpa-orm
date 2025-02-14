package jpabook.jpashop.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.time.LocalDateTime;

@Embeddable
@Getter
public class Period {
    //Period 기간
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
