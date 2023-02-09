package com.example.HibernatePart2.repos;

import org.springframework.data.repository.CrudRepository;

import com.example.HibernatePart2.entities.many2many.Programmer;

public interface ProgrammerRepo extends CrudRepository<Programmer, Integer> {
    Programmer findById(int id);
}
