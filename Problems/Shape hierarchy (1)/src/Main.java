abstract class Shape {

    abstract double getPerimeter();

    abstract double getArea();
}
class Triangle extends Shape {

    double a;
    double b;
    double c;

    public Triangle(double a, double b , double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    double getPerimeter() {
        return this.a + this.b + this.c;
    }
    @Override
    double getArea() {
        double p = 0.5 * getPerimeter();

        return Math.sqrt(p* (p-a) * (p-b) * (p-c));
    }
}
class Rectangle extends Shape {
    double a;
    double b;

    public Rectangle (double a, double b) {
        this.a = a;
        this.b = b;
    }
    @Override
    double getPerimeter() {
        return (this.a + this.b) * 2;
    }
    @Override
    double getArea(){
        return this.a * this.b;
    }
}
class Circle extends Shape {
    double radius;

    public Circle (double radius) {
        this.radius = radius;
    }
    @Override
    double getPerimeter() {
        return this.radius * Math.PI * 2;
    }
    @Override
    double getArea(){
        return Math.pow(this.radius,2) * Math.PI;
    }
}
