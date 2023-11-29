package com.threads;

import java.io.*;

public class DeserializeExample {
    public static void main(String[] args) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("object.ser"))) {
            MyClass1 myObject = (MyClass1) ois.readObject();
            System.out.println("Object has been deserialized");
            // Use the deserialized object as needed
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
//Output :Object has been deserialized