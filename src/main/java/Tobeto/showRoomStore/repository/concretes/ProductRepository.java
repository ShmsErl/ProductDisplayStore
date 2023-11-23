package Tobeto.showRoomStore.repository.concretes;

import Tobeto.showRoomStore.model.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> getByProductName(String productName);
}
