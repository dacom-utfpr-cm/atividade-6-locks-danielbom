package activities.exercise3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ArrayListThreadSafe<T> {
	private ReadWriteLock locker = new ReentrantReadWriteLock();
	private Lock read = locker.readLock();
	private Lock write = locker.writeLock();
	
	private ArrayList<T> array;
	
	public ArrayListThreadSafe() {
		array = new ArrayList<T>();
	}
	public ArrayListThreadSafe(int length) {
		array = new ArrayList<T>(length);
	}
	
	public void add(T value) {
		write.lock();
		array.add(value);
		write.unlock();
	}
	
	public T get(int index) {
		read.lock();
		try {
			return array.get(index);
		} finally {
			read.unlock();
		}
	}

	public T remove(int index) {
		write.lock();
		try {
			return array.remove(index);
		} finally {
			write.unlock();
		}
	}
	
	public T set(int index, T value) {
		write.lock();
		try {
			return array.set(index, value);
		} finally {
			write.unlock();
		}
	}
	
	public boolean addAll(Collection<? extends T> c) {
		write.lock();
		try {
			return array.addAll(c);
		} finally {
			write.unlock();
		}
	}
	public boolean addAll(int index, Collection<? extends T> c) {
		write.lock();
		try {
			return array.addAll(index, c);
		} finally {
			write.unlock();
		}
	}

	public void clear() {
		write.lock();
		array.clear();
		write.unlock();
	}
	
	public Object clone() {
		read.lock();
		try {
			return array.clone();
		} finally {
			read.unlock();
		}
	}
	
	public boolean contains(T o) {
		read.lock();
		try {
			return array.contains(o);
		} finally {
			read.unlock();
		}
	}
	
	public boolean containsAll(Collection<? extends T> c) {
		read.lock();
		try {
			array.
			return array.containsAll(c);
		} finally {
			read.unlock();
		}
	}
}
