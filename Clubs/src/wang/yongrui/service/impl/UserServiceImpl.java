/**
 *
 */
package wang.yongrui.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import wang.yongrui.model.converter.JPAConverter;
import wang.yongrui.model.jpa.User;
import wang.yongrui.model.web.UserSRLZ;
import wang.yongrui.repository.UserRepository;
import wang.yongrui.service.UserService;
import wang.yongrui.utils.PatchBeanUtils;

/**
 * @author Yongrui.Wang
 *
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    /*
     * (non-Javadoc)
     *
     * @see wang.yongrui.business.UserService#create(wang.yongrui.model.web.UserSRLZ)
     */
    @Override
    public UserSRLZ create(UserSRLZ user) {
        User userModel = new User();
        BeanUtils.copyProperties(user, userModel);
        return new UserSRLZ(this.userRepository.save(userModel));
    }

    /*
     * (non-Javadoc)
     *
     * @see wang.yongrui.service.UserService#retrieve(wang.yongrui.model.web.UserSRLZ)
     */
    @Override
    public UserSRLZ retrieve(UserSRLZ user) {
        User userModel = new User();
        BeanUtils.copyProperties(user, userModel);
        return new UserSRLZ(this.userRepository.findOne(Example.of(userModel)));
    }

    /*
     * (non-Javadoc)
     *
     * @see wang.yongrui.service.UserService#retrieve(wang.yongrui.model.web.UserSRLZ)
     */
    @Override
    public Page<UserSRLZ> retrievePage(UserSRLZ user, Pageable pageable) {
        User userModel = new User();
        BeanUtils.copyProperties(user, userModel);
        Page<UserSRLZ> userPage = this.userRepository.findAll(Example.of(userModel), pageable)
                        .map(new JPAConverter<>(User.class, UserSRLZ.class));
        return userPage;
    }

    /*
     * (non-Javadoc)
     *
     * @see wang.yongrui.service.UserService#putUpdate(wang.yongrui.model.web.UserSRLZ)
     */
    @Override
    public UserSRLZ putUpdate(UserSRLZ user) {
        User userModel = new User();
        userModel.setId(user.getId());
        userModel = this.userRepository.findOne(Example.of(userModel));
        String[] ignoreArray = new String[] { "id", "activeStatus" };
        BeanUtils.copyProperties(user, userModel, ignoreArray);
        return new UserSRLZ(this.userRepository.save(userModel));
    }

    /*
     * (non-Javadoc)
     *
     * @see wang.yongrui.service.UserService#patchUpdate(wang.yongrui.model.web.UserSRLZ)
     */
    @Override
    public UserSRLZ patchUpdate(UserSRLZ user) {
        User userModel = new User();
        userModel.setId(user.getId());
        userModel = this.userRepository.findOne(Example.of(userModel));
        String[] ignoreArray = new String[] { "id", "activeStatus" };
        PatchBeanUtils.patchProperties(user, userModel, ignoreArray);
        return new UserSRLZ(this.userRepository.save(userModel));
    }

    /*
     * (non-Javadoc)
     *
     * @see wang.yongrui.service.UserService#delete(wang.yongrui.model.web.UserSRLZ)
     */
    @Override
    public UserSRLZ delete(UserSRLZ user) {
        return null;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new UserSRLZ(this.userRepository.findOneByName(username));
    }

}
