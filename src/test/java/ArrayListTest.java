import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListTest {
    @Test
    void addAndGetCheck(){
        List<Integer> a = new ArrayList<>();
        a.add(5);
        Integer rez = a.get(0);

        assertEquals(rez, 5);
    }

    @Test
    void addOnIndex(){
        List<Integer> a = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> rez = new ArrayList<>(Arrays.asList(1, 5, 2, 3));

        a.add(1, 5);
        assertEquals(a, rez);
    }

    @Test
    void toArrayCheck(){
        List<String> a = new ArrayList<>();
        a.add("one");
        a.add("two");
        a.add("three");

        String [] arr = a.toArray(new String[0]);
        String [] rez = new String[]{"one", "two", "three"};
        assertArrayEquals(arr, rez);
    }

    @Test
    void equalsCheckTrue(){
        List<Integer> a = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> b = new ArrayList<>(Arrays.asList(1, 2, 3));

        assertTrue(a.equals(b));
    }

    @Test
    void equalsCheckFalse(){
        List<Integer> a = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> b = new ArrayList<>(Arrays.asList(1, 2, 7));

        assertFalse(a.equals(b));
    }

    @Test
    void addAllCheck(){
        List<Integer> a = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> rez = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        a.addAll(Arrays.asList(4, 5));

        assertEquals(a, rez);
    }

    @Test
    void addAllOnIndexCheck(){
        List<Integer> a = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> rez = new ArrayList<>(Arrays.asList(1, 7, 8, 2, 3));
        a.addAll(1, Arrays.asList(7, 8));

        assertEquals(a, rez);
    }

    @Test
    void isEmptyTrueCheck(){
        List<Integer> a = new ArrayList<>();

        boolean rez = a.isEmpty();
        assertTrue(rez);
    }

    @Test
    void isEmptyFalseCheck(){
        List<Integer> a = new ArrayList<>(Arrays.asList(1, 2, 3));
        boolean rez = a.isEmpty();

        assertFalse(rez);
    }

    @Test
    void clearCheck(){
        List<Integer> a = new ArrayList<>(Arrays.asList(1, 2, 3));
        a.clear();

        boolean rez = a.isEmpty();
        assertTrue(rez);
    }

    @Test
    void containsTrueCheck(){
        List<Integer> a = new ArrayList<>(Arrays.asList(1, 2, 3));

        boolean rez = a.contains(2);
        assertTrue(rez);
    }

    @Test
    void containsFalseCheck(){
        List<Integer> a = new ArrayList<>(Arrays.asList(1, 2, 3));

        boolean rez = a.contains(7);
        assertFalse(rez);
    }

    @Test
    void containsAllTrueCheck(){
        List<Integer> a = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        boolean rez = a.containsAll(Arrays.asList(2, 3, 4));
        assertTrue(rez);
    }

    @Test
    void containsAllFalseCheck(){
        List<Integer> a = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        boolean rez = a.containsAll(Arrays.asList(3, 4, 8));

        assertFalse(rez);
    }

    @Test
    void removeObjectCheck(){
        List<Integer> a = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        List<Integer> rez = new ArrayList<>(Arrays.asList(1, 2, 3, 5));
        Integer t = 4;
        a.remove(t);

        assertEquals(a, rez);
    }

    @Test
    void removeIndexCheck(){
        List<Integer> a = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        List<Integer> rez = new ArrayList<>(Arrays.asList(2, 3, 4, 5));
        a.remove(0);

        assertEquals(a, rez);
    }

    @Test
    void indexOfCheck(){
        List<Integer> a = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        Integer t = 3;
        int rez = a.indexOf(t);

        assertEquals(2, rez);
    }

    @Test
    void lastIndexOfCheck(){
        List<Integer> a = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 3, 6));
        Integer t = 3;
        int rez = a.lastIndexOf(t);

        assertEquals(5, rez);
    }


    @Test
    void setCheck(){
        List<Integer> a = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 3, 6));
        List<Integer> rez = new ArrayList<>(Arrays.asList(1, 8, 3, 4, 5, 3, 6));
        a.set(1, 8);

        assertEquals(rez, a);
    }

    @Test
    void sizeCheck(){
        List<Integer> a = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 3, 6));
        int rez = a.size();

        assertEquals(7, rez);
    }

    @Test
    void subListCheck(){
        List<Integer> a = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 3, 6));
        List<Integer> rez = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        List<Integer> b = a.subList(0, 4);

        assertEquals(b, rez);
    }

}
