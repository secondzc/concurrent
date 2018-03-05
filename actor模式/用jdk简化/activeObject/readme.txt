与自己的实现相比，利用jdk的concurrent包做出了以下简化：
1. ExecutorService，提交请求的接口，代替SchedulerThread、ActivationQueue
2. Callable，将获取返回值的调用（call）抽象化后的接口，代替MethodRequest
3. Runnable，将获取返回值的调用（run）抽象化后的接口，代替MethodRequest
4. Future，代替Result、FutureResult、RealResult
