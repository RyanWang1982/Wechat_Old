/**
 *
 */
package wang.yongrui.config;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
                    if (destinationFieldType.isEnum()) {
                        fieldMap.writeDestValue(destination, getEnum(destinationFieldType, sourceFieldValue));
                        isMappable = true;
                    }
                }

                return isMappable;
            }

            private Object getEnum(Class<?> destinationClass, Object source) {
                Object enumeration = null;

                Method[] methods = destinationClass.getMethods();
                for (Method method : methods) {
                    if (method.getName().equalsIgnoreCase("valueOf")) {
                        try {
                            enumeration = method.invoke(destinationClass.getClass(), (String) source);
                        } catch (IllegalArgumentException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        }
                        return enumeration;
                    }
                }
                return null;
            }
        };
    }

}
