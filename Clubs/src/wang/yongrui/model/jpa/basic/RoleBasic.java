/**
 *
 */
package wang.yongrui.model.jpa.basic;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import wang.yongrui.model.jpa.fundamental.AuditingEntity;

/**
 * @author I323560
 *
 */
@MappedSuperclass
public class RoleBasic extends AuditingEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String description;

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

}
