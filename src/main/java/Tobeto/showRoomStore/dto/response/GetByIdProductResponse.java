package Tobeto.showRoomStore.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdProductResponse {

    private String productName;
    private int productQuantity;
    private double unitPrice;
    private String imgUri;
    private String description;
    private String categoryName;
}
