/**
 *
 */
package wang.yongrui.repository.impl;

import javax.persistence.EntityManager;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import wang.yongrui.model.jpa.User;
import wang.yongrui.repository.UserRepository;

/**
 * @author I323560
 *
 */
@Repository
public class UserRepositoryImpl extends SimpleJpaRepository<User, Long> implements UserRepository {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserRepositoryImpl(EntityManager em) {
        super(User.class, em);
    }

    /*
     * (non-Javadoc)
     *
     * @see org.springframework.data.jpa.repository.support.SimpleJpaRepository#save(java.lang.Object)
     */
    @Override
    public <S extends User> S save(S entity) {
        if (StringUtils.isNotBlank(entity.getPassword())) {
            entity.setPassword(this.passwordEncoder.encode(entity.getPassword()));
        }

        return super.save(entity);
    }

    @Override
    public User findOneByName(String name) {
        User user = new User();
        user.setName(name);
        return super.findOne(Example.of(user));
    }

}
