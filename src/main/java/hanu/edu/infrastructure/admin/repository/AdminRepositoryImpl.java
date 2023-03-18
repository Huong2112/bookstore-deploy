package hanu.edu.infrastructure.admin.repository;

import hanu.edu.domain.admin.repository.AdminRepository;
import hanu.edu.infrastructure.admin.entity.AdminEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class AdminRepositoryImpl implements AdminRepository {
    @Autowired
    private AdminJPARepository adminJPARepository;

    @Override
    public void save(AdminEntity adminEntity) {
        adminJPARepository.save(adminEntity);
    }

    @Override
    public Optional<AdminEntity> findByUsername(String username) {
        return adminJPARepository.findByUsername(username);
    }
}
