package com.example.demo.repository;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Moto;

public interface MotoRepository  extends JpaRepository<Moto, Integer>{

}
