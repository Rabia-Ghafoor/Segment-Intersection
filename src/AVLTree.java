import java.util.function.BiPredicate;

public class AVLTree<K> extends BinarySearchTree<K> {

    public AVLTree(BiPredicate<K, K> lessThan) {
        super(lessThan);
    }

    @Override
    public Node<K> insert(K key) {
        if (key == null) {
            // Handle null values appropriately, for example, ignore them or throw an exception
            return null; // Return null to maintain consistency with the return type
        }
        Node<K> insertedNode = super.insert(key);
        balanceTree(insertedNode.parent); // Start balancing from the parent of the inserted node
        return insertedNode; // Return the inserted node
    }


    public void remove(K key) {
        if (key == null) {
            // Handle null values appropriately, for example, ignore them or throw an exception
            return; // Return to maintain consistency with the return type
        }
        Node<K> removedNode = search(key); // Find the node containing the key
        if (removedNode != null) {
            super.remove(key);
            balanceTree(removedNode.parent); // Start balancing from the parent of the removed node
        }
    }
    private void balanceTree(Node<K> node) {
        while (node != null) {
            updateHeight(node); // Update height before checking balance
            int balance = getBalance(node);
            if (balance > 1) {
                if (getHeight(node.left.left) >= getHeight(node.left.right)) {
                    rotateRight(node);
                } else {
                    rotateLeft(node.left);
                    rotateRight(node);
                }
            } else if (balance < -1) {
                if (getHeight(node.right.right) >= getHeight(node.right.left)) {
                    rotateLeft(node);
                } else {
                    rotateRight(node.right);
                    rotateLeft(node);
                }
            }
            node = node.parent;
        }
    }

    private int getBalance(Node<K> node) {
        if (node == null) {
            return 0;
        } else {
            int leftHeight = (node.left == null) ? -1 : node.left.height;
            int rightHeight = (node.right == null) ? -1 : node.right.height;
            return leftHeight - rightHeight;
        }
    }

    public void rotateLeft(Node<K> node) {
        Node<K> pivot = node.right;
        node.right = pivot.left;
        if (pivot.left != null) {
            pivot.left.parent = node;
        }
        pivot.parent = node.parent;
        if (node.parent == null) {
            root = pivot;
        } else if (node == node.parent.left) {
            node.parent.left = pivot;
        } else {
            node.parent.right = pivot;
        }
        pivot.left = node;
        node.parent = pivot;

        updateHeight(node);
        updateHeight(pivot);
    }

    public void rotateRight(Node<K> node) {
        Node<K> pivot = node.left;
        node.left = pivot.right;
        if (pivot.right != null) {
            pivot.right.parent = node;
        }
        pivot.parent = node.parent;
        if (node.parent == null) {
            root = pivot;
        } else if (node == node.parent.right) {
            node.parent.right = pivot;
        } else {
            node.parent.left = pivot;
        }
        pivot.right = node;
        node.parent = pivot;

        updateHeight(node);
        updateHeight(pivot);
    }

    private int getHeight(Node<K> node) {
        return node == null ? -1 : node.height; // Access height directly from node
    }

    private void updateHeight(Node<K> node) {
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }



}
