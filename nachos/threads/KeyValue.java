package nachos;

public class KeyValue implements Comparable<KeyValue>
{
	private KThread thread;
	private long wakeTime;
	
	 public KeyValue(KThread thread, long wakeTime) {
	        this.thread = thread;
	        this.wakeTime = wakeTime;
	    }
	 
	 public long getWakeTime() {
	        return wakeTime;
	    }
	 
	 public KThread getThread() {
	        return thread;
	    }
	 
	 @Override
	 public int compareTo(KeyValue other)
	 {
		 return this.getWakeTime().compareTo(other.getWakeTime());
	 }
}
