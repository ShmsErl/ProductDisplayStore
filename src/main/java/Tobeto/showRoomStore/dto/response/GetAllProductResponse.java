package Tobeto.showRoomStore.dto.response;

import Tobeto.showRoomStore.model.concretes.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalIdCache;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllProductResponse {

    private String productName;
    private int productQuantity;
    private double unitPrice;
    private String imgUri;
    private String description;
    private String categoryName;
}
