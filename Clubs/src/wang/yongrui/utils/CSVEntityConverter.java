/**
 *
 */
package wang.yongrui.utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.dozer.DozerBeanMapper;
import org.dozer.MappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Yongrui.Wang
 *
 */
@Component
public class CSVEntityConverter<E> {

    @Autowired
    private DozerBeanMapper mapper;

    public List<E> getEntityList(String fileLocation, Class<E> entityClass) {
        List<E> entityList = new ArrayList<>();
        try {
            CSVParser parser = new CSVParser(new FileReader(fileLocation), CSVFormat.EXCEL.withFirstRecordAsHeader());
            for (CSVRecord record : parser) {
                entityList.add(this.mapper.map(record.toMap(), entityClass));
            }
            parser.close();
        } catch (MappingException | IOException e) {
            e.printStackTrace();
        }

        return entityList;
    }

}
