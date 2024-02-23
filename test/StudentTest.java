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

        assertEquals(avl.height(), 2);
        assertEquals(avl.size(), 6);
//        assertEquals(avl.height(), 3);

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
    public void removeBST(){
        BinarySearchTree<Integer> bst = new BinarySearchTree<>((Integer x, Integer y) -> x < y);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Random rand = new Random(0);
        bst.insert(1);
        bst.insert(2);
        bst.insert(3);

//        for (int i = 0; i != 1000; ++i) {
//            int key = rand.nextInt();
//            bst.insert(key);
//            map.put(key, key);
//        }
//        for (int i = 0; i != 1000; ++i) {
//            assertEquals(bst.contains(i), map.containsKey(i));
//        }
        assertEquals(1, 1);

        bst.remove(3);
        assertEquals(bst.contains(3), false);
        assertEquals(bst.size(), 2);

    }




    @Test
    public void sizeBST(){

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
        assertEquals(bst.size(), 1000);





    }
    @Test
    public void insertLargeAVL() {
        AVLTree<Integer> avl = new AVLTree<>((Integer x, Integer y) -> x < y);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Random rand = new Random(0);
        for (int i = 0; i != 1000; ++i) {
            int key = rand.nextInt();
            avl.insert(i);
            map.put(i, i);
        }
        for (int i = 0; i != 1000; ++i) {
            assertEquals(avl.contains(i), map.containsKey(i));
        }

        assertTrue(avl.isAVL());



    }

    @Test
    public void testLargeAVLRemove() {
        AVLTree<Integer> avl = new AVLTree<>((Integer x, Integer y) -> x < y);
    //    Random rand = new Random(0);
        for (int i = 0; i != 1000; ++i) {
     //       avl.insert(rand.nextInt()
            avl.insert(i);
        }
//          System.out.println(rand.nextInt());
//        }
//        for (int i = 0; i != 1000; ++i) {
//            avl.remove(i);
//        //    System.out.println(avl.size());
//        }

        avl.remove(2);

        assertEquals(avl.contains(2), false);
        assertEquals(avl.size(), 999);

        //  assertEquals(avl.size(), 1000);


    }

    @Test
    public void testLargeAVLInsert() {
        AVLTree<Integer> avl = new AVLTree<>((Integer x, Integer y) -> x < y);
        Random rand = new Random(0);
        for (int i = 0; i != 1000; ++i) {
            avl.insert(rand.nextInt());
        }

        assertEquals(avl.size(), 1000);



    }

        /**
         * TODO: Test cases
         */
        @Test
        public void testRotateRight() {
            AVLTree<Integer> avl = new AVLTree<>((Integer x, Integer y) -> x < y);
            avl.insert(1);
            avl.insert(2);
            avl.insert(3);
            assertEquals(avl.root.data, 2);
            assertEquals(avl.root.left.data, 1);
            assertEquals(avl.root.right.data, 3);
        }

        @Test
       public void testRotateLeft(){
            AVLTree<Integer> avl = new AVLTree<>((Integer x, Integer y) -> x < y);
            avl.insert(3);
            avl.insert(2);
            avl.insert(1);
            assertEquals(avl.root.data, 2);
            assertEquals(avl.root.left.data, 1);
            assertEquals(avl.root.right.data, 3);
        }



    @Test
    public void test() {
        insertSmallBST();
        insertSmallAVL();
        insertLargeBST();
        insertLargeAVL();
        testLargeAVLRemove();
        testLargeAVLInsert();
        testRotateRight();
        testRotateLeft();

    }



}
