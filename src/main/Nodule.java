package main;

public class Nodule<T> {

	private T element;
	private Nodule<T> nextEl;
	private Nodule<T> previousEl;

	public Nodule(T element, Nodule<T> nextEl) {
		this.element = element;
		this.nextEl = nextEl;
	}

	public T getElement() {
		return this.element;
	}
	
	public void setElement(T element) {
		this.element = element;
	}

	public Nodule<T> getNextEl() {
		return this.nextEl;
	}

	public void setNextEl(Nodule<T> nextEl) {
		this.nextEl = nextEl;
	}
	
	public Nodule<T> getPreviousEl() {
		return this.previousEl;
	}

	public void setPreviousEl(Nodule<T> previousEl) {
		this.previousEl = previousEl;
	}
}
