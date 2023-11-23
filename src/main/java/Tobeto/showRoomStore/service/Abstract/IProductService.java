package Tobeto.showRoomStore.service.Abstract;

import Tobeto.showRoomStore.core.utilities.result.DataResult;
import Tobeto.showRoomStore.core.utilities.result.Result;
import Tobeto.showRoomStore.dto.request.CreateProductRequest;
import Tobeto.showRoomStore.dto.request.UpdateProductRequest;
import Tobeto.showRoomStore.dto.response.GetAllProductResponse;
import Tobeto.showRoomStore.dto.response.GetByIdProductResponse;
import Tobeto.showRoomStore.model.concretes.Product;

import java.util.List;

public interface IProductService {

    DataResult<List<GetAllProductResponse>> getAllProduct();
    Result createNewProduct(CreateProductRequest product);
    Result updateProduct(int id , UpdateProductRequest product) throws Exception;
    Result deleteProduct(int id) throws Exception;
    DataResult<GetByIdProductResponse> getElementById(int id) throws Exception;
    DataResult<GetByIdProductResponse> getByProductName(String name);


}


