package Tobeto.showRoomStore.repository.concretes;

import Tobeto.showRoomStore.model.concretes.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
