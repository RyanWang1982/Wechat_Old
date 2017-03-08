/**
 *
 */
package wang.yongrui.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import wang.yongrui.model.jpa.Role;

/**
 * @author Yongrui.Wang
 *
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
