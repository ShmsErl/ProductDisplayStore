package Tobeto.showRoomStore.controller.controller;

import Tobeto.showRoomStore.dto.request.CreateCategoryRequest;
import Tobeto.showRoomStore.dto.request.UpdateCategoryRequest;
import Tobeto.showRoomStore.dto.response.GetAllCategoryResponse;
import Tobeto.showRoomStore.dto.response.GetByIdCategoryResponse;
import Tobeto.showRoomStore.service.Abstract.ICategoryService;
import Tobeto.showRoomStore.core.utilities.result.DataResult;
import Tobeto.showRoomStore.core.utilities.result.Result;
import Tobeto.showRoomStore.model.concretes.Category;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
@AllArgsConstructor
public class CategoryController {
    private final ICategoryService iCategoryService;

    @GetMapping("/getall")
    public DataResult<List<GetAllCategoryResponse>> getAllProduct() {

        return this.iCategoryService.getAllCategory();
    }
    @GetMapping("/get/{id}")
    public DataResult<GetByIdCategoryResponse> getByIdResponse(@PathVariable int id){

        return this.iCategoryService.getElementById(id);
    }

    @PostMapping("/add")
    public Result createNewCategory(@RequestBody CreateCategoryRequest category){

        return this.iCategoryService.createNewCategory(category);
    }

    @PutMapping("/update/{id}")
    public Result updateCategory(@PathVariable int id, @RequestBody UpdateCategoryRequest category) throws Exception {

        return this.iCategoryService.updateCategory(id,category);

    }
    @DeleteMapping("/delete/{id}")
    public Result deleteCategory(@PathVariable int id){

        return this.iCategoryService.deleteCategory(id);
    }
}
