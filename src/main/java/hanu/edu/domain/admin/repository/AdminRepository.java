package hanu.edu.domain.admin.repository;

import hanu.edu.infrastructure.admin.entity.AdminEntity;

import java.util.Optional;

public interface AdminRepository {

    void save(AdminEntity adminEntity);

    Optional<AdminEntity> findByUsername(String username);
}
