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


