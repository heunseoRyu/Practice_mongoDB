package com.example.ducami.service;

import com.example.ducami.dto.StudentScore;
import com.example.ducami.entity.Result;
import com.example.ducami.repo.ResultMongoRepository;
import com.example.ducami.repo.ResultRepository;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ResultService {

    private final ResultRepository resultRepository;
    private final ResultMongoRepository resultMongoRepository;
    private final MongoTemplate mongoTemplate;

    public void saveExcel(MultipartFile file) {
        // 1. 성적 저장
        String collectionName = file.getOriginalFilename();
        mongoTemplate.createCollection(collectionName);
        saveScore(file,collectionName);

        // 2. 시험이름, 생성일 저장
        resultRepository.save(Result.builder()
                .fileName(file.getOriginalFilename())
                .createTime(LocalDateTime.now()).build());
    }

    private void saveScore(MultipartFile file,String collectionName) {
        List<StudentScore> scores = extractScores(file);
        for(StudentScore score : scores)
            mongoTemplate.save(score,collectionName);
    }

    private List<StudentScore> extractScores(MultipartFile file) {
        List<StudentScore> scores = new ArrayList<>();

        try (XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream())) {
            XSSFSheet sheet = workbook.getSheetAt(0);
            DataFormatter formatter = new DataFormatter();

            // Assume first row is header, start from second row
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row != null) {
                    Integer grade = Integer.valueOf(formatter.formatCellValue(row.getCell(0)));  // 첫 번째 셀 (학년)
                    Integer cls = Integer.valueOf(formatter.formatCellValue(row.getCell(1)));      // 두 번째 셀 (반)
                    Integer num = Integer.valueOf(formatter.formatCellValue(row.getCell(2)));      // 3 번째 셀 (번호)
                    String score = formatter.formatCellValue(row.getCell(3));      // 4 번째 셀 (성적)
                    String description = formatter.formatCellValue(row.getCell(4));      // 5 번째 셀 (설명)
                    scores.add(new StudentScore(grade,cls,num,score,description));
                }
            }
        } catch (IOException e) {
            // Handle exception (e.g., log it or rethrow)
            e.printStackTrace();
        }

        return scores;
    }


}
