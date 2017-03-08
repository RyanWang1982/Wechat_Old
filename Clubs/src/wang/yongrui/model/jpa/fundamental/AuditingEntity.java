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

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = (prime * result) + ((this.lastModifiedBy == null) ? 0 : this.lastModifiedBy.hashCode());
        result = (prime * result) + ((this.lastModifiedDate == null) ? 0 : this.lastModifiedDate.hashCode());
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
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        AuditingEntity other = (AuditingEntity) obj;
        if (this.lastModifiedBy == null) {
            if (other.lastModifiedBy != null) {
                return false;
            }
        } else if (!this.lastModifiedBy.equals(other.lastModifiedBy)) {
            return false;
        }
        if (this.lastModifiedDate == null) {
            if (other.lastModifiedDate != null) {
                return false;
            }
        } else if (!this.lastModifiedDate.equals(other.lastModifiedDate)) {
            return false;
        }
        return true;
    }

}
