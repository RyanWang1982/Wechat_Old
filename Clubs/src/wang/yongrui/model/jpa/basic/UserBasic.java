/**
 *
 */
package wang.yongrui.model.jpa.basic;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import wang.yongrui.model.enums.ActiveStatus;
import wang.yongrui.model.jpa.fundamental.AuditingEntity;

/**
 * @author Yongrui.Wang
 *
 */
@MappedSuperclass
public class UserBasic extends AuditingEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String name;

    @JsonProperty(access = Access.WRITE_ONLY)
    private String password;

    private String nickName;

    private String gender;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Calendar dateOfBirth;

    private Integer height;

    private Integer weight;

    private String portrait;

    private String selfIntroduce;

    private String weChatId;

    private String weChatOpenId;

    private String weChatUnionId;

    @Enumerated(value = EnumType.STRING)
    private ActiveStatus activeStatus;

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
     * @return the password
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * @param password
     *            the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the nickName
     */
    public String getNickName() {
        return this.nickName;
    }

    /**
     * @param nickName
     *            the nickName to set
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return this.gender;
    }

    /**
     * @param gender
     *            the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the dateOfBirth
     */
    public Calendar getDateOfBirth() {
        return this.dateOfBirth;
    }

    /**
     * @param dateOfBirth
     *            the dateOfBirth to set
     */
    public void setDateOfBirth(Calendar dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * @return the height
     */
    public Integer getHeight() {
        return this.height;
    }

    /**
     * @param height
     *            the height to set
     */
    public void setHeight(Integer height) {
        this.height = height;
    }

    /**
     * @return the weight
     */
    public Integer getWeight() {
        return this.weight;
    }

    /**
     * @param weight
     *            the weight to set
     */
    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    /**
     * @return the portrait
     */
    public String getPortrait() {
        return this.portrait;
    }

    /**
     * @param portrait
     *            the portrait to set
     */
    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    /**
     * @return the selfIntroduce
     */
    public String getSelfIntroduce() {
        return this.selfIntroduce;
    }

    /**
     * @param selfIntroduce
     *            the selfIntroduce to set
     */
    public void setSelfIntroduce(String selfIntroduce) {
        this.selfIntroduce = selfIntroduce;
    }

    /**
     * @return the weChatId
     */
    public String getWeChatId() {
        return this.weChatId;
    }

    /**
     * @param weChatId
     *            the weChatId to set
     */
    public void setWeChatId(String weChatId) {
        this.weChatId = weChatId;
    }

    /**
     * @return the weChatOpenId
     */
    public String getWeChatOpenId() {
        return this.weChatOpenId;
    }

    /**
     * @param weChatOpenId
     *            the weChatOpenId to set
     */
    public void setWeChatOpenId(String weChatOpenId) {
        this.weChatOpenId = weChatOpenId;
    }

    /**
     * @return the weChatUnionId
     */
    public String getWeChatUnionId() {
        return this.weChatUnionId;
    }

    /**
     * @param weChatUnionId
     *            the weChatUnionId to set
     */
    public void setWeChatUnionId(String weChatUnionId) {
        this.weChatUnionId = weChatUnionId;
    }

    /**
     * @return the activeStatus
     */
    public ActiveStatus getActiveStatus() {
        return this.activeStatus;
    }

    /**
     * @param activeStatus
     *            the activeStatus to set
     */
    public void setActiveStatus(ActiveStatus activeStatus) {
        this.activeStatus = activeStatus;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = (prime * result) + ((this.id == null) ? 0 : this.id.hashCode());
        return result;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        UserBasic other = (UserBasic) obj;
        if (this.id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!this.id.equals(other.id)) {
            return false;
        }
        return true;
    }

}
