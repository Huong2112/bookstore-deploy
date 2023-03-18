package hanu.edu.infrastructure.admin.repository;

import hanu.edu.infrastructure.admin.entity.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminJPARepository extends JpaRepository<AdminEntity, Long> {
    Optional<AdminEntity> findByUsername(String admin);
}
