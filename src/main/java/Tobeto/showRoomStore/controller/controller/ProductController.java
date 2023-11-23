package Tobeto.showRoomStore.controller.controller;

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
    public DataResult<List<Product>> getAllProduct() {

        return this.iProductService.getAllProduct();
    }

    @PostMapping("/add")
    public Result createNewProduct(@RequestBody Product product){

        return  this.iProductService.createNewProduct(product);
    }

    @PutMapping("/{id}")
    public Result updateProduct(@PathVariable int id, @RequestBody Product product){

        return this.iProductService.updateProduct(id, product );
    }

    @DeleteMapping("/{id}")
    public Result updateProduct(@PathVariable int id){

        return this.iProductService.deleteProduct(id);
    }

    @GetMapping("/getbyname")
    public DataResult<List<Product>> getElementByName(@RequestParam(value = "name",required = false) String name){

        return this.iProductService.getByProductName(name);
    }
}