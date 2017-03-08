/**
 *
 */
package wang.yongrui.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import wang.yongrui.model.web.RoleSRLZ;

/**
 * @author Yongrui.Wang
 *
 */
public interface RoleService {

    public RoleSRLZ create(RoleSRLZ role);

    public RoleSRLZ retrieve(RoleSRLZ role);

    public Page<RoleSRLZ> retrievePage(RoleSRLZ role, Pageable pageable);

    public RoleSRLZ putUpdate(RoleSRLZ role);

    public RoleSRLZ patchUpdate(RoleSRLZ role);

    public RoleSRLZ delete(RoleSRLZ role);

}
