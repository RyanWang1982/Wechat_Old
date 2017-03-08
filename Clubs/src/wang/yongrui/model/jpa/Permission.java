/**
 *
 */
package wang.yongrui.model.jpa;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import wang.yongrui.model.jpa.basic.PermissionBasic;

/**
 * @author I323560
 *
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "targetDomain", "permission" }))
public class Permission extends PermissionBasic {

    @ManyToMany
    @JoinTable(name = "role_permission", joinColumns = { @JoinColumn(name = "permission_id") }, inverseJoinColumns = {
                    @JoinColumn(name = "role_id") })
    private Set<Role> roleSet;

    /**
     * @return the roleSet
     */
    public Set<Role> getRoleSet() {
        return this.roleSet;
    }

    /**
     * @param roleSet
     *            the roleSet to set
     */
    public void setRoleSet(Set<Role> roleSet) {
        this.roleSet = roleSet;
    }

}
