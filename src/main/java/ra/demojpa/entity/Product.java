package ra.demojpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long productId;
   private String productName;
   private double price;
   @Column(columnDefinition = "text")
   private String description;
   private int stock;
   @ManyToOne
   @JoinColumn(name = "catalogId")
   private Catalog catalog;
}
