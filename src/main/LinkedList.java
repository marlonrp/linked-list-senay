package main;

public class LinkedList<T> {

	private Nodule<T> firstEl;
	private Nodule<T> lastEl;
	private int totalEl = 0;

	public LinkedList() {
	}

	public void add(T element) {
		if (totalEl == 0) {
			this.addFirst(element);
		} else {
			Nodule<T> nodule = new Nodule<T>(element, null);
			lastEl.setNextEl(nodule);
			nodule.setPreviousEl(this.lastEl);
			lastEl = nodule;
			totalEl++;
		}
	}

	public void add(int index, T element) throws Exception {
		if (index == 0) {
			this.addFirst(element);
		} else if (index == this.totalEl) {
			this.add(element);
		} else {
			Nodule<T> elementInIndex = this.getNodule(index);
			Nodule<T> previous = elementInIndex.getPreviousEl();
			Nodule<T> newEl = new Nodule<T>(element, elementInIndex);
			elementInIndex.setPreviousEl(newEl);
			previous.setNextEl(newEl);
			newEl.setPreviousEl(previous);
			this.totalEl++;
		}
	}

	public T get(int index) throws Exception {
		return this.getNodule(index).getElement();
	}

	public void set(int index, T element) throws Exception {
		if (!this.hasIndex(index))
			throw new Exception("Non-existent index!");
		Nodule<T> nodule = getNodule(index);
		nodule.setElement(element);
		if (index == 0)
			this.firstEl = nodule;
		else if (index == this.totalEl)
			this.lastEl = nodule;
	}

	public int size() {
		return this.totalEl;
	}

	public boolean contains(T element) {
		Nodule<T> nodule = this.firstEl;
		while (nodule.getNextEl() != null && nodule.getElement() != element) {
			nodule = nodule.getNextEl();
			if (nodule.getElement() == element)
				return true;
		}
		return false;
	}

	public int indexOf(T element) {
		Nodule<T> nodule = this.firstEl;
		for (int i = 0; i < this.totalEl; i++) {
			if (nodule != null && nodule.getElement() == element)
				return i;
			nodule = nodule.getNextEl();
		}
		return -1;
	}

	public int lastIndexOf(T element) {
		Nodule<T> nodule = this.firstEl;
		for (int i = this.totalEl; i > 0; i--) {
			if (nodule != null && nodule.getElement() == element)
				return i;
			nodule = nodule.getNextEl();
		}
		return -1;
	}

	public void removeFirst(T element) throws Exception {
		this.remove(this.indexOf(element));
	}

	public void remove(int index) throws Exception {
		if (!this.hasIndex(index))
			throw new Exception("Non-existent index!");

		if (index == 0) {
			this.removeFirstEl();
		} else if (index == this.totalEl - 1) {
			this.removeLastEl();
		} else {
			Nodule<T> elementInIndex = this.getNodule(index);
			Nodule<T> previous = elementInIndex.getPreviousEl();
			Nodule<T> next = elementInIndex.getNextEl();
			previous.setNextEl(next);
			next.setPreviousEl(previous);
			this.totalEl--;
		}
	}

	public void clear() {
		firstEl = lastEl = null;
		this.totalEl = 0;
	}

	public boolean isEmpty() {
		return totalEl == 0;
	}

	private void addFirst(T element) {
		Nodule<T> nodule = new Nodule<T>(element, null);
		firstEl = lastEl = nodule;
		totalEl++;
	}

	private Nodule<T> getNodule(int index) throws Exception {
		if (!this.hasIndex(index))
			throw new Exception("Non-existent index!");
		Nodule<T> element = this.firstEl;
		for (int i = 0; i < index; i++)
			element = element.getNextEl();
		return element;
	}

	private boolean hasIndex(int index) {
		return index >= 0 && index < this.totalEl;
	}

	private void removeFirstEl() {
		this.firstEl = this.firstEl.getNextEl();
		this.totalEl--;

		if (this.totalEl == 0)
			this.lastEl = null;
	}

	private void removeLastEl() throws Exception {
		if (!this.hasIndex(this.totalEl - 1))
			throw new Exception("Non-existent index!");

		if (this.totalEl == 1) {
			this.removeFirstEl();
		} else {
			Nodule<T> lastButOne = this.lastEl.getPreviousEl();
			lastButOne.setNextEl(null);
			this.lastEl = lastButOne;
			this.totalEl--;
		}
	}

	public String toString() {
		if (this.totalEl == 0)
			return "[]";

		Nodule<T> element = firstEl;
		StringBuilder builder = new StringBuilder("[");
		while (element != null) {
			builder.append(element.getElement());
			element = element.getNextEl();
			if (element != null)
				builder.append(", ");
		}
		builder.append("]");

		return builder.toString();
	}

	public T[] toArray() throws Exception {
		T[] aux = (T[]) new Object[this.totalEl];
		for (int i = 0; i < this.totalEl; i++) {
			aux[i] = this.getNodule(i).getElement();
		}
		return aux;
	}
}
