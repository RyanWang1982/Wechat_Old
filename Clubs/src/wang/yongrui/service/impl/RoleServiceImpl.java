/**
 *
 */
package wang.yongrui.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import wang.yongrui.model.web.RoleSRLZ;
import wang.yongrui.repository.RoleRepository;
import wang.yongrui.service.RoleService;

/**
 * @author I323560
 *
 */
@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    /*
     * (non-Javadoc)
     *
     * @see wang.yongrui.service.RoleService#create(wang.yongrui.model.web.RoleSRLZ)
     */
    @Override
    public RoleSRLZ create(RoleSRLZ role) {
        return null;
    }

    /*
     * (non-Javadoc)
     *
     * @see wang.yongrui.service.RoleService#retrieve(wang.yongrui.model.web.RoleSRLZ,
     * org.springframework.data.domain.Pageable)
     */
    @Override
    public Page<RoleSRLZ> retrieve(RoleSRLZ role, Pageable pageable) {
        return null;
    }

    /*
     * (non-Javadoc)
     *
     * @see wang.yongrui.service.RoleService#putUpdate(wang.yongrui.model.web.RoleSRLZ)
     */
    @Override
    public RoleSRLZ putUpdate(RoleSRLZ role) {
        return null;
    }

    /*
     * (non-Javadoc)
     *
     * @see wang.yongrui.service.RoleService#patchUpdate(wang.yongrui.model.web.RoleSRLZ)
     */
    @Override
    public RoleSRLZ patchUpdate(RoleSRLZ role) {
        return null;
    }

}
