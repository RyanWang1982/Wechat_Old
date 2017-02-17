/**
 *
 */
package wang.yongrui.model.enums;

/**
 * @author I323560
 *
 */
public enum ActiveStatus {

    ACTIVE("Active"), INACTIVE("Inactive");

    private String description;

    /**
     * @param description
     */
    private ActiveStatus(String description) {
        this.description = description;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return this.description;
    }

}
