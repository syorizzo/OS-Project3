package nachos.vm;

import nachos.machine.*;
import nachos.threads.*;
import nachos.userprog.*;
import nachos.vm.*;

public class Page{
	PageItem item;
	TranslationEntry entry;

	public Page(PageItem item, TranslationEntry entry){
		this.item = item;
		this.entry = entry;
	}
}