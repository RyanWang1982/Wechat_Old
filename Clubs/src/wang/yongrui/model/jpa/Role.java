/**
 *
 */
package wang.yongrui.model.jpa;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import wang.yongrui.model.jpa.basic.RoleBasic;

/**
 * @author I323560
 *
 */
@Entity
public class Role extends RoleBasic {

    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = { @JoinColumn(name = "role_id") }, inverseJoinColumns = {
                    @JoinColumn(name = "user_id") })
    private List<User> userList;

    @ManyToMany
    @JoinTable(name = "role_permission", joinColumns = { @JoinColumn(name = "role_id") }, inverseJoinColumns = {
                    @JoinColumn(name = "permission_id") })
    private List<Permission> permissionList;

    /**
     * @return the userList
     */
    public List<User> getUserList() {
        return this.userList;
    }

    /**
     * @param userList
     *            the userList to set
     */
    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    /**
     * @return the permissionList
     */
    public List<Permission> getPermissionList() {
        return this.permissionList;
    }

    /**
     * @param permissionList
     *            the permissionList to set
     */
    public void setPermissionList(List<Permission> permissionList) {
        this.permissionList = permissionList;
    }

}
