package Tobeto.showRoomStore.dto.request;

import Tobeto.showRoomStore.model.concretes.Category;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductRequest {


    private String productName;
    private int productQuantity;
    private double unitPrice;
    private String imgUri;
    private String description;
    private Category category;


}
