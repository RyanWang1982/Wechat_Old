/**
 *
 */
package wang.yongrui.model.jpa;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;

import wang.yongrui.model.enums.InfoType;

/**
 * @author I323560
 *
 */
@Entity
public class InfoValidation {

    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private InfoType type;

    @ElementCollection
    @JoinTable(name = "info_validation_value")
    @Column(name = "value")
    private List<String> valueList;

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
     * @return the type
     */
    public InfoType getType() {
        return this.type;
    }

    /**
     * @param type
     *            the type to set
     */
    public void setType(InfoType type) {
        this.type = type;
    }

    /**
     * @return the valueList
     */
    public List<String> getValueList() {
        return this.valueList;
    }

    /**
     * @param valueList
     *            the valueList to set
     */
    public void setValueList(List<String> valueList) {
        this.valueList = valueList;
    }

}
