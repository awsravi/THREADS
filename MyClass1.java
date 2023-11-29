package com.threads;

import java.io.*;

public class MyClass1 implements Serializable {
    private int intValue;
    private String stringValue;

    // Constructors, getters, setters, and other methods...

    public MyClass1(int i, String string) {
		// TODO Auto-generated constructor stub
	}
    //Output Object has been serialized
	public static void main(String[] args) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("object.ser"))) {
            MyClass1 myObject = new MyClass1(42, "Hello, Serialization!");
            oos.writeObject(myObject);
            System.out.println("Object has been serialized");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
