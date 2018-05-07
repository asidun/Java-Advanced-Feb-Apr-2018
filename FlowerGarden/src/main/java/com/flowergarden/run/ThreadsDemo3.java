import java.lang.InterruptedException;
class Callme {
    void call(String msg) {
         System.out.println("["+msg);
	try {
	  Thread.sleep(1000);
	}catch(InterruptedException e) {
		System.out.println("Прерывание");
         }
        System.out.println("]");
     }
}
class Caller implements Runnable {
   String msg;
   Callme target;
   Thread t;
   public Caller(Callme targ, String s) {
        target=targ;
        msg = s;
        t = new Thread(this);
        t.start();
   }
   public void run() { target.call(msg);   }
}
