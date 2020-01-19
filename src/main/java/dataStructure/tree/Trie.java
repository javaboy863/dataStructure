package dataStructure.tree;

import util.FileOperation;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * 字典树
 */
public class Trie {

    private class Node{

        public boolean isWord;
        public TreeMap<Character, Node> next;

        public Node(boolean isWord){
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node(){
            this(false);
        }
    }

    private Node root;
    private int size;

    public Trie(){
        root = new Node();
        size = 0;
    }

    // 获得Trie中存储的单词数量
    public int getSize(){
        return size;
    }

    // 向Trie中添加一个新的单词word
    public void add(String word){
        //根部开始每个字符加到一个node里
        Node cur = root;
        for(int i = 0 ; i < word.length() ; i ++){
            char c = word.charAt(i);
            //这里注意，root默认有个node是empty 的map。
            if(cur.next.get(c) == null)
                cur.next.put(c, new Node());
            //指向下一个,这里的next是个node，node的value即是下一个节点，node的key则是字典的一个char。
            //这里对于一个新的，next node一定是empty的，到了上面方法的开始get c一定是null，所以会放个新的，也就是下一个了。
            cur = cur.next.get(c);
        }
        //一个单词分解完后，设置是个单词的标记
        if(!cur.isWord){
            cur.isWord = true;
            size ++;
        }
    }

    // 查询单词word是否在Trie中
    public boolean contains(String word){
        Node cur = root;
        for(int i = 0 ; i < word.length() ; i ++){
            char c = word.charAt(i);
            if(cur.next.get(c) == null)
                return false;
            cur = cur.next.get(c);
        }
        return cur.isWord;
    }

    // 查询是否在Trie中有单词以prefix为前缀
    public boolean isPrefix(String prefix){
        Node cur = root;
        for(int i = 0 ; i < prefix.length() ; i ++){
            char c = prefix.charAt(i);
            //只要能取到就继续，取不到代表不匹配
            if(cur.next.get(c) == null)
                return false;
            cur = cur.next.get(c);
        }

        return true;
    }

    public boolean match(String word) {
        return match(root, word, 0);
    }

    /**
     * 模式匹配 , abbc = a..c
     *
     */
    private boolean match(Node node, String word, int index){

         if(index == word.length())
            return node.isWord;
        char c = word.charAt(index);
        if(c != '.'){
            if(node.next.get(c) == null)
                return false;
            return match(node.next.get(c), word, index + 1);
        }
        else{
            for(char nextChar: node.next.keySet())
                //特殊匹配符.的情况下，跟下一个字符里的任意一个匹配上就算匹配上了
                 if(match(node.next.get(nextChar), word, index + 1))
                    return true;
            return false;
        }
    }

    public static void main(String[] args) {
        testMatch();

    }

    private static void testMatch() {
        Trie trie = new Trie();
        trie.add("abbc");
        trie.add("abcc");
        System.out.println(trie.match("a..c"));
    }

    private static void testCompare(){
        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile("/java/pride-and-prejudice.txt", words)){

            long startTime = System.nanoTime();

            BST<String> set = new BST<>();
            for(String word: words)
                set.add(word);

            for(String word: words)
                set.contains(word);

            long endTime = System.nanoTime();

            double time = (endTime - startTime) / 1000000000.0;

            System.out.println("Total different words: " + set.getSize());
            System.out.println("BSTSet: " + time + " s");

            // ---

            startTime = System.nanoTime();

            Trie trie = new Trie();
            for(String word: words)
                trie.add(word);

            for(String word: words)
                trie.contains(word);

            endTime = System.nanoTime();

            time = (endTime - startTime) / 1000000000.0;

            System.out.println("Total different words: " + trie.getSize());
            System.out.println("Trie: " + time + " s");
        }
    }
}
