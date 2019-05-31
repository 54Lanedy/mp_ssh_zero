import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by liyue
 * Time 2019-03-27 9:00
 */
public class LinkHashMapTest {

    @Test
    public void t(){
        Map<String, String> map = new HashMap<String, String>();
        map.put("apple", "苹果");
        map.put("watermelon", "西瓜");
        map.put("banana", "香蕉");
        map.put("peach", "桃子");

        Iterator iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }
    @Test
    public void t2(){
        Map<String, String> map = new LinkedHashMap<>();
        map.put("apple", "苹果");
        map.put("watermelon", "西瓜");
        map.put("banana", "香蕉");
        map.put("peach", "桃子");

        map.get("apple");

        Iterator iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }

    @Test
    public void t3(){
        Map<String, String> map = new LinkedHashMap<>(16,0.75f,true);
        map.put("apple", "苹果");
        map.put("watermelon", "西瓜");
        map.put("banana", "香蕉");
        map.put("peach", "桃子");

        map.get("banana");
        map.get("apple");

        Iterator iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }

    @Test
    public void a(){
        int[] i = {1,2,3};
        for (int i1 = 0; i1 < i.length; i1++) {
            System.out.println(i[i1]);
        }

        int[] j = new int[3];
        j[0]=1;
        j[1]=2;
        j[2]=3;

        synchronized (this){

        }

    }
}
