/**
 *
 */
package wang.yongrui.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import wang.yongrui.model.jpa.User;

/**
 * @author Yongrui.Wang
 *
 */
@NoRepositoryBean
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    User findOneByName(String name);

}
