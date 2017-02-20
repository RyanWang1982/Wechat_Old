/**
 *
 */
package wang.yongrui.security;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import wang.yongrui.model.enums.PermissionEnum;
import wang.yongrui.model.enums.TargetDomain;
import wang.yongrui.model.web.PermissionSRLZ;
import wang.yongrui.model.web.RoleSRLZ;
import wang.yongrui.model.web.UserSRLZ;
import wang.yongrui.service.UserService;

/**
 * @author I323560
 *
 */
@Component
public class RoleBasePermissionEvaluator implements PermissionEvaluator {

    @Autowired
    UserService userService;

    /*
     * (non-Javadoc)
     *
     * @see org.springframework.security.access.PermissionEvaluator#hasPermission(org.springframework.security.core.
     * Authentication, java.lang.Object, java.lang.Object)
     */
    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomain, Object permission) {
        boolean hasPermission = false;
        UserSRLZ user = new UserSRLZ();
        user.setName(authentication.getName());

        PermissionSRLZ perm = new PermissionSRLZ();
        perm.setTargetDomain(TargetDomain.valueOf(targetDomain.toString()));
        perm.setPermission(PermissionEnum.valueOf(permission.toString()));
        List<PermissionSRLZ> permissionList = new ArrayList<PermissionSRLZ>();
        permissionList.add(perm);
        RoleSRLZ role = new RoleSRLZ();
        role.setPermissionList(permissionList);
        List<RoleSRLZ> roleList = new ArrayList<RoleSRLZ>();
        roleList.add(role);
        user.setRoleList(roleList);

        if (CollectionUtils.isNotEmpty(this.userService.retrieve(user, null).getContent())) {
            hasPermission = true;
        }

        return hasPermission;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.springframework.security.access.PermissionEvaluator#hasPermission(org.springframework.security.core.
     * Authentication, java.io.Serializable, java.lang.String, java.lang.Object)
     */
    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType,
                    Object permission) {
        return false;
    }

}
