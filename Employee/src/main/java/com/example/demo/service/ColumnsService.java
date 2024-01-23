package com.example.demo.service;

import com.example.demo.entity.Column;
import com.example.demo.helper.Helper;
import com.example.demo.repository.ColumnRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ColumnsService {
    @Autowired
    private ColumnRepo columnRepo;

    public void save(MultipartFile file) {
        try {
            List<Column> columns = Helper.convertExcelToListOfColumns(file.getInputStream());
            columnRepo.saveAll(columns);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Column> getAllColumns() {

        return columnRepo.findAll();

    }

}
