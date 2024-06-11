package Gabri.Dev.com.repositories;

import Gabri.Dev.com.entities.MatchEntity;
import Gabri.Dev.com.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepository extends JpaRepository<MatchEntity, Long> {
}
