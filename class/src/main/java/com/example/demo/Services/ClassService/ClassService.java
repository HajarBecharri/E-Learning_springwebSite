package com.example.demo.Services.ClassService;

import com.example.demo.Models.Level;
import com.example.demo.Repositoris.ClassRepo;
import com.example.demo.dto.ClassDTO;
import com.example.demo.dto.CreatCl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ClassService implements IClassService{
   @Autowired
    private final ClassRepo repo;
    @Override
    public String removeClassById(Long id) {
        if(repo.existsById(id)){
            repo.deleteById(id);
            return "Class is deleted it";
        }
        else{
            return "Class not exist";
        }
    }



    @Override
    public CreatCl AddClass(ClassDTO c) {

        Level cl =new Level() ;
        cl.setName(c.getName());
        repo.save(cl);
        CreatCl cr= new CreatCl();
        cr.setName(c.getName());
        return cr;
    }

    @Override
    public Optional<Level> getClassById(Long id) {
        return repo.findById(id);
    }
}
