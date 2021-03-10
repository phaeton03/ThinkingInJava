package ThinkingInJava.ContainersInDepth.P632;

import java.util.*;
//Exercise 15: (1) Repeat Exercise 13 using a SlowMap.
public class SlowMap<K,V> extends AbstractMap<K,V>  {

    private List<K> keys = new ArrayList<>();
    private List<V> values = new ArrayList<>();
    public V put(K key, V value){
        V oldValue = get(key);
        if(!keys.contains(key)) {
            keys.add(key);
            values.add(value);
        } else
            values.set(keys.indexOf(key), value);
        return oldValue;
    }
    public V get(Object key){
        if(!keys.contains(key))
            return null;
        return values.get(keys.indexOf(key));
    }

    @Override
    public Set<K> keySet() {
        return super.keySet();
    }

    @Override
    public void clear() {
        keys.clear();
        values.clear();
    }

    public Set<Map.Entry<K,V>> entrySet(){
        Set<Map.Entry<K,V>> set = new HashSet<>();
        Iterator<K> ki = keys.iterator();
        Iterator<V> vi = values.iterator();
        while(ki.hasNext())
            set.add(new MapEntry<K,V>(ki.next(), vi.next()));
        return set;
    }

    public static void main(String[] args) {
        HashMap<String,Integer> hm;
        HashSet<String> hs;
        String text = "hello, hello'! hello/.";
        String text2 = "Hi men ! Hi men !!! His name is men is";
        SlowMap<String,Integer> wordCounterMap = new SlowMap<>();
        wordCounterMap.put("ket", 90);
        //System.out.println(wordCounterMap.get("ket"));
        System.out.println(WordOccurenceMap.wordCounter(text2));
    }
}
