/**
 *
 */
package wang.yongrui.model.web;

import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.security.core.GrantedAuthority;

import wang.yongrui.model.jpa.Role;
import wang.yongrui.model.jpa.basic.RoleBasic;

/**
 * @author I323560
 *
 */
public class RoleSRLZ extends RoleBasic implements GrantedAuthority {

    /**
     *
     */
    private static final long serialVersionUID = 5743474482881147892L;

    /**
     *
     */
    public RoleSRLZ() {
        super();
    }

    /**
     * @param role
     */
    public RoleSRLZ(Role role) {
        super();
        BeanUtils.copyProperties(role, this);
    }

    private Set<PermissionSRLZ> permissionSet;

    /**
     * @return the permissionSet
     */
    public Set<PermissionSRLZ> getPermissionSet() {
        return this.permissionSet;
    }

    /**
     * @param permissionSet
     *            the permissionSet to set
     */
    public void setPermissionSet(Set<PermissionSRLZ> permissionSet) {
        this.permissionSet = permissionSet;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.springframework.security.core.GrantedAuthority#getAuthority()
     */
    @Override
    public String getAuthority() {
        return getName();
    }

}
