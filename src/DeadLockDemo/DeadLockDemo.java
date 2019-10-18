/*
 * synchronized is the only keyword for deadlock situation. 
 * Due to this, while using Synchnorized keyword we have to take special care
 * 
 */


/*     DeadLock Vs Starvation
 * 
 *   Long waiting of a thread where waiting never ends is called DeadLock
 *   
 *   Long waiting of a thread where waiting ends at certain point is called Starvation
 *   e.g --> Low priority Thread has to wait until completing all high priority Threads. 
 *   		It may be long waiting but ends at certain points which is nothing but Starvation
 *   
 *   	  Thread with priority 1 will have to wait till Thread with priority > 1 is completed
 * 
 */

package DeadLockDemo;

class A {
	
	public synchronized void d1(B b) {
		System.out.println("Thread 1 starts executing of d(B) method");
		try {
			Thread.sleep(6000);
		}
		catch(InterruptedException e) {}
		
		System.out.println("Thread 1 trying to call B's last method");
		b.last();
	
	}
	
	public synchronized void last() {
		System.out.println("Inside A, this is last() method");
	}
}

class B {
	
	public synchronized void d2(A a) {
		System.out.println("Thread 2 starts executing of d(A) method");
		try {
			Thread.sleep(6000);
		}
		catch(InterruptedException e) {}
		
		System.out.println("Thread 2 trying to call A's last method");
		a.last();
	
	}
	
	public synchronized void last() {
		System.out.println("Inside B, this is last() method");
	}
}	

class DeadLockDemo extends Thread{
	
	A a = new A();
	B b = new B();
	
	public void m1() {
		this.start();
		a.d1(b);  // This line executed by main Thread
	}
	public void run() {
		b.d2(a);  // This line executed by child Thread
	}
	
	public static void main(String[] args) {
		DeadLockDemo d = new DeadLockDemo();
		d.m1();
	}
	
	
}
