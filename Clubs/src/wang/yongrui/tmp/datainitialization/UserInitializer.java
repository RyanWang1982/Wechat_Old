/**
 *
 */
package wang.yongrui.tmp.datainitialization;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.dozer.DozerBeanMapper;
import org.dozer.MappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import wang.yongrui.model.jpa.Permission;
import wang.yongrui.model.jpa.Role;
import wang.yongrui.model.jpa.User;
import wang.yongrui.repository.UserRepository;

/**
 * @author I323560
 *
 */
@Component
public class UserInitializer {

    @Autowired
    private DozerBeanMapper mapper;

    @Autowired
    private UserRepository repository;

    private static final String dataFileLocation = "./resources/InitialData/User.csv";
    private static final String roleDataFileLocation = "./resources/InitialData/Role.csv";
    private static final String permissionDataFileLocation = "./resources/InitialData/Permission.csv";

    @PostConstruct
    public void initial() {
        try {
            Set<Permission> permissionSet = new LinkedHashSet<>();
            CSVParser parser = new CSVParser(new FileReader(permissionDataFileLocation),
                            CSVFormat.EXCEL.withFirstRecordAsHeader());
            for (CSVRecord record : parser) {
                permissionSet.add(this.mapper.map(record.toMap(), Permission.class));
            }

            Set<Role> roleSet = new LinkedHashSet<>();
            parser = new CSVParser(new FileReader(roleDataFileLocation), CSVFormat.EXCEL.withFirstRecordAsHeader());
            for (CSVRecord record : parser) {
                Role role = this.mapper.map(record.toMap(), Role.class);
                role.setPermissionSet(permissionSet);
                roleSet.add(role);
            }

            List<User> userList = new ArrayList<>();
            parser = new CSVParser(new FileReader(dataFileLocation), CSVFormat.EXCEL.withFirstRecordAsHeader());
            for (CSVRecord record : parser) {
                User user = this.mapper.map(record.toMap(), User.class);
                user.setRoleSet(roleSet);
                userList.add(user);
            }

            parser.close();

            this.repository.save(userList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (MappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
