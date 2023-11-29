package com.threads;

import java.io.Externalizable;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.IOException;

import java.io.*;

public class MyExternalizableClass implements Externalizable {

	private int intValue;
	private String stringValue;

	// Constructors, methods, etc.

	public MyExternalizableClass() {
		// Default constructor (required for Externalizable)
	}

	public MyExternalizableClass(int intValue, String stringValue) {
		this.intValue = intValue;
		this.stringValue = stringValue;
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		// Custom code to write object fields to the stream
		out.writeInt(intValue);
		out.writeUTF(stringValue);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		// Custom code to read object fields from the stream
		intValue = in.readInt();
		stringValue = in.readUTF();
	}

	@Override
	public String toString() {
		return "MyExternalizableClass{" + "intValue=" + intValue + ", stringValue='" + stringValue + '\'' + '}';
	}

	public static void main(String[] args) {
		// Externalization
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("externalObject.ser"))) {
			MyExternalizableClass myObject = new MyExternalizableClass(42, "Hello, Externalization!");
			oos.writeObject(myObject);
			System.out.println("Object externalized successfully.");
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Deserialization
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("externalObject.ser"))) {
			MyExternalizableClass deserializedObject = (MyExternalizableClass) ois.readObject();
			System.out.println("Object externalized successfully:");
			System.out.println(deserializedObject);
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
