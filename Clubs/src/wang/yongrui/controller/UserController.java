/**
 *
 */
package wang.yongrui.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import wang.yongrui.model.web.UserSRLZ;
import wang.yongrui.service.UserService;

/**
 * @author I323560
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    @PreAuthorize("hasPermission('USER', 'CREATE')")
    public UserSRLZ create(@RequestBody UserSRLZ user) {
        return this.userService.create(user);
    }

    @PostMapping(path = "/retrieving")
    public Page<UserSRLZ> retrieve(@RequestBody UserSRLZ user, Pageable pageable) {
        return this.userService.retrievePage(user, pageable);
    }

    @PutMapping
    public UserSRLZ putUpdate(@RequestBody UserSRLZ user) {
        return this.userService.putUpdate(user);
    }

    @PatchMapping
    public UserSRLZ patchUpdate(@RequestBody UserSRLZ user) {
        return this.userService.patchUpdate(user);
    }

    @DeleteMapping
    public List<UserSRLZ> delete(@RequestBody UserSRLZ user) {
        return null;
    }

    @PutMapping(path = "/activeStatus")
    public UserSRLZ softDelete(@RequestBody UserSRLZ user) {
        return null;
    }

}
