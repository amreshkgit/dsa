package Serialization;

import java.io.*;

class Student implements Serializable {
    private String name;
    private transient int age;
    private static int year;

    public void student(){
        System.out.println("default constructor");
    }
    public Student(){
        System.out.println("This is a constructor");
        this.name = "Krishna";
        this.age = 25;
    }
    public Student(String name, int age){
        System.out.println("Calling constructor");
        this.name = name;
        this.age = age;
    }
    public void display() {
        System.out.println("Name: "+this.name);
        System.out.println("Age: "+this.age);
        System.out.println("Year: "+Student.year);
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setYear(int year) {
        Student.year = year;
    }
}

public class SerializeExample{
    public static void main(String args[]) throws Exception{
        //Creating a Student object
        Student std = new Student("Vani", 27);
        //Serializing the object
        FileOutputStream fos = new FileOutputStream("student.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(std);
        oos.close();
        fos.close();
        //Printing the data before de-serialization
        System.out.println("Values before de-serialization");
        std.display();
        //Changing the static variable value
        std.setYear(2019);
        //Changing the instance variable value
        std.setName("Varada");
        //Changing the transient variable value
        std.setAge(19);
        System.out.println("Object serialized.......");
        //De-serializing the object
        FileInputStream fis = new FileInputStream("student.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Student deSerializedStd = (Student) ois.readObject();
        System.out.println("Object de-serialized.......");
        ois.close();
        fis.close();
        System.out.println("Values after de-serialization");
        deSerializedStd.display();
    }
}