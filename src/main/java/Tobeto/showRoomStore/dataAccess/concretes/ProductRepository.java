package Tobeto.showRoomStore.dataAccess.concretes;

import Tobeto.showRoomStore.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> getByProductName(String productName);
}
