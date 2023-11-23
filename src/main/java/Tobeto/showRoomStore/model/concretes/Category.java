package Tobeto.showRoomStore.model.concretes;

import Tobeto.showRoomStore.model.concretes.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "categories")
public class Category {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "categoryName")
    private String categoryName;
    @Column(name = "isActive")
    private boolean isActive;
    @OneToMany(mappedBy = "category")
    @JsonManagedReference
    @JsonIgnore
    private List<Product> products;





}
