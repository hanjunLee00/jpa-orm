 package jpabook.jpashop.domain;

 import jakarta.persistence.*;
 import lombok.Getter;
 import lombok.Setter;

 @Entity
 @Getter
 @Setter
 public class Delivery extends BaseEntity {
     @Id
     @GeneratedValue
     private Long id;


     @Embedded
     private Address address;
     private DeliveryStatus status;

     @OneToOne(mappedBy  = "delivery")
     private Order order;

}
