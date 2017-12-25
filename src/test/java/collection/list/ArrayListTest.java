package collection.list;

import com.bestcode.sourcecode.collection.list.ArrayList;
import com.bestcode.sourcecode.collection.list.List;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Iterator;

public class ArrayListTest {
//
//    @Test
//    public void testIteratorRemove() {
//        List<Integer> list = new ArrayList<Integer>();
//        list.add(10);
//        Iterator<Integer> iterator = list.iterator();
//        while (iterator.hasNext()) {
//            Integer integer = iterator.next();
//            if (integer == 10) {
//                list.remove(integer);
//            }
//        }
//    }

    /**
     * 测试ArrayList的扩容规则
     * 10 -> 15 -> 22 -> 33 -> 49
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    @Test
    public void testCapacity() throws NoSuchFieldException, IllegalAccessException {
        List list = new ArrayList<Integer>();
        for (int i = 0; i < 33; i++) {
            list.add(i);
        }
        list.add(0);
        Class<?> classType = list.getClass();
        Field field = classType.getDeclaredField("elementData");
        field.setAccessible(true);
        Object[] elementData = (Object[]) field.get(list);
        System.out.println(elementData.length );
    }

    @Test
    public void testEquals() {
        Object[] obj = new Object[3];
        Object[] obj2 = {};
        System.out.println(obj == obj2);
    }




}
