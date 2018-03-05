主动对象模式集合了Future模式、生产者消费者模式、Thread-per-request模式

在主动对象这个高内聚的包中，把方法抽象成了类，外界只是传递参数进来，在主动对象中通过队列执行方法并返回。

方法的调用包括了四大部分：
方法类型： MethodRequest  MakeStringRequest DisplayStringRequest
执行者:  Servant
返回值: Result  RealResult FutureResult
调用队列：   ActivationQueue  SchedularThread
对外接口： ActiveObject  ActiveObjectFactory  Result


Proxy类和Servant类都实现了ActiveObject接口，以下两者是一致的：
1. 主动对象可以调用的方法群（由Proxy实现的方法群）
2. 主动对象可以实际执行的方法群（由Servant类实现的方法群）


在本例子中启动了以下线程：
1. main线程
2. 两个MakerClientThread线程
3. 一个DisplayClientThread线程
4. 一个SchedulerThread线程
（2和3的三个线程发出请求还可以做其他事情，4线程不停地处理接受到的请求），使用Producer-Consumer模式可以将MakerStringRequest的实例和
DisplayStringRequest的实例安全地从Producer角色的线程传递给Consumer角色的线程。

通过Active Object模式，实现了“异步方法”，也就是“异步消息”。如果将调用和执行的线程分离开放在不同的计算机中运行，通过网络传输MethodRequest和
Result，就可以通向分布式。

Active Object模式具有以下特征：接收来自外部的异步请求、能够自由地调度请求、可以返回执行结果、拥有独立的线程。


