package se.sdaproject;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.junit.jupiter.api.Assertions.assertFalse;

class LinkedListTests {

    @Test
    void addsTwoNumbers() {
        assertEquals(2, 1 + 1, "1 + 1 should equal 2");
    }

    @Test
    void addANumberToList() {
        LinkedList list = new LinkedList();
        list.add(5);
        String expected = "LinkedList(5)";
        assertEquals(list.toString(), expected);
    }

    @Test
    void testToStringOfEmptyList() {
        LinkedList list = new LinkedList();
        String expected = "LinkedList()";
        assertEquals(list.toString(), expected);
    }

    @Test
    void searchElementFromList(){
        LinkedList list = new LinkedList();
        list.add(8);
        list.add(7);
        Integer index = list.search(7);
        assertEquals(1,index);
    }

    @Test
    void search_EmptyList() {
        LinkedList list = new LinkedList();

        int expected = -1;
        assertEquals(list.search(7), expected);
    }

    @Test
    void search_NotFound() {
        LinkedList list = new LinkedList();
        list.add(5);
        list.add(7);
        list.add(10);

        int expected = -1;
        assertEquals(list.search(12), expected);
    }

    @Test
    void get_FullList() {
        LinkedList list = new LinkedList();
        list.add(5);
        list.add(7);
        list.add(10);

        int expected = 10;
        assertEquals(list.get(2).elem, expected);
    }

    @Test
    void get_EmptyList() {
        LinkedList list = new LinkedList();

        assertEquals(list.get(2), null);
    }

    @Test
    void size_FullList() {
        LinkedList list = new LinkedList();
        list.add(5);
        list.add(7);
        list.add(10);

        int expected = 3;
        assertEquals(list.size(), expected);
    }

    @Test
    void size_EmptyList() {
        LinkedList list = new LinkedList();

        int expected = 0;
        assertEquals(list.size(), expected);
    }

    @Test
    void remove_ListStartElement() {
        LinkedList list = new LinkedList();
        list.add(5);
        list.add(7);
        list.add(10);

        String expected = "LinkedList(7,10)";
        boolean remove = list.remove(5);
        assertEquals(expected, list.toString());
        assertTrue(remove);
    }

    @Test
    void remove_ListEndElement() {
        LinkedList list = new LinkedList();
        list.add(5);
        list.add(7);
        list.add(10);

        String expected = "LinkedList(5,7)";
        boolean remove = list.remove(10);
        assertEquals(expected, list.toString());
        assertTrue(remove);
    }
    @Test
    void remove_ListMiddleElement() {
        LinkedList list = new LinkedList();
        list.add(5);
        list.add(7);
        list.add(10);

        String expected = "LinkedList(5,10)";
        boolean remove = list.remove(7);
        assertEquals(expected, list.toString());
        assertTrue(remove);
    }

    @Test
    void remove_ListMissingElement() {
        LinkedList list = new LinkedList();
        list.add(5);
        list.add(7);
        list.add(10);

        String expected = "LinkedList(5,7,10)";
        boolean remove = list.remove(12);
        assertEquals(expected, list.toString());
        assertFalse(remove);
    }

    @Test
    void remove_EmptyList() {
        LinkedList list = new LinkedList();

        String expected = "LinkedList()";
        boolean remove = list.remove(5);
        assertEquals(expected, list.toString());
        assertFalse(remove);
    }
}
