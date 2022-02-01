package com.example.rishibhaiya.controller;

import com.example.rishibhaiya.service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;

@RestController
@CrossOrigin
public class ExcelController {


    @Autowired
    ExcelService excelService;

    @GetMapping("/saveexcel")
    public String saveExcel() throws IOException {

        File file = new File("C:\\koustubh\\coding\\rishiBhaiya\\src\\main\\resources\\templates");
        excelService.listFilesForFolder(file);
        return "done";
    }

    @GetMapping("/hello")
    public String getMessage(){
        System.out.println("hello");
        return "Hello";
    }

}
