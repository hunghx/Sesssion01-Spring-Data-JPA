package ra.demojpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Catalog {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String catalogId;
    @Column(unique = true, length = 100)
    private String catalogName;
    @Column(columnDefinition = "text")
    private String description;
    private boolean status;
//    @OneToMany(mappedBy = "catalog")
//    private List<Product> products;
}
