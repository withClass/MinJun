package com.example.springpluscache.domain.Busniess.repository;


import com.example.springpluscache.domain.Busniess.entity.Business;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessRepository extends JpaRepository<Business, Long>, BusinessRepositoryCustom  {
}