/**
 *
 */
package wang.yongrui.tmp.datainitialization;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import wang.yongrui.model.jpa.Permission;
import wang.yongrui.model.jpa.Role;
import wang.yongrui.model.jpa.User;
import wang.yongrui.repository.UserRepository;
import wang.yongrui.utils.CSVEntityConverter;

/**
 * @author I323560
 *
 */
@Component
public class UserInitializer {

    @Autowired
    private UserRepository repository;

    @Autowired
    private CSVEntityConverter<Permission> permissionConverter;

    @Autowired
    private CSVEntityConverter<Role> roleConverter;

    @Autowired
    private CSVEntityConverter<User> userConverter;

    private static final String dataFileLocation = "./resources/InitialData/User.csv";
    private static final String roleDataFileLocation = "./resources/InitialData/Role.csv";
    private static final String permissionDataFileLocation = "./resources/InitialData/Permission.csv";

    @PostConstruct
    public void initial() {
        Set<Permission> permissionSet = new LinkedHashSet<>();
        permissionSet.addAll(this.permissionConverter.getEntityList(permissionDataFileLocation, Permission.class));

        Set<Role> roleSet = new LinkedHashSet<>();
        roleSet.addAll(this.roleConverter.getEntityList(roleDataFileLocation, Role.class));
        for (Role role : roleSet) {
            role.setPermissionSet(permissionSet);
        }

        List<User> userList = this.userConverter.getEntityList(dataFileLocation, User.class);
        for (User user : userList) {
            user.setRoleSet(roleSet);
        }

        this.repository.save(userList);
    }

}
