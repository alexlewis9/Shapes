package alexlewis9.shapes;

import processing.core.PApplet;
import java.awt.Color;

/**
 * This shapes.Rectangle class represents a double precision shapes.Rectangle that can be drawn using the Processing library.
 *
 * @author Alex
 * @version 2020-10-16
 *
 */
public class Rectangle extends Shape{

	private double width = 0;
	private double height = 0;	
	
	/**
	 * Initializes a default instance of a shapes.Rectangle object with
	 * all dimensions set to zero.
	 */
	public Rectangle() {
		super(0, 0);
	}


	/**
	 * Initializes new instance of a shapes.Rectangle object with given dimensions.
	 * The left and right edges of the rectangle at x and x + width. The top 
	 * and bottom edges are at y and y + height.
	 * 
	 * @param x X-coordinate of rectangle.
	 * @param y Y-coordinate of rectangle.
	 * @param width Width of rectangle.
	 * @param height Height of rectangle.
	 */
	public Rectangle(double x, double y, double width, double height) {
		super (x, y);
		this.width = width;
		this.height = height;
	}
	
	/**
	 * Initializes new instance of a shapes.Rectangle object with given dimensions.
	 * The left and right edges of the rectangle at x and x + width. The top 
	 * and bottom edges are at y and y + height.
	 * 
	 * @param x X-coordinate of rectangle.
	 * @param y Y-coordinate of rectangle.
	 * @param width Width of rectangle.
	 * @param height Height of rectangle.
	 * @param color Stroke color.
	 */
	public Rectangle(double x, double y, double width, double height, Color color) {
		super (x, y, color);
		this.width = width;
		this.height = height;
	}

	/**
	 * Initializes new instance of a shapes.Rectangle object with given dimensions.
	 * The left and right edges of the rectangle at x and x + width. The top 
	 * and bottom edges are at y and y + height.
	 * 
	 * @param x X-coordinate of rectangle.
	 * @param y Y-coordinate of rectangle.
	 * @param width Width of rectangle.
	 * @param height Height of rectangle.
	 * @param r Red.
	 * @param g Green.
	 * @param b Blue.
	 */
	public Rectangle(double x, double y, double width, double height, int r, int g, int b) {
		super(x, y, new Color(r, g, b));
		this.width = width;
		this.height = height;
	}
	
	/**
	 * Returns the width of the rectangle.
	 * 
	 * @return The width of the rectangle.
	 */
	public double getWidth() {
		return width;
	}
	
	/**
	 * Returns the height of the rectangle.
	 * 
	 * @return The height of the rectangle.
	 */
	public double getHeight() {
		return height;
	}
	
	/**
	 * Calculates the perimeter of the rectangle.
	 * 
	 * @return The perimeter of the rectangle.
	 */
	public double getPerimeter() {
		double perimeter = width*2 + height*2;
		return perimeter;
	}
	
	/**
	 * Calculates the area of the rectangle.
	 * 
	 * @return The area of the rectangle.
	 */
	public double getArea() {
		double area = height*width;
		return area;
	}
	
	/**
	 * Initializes a shapes.Line object that is the right line of the rectangle.
	 * 
	 * @return The right line of the rectangle.
	 */
	public Line getLeftLine() {
		Line line = new Line(x, y, x, y+height);
		return line;
	}
	
	/**
	 * Initializes a shapes.Line object that is the upper line of the rectangle.
	 * 
	 * @return The top line of the rectangle.
	 */
	public Line getBottomLine() {
		Line line = new Line(x, y+height, x+width, y+height);
		return line;
	}
	
	/**
	 * Initializes a shapes.Line object that is the upper line of the rectangle.
	 * 
	 * @return The top line of the rectangle.
	 */
	public Line getTopLine() {
		Line line = new Line(x, y, x+width, y);
		return line;
	}
	
	/**
	 * Initializes a shapes.Line object that is the upper line of the rectangle.
	 * 
	 * @return The top line of the rectangle.
	 */
	public Line getRightLine() {
		Line line = new Line(x+width, y, x+width, y+height);
		return line;
	}
	
	/**
	 * Tests whether the point x, y is contained inside this rectangle.
	 * 
	 * @param x X-coordinate of the point.
	 * @param y Y-coordinate of the point.
	 * @return true if the point x, y is contained inside this rectangle, false otherwise.
	 */
	public boolean isPointInside(double x, double y) {
		boolean isPointInside = this.x < x && x < this.x + width && this.y < y && y < this.y + height;
		return isPointInside;
	}
	
	/**
	 * Tests whether this shapes.Rectangle intersects with the other shapes.Rectangle.
	 * 
	 * @param other The other shapes.Rectangle to test intersection.
	 * @return True if the Rectangles intersect, false otherwise.
	 */
	public boolean intersects(Rectangle other) {
		Line[] rect1 = {getTopLine(), getBottomLine(), getLeftLine(), getRightLine()};
		Line[] rect2 = {other.getTopLine(), other.getBottomLine(), other.getLeftLine(), other.getRightLine()};
		boolean intersect = false;
		for (int i = 0; i < 4 && intersect == false; i++) {
			for (int j = 0; j < 4 && intersect == false; j++) {
				if (rect1[i].intersects(rect2[j])) {
					intersect = true;
				}
			}
		}
		return intersect;
	}
	
	/**
	 * Tests whether this shapes.Rectangle intersects with the shapes.Line.
	 * 
	 * @param other The shapes.Line to test intersection.
	 * @return True if the shapes.Rectangle intersects the line, false otherwise.
	 */
	public boolean intersects(Line other) {
		Line[] rect = {getTopLine(), getBottomLine(), getLeftLine(), getRightLine()};
		boolean intersect = false;
		for (int i = 0; i < 4 && intersect == false; i++) {
			if (rect[i].intersects(other)) {
					intersect = true;
			}
		}
		return intersect;
	}
	
	/**
	 * Draws the rectangle to the given Processing PApplet. The left and right
	 * edges of the rectangle at getX() and getX() + getWidth(). The top and bottom edges
	 * are at getY() and getY() + getHeight().
	 * 
	 * @param marker The Processing PApplet on which to draw the shapes.Rectangle.
	 * @pre The shapes.Rectangle will be drawn with attributes previously set on the given PApplet.
	 * @post Side effect - marker is set to: marker.stroke(r, g, b), marker.fill(r, g, b)
	 */
	public void draw(PApplet marker) {
		super.draw(marker);
		marker.rect((float)x, (float)y, (float)width, (float)height);
	}
	
	/**
	 * Rotates the rectangle 90 degrees around the upper left corner.
	 * 
	 */
	public void rotate() {
		double twidth = width;
		width = height;
		height = twidth;
		x -= width;
	}
	
}