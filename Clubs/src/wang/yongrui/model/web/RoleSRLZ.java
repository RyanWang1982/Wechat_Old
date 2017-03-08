/**
 *
 */
package wang.yongrui.model.web;

import java.util.LinkedHashSet;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.GrantedAuthority;

import wang.yongrui.model.jpa.Permission;
import wang.yongrui.model.jpa.Role;
import wang.yongrui.model.jpa.basic.RoleBasic;

/**
 * @author Yongrui.Wang
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
        if (CollectionUtils.isNotEmpty(role.getPermissionSet())) {
            Set<PermissionSRLZ> PermissionSRLZSet = new LinkedHashSet<>();
            for (Permission permission : role.getPermissionSet()) {
                PermissionSRLZSet.add(new PermissionSRLZ(permission));
            }
            setPermissionSRLZSet(PermissionSRLZSet);
        }
    }

    private Set<PermissionSRLZ> permissionSRLZSet;

    /**
     * @return the permissionSRLZSet
     */
    public Set<PermissionSRLZ> getPermissionSRLZSet() {
        return this.permissionSRLZSet;
    }

    /**
     * @param permissionSRLZSet
     *            the permissionSRLZSet to set
     */
    public void setPermissionSRLZSet(Set<PermissionSRLZ> permissionSRLZSet) {
        this.permissionSRLZSet = permissionSRLZSet;
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
