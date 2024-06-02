package alexlewis9.shapes;

import processing.core.PApplet;
import java.awt.Color;

/**
 * This shapes.Shape class represents a double precision shape that can be drawn using the Processing library.
 * 
 * @author Alex
 * @version 2020-10-15
 * 
 */
public abstract class Shape {
	
	/**
	 * The x-coordinate of the shapes.Shape.
	 */
	protected double x;
	/**
	 * The y-coordinate of the shapes.Shape.
	 */
	protected double y;
	/**
	 * The red of the color of the shapes.Shape.
	 */
	private Color strokeColor = new Color(0, 0, 0);
	private Color fillColor = new Color(0, 0, 0);
	private boolean isFilled = false;
	
	/**
	 * Initializes a new shapes.Shape with given coordinates.
	 * 
	 * @param x X-coordinate of shapes.Shape.
	 * @param y Y-coordinate of shapes.Shape.
	 */
	public Shape (double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Initializes a new shapes.Shape with given coordinates and color.
	 * 
	 * @param x X-coordinate of shapes.Shape.
	 * @param y Y-coordinate of shapes.Shape.
	 * @param r Red.
	 * @param g Green.
	 * @param b Blue.
	 */
	public Shape (double x, double y, int r, int b, int g) {
		this.x = x;
		this.y = y;
		this.strokeColor = new Color(r, g, b);
	}
	
	/**
	 * Initializes a new shapes.Shape with given coordinates and color.
	 * 
	 * @param x X-coordinate of shapes.Shape.
	 * @param y Y-coordinate of shapes.Shape.
	 * @param strokeColor Stroke color.
	 */
	public Shape (double x, double y, Color strokeColor) {
		this.x = x;
		this.y = y;
		this.strokeColor = strokeColor;
	}
	
	/**
	 * Draws the shapes.Shape to the given Processing PApplet.
	 * @param surface The Processing PApplet on which to draw the shapes.Shape
	 */
	public void draw(PApplet surface) {
		surface.stroke(strokeColor.getRGB());
		if (this.isFilled)  {
			surface.fill(fillColor.getRGB());
		} else {
			surface.noFill();
		}
	}
	
	/**
	 * Returns the x-coordinate of the shape.
	 * 
	 * @return The x-coordinate of the shape.
	 */
	public double getX() {
		return x;
	}
	
	/**
	 * Returns the y-coordinate of the shape.
	 * 
	 * @return The y-coordinate of the shape.
	 */
	public double getY() {
		return y;
	}
	
	/**
	 * Sets the x-coordinate of the shape.
	 * 
	 * @param x X-coordinate of the shape.
	 */
	public void setX(double x) {
		this.x = x;
	}
	
	/**
	 * Sets the y-coordinate of the shape.
	 * 
	 * @param y Y-coordinate of the shape.
	 */
	public void setY(double y) {
		this.y = y;
	}
	
	/**
	 * Sets the coordinates of the shape.
	 * 
	 * @param x X-coordinate of the shape.
	 * @param y Y-coordinate of the shape.
	 */
	public void setCoordinates(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Moves the shape.
	 * 
	 * @param xMove Distance to move the shape in the x direction.
	 * @param yMove Distance to move the shape in the y direction.
	 */
	public void move(double xMove, double yMove) {
		this.x += xMove;
		this.y += yMove;
	}
	
	
	/**
	 * Calculates the area of the shapes.Shape.
	 * 
	 * @return The area of the shapes.Shape.
	 */
	public abstract double getArea();
	
	/**
	 * Calculates the perimeter of the shapes.Shape.
	 * 
	 * @return The perimeter of the shapes.Shape.
	 */
	public abstract double getPerimeter();
	
	/**
	 * Tests whether the point x, y is contained inside this shapes.Shape.
	 * 
	 * @param x X-coordinate of the point.
	 * @param y Y-coordinate of the point.
	 * @return True if the point x, y is contained inside this shapes.Shape, false otherwise.
	 */
	public abstract boolean isPointInside(double x, double y);
	
	/**
	 * Sets the stroke color of the shapes.Shape.
	 * 
	 * @param color Stroke color.
	 */
	public void setStrokeColor(Color color) {
		strokeColor = color;
	}
	
	/**
	 * Sets the fill color of the shapes.Shape.
	 * 
	 * @param color Fill color.
	 */
	public void setFillColor(Color color) {
		fillColor = color;
	}
	
	/**
	 * Sets if the shapes.Shape if filled.
	 * 
	 * @param isFilled True if the color is filled, false if not.
	 */
	public void isFilled(Boolean isFilled) {
		this.isFilled = isFilled;
	}

}
