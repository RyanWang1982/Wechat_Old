/**
 *
 */
package wang.yongrui.model.web;

import java.io.Serializable;

import org.springframework.beans.BeanUtils;

import wang.yongrui.model.jpa.ExtendedInfo;

/**
 * @author I323560
 *
 */
public class ExtendedInfoSRLZ extends ExtendedInfo implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1068908426590357822L;

    /**
     *
     */
    public ExtendedInfoSRLZ() {
        super();
    }

    /**
     *
     */
    public ExtendedInfoSRLZ(ExtendedInfo extendedInfo) {
        BeanUtils.copyProperties(extendedInfo, this);
    }

}
