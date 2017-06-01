package common;

/**
 * Class represents geometric figure such as rectangle or triangle. Contains
 * coordinates of figure and methods to calculate area and perimeter
 */
public class GeomFigure {

	// TODO
	private int value;
	private int hash = 0;

	public GeomFigure(int value) {
		// TODO
		this.value = value;
		this.hash = hashCode();
	}

	/**
	 * Returns the hash code value for this geometric figure. The hash code of a
	 * figure is defined to be the sum of the hash codes of the elements in the
	 * figure, where the hash code of a null element is defined to be zero.
	 * 
	 * @return the hash code value for this object
	 */
	public int hashCode() {
		// TODO
		if (hash == 0) {
			hash = 1;
			hash = 31 * value;
		}

		return hash;
	}

	@Override
	public String toString() {
		return String.format("%-10s|  %-6d|", hash, value);
	}

	/**
	 * Returns the hash code value for this geometric figure. The hash code of a
	 * figure is defined to be the sum of the hash codes of the elements in the
	 * figure, where the hash code of a null element is defined to be zero.
	 * 
	 * @return the hash code value for this object
	 */
	public boolean equals(GeomFigure gf) {
		// TODO

		return false;

	}

}
