/**
 *
 */
package wang.yongrui.config;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.dozer.CustomFieldMapper;
import org.dozer.DozerBeanMapper;
import org.dozer.classmap.ClassMap;
import org.dozer.fieldmap.FieldMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author I323560
 *
 */
@Configuration
public class BeanMappingConfig {

    @Bean
    public DozerBeanMapper beanMapper() {
        DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();
        dozerBeanMapper.setCustomFieldMapper(customFieldMapper());

        return dozerBeanMapper;
    }

    @Bean
    public CustomFieldMapper customFieldMapper() {
        return new CustomFieldMapper() {

            @Override
            public boolean mapField(Object source, Object destination, Object sourceFieldValue, ClassMap classMap,
                            FieldMap fieldMap) {
                boolean isMappable = false;

                Class<?> destinationFieldType = fieldMap.getDestFieldType(destination.getClass());
                if (null != sourceFieldValue) {
                    if (Calendar.class.equals(destinationFieldType)) {
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        Calendar calendar = Calendar.getInstance();
                        try {
                            calendar.setTime(sdf.parse((String) sourceFieldValue));
                            fieldMap.writeDestValue(destination, calendar);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        isMappable = true;
                    }
                }

                return isMappable;
            }

        };
    }
}
