package com.recursospropios.facturacion.repository;

import com.recursospropios.facturacion.entity.UserPatient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserPatientRepository extends JpaRepository<UserPatient, Integer> {
    @Query
    void deleteByDni(Long dni);
    @Query
    UserPatient searchByDni(Long dni);
}
