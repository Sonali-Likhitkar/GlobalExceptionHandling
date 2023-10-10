package com.example.demo.controller;

import com.example.demo.entity.Column;
import com.example.demo.helper.Helper;
import com.example.demo.service.ColumnsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class ColumnController {
    @Autowired
    private ColumnsService  columnsService;

    @PostMapping("/Column/upload")
    public ResponseEntity<?> upload(@RequestParam("file")MultipartFile file){
        if(Helper.checkExcelFormat(file)){
            this.columnsService.save(file);
            return ResponseEntity.ok(Map.of("message","file is uploaded and Data is save to DB" ));
        }
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload excel file ");
    }

    @GetMapping("/getAll")
    public List<Column> getAllColumns(){
        return this.columnsService.getAllColumns();
    }


}
