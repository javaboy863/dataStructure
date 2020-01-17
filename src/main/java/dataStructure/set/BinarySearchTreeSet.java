package dataStructure.set;

import dataStructure.tree.BinarySearchTree;

public class BinarySearchTreeSet<E extends Comparable<E>,Value> implements Set<E> {

    private BinarySearchTree<E,Value> bst;

    public BinarySearchTreeSet(){
        bst = new BinarySearchTree<>();
    }

    @Override
    public int getSize(){
        return bst.size();
    }

    @Override
    public boolean isEmpty(){
        return bst.isEmpty();
    }

    @Override
    public void add(E e){
        bst.insert(e,null);
    }

    @Override
    public boolean contains(E e){
        return bst.search(e) != null;
    }

    @Override
    public void remove(E e){
        bst.remove(e);
    }

    public static void main(String[] args) {
        BinarySearchTreeSet listnodeSet = new BinarySearchTreeSet();
        for (int i = 0; i < 10; i++) {
            listnodeSet.add(i);
        }
        for (int i = 0; i < 10; i++) {
            listnodeSet.add(i);
        }

        System.out.println(listnodeSet.getSize());

    }
}
