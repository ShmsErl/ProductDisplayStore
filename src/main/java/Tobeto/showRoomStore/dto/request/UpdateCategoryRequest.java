package Tobeto.showRoomStore.dto.request;

import Tobeto.showRoomStore.model.concretes.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCategoryRequest {

    private int id;
    private String categoryName;

}