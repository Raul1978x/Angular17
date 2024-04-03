package com.recursospropios.facturacion.repository;

import com.recursospropios.facturacion.entity.SocialSecurity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ISocialSecurityRepository extends JpaRepository<SocialSecurity, Long> {
    @Query
    SocialSecurity searchByRnos(Long rnos);

    @Query
    void deleteByRnos(Long rnos);
}
