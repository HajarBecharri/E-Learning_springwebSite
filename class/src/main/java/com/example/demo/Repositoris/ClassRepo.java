package com.example.demo.Repositoris;

import com.example.demo.Models.Level;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;




    @Repository
    public interface ClassRepo extends JpaRepository<Level,Long> {

    }


