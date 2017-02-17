/**
 *
 */
package wang.yongrui.model.validator;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import wang.yongrui.model.jpa.ExtendedInfo;

/**
 * @author I323560
 *
 */
@Component("beforeCreateExtendedInfoValidator")
public class ExtendedInfoValidator implements Validator {

    /*
     * (non-Javadoc)
     *
     * @see org.springframework.validation.Validator#supports(java.lang.Class)
     */
    @Override
    public boolean supports(Class<?> clazz) {
        return ExtendedInfo.class.equals(clazz);
    }

    /*
     * (non-Javadoc)
     *
     * @see org.springframework.validation.Validator#validate(java.lang.Object, org.springframework.validation.Errors)
     */
    @Override
    public void validate(Object target, Errors errors) {
        ExtendedInfo extendedInfo = (ExtendedInfo) target;
        if (null == extendedInfo.getInfoValidation()) {
            errors.rejectValue("infoValidation", "infoValidation.empty");
        } else if (CollectionUtils.isEmpty(extendedInfo.getValueList())) {
            errors.rejectValue("valueList", "valueList.empty");
        } else {
            if (null == extendedInfo.getInfoValidation().getType()) {
                errors.rejectValue("infoValidation.type", "infoValidation.type.empty");
            }
        }
    }

}
