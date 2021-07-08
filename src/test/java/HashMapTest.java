import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

public class HashMapTest {
    @Test
    void putAndGetCheck(){
        Map<Integer, String> map = new HashMap<>();
        map.put(3, "value");
        String rez = map.get(3);

        assertEquals(rez, "value");
    }

    @Test
    void equalsCheck(){
        Map<Integer, String> map = new HashMap<>();
        Map<Integer, String> rez = new HashMap<>();
        map.put(1, "odin");
        map.put(4, "four");
        rez.put(1, "odin");
        rez.put(4, "four");
        assertEquals(map, rez);
    }

    @Test
    void isEmptyTrueCheck(){
        Map<Integer, String> map = new HashMap<>();
        boolean rez = map.isEmpty();

        assertTrue(rez);
    }

    @Test
    void isEmptyFalseCheck(){
        Map<Integer, String> map = new HashMap<>();
        map.put(3, "value");
        boolean rez = map.isEmpty();

        assertFalse(rez);
    }

    @Test
    void sizeCheck(){
        Map<Integer, String> map = new HashMap<>();
        map.put(4, "four");
        map.put(1, "odin");

        int rez = map.size();
        assertEquals(rez, 2);
    }

    @Test
    void clearCheck(){
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "odin");
        map.put(2, "dva");
        map.clear();

        int rez = map.size();
        assertEquals(rez, 0);
    }

    @Test
    void computeCheck(){
        Map<Integer, String> map = new HashMap<>();
        map.put(2, "dva");
        map.put(5,"five");
        map.compute(5,
                (key,value)->value += "5");

        String rez = map.get(5);
        assertEquals(rez, "five5");
    }

    @Test
    void computeIfAbsentCheck(){
        Map<Integer, String> map = new HashMap<>();
        map.put(2, "dva");
        map.put(5,"five");
        map.computeIfAbsent(7,
                key -> "seven" + key.toString());

        String rez = map.get(7);
        assertEquals(rez, "seven7");
    }

    @Test
    void computeIfPresentCheck(){
        Map<Integer, String> map = new HashMap<>();
        map.put(2, "dva");
        map.put(5,"five");
        map.computeIfPresent(5,
                (key, value) -> value+key.toString() );

        String rez = map.get(5);
        assertEquals(rez, "five5");
    }

    @Test
    void containsKeyTrueCheck(){
        Map<Integer, String> map = new HashMap<>();
        map.put(2, "dva");
        map.put(5,"five");

        boolean rez = map.containsKey(2);
        assertTrue(rez);
    }

    @Test
    void containsKeyFalseCheck(){
        Map<Integer, String> map = new HashMap<>();
        map.put(2, "dva");
        map.put(5,"five");

        boolean rez = map.containsKey(1);
        assertFalse(rez);
    }

    @Test
    void containsValueTrueCheck(){
        Map<Integer, String> map = new HashMap<>();
        map.put(2, "dva");
        map.put(5,"five");

        boolean rez = map.containsValue("five");
        assertTrue(rez);
    }

    @Test
    void containsValueFalseCheck(){
        Map<Integer, String> map = new HashMap<>();
        map.put(2, "dva");
        map.put(5,"five");

        boolean rez = map.containsValue("no");
        assertFalse(rez);
    }

    @Test
    void removeKeyCheck(){
        Map<Integer, String> map = new HashMap<>();
        Map<Integer, String> rez = new HashMap<>();
        rez.put(5,"five");
        map.put(2, "dva");
        map.put(5,"five");

        map.remove(2);
        assertEquals(map, rez);
    }

    @Test
    void removeKeyValueCheck(){
        Map<Integer, String> map = new HashMap<>();
        Map<Integer, String> rez = new HashMap<>();
        rez.put(5,"five");
        map.put(2, "dva");
        map.put(5,"five");

        map.remove(2, "dva");
        assertEquals(map, rez);
    }

    @Test
    void replaceCheck(){
        Map<Integer, String> map = new HashMap<>();
        Map<Integer, String> rez = new HashMap<>();
        map.put(2, "dva");
        map.put(5,"five");
        rez.put(2, "dva");
        rez.put(5,"pyat'");

        map.replace(5, "pyat'");
        assertEquals(map, rez);
    }

    @Test
    void replaceAllCheck(){
        Map<Integer, String> map = new HashMap<>();
        Map<Integer, String> rez = new HashMap<>();
        map.put(2, "dva");
        map.put(5,"five");
        rez.put(2, "val = 2");
        rez.put(5,"val = 5");

        map.replaceAll((key, value)-> value = "val = "+key.toString());
        assertEquals(map, rez);
    }

    @Test
    void putIfAbsentCheck(){
        Map<Integer, String> map = new HashMap<>();
        Map<Integer, String> rez = new HashMap<>();
        map.put(2, "dva");
        rez.put(2, "dva");
        rez.put(7,"seven");

        map.putIfAbsent(7, "seven");
        assertEquals(map, rez);
    }

    @Test
    void putIfAbsentNullCheck(){
        Map<Integer, String> map = new HashMap<>();
        map.put(2, "dva");
        map.put(7,"seven");

        var rez= map.putIfAbsent(9, "nayn");
        assertNull(rez);
    }

    @Test
    void putAllCheck(){
        Map<Integer, String> map = new HashMap<>();
        Map<Integer, String> storedMap = new HashMap<>();
        Map<Integer, String> rez = new HashMap<>();
        map.put(2, "dva");
        storedMap.put(4, "four");
        rez.put(2, "dva");
        rez.put(4, "four");

        map.putAll(storedMap);
        assertEquals(map, rez);
    }

    @Test
    void getOrDefaultGETCheck(){
        Map<Integer, String> map = new HashMap<>();
        map.put(2, "dva");
        map.put(3, "three");

        String rez = map.getOrDefault(3, "default");
        assertEquals(rez, "three");
    }

    @Test
    void getOrDefaultDEFAULTCheck(){
        Map<Integer, String> map = new HashMap<>();
        map.put(2, "dva");
        map.put(3, "three");

        String rez = map.getOrDefault(9, "default");
        assertEquals(rez, "default");
    }

    @Test
    void forEachCheck(){
        Map<Integer, String> map = new HashMap<>();
        Map<Integer, String> rez = new HashMap<>();
        map.put(2, "dva");
        map.put(3, "three");

        rez.put(2, "dva2");
        rez.put(3, "three3");
        map.forEach(
                (key, value)-> map.compute(key,
                                (k, v)-> v = v + k.toString()));

        assertEquals(map, rez);
    }

}

