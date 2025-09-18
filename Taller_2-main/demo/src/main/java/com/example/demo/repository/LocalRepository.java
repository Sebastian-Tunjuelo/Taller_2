package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Local;
//
public interface LocalRepository extends JpaRepository<Local,Long>{
    
}
