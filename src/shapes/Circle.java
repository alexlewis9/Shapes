package shapes;

import processing.core.PApplet;
import java.awt.Color;
import processing.core.PConstants;

/**
 * This shapes.Circle class represents a double precision circle that can be drawn using the Processing library.
 *
 * @author Alex
 * @version 2020-10-15
 *
 */
public class Circle extends Shape {

	private double diameter = 0;
	
	/**
	 * Initializes a default instance of a shapes.Circle object with
	 * all dimensions set to zero.
	 */
	public Circle() {
		super(0, 0);
	}
	
	/**
	 * Initializes new instance of a shapes.Circle object with given dimensions.
	 * The center of the circle is at x, y.
	 * 
	 * @param x X-coordinate of circle.
	 * @param y Y-coordinate of circle.
	 * @param diameter Diameter of circle.
	 */
	public Circle(double x, double y, double diameter) {
		super(x, y);
		this.diameter = diameter;
	}
	
	/**
	 * Initializes new instance of a shapes.Circle object with given dimensions and color.
	 * The center of the circle is at x, y.
	 * 
	 * @param x X-coordinate of circle.
	 * @param y Y-coordinate of circle.
	 * @param diameter Diameter of circle.
	 * @param r Red.
	 * @param g Green.
	 * @param b Blue.
	 */
	public Circle(double x, double y, double diameter, int r, int g, int b) {
		super(x, y, r, g, b);
		this.diameter = diameter;
	}
	
	/**
	 * Initializes new instance of a shapes.Circle object with given dimensions and color.
	 * The center of the circle is at x, y.
	 * 
	 * @param x X-coordinate of circle.
	 * @param y Y-coordinate of circle.
	 * @param diameter Diameter of circle.
	 * @param color Stroke color.
	 */
	public Circle(double x, double y, double diameter, Color color) {
		super(x, y, color);
		this.diameter = diameter;
	}
	
	/**
	 * Returns the diameter of the circle.
	 * 
	 * @return The diameter of the circle.
	 */
	public double getDiameter() {
		return diameter;
	}
	
	/**
	 * Calculates the perimeter of the circle.
	 * 
	 * @return The perimeter of the circle.
	 */
	public double getPerimeter() {
		double perimeter = diameter * Math.PI;
		return perimeter;
	}
	
	/**
	 * Calculates the area of the circle.
	 * 
	 * @return The area of the circle.
	 */
	public double getArea() {
		double area = Math.pow(diameter/2, 2) * Math.PI;
		return area;
	}
	
	/**
	 * Tests whether the point x, y is contained inside this circle.
	 * 
	 * @param x X-coordinate of the point.
	 * @param y Y-coordinate of the point.
	 * @return True if the point x, y is contained inside this circle, false otherwise.
	 */
	public boolean isPointInside(double x, double y) {
		boolean isPointInside;
		double xDistance = this.x - x;
		double yDistance = this.y - y;
		double totalDistance = Math.pow(xDistance, 2) + Math.pow(yDistance, 2);
		isPointInside = totalDistance < Math.pow(diameter/2, 2);
		return isPointInside;
	}
	
	/**
	 * Draws the circle to the given Processing PApplet. The center of the circle is at getX(),getY().
	 * 
	 * @param marker The Processing PApplet on which to draw the shapes.Circle.
	 * @pre The shapes.Circle will be drawn with attributes previously set on the given PApplet.
	 * @post Side effect - marker is set to: marker.stroke(r, g, b), marker.fill(r, g, b), marker.ellipseMode(PConstants.CENTER).
	 */
	public void draw(PApplet marker) {
		super.draw(marker);
		marker.ellipseMode(PConstants.CENTER);
		marker.circle((float)x, (float)y, (float)diameter);
	}
	
	/**
	 * Initializes a shapes.Rectangle object which is a bounding rectangle of the circle.
	 * 
	 * @return The bounding shapes.Rectangle
	 */
	public Rectangle getBoundingRectangle() {
		Rectangle rectangle = new Rectangle(x-diameter/2, y-diameter/2, diameter, diameter);
		return rectangle;
	}
	
	/**
	 * Determines the equation of the circle in the form (x - h)^2 + (y - k)^2 = r^2, 
	 * where (h, k) is the center and r is the radius. 
	 * 
	 * @return The equation of the circle.
	 */
	public String getEquation() {
		String equation = "(x - " + this.x + ")^2 + (y - " + this.y + ")^2 = " + Math.pow(diameter, 2);
		return equation;
	}
	
}