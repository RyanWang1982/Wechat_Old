/**
 *
 */
package wang.yongrui.model.jpa;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import wang.yongrui.model.jpa.basic.PermissionBasic;

/**
 * @author I323560
 *
 */
@Entity
public class Permission extends PermissionBasic {

    @ManyToMany
    @JoinTable(name = "role_permission", joinColumns = { @JoinColumn(name = "permission_id") }, inverseJoinColumns = {
                    @JoinColumn(name = "role_id") })
    private List<Role> roleList;

    /**
     * @return the roleList
     */
    public List<Role> getRoleList() {
        return this.roleList;
    }

    /**
     * @param roleList
     *            the roleList to set
     */
    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

}
