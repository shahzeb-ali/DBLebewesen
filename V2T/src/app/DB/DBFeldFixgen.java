package app.DB;

import java.util.Iterator;

import app.Lebenswesen.*;

public class DBFeldFixgen<T extends Tier> extends DBgen<T> {
	T[] dBFeldFixgenArray;
	


	/**
	 * @return the dBFeldFixgenArray
	 */
	public T[] getdBFeldFixgenArray() {
		return dBFeldFixgenArray;
	}

	/**
	 * Default Constructor
	 * 
	 * @param igelFeld
	 */

	public DBFeldFixgen(T[] igelFeld) {
		this.dBFeldFixgenArray = igelFeld;
		this.size = 0;
	}

	@Override
	public T get(int i) {
//		System.out.println("element at " + i + " Position" + dBFeldFixgenArray[i - 1]);
		// TODO: What if index is out of bound ?

		return dBFeldFixgenArray[i - 1];

	}

	public T maxWeightnonit() {
		T t1;
		T t2;
		T maxWeightTier = this.get(1);

		for (int i = 1; i < this.size(); i++) {

			t1 = this.get(i);
			t2 = this.get(i + 1);

			if (i == this.size()) {
				break;
			}

			if (t1.weight() <= t2.weight() && maxWeightTier.weight() <= t2.weight()) {
				maxWeightTier = t2;

			}

		}

		return maxWeightTier;

	}

	@Override
	public void swap(int a, int b) {

		try {

			final T tmp = this.dBFeldFixgenArray[a - 1];
			this.dBFeldFixgenArray[a - 1] = this.dBFeldFixgenArray[b - 1];
			this.dBFeldFixgenArray[b - 1] = tmp;
		} catch (final Exception e) {
			throw new IndexOutOfBoundsException();
		}
	}

	@Override
	public void appendLast(T o) {
		try {
			this.dBFeldFixgenArray[this.size()] = o;
			this.size = this.size() + 1;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("FEHLER: t konnte nicht eingefuegt werden (Indexfehler) " + e.getMessage());
		}
	}

	@Override
	public T removeLast() {
		try {

			size = this.size() - 1;
			return this.dBFeldFixgenArray[this.size()];

//			for(int i =0; i<rIgel.length;i++) {
//				rIgel[i] = this.igel[i];
//			}
		} catch (final Exception e) {
			throw new IndexOutOfBoundsException();
		}

	}

//	public String toString() {
//		StringBuilder tmp = new StringBuilder();
//		tmp.append(this.getClass().getName());
//
//		for (Igel igel : db) {
//			if (igel != null)
//				tmp.append(igel.toString());
//			else
//				System.out.println("is null");
//
//		}
//
//		return tmp.toString();
//	}

	@Override
	public String toString() {
		String out = "";
		for (int i = 0; i < this.size(); i++) {
			out += i + 1 + ": " + dBFeldFixgenArray[i] + "\n";
		}
		return out;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		
		return new DbIterator<T>(dBFeldFixgenArray);
	}
	public Iterator<T> iterator(int a, int b) {
		// TODO Auto-generated method stub
		
		return new DbIterator<T>(dBFeldFixgenArray, a,b);
	}
	public Iterator<T> iterator(int start) {
		// TODO Auto-generated method stub
		
		return new DbIterator<T>(dBFeldFixgenArray, start);
	}



}
