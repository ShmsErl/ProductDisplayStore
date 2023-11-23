package Tobeto.showRoomStore.repository.concretes;

import Tobeto.showRoomStore.model.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface IUserRepository extends JpaRepository<User, Integer> {
}
