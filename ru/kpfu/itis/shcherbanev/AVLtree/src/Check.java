import java.util.*;


// тут я посмотрел что если обойти дерево LNR то есть TreeSort то оно реально будет
// отсортированным. ну то есть проверил что каждый элемент на своем месте
public class Check {

    public static void main(String[] args) {
//        List<Integer> expected = new ArrayList<>();
//        AVLTree avlTree = new AVLTree();
//
//        Random random = new Random();
//        for (int i = 0; i < 10000; i++) {
//            int r = random.nextInt(0, 20000);
//            expected.add(r);
//            avlTree.insert(r);
//        }
//        expected.sort(Comparator.comparingInt(Integer::intValue));
//        String[] s = avlTree.toString().split(" ");
//        List<Integer> actual = new ArrayList<>();
//        for (String string : s) {
//            actual.add(Integer.parseInt(string));
//        }
//        System.out.println(actual.equals(expected));
//        System.out.println(avlTree.getRoot());
//        // equals для листов вернет тру если сайз и соответствующие элементы равны
//        avlTree.delete(11426);
//        System.out.println(avlTree);
        AVLTree avlTree = new AVLTree();
        avlTree.insert(1);
        avlTree.insert(2);
        avlTree.insert(3);
        avlTree.insert(4);
        System.out.println(avlTree.getRoot());
        System.out.println(avlTree.getRoot().left);
        System.out.println(avlTree.getRoot().right);
        System.out.println(avlTree.getRoot().right.right);
    }

}
