/**
 *
 */
package wang.yongrui.model.web;

import java.util.List;

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

    private List<PermissionSRLZ> permissionList;

    /**
     * @return the permissionList
     */
    public List<PermissionSRLZ> getPermissionList() {
        return this.permissionList;
    }

    /**
     * @param permissionList
     *            the permissionList to set
     */
    public void setPermissionList(List<PermissionSRLZ> permissionList) {
        this.permissionList = permissionList;
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
