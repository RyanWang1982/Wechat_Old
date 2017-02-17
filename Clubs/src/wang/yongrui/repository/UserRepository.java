/**
 *
 */
package wang.yongrui.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import wang.yongrui.model.jpa.User;

/**
 * @author I323560
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    User findOneByName(String name);

}
