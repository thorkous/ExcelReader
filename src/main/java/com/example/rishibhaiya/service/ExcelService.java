package com.example.rishibhaiya.service;

import com.example.rishibhaiya.pojo.Excel;
import com.example.rishibhaiya.repository.ExcelRepository;
import com.opencsv.CSVReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ForkJoinPool;

@Component
public class ExcelService {
    @Autowired
    ExcelRepository excelRepository;

    final static String NIFTY = "NIFTY";


    public List<Excel> readExcel(File file) throws IOException {

        List<Excel> excelList = new ArrayList<>();
        try {

            FileReader filereader = new FileReader(file);
            CSVReader csvReader = new CSVReader(filereader);
            String[] nextRecord;

            while ((nextRecord = csvReader.readNext()) != null){
                if(nextRecord[0].substring(0,5).equalsIgnoreCase(NIFTY)){
                    String uuid = UUID.randomUUID().toString();
                    Excel excel = new Excel();
                    excel.setUuid(uuid);
                    excel.setTicker(nextRecord[0]);
                    excel.setDate(new SimpleDateFormat("dd/MM/yyyy").parse(nextRecord[1]));
                    excel.setTime(nextRecord[2]);
                    excel.setOpen(nextRecord[3]);
                    excel.setHigh(nextRecord[4]);
                    excel.setLow(nextRecord[5]);
                    excel.setClose(nextRecord[6]);
                    excel.setVolume(nextRecord[7]);
                    excel.setOpenInterest(nextRecord[8]);
                    excelList.add(excel);
//                    excelRepository.save(excel);
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return excelList;
    }

    public void listFilesForFolder(final File folder) throws IOException {
        List<File> files = new ArrayList<>();
        List<Excel> list = new ArrayList<>();
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry);
            } else {
                files.add(fileEntry.getAbsoluteFile());
                list.addAll(readExcel(fileEntry.getAbsoluteFile()));
//                System.out.println(fileEntry.getName());
            }
        }

        long start = System.currentTimeMillis();
        Runnable retrieveMetricsJob =(()->
                list.parallelStream().forEach(listVal->{
                    excelRepository.save(listVal);
                }));
        int poolSize = Runtime.getRuntime().availableProcessors();
        ForkJoinPool threadPool = new ForkJoinPool(poolSize);
        threadPool.submit(retrieveMetricsJob);
        long end = System.currentTimeMillis();
        long ans = end-start;
        System.out.println("end- start: "+ans);
        threadPool.shutdown();
    }
}
