package com.example.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Operator_mst;
@Repository
public interface Operator_mst_Repo extends JpaRepository<Operator_mst, Integer> {

}
