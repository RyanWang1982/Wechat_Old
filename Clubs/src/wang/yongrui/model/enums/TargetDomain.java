/**
 *
 */
package wang.yongrui.model.enums;

/**
 * @author Yongrui.Wang
 *
 */
public enum TargetDomain {

    USER("User"), ROLE("Role");

    private String description;

    /**
     * @param description
     */
    private TargetDomain(String description) {
        this.description = description;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return this.description;
    }

}
