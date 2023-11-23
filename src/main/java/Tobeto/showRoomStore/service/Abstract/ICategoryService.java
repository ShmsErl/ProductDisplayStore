package Tobeto.showRoomStore.service.Abstract;

import Tobeto.showRoomStore.core.utilities.result.DataResult;
import Tobeto.showRoomStore.core.utilities.result.Result;
import Tobeto.showRoomStore.dto.request.CreateCategoryRequest;
import Tobeto.showRoomStore.dto.request.UpdateCategoryRequest;
import Tobeto.showRoomStore.dto.response.GetAllCategoryResponse;
import Tobeto.showRoomStore.dto.response.GetByIdCategoryResponse;
import Tobeto.showRoomStore.model.concretes.Category;

import java.util.List;

public interface ICategoryService {

    DataResult<List<GetAllCategoryResponse>> getAllCategory();

    Result createNewCategory(CreateCategoryRequest category);

    Result updateCategory(int id, UpdateCategoryRequest category) throws Exception;

    Result deleteCategory(int id);

    DataResult<GetByIdCategoryResponse> getElementById(int id);

}
