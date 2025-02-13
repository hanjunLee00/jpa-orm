package jpabook.jpashop.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Setter;

@Entity
@Setter
@DiscriminatorValue("M")
public class Movie extends Item{

    private String director;
    private String actor;
}
