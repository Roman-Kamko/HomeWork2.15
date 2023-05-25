package edu.skypro.mylist.impl;

import edu.skypro.mylist.MyList;
import edu.skypro.mylist.exception.InvalidItemException;
import edu.skypro.mylist.exception.StorageIsFullException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class MyListImplTest {
    private MyList out;

    @BeforeEach
    void beforeEach() {
        out = new MyListImpl();

        out.add(5);
        out.add(1);
        out.add(9);
        out.add(3);
    }

    @Test
    void addTest() {
        Integer[] expected = {5, 1, 9, 3, 2};

        assertThat(out.add(2)).isIn(expected);
        assertThat(out.size()).isEqualTo(5);
        assertThat(out.lastIndexOf(2)).isEqualTo(4);
        assertThat(out.toArray()).isEqualTo(expected);
    }

    @Test
    void addNegativeTest1() {
        out.add(2);
        assertThatExceptionOfType(StorageIsFullException.class)
                .isThrownBy(() -> out.add(8));
    }

    @Test
    void addNegativeTest2() {
        assertThatExceptionOfType(InvalidItemException.class)
                .isThrownBy(() -> out.add(null));
    }

    @Test
    void addByIndexTest() {
        Integer[] expected = {5, 1, 100, 9, 3};

        assertThat(out.add(2, 100)).isIn(expected);
        assertThat(out.size()).isEqualTo(5);
        assertThat(out.indexOf(100)).isEqualTo(2);
        assertThat(out.toArray()).isEqualTo(expected);
    }

    @Test
    void addByIndexNegativeTest1() {
        out.add(1, 2);
        assertThatExceptionOfType(StorageIsFullException.class)
                .isThrownBy(() -> out.add(4, 8));
    }

    @Test
    void setTest() {
        Integer[] expected = {5, 1, 100, 3};
        assertThat(out.set(2, 100)).isIn(expected);
    }

    @Test
    void removeByElementTest() {
        Integer[] expected = {5, 1, 3};
        assertThat(out.remove(new Integer(9))).isNotIn(out.toArray());
    }

    @Test
    void removeByElementNegativeTest() {
        assertThatExceptionOfType(InvalidItemException.class)
                .isThrownBy(() -> out.remove(new Integer(65)));
    }

    @Test
    void removeByIndexTest() {
        Integer[] expected = {5, 1, 3};
        assertThat(out.remove(2)).isNotIn(out.toArray());
    }

    @Test
    void containsTest() {
        assertThat(out.contains(9)).isTrue();
    }

    @Test
    void getTest() {
        assertThat(out.get(0)).isEqualTo(5);
    }

    @Test
    void equalsTest() {
        MyList otherList = new MyListImpl();
        otherList.add(5);
        otherList.add(1);
        otherList.add(9);
        otherList.add(3);

        assertThat(out.equals(otherList)).isTrue();
    }

    @Test
    void isEmptyTest() {
        assertThat(out.isEmpty()).isFalse();
    }

    @Test
    void clearTest() {
        out.clear();
        assertThat(out.isEmpty()).isTrue();
    }
}