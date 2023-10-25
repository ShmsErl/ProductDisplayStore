package Tobeto.showRoomStore.business.concretes;

import Tobeto.showRoomStore.business.Abstract.ICategoryService;
import Tobeto.showRoomStore.core.utilities.result.DataResult;
import Tobeto.showRoomStore.core.utilities.result.Result;
import Tobeto.showRoomStore.core.utilities.result.SuccessDataResult;
import Tobeto.showRoomStore.core.utilities.result.SuccessResult;
import Tobeto.showRoomStore.dataAccess.concretes.CategoryRepository;
import Tobeto.showRoomStore.entities.concretes.Category;
import Tobeto.showRoomStore.entities.concretes.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryManager implements ICategoryService {
    @Autowired
    private final CategoryRepository categoryRepository;
    @Override
    public DataResult<List<Category>> getAllCategory() {
        return new SuccessDataResult<List<Category>>(this.categoryRepository.findAll()) ;
    }

    @Override
    public Result createNewCategory(Category category) {
       Category createCategory =  Category.builder().id(category.getId()).categoryName(category.getCategoryName())
                .active(category.isActive()).build();

       this.categoryRepository.save(createCategory);


        return new SuccessResult("Yeni Kategori Eklendi.");
    }

    @Override
    public Result updateCategory(int id, Category category) {
        return null;
    }

    @Override
    public Result deleteCategory(int id) {


        this.categoryRepository.delete(this.categoryRepository.getReferenceById(id));

        return new SuccessResult("Silme İşlemi Başarılı ." );
    }

    @Override
    public DataResult<Category> getElementById(int id) {
        Category category = this.categoryRepository.getReferenceById(id);



        return new SuccessDataResult<Category>("Değer bulundu. " , category);
    }
}
