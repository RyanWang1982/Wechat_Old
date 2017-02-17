/**
 *
 */
package wang.yongrui.model.jpa.fundamental;

import java.util.Calendar;

import javax.persistence.EntityListeners;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

import wang.yongrui.model.jpa.User;

/**
 * @author I323560
 *
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AuditingEntity {

    @CreatedDate
    @JsonIgnore
    private Calendar createdDate;

    @CreatedBy
    @OneToOne
    @JoinColumn(name = "created_by_user_id")
    @JsonIgnore
    private User createdBy;

    @LastModifiedDate
    @JsonIgnore
    private Calendar lastModifiedDate;

    @LastModifiedBy
    @OneToOne
    @JoinColumn(name = "last_modified_by_user_id")
    @JsonIgnore
    private User lastModifiedBy;

    /**
     * @return the createdDate
     */
    public Calendar getCreatedDate() {
        return this.createdDate;
    }

    /**
     * @param createdDate
     *            the createdDate to set
     */
    public void setCreatedDate(Calendar createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * @return the createdBy
     */
    public User getCreatedBy() {
        return this.createdBy;
    }

    /**
     * @param createdBy
     *            the createdBy to set
     */
    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * @return the lastModifiedDate
     */
    public Calendar getLastModifiedDate() {
        return this.lastModifiedDate;
    }

    /**
     * @param lastModifiedDate
     *            the lastModifiedDate to set
     */
    public void setLastModifiedDate(Calendar lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    /**
     * @return the lastModifiedBy
     */
    public User getLastModifiedBy() {
        return this.lastModifiedBy;
    }

    /**
     * @param lastModifiedBy
     *            the lastModifiedBy to set
     */
    public void setLastModifiedBy(User lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

}
