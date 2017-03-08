/**
 *
 */
package wang.yongrui.model.jpa;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import wang.yongrui.model.jpa.basic.RoleBasic;

/**
 * @author Yongrui.Wang
 *
 */
@Entity
public class Role extends RoleBasic {

    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = { @JoinColumn(name = "role_id") }, inverseJoinColumns = {
                    @JoinColumn(name = "user_id") })
    private Set<User> userSet;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "role_permission", joinColumns = { @JoinColumn(name = "role_id") }, inverseJoinColumns = {
                    @JoinColumn(name = "permission_id") })
    private Set<Permission> permissionSet;

    /**
     * @return the userSet
     */
    public Set<User> getUserSet() {
        return this.userSet;
    }

    /**
     * @param userSet
     *            the userSet to set
     */
    public void setUserSet(Set<User> userSet) {
        this.userSet = userSet;
    }

    /**
     * @return the permissionSet
     */
    public Set<Permission> getPermissionSet() {
        return this.permissionSet;
    }

    /**
     * @param permissionSet
     *            the permissionSet to set
     */
    public void setPermissionSet(Set<Permission> permissionSet) {
        this.permissionSet = permissionSet;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = (prime * result) + ((this.permissionSet == null) ? 0 : this.permissionSet.hashCode());
        return result;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Role other = (Role) obj;
        if (this.permissionSet == null) {
            if (other.permissionSet != null) {
                return false;
            }
        } else if (!this.permissionSet.equals(other.permissionSet)) {
            return false;
        }
        return true;
    }

}
