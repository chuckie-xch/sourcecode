package concurrent.locks;

import org.junit.Test;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author xch
 * @version 1.00
 * @date 2017-12-28
 */
public class UnsafeTest {

    /**
     * 获取Unsafe实例
     * 会抛出java.lang.SecurityException: Unsafe异常
     *
     */
    @Test
    public void getUnsafeDirectiveTest() {
        Unsafe unsafe = Unsafe.getUnsafe();
        System.out.println(unsafe);
    }

    /**
     * 通过反射获取到Unsafe实例
     */
    @Test
    public void getUnsafeTest() throws NoSuchFieldException, IllegalAccessException {
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        Unsafe unsafe = (Unsafe) field.get(null);
        System.out.println(unsafe);
    }
}
