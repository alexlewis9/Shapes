package alexlewis9.shapes;

import java.awt.Color;

import processing.core.PApplet;


/**
 * This shapes.RegularPolygon class represents a double precision Regular Polygon that can be drawn using the Processing library.
 *
 * @author Alex
 * @version 2020-11-05
 *
 */
public class RegularPolygon extends Shape {
	
	private int n;
	private double s;
	
	// constructors
	
	/**
	 * Initializes a default instance of a shapes.Rectangle object with
	 * all dimensions set to zero.
	 */
	public RegularPolygon() {
		super(0, 0);
		n = 3;
		s = 100;
	}
	
	/**
	 * Initializes new instance of a shapes.RegularPolygon object with given dimensions.
	 * 
	 * @param x X-coordinate of polygon.
	 * @param y Y-coordinate of polygon.
	 * @param numSides - The number of sides the Polygon has.
	 * @param sideLength - The length of the sides of the Polygon.
	 */
	public RegularPolygon(int x, int y, int numSides, double sideLength) {
		super(x, y);
		n = numSides;
		s = sideLength;
	}
	
	/**
	 * Initializes new instance of a shapes.RegularPolygon object with given dimensions.
	 * 
	 * @param x X-coordinate of polygon.
	 * @param y Y-coordinate of polygon.
	 * @param numSides - The number of sides the Polygon has.
	 * @param sideLength - The length of the sides of the Polygon.
	 * @param color Stroke color.
	 */
	public RegularPolygon(int x, int y, int numSides, double sideLength, Color color) {
		super(x, y, color);
		n = numSides;
		s = sideLength;
	}
	
	// public methods
	
	/**
	 * Calculates the radius of the inscribed circle of the polygon, 
	 * where the inscribed circle is the circle that can be drawn 
	 * inside the regular polygon such that it is tangent to
	 * every side of the polygon.
	 * 
	 * @return The radius of the inscribed circle of the polygon.
	 */
	public double calcr(){
		return s / 2 / Math.tan(Math.PI / n);
		
	}
	
	/**
	 * Calculates the radius of the circumscribed circle of the polygon,
	 * where the circumscribed circle is the circle that intersects 
	 * each vertex of the polygon.
	 * 
	 * @return The radius of the circumscribed circle of the polygon.
	 */
	public double calcR(){
		return s / 2 / Math.sin(Math.PI / n);
	}  
	
	/**
	 * Calculates the vertex angle of the polygon.
	 * 
	 * @return The vertex angle of the polygon.
	 */
	public double calcVertexAngle(){
		return 180 * (n-2) / n;
	}
	
	/**
	 * Calculates the perimeter of the polygon.
	 * 
	 * @return The perimeter of the polygon.
	 */
	public double getPerimeter(){
		return n * s;
	}
	
	/**
	 * Calculates the area of the polygon.
	 * 
	 * @return The area of the polygon.
	 */
	public double getArea(){
		return n / 2 * calcR() * calcR() * Math.sin(2 * Math.PI / n);
	}
	
	/**
	 * Returns the number of sides of the polygon.
	 * 
	 * @return The number of sides of the polygon.
	 */
	public int getNumSides(){
		return n;
	}
	
	/**
	 * Returns the length of the sides of the polygon.
	 * 
	 * @return The length of the sides of the polygon.
	 */
	public double getSideLength(){
		return s;
	}
	
	/**
	 * Draws the regular polygon to the given Processing PApplet.
	 * 
	 * @param drawer The Processing PApplet on which to draw the polygon.
	 * @pre The polygon will be drawn with attributes previously set on the given PApplet.
	 * @post Side effect - marker is set to: marker.stroke(r, g, b), marker.fill(r, g, b)
	 */
	public void draw(PApplet drawer){
		Line[] lines = new Line [n];
		double x = this.x;
		double y = this.y;
		double x2;
		double y2;
		for (int i = 0; i < n; i++) {
			x2 = Math.cos(i*(calcVertexAngle()*Math.PI/(90*(n-2))))*s + x;
			y2 = Math.sin(i*(calcVertexAngle()*Math.PI/(90*(n-2))))*s + y;
			lines[i] =  new Line(x, y, x2, y2);
			//lines[i] = new shapes.Line(x, y, x - (s * Math.cos((360-(180/n)) * Math.PI / 180)), y - (s * Math.sin((360-(180/n))* Math.PI / 180)));
			//x -= (s * Math.cos(i * (360-(180/n))));
			//y -= (s * Math.sin(i * (360-(180/n))));
			x = x2;
			y = y2;
		}
		for (int i = 0; i < n; i++) {
			lines[i].draw(drawer);
		}
		
	}
	
	/**
	 * Draws the inscribed and circumscribed circles of the polygon to the given Processing PApplet.
	 * 
	 * @param drawer The Processing PApplet on which to draw the circles.
	 * @pre The circles will be drawn with attributes previously set on the given PApplet.
	 */
	public void drawBoundingCircles(PApplet drawer){
		Circle circler = new Circle(x+s/2, y+calcr(), 2 * calcr());
		Circle circleR = new Circle(x+s/2, y+calcr(), 2 * calcR());
		circler.draw(drawer);
		circleR.draw(drawer);
	}

	/**
	 * Tests whether the point x, y is contained the bounding circle of this polygon.
	 * 
	 * @param x X-coordinate of the point.
	 * @param y Y-coordinate of the point.
	 * @return true if the point x, y is contained inside this polygon, false otherwise.
	 */
	public boolean isPointInside(double x, double y) {
		Circle circleR = new Circle(x, y, 2 * calcR());
		return circleR.isPointInside(x, y);
	}
	
}