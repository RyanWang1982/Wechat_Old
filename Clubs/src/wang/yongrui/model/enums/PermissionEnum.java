/**
 *
 */
package wang.yongrui.model.enums;

/**
 * @author Yongrui.Wang
 *
 */
public enum PermissionEnum {

    CREATE("Create"), RETRIEVE("Retrieve"), UPDATE("Update"), DELETE("Delete"), DEACTIVATE("Deactivate");

    private String description;

    /**
     * @param description
     */
    private PermissionEnum(String description) {
        this.description = description;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return this.description;
    }

}
