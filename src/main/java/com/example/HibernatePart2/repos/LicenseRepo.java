package com.example.HibernatePart2.repos;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.example.HibernatePart2.entities.one2one.License;

public interface LicenseRepo extends CrudRepository<License, UUID> {

}
