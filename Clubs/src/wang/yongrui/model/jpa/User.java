/**
 *
 */
package wang.yongrui.model.jpa;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import wang.yongrui.model.jpa.basic.UserBasic;

/**
 * @author I323560
 *
 */
@Entity
public class User extends UserBasic {

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_extended_info", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
                    @JoinColumn(name = "extended_info_id") })
    private List<ExtendedInfo> extendedInfoList;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
                    @JoinColumn(name = "role_id") })
    private List<Role> roleList;

    /**
     * @return the extendedInfoList
     */
    public List<ExtendedInfo> getExtendedInfoList() {
        return this.extendedInfoList;
    }

    /**
     * @param extendedInfoList
     *            the extendedInfoList to set
     */
    public void setExtendedInfoList(List<ExtendedInfo> extendedInfoList) {
        this.extendedInfoList = extendedInfoList;
    }

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
