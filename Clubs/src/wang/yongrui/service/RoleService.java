/**
 *
 */
package wang.yongrui.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import wang.yongrui.model.web.RoleSRLZ;

/**
 * @author I323560
 *
 */

public interface RoleService {

    public RoleSRLZ create(RoleSRLZ role);

    public Page<RoleSRLZ> retrieve(RoleSRLZ role, Pageable pageable);

    public RoleSRLZ putUpdate(RoleSRLZ role);

    public RoleSRLZ patchUpdate(RoleSRLZ role);

}
