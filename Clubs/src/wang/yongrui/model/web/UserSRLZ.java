/**
 *
 */
package wang.yongrui.model.web;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

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
        if (CollectionUtils.isNotEmpty(user.getRoleSet())) {
            Set<RoleSRLZ> roleSRLZSet = new LinkedHashSet<>();
            for (Role role : user.getRoleSet()) {
                roleSRLZSet.add(new RoleSRLZ(role));
            }
            setRoleSRLZSet(roleSRLZSet);
        }
    }

    private Set<RoleSRLZ> roleSRLZSet;

    private List<ExtendedInfoSRLZ> extendedInfoList;

    /**
     * @return the roleSRLZSet
     */
    public Set<RoleSRLZ> getRoleSRLZSet() {
        return this.roleSRLZSet;
    }

    /**
     * @param roleSRLZSet
     *            the roleSRLZSet to set
     */
    public void setRoleSRLZSet(Set<RoleSRLZ> roleSRLZSet) {
        this.roleSRLZSet = roleSRLZSet;
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
        return getRoleSRLZSet();
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
