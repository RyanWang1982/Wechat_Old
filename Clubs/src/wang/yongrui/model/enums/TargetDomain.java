/**
 *
 */
package wang.yongrui.model.enums;

/**
 * @author I323560
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
