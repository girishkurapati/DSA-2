class Node {
    int id, height;
    Node left, right;

    Node(int id) {
        this.id = id;
        this.height = 1;
    }
}

public class DeliveryAVL {

    Node root;

    int height(Node n) {
        return (n == null) ? 0 : n.height;
    }

    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    Node rightRotate(Node y) {
        Node x = y.left;
        Node t2 = x.right;

        x.right = y;
        y.left = t2;

        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        return x;
    }

    Node leftRotate(Node x) {
        Node y = x.right;
        Node t2 = y.left;

        y.left = x;
        x.right = t2;

        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        return y;
    }

    int getBalance(Node n) {
        if (n == null)
            return 0;

        return height(n.left) - height(n.right);
    }

    Node insert(Node node, int id) {

        if (node == null)
            return new Node(id);

        if (id < node.id)
            node.left = insert(node.left, id);

        else if (id > node.id)
            node.right = insert(node.right, id);

        else
            return node;

        node.height = 1 + max(height(node.left),
                              height(node.right));

        int balance = getBalance(node);

        if (balance > 1 && id < node.left.id)
            return rightRotate(node);

        if (balance < -1 && id > node.right.id)
            return leftRotate(node);

        if (balance > 1 && id > node.left.id) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (balance < -1 && id < node.right.id) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    boolean search(Node root, int key) {

        if (root == null)
            return false;

        if (root.id == key)
            return true;

        if (key < root.id)
            return search(root.left, key);

        return search(root.right, key);
    }

    void inorder(Node node) {

        if (node != null) {

            inorder(node.left);

            System.out.print(node.id + " ");

            inorder(node.right);
        }
    }

    int countNodes(Node node) {

        if (node == null)
            return 0;

        return 1 +
                countNodes(node.left) +
                countNodes(node.right);
    }

    public static void main(String[] args) {

        DeliveryAVL tree = new DeliveryAVL();

        int partners[] = {
                205,210,201,230,220,
                215,225,240,235,245,
                250,200,198,207,212,
                260,255,265,270,275,
                280,290,285,295,300
        };

        for (int p : partners)
            tree.root = tree.insert(tree.root, p);

        System.out.println("======================================");
        System.out.println(" FOOD DELIVERY PARTNER MANAGEMENT");
        System.out.println("======================================");

        System.out.println("\nRegistered Delivery Partner IDs:");
        tree.inorder(tree.root);

        System.out.println("\n\nTotal Delivery Partners : "
                + tree.countNodes(tree.root));

        System.out.println("AVL Tree Height : "
                + tree.height(tree.root));

        int searchId = 275;

        System.out.println("\nSearching Partner ID : "
                + searchId);

        if (tree.search(tree.root, searchId))
            System.out.println("Partner Found");
        else
            System.out.println("Partner Not Found");

        System.out.println("\nSystem Status : ACTIVE");
    }
}