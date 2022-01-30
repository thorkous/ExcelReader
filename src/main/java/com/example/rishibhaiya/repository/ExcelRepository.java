package com.example.rishibhaiya.repository;

import com.example.rishibhaiya.pojo.Excel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface ExcelRepository extends JpaRepository<Excel, String> {

}
