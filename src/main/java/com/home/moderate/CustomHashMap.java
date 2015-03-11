package com.home.moderate;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class DVD implements Comparator<DVD>{
	String name;
	int id;

	public int compare(DVD d1, DVD d2) {
		return d1.name.compareTo(d2.name);
	}
	
	@Override
	public int hashCode() {
		return id*12;		
	}
}

class KeyValueWrapper {
	DVD d;
	int info;
}
public class CustomHashMap {

	List<LinkedList<KeyValueWrapper>> hashmapList = new ArrayList<LinkedList<KeyValueWrapper>>();
	public void put(KeyValueWrapper obj) {
		int index = obj.d.hashCode();
		LinkedList<KeyValueWrapper> l = hashmapList.get(index);
		if (l == null) {
			hashmapList.add(index, new LinkedList<KeyValueWrapper>());
		}
		for (KeyValueWrapper wrapper:l) {
			if (wrapper.d == obj.d) {
				l.remove(wrapper);
				break;
			}
		}
		l.add(obj);
	}
	
	public KeyValueWrapper get(DVD obj) {
		int index = obj.hashCode();
		LinkedList<KeyValueWrapper> l = hashmapList.get(index);
		if (l == null) {
			return null;
		}
		for (KeyValueWrapper wrapper:l) {
			if (wrapper.d == obj) {
				return wrapper;
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
