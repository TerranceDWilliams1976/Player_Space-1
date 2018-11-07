package com.garage.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.garage.models.Want;

public interface WantRepo extends JpaRepository<com.garage.models.Want, Integer> {

}