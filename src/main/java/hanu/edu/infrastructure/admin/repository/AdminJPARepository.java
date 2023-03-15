package hanu.edu.infrastructure.admin.repository;

import hanu.edu.infrastructure.admin.repository.entity.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface AdminJPARepository extends JpaRepository<AdminEntity, Long> {
    Collection<Object> findByUsername(String admin);
}
