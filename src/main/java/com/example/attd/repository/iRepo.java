package com.example.attd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.attd.model.Animal;

public interface iRepo extends JpaRepository<Animal, String> {
}
