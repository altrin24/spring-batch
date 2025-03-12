package com.example.springbatch.file.csv;

import com.example.springbatch.entity.ExcelData;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;

import javax.sql.DataSource;

public class CsvItemWriter extends JdbcBatchItemWriter<ExcelData> {

    public  CsvItemWriter(DataSource dataSource) {
        setDataSource(dataSource);
        setSql("INSERT INTO excel_data (col1, col2, col3,col4,col5,col6,col7,col8,col9,col10,col11,col12) VALUES (:col1, :col2, :col3, :col4, :col5, :col6, :col7, :col8, :col9, :col10, :col11,:col12)");
        setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());


    }
}
