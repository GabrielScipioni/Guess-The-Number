package Gabri.Dev.com.repositories;

import Gabri.Dev.com.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional <UserEntity> getByEmail(String email);
}
