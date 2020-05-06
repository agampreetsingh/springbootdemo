package com.springboot.demo.topicsapp;

import static com.esotericsoftware.kryo.Kryo.NULL;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.serializers.DefaultArraySerializers.ObjectArraySerializer;

public class DoubleSerializer extends ObjectArraySerializer{

	public DoubleSerializer(Kryo kryo, Class type) {
		super(kryo, type);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void write (Kryo kryo, Output output, Object[] object) {
		if (object == null) {
			output.writeByte(NULL);
			return;
		}
		int n = object.length;
		output.writeVarInt(n + 1, true);
		Class elementClass = double[].class;
		if (kryo.isFinal(elementClass)) {
			Serializer elementSerializer = kryo.getSerializer(elementClass);
			
				for (int i = 0; i < n; i++)
					kryo.writeObject(output, object[i], elementSerializer);
			
		} else {
			for (int i = 0; i < n; i++)
				kryo.writeClassAndObject(output, object[i]);
		}
	}

	@Override
	public double[][] read (Kryo kryo, Input input, Class type) {
		int n = input.readVarInt(true);
		if (n == NULL) return null;
		n--;
		double[][] object = (double[][])Array.newInstance(type.getComponentType(), n);
		kryo.reference(object);
		Class elementClass = double[].class;
		if ( kryo.isFinal(elementClass)) {
			Serializer elementSerializer = kryo.getSerializer(elementClass);
			 
				for (int i = 0; i < n; i++)
					object[i] = (double[]) kryo.readObject(input, elementClass, elementSerializer);
			
		} else {
			for (int i = 0; i < n; i++)
				object[i] = (double[]) kryo.readClassAndObject(input);
		}
		return object;
	}


	
}
