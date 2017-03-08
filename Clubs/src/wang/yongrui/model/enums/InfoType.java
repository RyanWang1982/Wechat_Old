/**
 *
 */
package wang.yongrui.model.enums;

/**
 * @author Yongrui.Wang
 *
 */
public enum InfoType {

    SINGLEVALUE("Single Value"), MULTIPLEVALUE("Multiple Value");

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
