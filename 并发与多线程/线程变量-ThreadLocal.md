# 线程变量-ThreadLocal

### 一，概述

+ ThreadLocal是线程变量，是一个以ThreadLocal对象为主键，任意对象为值的存储结构。这个结构被附带到线程上，也就是说一个线程可以根据一个ThreadLocal对象查询到绑定在这个线程上的值。

### 二，应用场景

+ 解决的是为了每个线程绑定自己的值，以方便其处理自己的状态。

  例子：

  ~~~ java
  
  import java.lang.*;
  
  import com.sun.corba.se.impl.orbutil.StackImpl;
  public class ThreadLocalTest{
      private static ThreadLocal<String> name=new ThreadLocal<>();
      private static ThreadLocal<Long> id=new ThreadLocal<>();
      public static String getName(){
          return name.get();
      }
      public static Long getId(){
          return id.get();
      }
      public static void main(String[] args){
          Thread[] arr=new Thread[5];
          for(int i=0;i<5;i++){
              arr[i]=new Thread(()->{
                  name.set(Thread.currentThread().getName());
                  id.set(Thread.currentThread().getId());
                  System.out.println("name:"+ThreadLocalTest.getName()+"  id:"+ThreadLocalTest.getId());               
              });
              arr[i].start();
          }
  
      }
  }
  /*
  name:Thread-1  id:11
  name:Thread-3  id:13
  name:Thread-4  id:14
  name:Thread-0  id:10
  name:Thread-2  id:12
  */
  ~~~

### 理解

+ 每个线程内部都有一个ThreadLocal.ThreadLocalMap类型的成员变量ThreadLocals，这个变量存储了所有ThreadLocal变量机对应的value值。

  ~~~ java
  public T get() {
          Thread t = Thread.currentThread();
          ThreadLocalMap map = getMap(t);  //获取当前线程的ThreadLocalMap的实例对象threadLocals
          if (map != null) {
              ThreadLocalMap.Entry e = map.getEntry(this);   //获取变量所对应的值
              if (e != null) {
                  @SuppressWarnings("unchecked")
                  T result = (T)e.value;
                  return result;
              }
          }
          return setInitialValue();
      }
  ~~~

  当e为空的时候，就调用setInitialValue()方法，该方法如下所示

  ~~~ java
  private T setInitialValue() {
          T value = initialValue();    //默认为空null
          Thread t = Thread.currentThread();
          ThreadLocalMap map = getMap(t);
          if (map != null)
              map.set(this, value);
          else
              createMap(t, value);
          return value;              //返回value空值
      }
  ~~~


+ get()函数的过程

  获取每个线程所拥有的ThreadLocalMa对象实例threadLocals，然后由该对象根据ThreadLocal对象来去获取相应的value值，如果value值为null，调用setInitiavalue()函数去获取对应的value值(null)。