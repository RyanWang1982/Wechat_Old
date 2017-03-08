/**
 *
 */
package wang.yongrui.model.web;

import java.io.Serializable;

import org.springframework.beans.BeanUtils;

import wang.yongrui.model.jpa.Permission;
import wang.yongrui.model.jpa.basic.PermissionBasic;

/**
 * @author Yongrui.Wang
 *
 */
public class PermissionSRLZ extends PermissionBasic implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -4960515835040276542L;

    /**
     *
     */
    public PermissionSRLZ() {
        super();
    }

    /**
     * @param permission
     */
    public PermissionSRLZ(Permission permission) {
        super();
        BeanUtils.copyProperties(permission, this);
    }

}
