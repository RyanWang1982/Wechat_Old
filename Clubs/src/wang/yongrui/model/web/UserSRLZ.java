/**
 *
 */
package wang.yongrui.model.web;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import wang.yongrui.model.jpa.Role;
import wang.yongrui.model.jpa.User;
import wang.yongrui.model.jpa.basic.UserBasic;

/**
 * @author I323560
 *
 */
public class UserSRLZ extends UserBasic implements UserDetails {

    /**
     *
     */
    private static final long serialVersionUID = -4890178674161752799L;

    /**
     *
     */
    public UserSRLZ() {
        super();
    }

    /**
     * @param user
     */
    public UserSRLZ(User user) {
        super();
        BeanUtils.copyProperties(user, this);
        if (CollectionUtils.isNotEmpty(user.getRoleList())) {
            List<RoleSRLZ> roleSRLZList = new ArrayList<RoleSRLZ>();
            for (Role role : user.getRoleList()) {
                roleSRLZList.add(new RoleSRLZ(role));
            }
            setRoleList(roleSRLZList);
        }
    }

    private List<RoleSRLZ> roleList;

    private List<ExtendedInfoSRLZ> extendedInfoList;

    /**
     * @return the roleList
     */
    public List<RoleSRLZ> getRoleList() {
        return this.roleList;
    }

    /**
     * @param roleList
     *            the roleList to set
     */
    public void setRoleList(List<RoleSRLZ> roleList) {
        this.roleList = roleList;
    }

    /**
     * @return the extendedInfoList
     */
    public List<ExtendedInfoSRLZ> getExtendedInfoList() {
        return this.extendedInfoList;
    }

    /**
     * @param extendedInfoList
     *            the extendedInfoList to set
     */
    public void setExtendedInfoList(List<ExtendedInfoSRLZ> extendedInfoList) {
        this.extendedInfoList = extendedInfoList;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.security.core.userdetails.UserDetails#getAuthorities()
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoleList();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.security.core.userdetails.UserDetails#getUsername()
     */
    @Override
    public String getUsername() {
        return getName();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.security.core.userdetails.UserDetails#isAccountNonExpired()
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.security.core.userdetails.UserDetails#isAccountNonLocked()
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.security.core.userdetails.UserDetails#isCredentialsNonExpired()
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.security.core.userdetails.UserDetails#isEnabled()
     */
    @Override
    public boolean isEnabled() {
        return true;
    }

}
