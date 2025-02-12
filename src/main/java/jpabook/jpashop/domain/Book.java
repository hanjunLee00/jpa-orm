package jpabook.jpashop.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Setter;

@Entity
@Setter
@DiscriminatorValue("B")
public class Book extends Item{
    private String author;
    private String isbn;
}