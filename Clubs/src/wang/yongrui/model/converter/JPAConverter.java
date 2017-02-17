/**
 *
 */
package wang.yongrui.model.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.converter.Converter;

/**
 * @author I323560
 * @param <S>
 * @param <T>
 *
 */
public class JPAConverter<S, T> implements Converter<S, T> {

    private Class<T> targetClass;

    /**
     * @param target
     */
    public JPAConverter(Class<T> targetClass) {
        super();
        this.targetClass = targetClass;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public T convert(S source) {
        T target = null;
        try {
            target = this.targetClass.newInstance();
            BeanUtils.copyProperties(source, target);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return target;
    }
}
