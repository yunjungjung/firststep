package com.itwill.inheritance08;

public class Circle extends Shape {
	// field
	private double radius;
	
	// constructor
	public Circle(double radius) {
		super("원");
		this.radius= radius;
		
	}
		
	@Override
		public double area() {
		    return Math.PI *radius * radius;
	}
			
	@Override
	public double perimeter() {
		return 2 * Math.PI * radius;
		}
	}

