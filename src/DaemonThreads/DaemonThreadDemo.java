/*
 *  The Thread which are executing in background are called Daemon Thread
 *   e.g Garbage Collector
 *   	 Signal Dispatcher
 *       Attach Listener etc
 * 
 * 
 * 
 * 	The main Objective of Daemon Thread is to provide support for non-daemon threads (main thread).
 * 		e.g
 * 			Suppose main Thread is running and suddenly main thread is facing memory problem.
 *  Immediately, JVM will run Garbage Collector to free up memory (in background)  --> Daemon Thread
 *  With this free memory, main thread can continue its 
 *  
 *  Usually, Daemon threads are having low priority but based on our requirement daemon threads can run with high priority also.
 *  
 *  How to check if thread is daemon or now?
 *  	public boolean isDaemon()
 *  
 *  How to change daemon method to non-daemon or vice versa.
 *  	public void setDaemon(boolean b)
 *  
 *  NOTE: We can change the daemon nature of the thread before start of thread.
 *  	  If we are trying to change it while its execution then immediately we will get RuntimeException saying IllegalThreadStateException
 *  
 *  
 *  Default Nature of Thread:
 *  
 *  	By Default main thread is always non-daemon and all remaining threads daemon nature will be inherited from parent to child.
 *  	i.e if Parent thread is daemon then automatically child thread is also daemon
 *  		and if Parent thread is non-daemon then automatically child thread is also non-daemon
 *  
 *  Is it possible to change the daemon nature of main thread?
 *  No it is impossible, JVM starts main thread and already started thread we can not change the nature.
 * 
 * 
 */


package DaemonThreads;

public class DaemonThreadDemo {
	
	public static void main(String[] args) {
		System.out.println("Is Daemon "  + Thread.currentThread().isDaemon());
		
	//	Thread.currentThread().setDaemon(true); // RE: IllegalThreadStateException		
		MyThread t = new MyThread();
		System.out.println(t.isDaemon());
		t.setDaemon(true);
		System.out.println(t.isDaemon());
		
	}
	
}

class MyThread extends Thread{
	
}
