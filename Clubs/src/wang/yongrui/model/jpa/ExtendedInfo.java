/**
 *
 */
package wang.yongrui.model.jpa;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;

/**
 * @author I323560
 *
 */
@Entity
public class ExtendedInfo {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String description;

    @OneToOne(cascade = CascadeType.ALL)
    private InfoValidation infoValidation;

    /**
     * For InfoValidation.InfoType other than "MultipleText", there will be ONLY ONE value;
     */
    @ElementCollection
    @JoinTable(name = "extended_info_value")
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
     * @return the infoValidation
     */
    public InfoValidation getInfoValidation() {
        return this.infoValidation;
    }

    /**
     * @param infoValidation
     *            the infoValidation to set
     */
    public void setInfoValidation(InfoValidation infoValidation) {
        this.infoValidation = infoValidation;
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
