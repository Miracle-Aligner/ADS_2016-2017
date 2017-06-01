package common;
/**
 * Class represents geometric figure such as rectangle or triangle. Contains
 * coordinates of figure and methods to calculate area and perimeter
 */
public class GeomFigure {

	// TODO
	private int v1[];
	private int v2[];
	private int v3[];
	private double angle;
	private int hash = 0;

	public GeomFigure(int v1[], int v2[], int v3[], double angle) {
		// TODO
		this.v1 = v1;
		this.v2 = v2;
		this.v3 = v3;
		this.angle = angle;
		
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
			hash =  31 * hash + Integer.hashCode (this.v1[0]) + 
								Integer.hashCode (this.v1[1]) +
								Integer.hashCode (this.v2[0]) + 
								Integer.hashCode (this.v2[1]) + 
								Integer.hashCode (this.v3[0]) + 
								Integer.hashCode (this.v3[1]) + 
								Double.hashCode (this.angle);
		}

		return hash;
	}

	@Override
	public String toString() {
		return String.format ("  %10d  |  (%3d; %3d)  |  (%3d; %3d)  |  (%3d; %3d)  |  %6.1f  |", hash, this.v1[0], 
																										this.v1[1],
																										this.v2[0],
																										this.v2[1],
																										this.v3[0],
																										this.v3[1],
																										this.angle);
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
		if (gf != null)
		{
			if (this.angle == gf.angle)
			{
				if (calcSide(this.v1, this.v2) == calcSide(gf.v1, gf.v2) && calcSide(this.v3, this.v2) == calcSide(gf.v3, gf.v2))
					return true;
				else if (calcSide(this.v1, this.v2) == calcSide(gf.v3, gf.v2) && calcSide(this.v3, this.v2) == calcSide(gf.v1, gf.v2))
					return true;
			}
		}
		
		return false;

	}
	
	private double calcSide(int v1[], int v2[]){
		return Math.sqrt(Math.pow(v1[0] - v2[0], 2) + Math.pow(v1[1] - v2[1], 2));
	}
	
	public double getPerimeter(){
		return calcSide(this.v1, this.v2)* 2 + calcSide(this.v3, this.v2) * 2;
	}
	
	public double getArea(){		
		return calcSide(this.v1, this.v2) * calcSide(this.v3, this.v2) * Math.sin(this.angle);
	}
	
	public boolean validFigure ()
	{
		if (this.angle >= 180.0)
			return false;
		if (this.angle <= 0.0)
			return false;
		if (calcSide(this.v1, this.v2) == 0)
			return false;
		if (calcSide(this.v3, this.v2) == 0)
			return false;
		return true;
	}
	
}
