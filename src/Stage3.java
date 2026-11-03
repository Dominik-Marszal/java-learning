import java.util.ArrayList;
import java.util.List;

public class Stage3 {

    static void exercise1() {
        class Book {
            private String title;
            private String author;
            private boolean isRead = false;

            public Book(String title, String author) {
                this.title = title;
                this.author = author;
            }

            public String getTitle() {
                return title;
            }
            public String getAuthor() {
                return author;
            }
            public boolean isRead() {
                return isRead;
            }
            public void markAsRead() {
                isRead = true;
            }

            @Override
            public String toString() {
                String status = isRead ? "read" : "not read";
                return "\"" + title + "\" " + "by " + author + " - " + status;
            }
        }
        Book book = new Book("Book 1", "John Smith");
        System.out.println(book);
        book.markAsRead();
        System.out.println(book);

    }

    static void exercise2() {
        class Book {
            private String title;
            private String author;
            private boolean isRead = false;
            private int pageCount;

            public Book(String title, String author) {
                this.title = title;
                this.author = author;
            }

            public int getPageCount() {
                return pageCount;
            }

            public void setPageCount(int pageCount) {
                if (pageCount > 0)
                    this.pageCount = pageCount;
                else {
                    System.out.println("Page count must be positive");
                }
            }
        }

        Book book = new Book("Book 1", "John Smith");

        book.setPageCount(-4);
        System.out.println("After -4: " + book.getPageCount());

        book.setPageCount(300);
        System.out.println("After 300: " + book.getPageCount());

        book.setPageCount(-10);
        System.out.println("After -10: " + book.getPageCount());
    }

    static void exercise3() {
        class Animal {
            protected String name;

            public Animal(String name) {
                this.name = name;
            }

            public String makeSound(){
                return "Some generic sound";
            }
        }

        class Dog extends Animal {

            public Dog(String name) {
                super(name);
            }

            @Override
            public String makeSound(){
                return "Woof!";
            }
        }

        class Cat extends Animal {

            public Cat(String name) {
                super(name);
            }

            @Override
            public String makeSound(){
                return "Meow!";
            }
        }

        Animal animal = new Animal("Generic");
        Animal dog = new Dog("Clifford");
        Animal cat = new Cat("Mruczek");
        System.out.println("Animal: " + animal.makeSound());
        System.out.println("Dog: " + dog.makeSound());
        System.out.println("Cat: " + cat.makeSound());
    }

    static void exercise4() {
        class Car {
            protected String name;

            public Car(String name){
                this.name = name;
            }

            public String engineStart(){
                return "Engine starts";
            }
        }

        class MyCar extends Car {
            public MyCar(String name){
                super(name);
            }

            @Override
            public String engineStart(){
                return "Engine error";
            }
        }

        class NeighborCar extends Car {
            public NeighborCar(String name){
                super(name);
            }

            @Override
            public String engineStart(){
                return "Engine starts smoothly";
            }
        }

        Car car1 = new Car("Ford");
        System.out.println("Generic car: " + car1.engineStart());
        Car car2 = new MyCar("Audi");
        System.out.println("my car: " + car2.engineStart());
        Car car3 = new NeighborCar("BMW");
        System.out.println("Neighbour's car: " + car3.engineStart());
        System.out.println();

        List <Car> carList = new ArrayList<>();
        carList.add(car2);
        carList.add(car3);

        for (Car car : carList) {
            System.out.println(car.engineStart());
        }
    }

    static void exercise5() {

        interface Payable{
            double calculatePay();
        }

        class Employee implements Payable{
            private double salary;

            public Employee(double salary) {
                this.salary = salary;
            }

            @Override
            public double calculatePay() {
                return salary;
            }
        }

        class Freelancer implements Payable{
            private double hourlyRate;
            private double hoursWorked;

            public Freelancer(double hourlyRate, double hoursWorked) {
                this.hourlyRate = hourlyRate;
                this.hoursWorked = hoursWorked;
            }

            @Override
            public double calculatePay() {
                return hourlyRate * hoursWorked;
            }
        }

        List<Payable> payableList = new ArrayList<>();
        Employee employee1 = new Employee(5000);
        Freelancer freelancer1 = new Freelancer(31.40, 137);

        payableList.add(employee1);
        payableList.add(freelancer1);

        for (Payable payable : payableList) {
            System.out.println(payable.calculatePay());
        }

    }

    static void exercise6() {

        class Shape {

            public Shape() {

            }

            public double getArea() {
                return 0;
            }

        }

        class Circle extends Shape {
            public double r;

            public Circle(double r) {
                this.r = r;
            }

            @Override
            public double getArea() {
                return Math.PI * r * r;
            }
        }

        class Rectangle extends Shape {
            public double width;
            public double height;

            public Rectangle(double width, double height) {
                this.width = width;
                this.height = height;
            }

            @Override
            public double getArea() {
                return width * height;
            }
        }

        List<Shape> shapes = new ArrayList<>();

        Circle circle1 = new Circle(5);
        Circle circle2 = new Circle(9);
        Rectangle rectangle1 = new Rectangle(3, 5);
        Rectangle rectangle2 = new Rectangle(3.6, 7.4);

        shapes.add(circle1);
        shapes.add(circle2);
        shapes.add(rectangle1);
        shapes.add(rectangle2);

        for (Shape shape : shapes) {
            System.out.println(shape.getArea());
        }

        double sum = 0;
        for (Shape shape : shapes) {
            sum += shape.getArea();
        }

        System.out.println(sum);

    }

    public static void main(String[] args){
        exercise6();
    }
}
