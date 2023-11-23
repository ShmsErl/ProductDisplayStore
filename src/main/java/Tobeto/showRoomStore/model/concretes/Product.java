package Tobeto.showRoomStore.model.concretes;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
public class Product {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "productName")
    private String productName;
    @Column(name = "productQuantity")
    private int productQuantity;
    @Column(name = "unitPrice")
    private double unitPrice;
    @Column(name = "imgUri")
    private String imgUri;
    @Column(name = "description")
    private String description;
    @Column(name = "isActive")
    private boolean isActive;
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    @JsonBackReference
    private Category category;





}