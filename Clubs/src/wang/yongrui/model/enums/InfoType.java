/**
 *
 */
package wang.yongrui.model.enums;

/**
 * @author I323560
 *
 */
public enum InfoType {

    NUMERIC("Numeric"), TEXT("Text"), MULTIPLETEXT("Multiple Text");

    private String description;

    /**
     * @param description
     */
    private InfoType(String description) {
        this.description = description;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return this.description;
    }

}
