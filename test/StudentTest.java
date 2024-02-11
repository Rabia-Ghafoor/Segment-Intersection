import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import java.util.Random;

import static java.lang.Math.log;

public class StudentTest {



    @Test
    public void insertSmallBST() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>((Integer x, Integer y) -> x < y);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int[] a = new int[]{4, 8, 0, 2, 6, 10};
        /*
         *       4
         *     /  \
         *    /    \
         *   0      8
         *    \    / \
         *     2  6   10
         */
        for (Integer key : a) {
            bst.insert(key);
            map.put(key, key);
        }
        for (int i = 0; i != 11; ++i) {
            assertEquals(bst.contains(i), map.containsKey(i));
        }
    }

    @Test
    public void insertSmallAVL() {
        AVLTree<Integer> avl = new AVLTree<>((Integer x, Integer y) -> x < y);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int[] a = new int[]{4, 8, 0, 2, 6, 10};
        /*
         *       4
         *     /  \
         *    /    \
         *   0      8
         *    \    / \
         *     2  6   10
         */
        for (Integer key : a) {
            avl.insert(key);
            map.put(key, key);
        }
        for (int i = 0; i != 11; ++i) {
            assertEquals(avl.contains(i), map.containsKey(i));
        }
    }

    @Test
    public void insertLargeBST() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>((Integer x, Integer y) -> x < y);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Random rand = new Random(0);
        for (int i = 0; i != 1000; ++i) {
            int key = rand.nextInt();
            bst.insert(key);
            map.put(key, key);
        }
        for (int i = 0; i != 1000; ++i) {
            assertEquals(bst.contains(i), map.containsKey(i));
        }
    }

    @Test
    public void insertLargeAVL() {
        AVLTree<Integer> avl = new AVLTree<>((Integer x, Integer y) -> x < y);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Random rand = new Random(0);
        for (int i = 0; i != 1000; ++i) {
            int key = rand.nextInt();
            avl.insert(key);
            map.put(key, key);
        }
        for (int i = 0; i != 1000; ++i) {
            assertEquals(avl.contains(i), map.containsKey(i));
        }
    }

    @Test
    public void testLargeAVLRemove() {
        AVLTree<Integer> avl = new AVLTree<>((Integer x, Integer y) -> x < y);
        Random rand = new Random(0);
        for (int i = 0; i != 1000; ++i) {
            avl.insert(rand.nextInt());
        }
        for (int i = 0; i != 1000; ++i) {
            avl.remove(i);
        }
        assertEquals(avl.height(), -1);
    }

    @Test
    public void testLargeAVLInsert() {
        AVLTree<Integer> avl = new AVLTree<>((Integer x, Integer y) -> x < y);
        Random rand = new Random(0);
        for (int i = 0; i != 1000; ++i) {
            avl.insert(rand.nextInt());
        }
        assertEquals(avl.height(), (int) (log(1000) / log(2)));
    }





        /**
         * TODO: Test cases
         */
    @Test
    public void test() {
        insertSmallBST();
        insertSmallAVL();
        insertLargeBST();
        insertLargeAVL();





//        testRotateLeft();
        // your tests go here
    }



}
