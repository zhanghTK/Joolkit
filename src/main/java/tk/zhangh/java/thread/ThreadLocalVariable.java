package tk.zhangh.java.thread;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 模拟ThreadLocal
 * Created by ZhangHao on 2016/4/6.
 */
public class ThreadLocalVariable <T>{
    private Map<Thread, T> container = Collections.synchronizedMap(new HashMap<Thread, T>());

    public void set(T value){
        container.put(Thread.currentThread(), value);
    }

    public T get(){
        Thread thread = Thread.currentThread();
        T value = container.get(thread);
        if (value == null && !container.containsKey(thread)){
            value = initiaValue();
            container.put(thread, value);
        }
        return value;
    }

    public void remove(){
        container.remove(Thread.currentThread());
    }

    protected T initiaValue(){
        return null;
    }
}