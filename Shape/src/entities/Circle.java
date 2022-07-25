package entities;

import entities.enums.Color;

public class Circle extends Shape{
	public Double radius;
	
	public Circle() {
		super();
	}

	public Circle(Color color, Double radius) {
		super(color);
		this.radius = radius;
	}

	public Double getRadius() {
		return radius;
	}

	public void setRadius(Double radius) {
		this.radius = radius;
	}
	public Double area() {
		return Math.pow(radius, 2) * Math.PI;
	}
}
