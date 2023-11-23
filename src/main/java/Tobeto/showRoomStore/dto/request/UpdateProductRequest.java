package Tobeto.showRoomStore.dto.request;

import Tobeto.showRoomStore.model.concretes.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class UpdateProductRequest {

        private int id;
        private String productName;
        private int productQuantity;
        private double unitPrice;
        private String imgUri;
        private String description;
        private Category category;



}
