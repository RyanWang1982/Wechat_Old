/**
 *
 */
package wang.yongrui.model.jpa.basic;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import wang.yongrui.model.enums.PermissionEnum;
import wang.yongrui.model.enums.TargetDomain;
import wang.yongrui.model.jpa.fundamental.AuditingEntity;

/**
 * @author I323560
 *
 */
@MappedSuperclass
public class PermissionBasic extends AuditingEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String description;

    @Enumerated(value = EnumType.STRING)
    private TargetDomain targetDomain;

    @Enumerated(value = EnumType.STRING)
    private PermissionEnum permission;

    /**
     * @return the id
     */
    public Long getId() {
        return this.id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * @param description
     *            the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the targetDomain
     */
    public TargetDomain getTargetDomain() {
        return this.targetDomain;
    }

    /**
     * @param targetDomain
     *            the targetDomain to set
     */
    public void setTargetDomain(TargetDomain targetDomain) {
        this.targetDomain = targetDomain;
    }

    /**
     * @return the permission
     */
    public PermissionEnum getPermission() {
        return this.permission;
    }

    /**
     * @param permission
     *            the permission to set
     */
    public void setPermission(PermissionEnum permission) {
        this.permission = permission;
    }

}
