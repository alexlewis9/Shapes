package shapes;

import java.awt.Color;

import processing.awt.PSurfaceAWT;
import processing.core.PApplet;

/**
 * The shapes.Line class represents a double-precision shapes.Line segment that can be drawn using the Processing library. It also focuses on the ability to detect
 * intersections with other Lines.
 *
 * @author Alex
 * @version 2020-10-15
 *
 */
public class Line extends Shape{

	private double x2, y2;
	
	/**
	 * Initializes a shapes.Line with both end points at 0,0.
	 */
	public Line() {
		super(0, 0);
		x2 = 0;
		y2 = 0;
	}
	
	/**
	 * Initializes a shapes.Line with given end points.
	 * 
	 * @param x1 X-coordinate of start point.
	 * @param y1 Y-coordinate of start point.
	 * @param x2 X-coordinate of end point.
	 * @param y2 Y-coordinate of end point.
	 */
	public Line(double x1, double y1, double x2, double y2) {
		super(x1, y1);
		this.x2 = x2;
		this.y2 = y2;
	}
	
	/**
	 * Returns a shapes.Line with given start points, length, and angle.
	 * 
	 * @param x1 X-coordinate of start point.
	 * @param y1 Y-coordinate of start point.
	 * @param l The length of the line.
	 * @param a Angle in degrees between line and 3 o'clock.
	 * @return a shapes.Line with given start points, length, and angle.
	 */
	public static Line LineAngle(double x1, double y1, double l, double a) {
		double x2 = x1 + l * Math.cos(a * Math.PI / 180);
		double y2 = y1 + l * Math.sin(a * Math.PI / 180);
		return new Line(x1, y1, x2, y2);
	}
	
	
	/**
	 * Initializes a shapes.Line with given end points.
	 * 
	 * @param x1 X-coordinate of start point.
	 * @param y1 Y-coordinate of start point.
	 * @param x2 X-coordinate of end point.
	 * @param y2 Y-coordinate of end point.
	 * @param r Red.
	 * @param g Green.
	 * @param b Blue.
	 */
	public Line(double x1, double y1, double x2, double y2, int r, int g, int b) {
		super(x1, y1, r, g, b);
		this.x2 = x2;
		this.y2 = y2;
	}
	
	/**
	 * Initializes a shapes.Line with given end points.
	 * 
	 * @param x1 X-coordinate of start point.
	 * @param y1 Y-coordinate of start point.
	 * @param x2 X-coordinate of end point.
	 * @param y2 Y-coordinate of end point.
	 * @param color Stroke color.
	 */
	public Line(double x1, double y1, double x2, double y2, Color color) {
		super(x1, x2, color);
		this.x2 = x2;
		this.y2 = y2;
	}
	
	/**
	 * Sets the end point.
	 * 
	 * @param x2 X-coordinate of end point.
	 * @param y2 Y-coordinate of end point.
	 */
	public void setPoint2(double x2, double y2) {
		this.x2 = x2;
		this.y2 = y2;
	}
	
	/** Returns the x-coordinate of the end point.
	 * 
	 * @return The x-coordinate of the end point.
	 */
	public double getX2() {
		return x2;
	}
	
	/** Returns the y-coordinate of the end point.
	 * 
	 * @return The y-coordinate of the end point.
	 */
	public double getY2() {
		return y2;
	}
	
	/**
	 * Moves the shapes.Line.
	 * 
	 * @param xMove Distance to move the shape in the x direction.
	 * @param yMove Distance to move the shape in the y direction.
	 */
	public void move(double xMove, double yMove) {
		super.move(xMove, yMove);
		this.x2 += xMove;
		this.y2 += yMove;
	}
	
	
	/**
	 * Draws the line to the given Processing PApplet.
	 * 
	 * @param drawer The Processing PApplet on which to draw the shapes.Line.
	 * @pre The shapes.Line will be drawn with attributes previously set on the given PApplet.
	 * @post Side effect - drawer is set to: marker.stroke(r, g, b), marker.fill(r, g, b)
	 */
	public void draw(PApplet drawer) {
		super.draw(drawer);
		drawer.line((float)x, (float)y, (float)x2, (float)y2);
	}
	
	/**
	 * Calculates the x-coordinate of the point of intersection between Lines.
	 * 
	 * @param other The other shapes.Line to test intersection.
	 * @return The x-coordinate of the point of intersection.
	 */
	public double getIntersectionX(Line other) {
		double x3 = other.x;
		double y3 = other.y;
		double x4 = other.x2;
		double y4 = other.y2;
		double intersectionX = ((x*y2-y*x2)*(x3-x4)-(x-x2)*(x3*y4-y3*x4))
								/((x-x2)*(y3-y4)-(y-y2)*(x3-x4));
		return intersectionX;
	}
	
	/**
	 * Calculates the y-coordinate of the point of intersection between Lines.
	 * 
	 * @param other The other shapes.Line to test intersection.
	 * @return The y-coordinate of the point of intersection.
	 */
	public double getIntersectionY(Line other) {
		double x3 = other.x;
		double y3 = other.y;
		double x4 = other.x2;
		double y4 = other.y2;
		double intersectionY = ((x*y2-y*x2)*(y3-y4)-(y-y2)*(x3*y4-y3*x4))
								/((x-x2)*(y3-y4)-(y-y2)*(x3-x4));
		return intersectionY;
	}
	
	/**
	 * Tests whether this line intersects with the other shapes.Line.
	 * 
	 * @param other The other shapes.Line to test intersection.
	 * @return True if the Lines intersect, false otherwise.
	 */
	public boolean intersects(Line other) {
		boolean intersect = false;
		double x1 = this.x;
		double y1 = this.y;
		double x2 = this.x2;
		double y2 = this.y2;
		double x3 = other.x;
		double y3 = other.y;
		double x4 = other.x2;
		double y4 = other.y2;
		if (x1 > x2) {
			double t = x1;
			x1 = x2;
			x2 = t;
		}
		if (y1 > y2) {
			double t = y1;
			y1 = y2;
			y2 = t;
		}
		if (x3 > x4) {
			double t = x3;
			x3 = x4;
			x4 = t;
		}
		if (y3 > y4) {
			double t = y3;
			y3 = y4;
			y4 = t;
		}
		double intersectX = getIntersectionX(other);
		double intersectY = getIntersectionY(other);
		intersect = (x1 <= intersectX && x2 >= intersectX && x3 <= intersectX && x4 >= intersectX
				&& y1 <= intersectY && y2 >= intersectY && y3 <= intersectY && y4 >= intersectY ||
				(x1==x3 && y1==y3) || (x1==x4 && y1==y4) || (x2==x3 && y2==y3) || (x2==x4 && y2==y4));
		return intersect;
	}

	public double getArea() {
		return 0;
	}

	/**
	 * Calculates the length of the shapes.Line.
	 * 
	 * @return The length of the shapes.Line.
	 */
	public double getPerimeter() {
		double length = Math.sqrt(Math.pow(x - x2, 2) + Math.pow(y - y2, 2));
		return length;
	}

	/**
	 * Tests whether the point is on the shapes.Line.
	 * 
	 * @return True if the point is on the shapes.Line, false otherwise.
	 */
	public boolean isPointInside(double x, double y) {
		Line point = new Line(x, y, x, y);
		return this.intersects(point);
	}
	
}
