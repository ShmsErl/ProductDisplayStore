package Tobeto.showRoomStore.service.concretes;

import Tobeto.showRoomStore.dto.request.CreateCategoryRequest;
import Tobeto.showRoomStore.dto.request.UpdateCategoryRequest;
import Tobeto.showRoomStore.dto.response.GetAllCategoryResponse;
import Tobeto.showRoomStore.dto.response.GetByIdResponses;
import Tobeto.showRoomStore.mapper.user.UserMapperService;
import Tobeto.showRoomStore.service.Abstract.ICategoryService;
import Tobeto.showRoomStore.core.utilities.result.DataResult;
import Tobeto.showRoomStore.core.utilities.result.Result;
import Tobeto.showRoomStore.core.utilities.result.SuccessDataResult;
import Tobeto.showRoomStore.core.utilities.result.SuccessResult;
import Tobeto.showRoomStore.repository.concretes.CategoryRepository;
import Tobeto.showRoomStore.model.concretes.Category;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CategoryManager implements ICategoryService {
    private final CategoryRepository categoryRepository;
    private final UserMapperService mapperService;

    @Override
    public DataResult<List<GetAllCategoryResponse>> getAllCategory() {
        List<Category> categories = this.categoryRepository.findAll();
        List<GetAllCategoryResponse> allCategoryResponses = new ArrayList<>();

        for (Category category : categories) {
        GetAllCategoryResponse categoryResponse =
            this.mapperService
                    .forResponse()
                    .map(category, GetAllCategoryResponse.class);

            allCategoryResponses.add(categoryResponse);

        }


        return new SuccessDataResult<List<GetAllCategoryResponse>>(allCategoryResponses);
    }

    @Override
    public Result createNewCategory(CreateCategoryRequest category) {
        Category createCategory = this.mapperService
        .forRequest().map(category,Category.class);

        this.categoryRepository.save(createCategory);


        return new SuccessResult("Yeni Kategori Eklendi.");
    }

    @Override
    public Result updateCategory(int id, UpdateCategoryRequest category) throws Exception {
        Category createCategory = this.categoryRepository.findById(id).orElseThrow(() -> new Exception("Category Not Found!"));
         createCategory = this.mapperService
                .forRequest().map(category,Category.class);

         this.categoryRepository.save(createCategory);
        return new SuccessResult(" Kategori Başarıyla Güncellendi.");
    }

    @Override
    public Result deleteCategory(int id) {


        this.categoryRepository.delete(this.categoryRepository.getReferenceById(id));

        return new SuccessResult("Silme İşlemi Başarılı .");
    }

    @Override
    public DataResult<GetByIdResponses> getElementById(int id) {
        Category category = this.categoryRepository.getReferenceById(id);

       GetByIdResponses responses = this.mapperService.forResponse().map(category, GetByIdResponses.class);


        return new SuccessDataResult<GetByIdResponses>("Değer bulundu. ", responses);
    }
}
