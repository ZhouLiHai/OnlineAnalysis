# JUC

## 基本概况

Java JUC包的主体结构：

1. Atomic : AtomicInteger
2. Locks : Lock, Condition, ReadWriteLock
3. Collections : Queue, ConcurrentMap
4. Executer : Future, Callable, Executor
5. Tools : CountDownLatch, CyclicBarrier, Semaphore

## 原子操作

多个线程执行一个操作时，其中任何一个线程要么完全执行完此操作，要么没有执行此操作的任何步骤，那么这个操作就是原子的。出现原因: synchronized的代价比较高。

以下以AtomicInteger为例：

1. int addAndGet(int delta)：以原子方式将给定值与当前值相加。 实际上就是等于线程安全版本的i =i+delta操作。
2. boolean compareAndSet(int expect, int update)：如果当前值 == 预期值，则以原子方式将该值设置为给定的更新值。 如果成功就返回true，否则返回false，并且不修改原值。
3. int decrementAndGet()：以原子方式将当前值减 1。 相当于线程安全版本的–i操作。
4. int getAndAdd(int delta)：以原子方式将给定值与当前值相加。 相当于线程安全版本的t=i;i+=delta;return t;操作。
5. int getAndDecrement()：以原子方式将当前值减 1。 相当于线程安全版本的i–操作。
6. int getAndIncrement()：以原子方式将当前值加 1。 相当于线程安全版本的i++操作。
7. int getAndSet(int newValue)：以原子方式设置为给定值，并返回旧值。 相当于线程安全版本的t=i;i=newValue;return t;操作。
8. int incrementAndGet()：以原子方式将当前值加 1。 相当于线程安全版本的++i操作。

## 指令重排

你的程序并不能总是保证符合CPU处理的特性。

要程序的最终结果等同于它在严格的顺序化环境下的结果，那么指令的执行顺序就可能与代码的顺序不一致。

## Happens-before法则：（Java 内存模型）

如果动作B要看到动作A的执行结果（无论A/B是否在同一个线程里面执行），那么A/B就需要满足happens-before关系。

Happens-before的几个规则：

1. Program order rule：同一个线程中的每个Action都happens-before于出现在其后的任何一个Action。
2. Monitor lock rule：对一个监视器的解锁happens-before于每一个后续对同一个监视器的加锁。
3. Volatile variable rule：对volatile字段的写入操作happens-before于每一个后续的同一个字段的读操作。
4. Thread start rule：Thread.start()的调用会happens-before于启动线程里面的动作。
5. Thread termination rule：Thread中的所有动作都happens-before于其他线程检查到此线程结束或者Thread.join（）中返回或者Thread.isAlive()==false。
6. Interruption rule：一个线程A调用另一个另一个线程B的interrupt（）都happens-before于线程A发现B被A中断（B抛出异常或者A检测到B的isInterrupted（）或者interrupted()）。
7. Finalizer rule：一个对象构造函数的结束happens-before与该对象的finalizer的开始
8. Transitivity：如果A动作happens-before于B动作，而B动作happens-before与C动作，那么A动作happens-before于C动作。

因为CPU是可以不按我们写代码的顺序执行内存的存取过程的，也就是指令会乱序或并行运行， 只有上面的happens-before所规定的情况下，才保证顺序性。

### JMM的特性：

多个CPU之间的缓存也不保证实时同步；

JMM不保证创建过程的原子性，读写并发时，可能看到不完整的对象。（so D-check）

### volatile语义：

volatile实现了类似synchronized的语义，却又没有锁机制。它确保对  volatile字段的更新以可预见的方式告知其他的线程。

Java 存储模型不会对volatile指令的操作进行重排序：这个保证对volatile变量的操作时按照指令的出现顺序执行的。

volatile变量不会被缓存在寄存器中（只有拥有线程可见），每次总是从主存中读取volatile变量的结果。

> ps：volatile并不能保证线程安全的，也就是说volatile字段的操作不是原子性的，volatile变量只能保证可见性。

## CAS操作

CAS有3个操作数，内存值V，旧的预期值A，要修改的新值B。当且仅当预期值A和内存值V相同时，将内存值V修改为B，否则什么都不做。

整个J.U.C都是建立在CAS之上的，对于synchronized阻塞算法，J.U.C在性能上有了很大的提升。会出现所谓的“ABA”问题

## Lock 锁

Synchronized属于独占锁，高并发时性能不高，JDK5以后开始用JNI实现更高效的锁操作。

## AQS

锁机制实现的核心所在。AbstractQueuedSynchronizer是Lock/Executor实现的前提。

AQS实现：

基本的思想是表现为一个同步器，AQS支持下面两个操作：

要支持这两个操作，需要实现的三个条件：

1. Atomically managing synchronization state（原子性操作同步器的状态位）
2. Blocking and unblocking threads（阻塞和唤醒线程）
3. Maintaining queues（维护一个有序的队列）
4. Atomically managing synchronization state

## 实践

### volatile关键字的例子

volatile 关键字: 当多个线程进行操作共享数据时,可以保证内存中的数据是可见的;相较于 synchronized 是一种较为轻量级的同步策略;

1. volatile 不具备"互斥性"
2. volatile 不能保证变量的"原子性"
3. volatile 保证的"可见性"

### AtomicInteger

### 并发容器

ConcurrentHashMap

ConcurrentHashMap 同步容器类是 Java5 增加的一个线程安全的哈希表;介于 HashMap 与 Hashtable 之间;内部采用"锁分段"机制替代Hashtable的独占锁,进而提高性能;此包还提供了设计用于多线程上下文中的Collection实现: ConcurrentHashMap,ConcurrentSkipListMap
ConcurrentSkipListSet, CopyOnWriteArrayList 和 CopyOnWriteArraySet;

当期望许多线程访问一个给定collection时,ConcurrentHashMap通常优于同步的HashMap;

ConcurrentSkipListMap通常优于同步的TreeMap;

当期望的读数和遍历远远大于列表的更新数时, CopyOnWriteArrayList优于同步的ArrayList;

CountDownLatch

CountDownLatch是一个同步辅助类,在完成一组正在其他线程中执行的操作之前,它允许一个或多个线程一直等待;

