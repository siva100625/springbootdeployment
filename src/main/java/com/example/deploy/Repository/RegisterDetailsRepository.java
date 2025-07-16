package com.example.deploy.Repository;

import com.example.deploy.Models.EmployeeRoleDTO;
import com.example.deploy.Models.RegisterDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface RegisterDetailsRepository extends JpaRepository<RegisterDetails,Integer> {
    RegisterDetails findByEmail(String email);


    @Query("SELECT new com.example.deploy.Models.EmployeeRoleDTO(u.name, r.roleName) FROM RegisterDetails u JOIN u.roles r WHERE r.roleName = :roleName")
    List<EmployeeRoleDTO> findEmployeeNamesByRoleName(@Param("roleName") String roleName);


    Optional<RegisterDetails> findByUserName(String username);
}