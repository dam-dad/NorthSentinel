package dad.northsentinel.model;

import javafx.geometry.Point2D;

class Vector2D {
	
	double x;
	double y;
	
	public Vector2D(Point2D p) {
		this.x = p.getX();
		this.y = p.getY();
	}

	public Vector2D(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public Vector2D subtract(Vector2D other) {
		return new Vector2D(this.x - other.x, this.y - other.y);
	}
	
	public double getModulo() {
		return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
	}

	public Vector2D getNormal(Vector2D v) {
		Vector2D d = v.subtract(this);
		return new Vector2D(d.x / d.getModulo(), d.y / d.getModulo());
	}
	
	public static Vector2D normalizar(Point2D p1, Point2D p2) {
		return new Vector2D(p1).getNormal(new Vector2D(p2));
	}
	
	@Override
	public String toString() {
		return "Vector(" + x + "," + y + ")";
	}
	
	public static void main(String[] args) {
		
		Vector2D v1 = new Vector2D(0, 0);
		Vector2D v2 = new Vector2D(5, 0);
		System.out.println(v1.getNormal(v2));
		
	}
	
}