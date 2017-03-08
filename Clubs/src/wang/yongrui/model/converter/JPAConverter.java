/**
 *
 */
package wang.yongrui.model.converter;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.springframework.core.convert.converter.Converter;

/**
 * @author Yongrui.Wang
 * @param <S>
 * @param <T>
 *
 */
public class JPAConverter<S, T> implements Converter<S, T> {

    private Class<S> sourceClass;
    private Class<T> targetClass;

    /**
     * @param target
     */
    public JPAConverter(Class<S> sourceClass, Class<T> targetClass) {
        super();
        this.sourceClass = sourceClass;
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
            Constructor<T> constructor = this.targetClass.getConstructor(this.sourceClass);
            target = constructor.newInstance(source);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        // target = this.targetClass.newInstance();
        // BeanUtils.copyProperties(source, target);

        return target;
    }
}
