package Tobeto.showRoomStore.service.concretes;

import Tobeto.showRoomStore.dto.request.CreateProductRequest;
import Tobeto.showRoomStore.dto.request.UpdateProductRequest;
import Tobeto.showRoomStore.dto.response.GetAllProductResponse;
import Tobeto.showRoomStore.dto.response.GetByIdProductResponse;
import Tobeto.showRoomStore.mapper.user.UserMapperService;
import Tobeto.showRoomStore.service.Abstract.IProductService;
import Tobeto.showRoomStore.core.utilities.result.DataResult;
import Tobeto.showRoomStore.core.utilities.result.Result;
import Tobeto.showRoomStore.core.utilities.result.SuccessDataResult;
import Tobeto.showRoomStore.core.utilities.result.SuccessResult;
import Tobeto.showRoomStore.repository.concretes.ProductRepository;
import Tobeto.showRoomStore.model.concretes.Product;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductManager implements IProductService {

    private final ProductRepository productRepository;
    private final UserMapperService mapperService;


    @Override
    public DataResult<List<GetAllProductResponse>> getAllProduct() {
        List<Product> products = this.productRepository.findAll();
        List<GetAllProductResponse> responses = new ArrayList<>();

        for (Product product : products) {
            GetAllProductResponse allProductResponse =
                    this.mapperService.forResponse().map(product, GetAllProductResponse.class);

            responses.add(allProductResponse);
        }
        return new SuccessDataResult<List<GetAllProductResponse>>("Ürün Başarı İle Çağrıldı. ", responses);
    }

    @Override
    public Result createNewProduct(CreateProductRequest product) {

        Product createProduct = this.mapperService.forRequest().map(product, Product.class);


        this.productRepository.save(createProduct);


        return new SuccessResult("Ürün Başarı İle Eklendi. ");

    }

    @Override
    public Result updateProduct(int id, UpdateProductRequest product) throws Exception {
        Product product1 = this.productRepository.findById(id).orElseThrow(() -> new Exception("Product note found"));

        product1 = this.mapperService.forRequest().map(product, Product.class);
        this.productRepository.save(product1);

        return new SuccessResult("Ürün Başarı İle Güncellendi. ");
    }

    @Override
    public Result deleteProduct(int id) throws Exception {
        Product product = this.productRepository.findById(id).orElseThrow(() -> new Exception("Product note found"));
        this.productRepository.delete(product);
        return new SuccessResult("Ürün Başarı İle Silindi. " + " " + product.getProductName());
    }

    @Override
    public DataResult<GetByIdProductResponse> getElementById(int id) throws Exception {

        Product product = this.productRepository.findById(id).orElseThrow(() -> new Exception("Product note found"));

        GetByIdProductResponse response = this.mapperService.forResponse().map(product, GetByIdProductResponse.class);


        return new SuccessDataResult<GetByIdProductResponse>("İstenilen Değer Bulundu : ", response);
    }

    @Override
    public DataResult<GetByIdProductResponse> getByProductName(String name) {
        Product product = this.productRepository.getByProductName(name);

        GetByIdProductResponse response = this.mapperService.forResponse().map(product, GetByIdProductResponse.class);


        return new SuccessDataResult<GetByIdProductResponse>("İstenilen Değer Bulundu : ", response);
    }
}
