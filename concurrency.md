# Concurrency in java

## Threads

```java
@FunctionalInterface public interface Runnable {
  void run(); // logic here
}
```

> Threads are created from the main thread

- implementation example: `new Thread(() -> System.out.println("s")).start();`
  - Thread receives a runnable
  - OS schedules the execution, we dont have control over them
  - No order guarantee

- **Should know**
  - The main thread
  - `run()` does not start new thread, sync run
  - `start()`  start new thread
  - The main thread is a user-defined thread

- user-defined
  - created by developer
  - eg main thread
- system thread
  - created by jvm
  - GB is a system thread created by jvm
- daemon threads
  - user-defined and system thread can be daemon threads
  - JVM shutdown these threads before exiting

- Thread states
  - `Thread.getState()`
  - New = `start()`
  - Runnable = after `start()`, Running or able to run
  - Terminated = Task complete
  - Blocked = wait to enter in `synchronized block`
  - Waiting = enters in wait mode (`wait()`) until `notify()`
  - Timed_Waiting = `sleep`

```java
public class ThreadMain {
  private static int counter = 0;
  
  public static void main(String[] a) {
    final var mainThread = Thread.currentThread();
    new Thread(() -> {
      for (int i =0;i<1_000_000;i++) counter++;
      mainThread.interrupt(); // interrupt main when done
      // change Thread.isInterrupted(); value
    });
    while (counter < 1_000_000) {
      System.out.println("Not reached yet");
      try {
        Thread.sleep(1_000); // 1sec
      } catch (InterruptedException e) {
        System.out.println("Interrupted!");
      }
    }
    System.out.println("Reached: "+counter);
  }
}
```

## Concurrency API

- `ExecutorService service = Executors.newSingleThreadExecutor();`
  - only one thread
  - send tasks/threads by using `service.execute(RunnableClass)`
  - must shutdown the service, or the executor will be running (`finally { service.shutdown(); }`)
  - REMEMBER => `.shutdown()` doesnt stop any task that have been submitted
  - REMEMBER => `isShutdown()` return true after the `.shutdown()` method being called
  - REMEMBER => `.isTerminated()` returns true after ALL tasks/threads finishes
  - `.shutdownNow()` attempts to stop all running tasks and discards any that have been not started

- `ExecutorService` methods:
  - `void execute(Runnable r)` run async, does not provide any return
  - `Future<?> submit(Runnable r)` run async and return a Future object
  - `Future<T> submit(Callable<T> task)` run async and return Future object
  - `<T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks)` execute and wait for all tasks to finish (keep same order submmited)
  - `<T> T invokeAny(Collection<? extends Callable<T>> tasks)` executes and wait for at least one

- `Future<?>` is an interface and is implemented by many SDKs
  - `Future<?>` methods:
  - `boolean isDone()`
  - `boolean isCancelled()`
  - `boolean cancel(boolean mayInterruptIfRunning)`
  - `V get()` get result of task, wait until task done
  - `V get(long timeout, TimeUnit unit)` can generate `TimeoutException`

```java
```

