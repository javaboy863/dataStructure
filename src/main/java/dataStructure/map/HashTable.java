package dataStructure.map;

import java.util.TreeMap;

public class HashTable<K, V> {

    private static final int upperTol = 10;
    private static final int lowerTol = 2;
    private static final int initCapacity = 7;

    private TreeMap<K, V>[] hashtable;
    private int size;
    /**
     * 与一个数mod取余的值。根据hahs的数据量不同，可设置不同的值，使得hash分配更均匀。
     */
    private int M;

    public HashTable(int M){
        this.M = M;
        size = 0;
        hashtable = new TreeMap[M];
        for(int i = 0 ; i < M ; i ++)
            hashtable[i] = new TreeMap<>();
    }

    public HashTable(){
        this(initCapacity);
    }

    /**
     * 获取一个key的int hash。
     *0x7fffffff 代表int的最大值
     */
    private int hash(K key){
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public void add(K key, V value){
        TreeMap<K, V> map = hashtable[hash(key)];
        // if(!hashtable[hash(key)].containsKey(key)){
        if(!map.containsKey(key)){
            map.put(key, value);
            size ++;
            //扩容
            if(size >= upperTol * M)
                resize(2 * M);
        }
    }

    public V remove(K key){
        V ret = null;
        TreeMap<K, V> map = hashtable[hash(key)];
        if(map.containsKey(key)){
            ret = map.remove(key);
            size --;
            //缩容
            if(size <= lowerTol * M && M > initCapacity)
                resize(M / 2);
        }
        return ret;
    }

    public void set(K key, V value){
        TreeMap<K, V> map = hashtable[hash(key)];
        if(!map.containsKey(key))
            throw new IllegalArgumentException(key + " doesn't exist!");

        map.put(key, value);
    }

    public boolean contains(K key){
        return hashtable[hash(key)].containsKey(key);
    }

    public V get(K key){
        return hashtable[hash(key)].get(key);
    }

    /**
     * 复制俩map即可完成
     */
    private void resize(int newM){
        TreeMap<K, V>[] newHashTable = new TreeMap[newM];
        for(int i = 0 ; i < newM ; i ++)
            newHashTable[i] = new TreeMap<>();

        for(int i = 0 ; i < M ; i ++)
            for(K key: hashtable[i].keySet())
                newHashTable[hash(key)].put(key, hashtable[i].get(key));

        this.M = newM;
        this.hashtable = newHashTable;
    }
}
