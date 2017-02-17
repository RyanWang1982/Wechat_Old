/**
 * 
 */
package wang.yongrui.service;

import java.io.FileReader;

import javax.annotation.PostConstruct;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.dozer.DozerBeanMapper;

/**
 * @author I323560
 *
 */
public abstract class Initializer {

    /**
     * @return initializerConfig
     */
    public abstract InitializerConfig build();

    /**
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    @PostConstruct
    public void initial() throws Exception {
        InitializerConfig config = build();
        CSVParser parser = new CSVParser(new FileReader(config.getDataFileLocation()),
                        CSVFormat.EXCEL.withFirstRecordAsHeader());
        for (CSVRecord record : parser) {
            DozerBeanMapper mapper = new DozerBeanMapper();
            config.getRepository().save(mapper.map(record.toMap(), config.getEntityClass()));
        }
        parser.close();
    }

}
