package nachos.vm;

import nachos.machine.*;
import nachos.threads.*;
import nachos.userprog.*;
import nachos.vm.*;
import java.util.Hashtable;

/**
 * A kernel that can support multiple demand-paging user processes.
 */
public class VMKernel extends UserKernel {
    /**
     * Allocate a new VM kernel.
     */
    public VMKernel() {
	super();
    }

    /**
     * Initialize this kernel.
     */
    public void initialize(String[] args) {
	super.initialize(args);

	coreMap = new Page[Machine.processor().getNumPhysPages()];
	tlbManager = new TLBManager();
    }

    /**
     * Test this kernel.
     */	
    public void selfTest() {
	super.selfTest();
    }

    /**
     * Start running user programs.
     */
    public void run() {
	super.run();
    }
    
    /**
     * Terminate this kernel. Never returns.
     */
    public void terminate() {
	super.terminate();
    }

    public static TranslationEntry getPageEntry(PageItem item){
    	Integer ppn = invertedPageTable.get(item);
    	if (ppn == null) return null;
    	Page res = coreMap[ppn];
    	if (res == null || !res.entry.valid) return null;
    	return res.entry;
    }

    // dummy variables to make javac smarter
    private static VMProcess dummy1 = null;
    private static final char dbgVM = 'v';
    protected static Page[] coreMap;
    protected static TLBManager tlbManager;
    protected static Hashtable <PageItem, Integer> invertedPageTable = new Hashtable <PageItem, Integer>();

}
