package nachos.vm;

import nachos.machine.*;
import nachos.threads.*;
import nachos.userprog.*;
import nachos.vm.*;

public class TLBManager{

	public void addEntry(TranslationEntry entry){
		int index = -1;
		for (int i = 0; i < Machine.processor().getTLBSize(); i++ ) 
			if (!Machine.processor().readTLBEntry(i).valid){
				index = i;
				break;
			}
		if (index == -1) index = Lib.random(Machine.processor().getTLBSize());

		TranslationEntry translationEntry = Machine.processor().readTLBEntry(index);
		if (translationEntry.valid) VMKernel.coreMap[entry.ppn].entry = translationEntry;
		Machine.processor().writeTLBEntry(index,entry);
	}


}
