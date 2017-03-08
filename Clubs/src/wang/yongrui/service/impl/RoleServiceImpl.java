/**
 *
 */
package wang.yongrui.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import wang.yongrui.model.converter.JPAConverter;
import wang.yongrui.model.jpa.Role;
import wang.yongrui.model.web.RoleSRLZ;
import wang.yongrui.repository.RoleRepository;
import wang.yongrui.service.RoleService;
import wang.yongrui.utils.PatchBeanUtils;

/**
 * @author Yongrui.Wang
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
        Role roleModel = new Role();
        BeanUtils.copyProperties(role, roleModel);
        return new RoleSRLZ(this.roleRepository.save(roleModel));
    }

    /*
     * (non-Javadoc)
     *
     * @see wang.yongrui.service.RoleService#retrieve(wang.yongrui.model.web.RoleSRLZ)
     */
    @Override
    public RoleSRLZ retrieve(RoleSRLZ role) {
        Role roleModel = new Role();
        BeanUtils.copyProperties(role, roleModel);
        return new RoleSRLZ(this.roleRepository.findOne(Example.of(roleModel)));
    }

    /*
     * (non-Javadoc)
     *
     * @see wang.yongrui.service.RoleService#retrieve(wang.yongrui.model.web.RoleSRLZ,
     * org.springframework.data.domain.Pageable)
     */
    @Override
    public Page<RoleSRLZ> retrievePage(RoleSRLZ role, Pageable pageable) {
        Role roleModel = new Role();
        BeanUtils.copyProperties(role, roleModel);
        Page<RoleSRLZ> rolePage = this.roleRepository.findAll(Example.of(roleModel), pageable)
                        .map(new JPAConverter<>(Role.class, RoleSRLZ.class));
        return rolePage;
    }

    /*
     * (non-Javadoc)
     *
     * @see wang.yongrui.service.RoleService#putUpdate(wang.yongrui.model.web.RoleSRLZ)
     */
    @Override
    public RoleSRLZ putUpdate(RoleSRLZ role) {
        Role roleModel = new Role();
        roleModel.setId(role.getId());
        roleModel = this.roleRepository.findOne(Example.of(roleModel));
        String[] ignoreArray = new String[] { "id", "activeStatus" };
        BeanUtils.copyProperties(role, roleModel, ignoreArray);
        return new RoleSRLZ(this.roleRepository.save(roleModel));
    }

    /*
     * (non-Javadoc)
     *
     * @see wang.yongrui.service.RoleService#patchUpdate(wang.yongrui.model.web.RoleSRLZ)
     */
    @Override
    public RoleSRLZ patchUpdate(RoleSRLZ role) {
        Role roleModel = new Role();
        roleModel.setId(role.getId());
        roleModel = this.roleRepository.findOne(Example.of(roleModel));
        String[] ignoreArray = new String[] { "id", "activeStatus" };
        PatchBeanUtils.patchProperties(role, roleModel, ignoreArray);
        return new RoleSRLZ(this.roleRepository.save(roleModel));
    }

    @Override
    public RoleSRLZ delete(RoleSRLZ role) {
        return null;
    }

}
