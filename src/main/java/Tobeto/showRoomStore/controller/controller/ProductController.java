package Tobeto.showRoomStore.controller.controller;

import Tobeto.showRoomStore.dto.request.CreateProductRequest;
import Tobeto.showRoomStore.dto.request.UpdateProductRequest;
import Tobeto.showRoomStore.dto.response.GetAllProductResponse;
import Tobeto.showRoomStore.dto.response.GetByIdProductResponse;
import Tobeto.showRoomStore.service.Abstract.IProductService;
import Tobeto.showRoomStore.core.utilities.result.DataResult;
import Tobeto.showRoomStore.core.utilities.result.Result;
import Tobeto.showRoomStore.model.concretes.Product;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@AllArgsConstructor
public class ProductController {

    private final IProductService iProductService;


    @GetMapping("/getall")
    public DataResult<List<GetAllProductResponse>> getAllProduct() {

        return this.iProductService.getAllProduct();
    }

    @PostMapping("/add")
    public Result createNewProduct(@RequestBody CreateProductRequest product){

        return  this.iProductService.createNewProduct(product);
    }

    @PutMapping("/{id}")
    public Result updateProduct(@PathVariable int id, @RequestBody UpdateProductRequest product) throws Exception {

        return this.iProductService.updateProduct(id, product );
    }

    @DeleteMapping("/{id}")
    public Result updateProduct(@PathVariable int id) throws Exception {

        return this.iProductService.deleteProduct(id);
    }

    @GetMapping("/getbyname/{name}")
    public DataResult<GetByIdProductResponse> getElementByName(@PathVariable(value = "name",required = false) String name){

        return this.iProductService.getByProductName(name);
    }
}