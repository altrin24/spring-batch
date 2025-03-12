package com.example.springbatch.file.csv;

import com.example.springbatch.entity.ExcelData;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.core.io.FileSystemResource;

public class CsvItemReader extends FlatFileItemReader<ExcelData> {

    public CsvItemReader(String filePath) {
        setResource(new FileSystemResource(filePath));
        setLinesToSkip(1); // Skip header row
        setLineMapper(new DefaultLineMapper<>() {{
            setLineTokenizer(new DelimitedLineTokenizer() {{
                setNames("col1", "col2", "col3","col4","col5","col6","col7","col8","col9","col10","col11","col12");
                setDelimiter(",");
                setStrict(false);
                setFieldSetMapper(fieldSet -> {
                    ExcelData data = new ExcelData();
                    data.setCol1(fieldSet.readString("col1"));
                    data.setCol2(fieldSet.readString("col2"));
                    data.setCol3(fieldSet.readString("col3"));
                    data.setCol4(fieldSet.readString("col4"));
                    data.setCol5(fieldSet.readString("col5"));
                    data.setCol6(fieldSet.readString("col6"));
                    data.setCol7(fieldSet.readString("col7"));
                    data.setCol8(fieldSet.readString("col8"));
                    data.setCol9(fieldSet.readString("col9"));
                    data.setCol10(fieldSet.readString("col10"));
                    data.setCol11(Thread.currentThread().getName());
                    data.setCol12(fieldSet.readString("col12"));
                    return data;
                });
            }});
    }

});
    }
}
