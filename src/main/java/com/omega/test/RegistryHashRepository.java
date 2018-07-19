package com.omega.test;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistryHashRepository extends JpaRepository<RegistryHash, Integer> {
    public RegistryHash findByMapkey(String mapkey);
}
