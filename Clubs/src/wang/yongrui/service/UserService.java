/**
 *
 */
package wang.yongrui.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

import wang.yongrui.model.web.UserSRLZ;

/**
 * @author I323560
 *
 */
public interface UserService extends UserDetailsService {

    public UserSRLZ create(UserSRLZ user);

    public Page<UserSRLZ> retrieve(UserSRLZ user, Pageable pageable);

    public UserSRLZ putUpdate(UserSRLZ user);

    public UserSRLZ patchUpdate(UserSRLZ user);

    public UserSRLZ delete(UserSRLZ user);

}
