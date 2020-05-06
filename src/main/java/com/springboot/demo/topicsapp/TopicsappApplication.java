package com.springboot.demo.topicsapp;

import java.io.ByteArrayOutputStream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

@SpringBootApplication
public class TopicsappApplication {

	public static void main(String[] args) {
		
		sample();
		SpringApplication.run(TopicsappApplication.class, args);
	}
	
	public static void sample() {
		double[][] arr = {{0.002,0.00415,121.145},
				{0.002,0.0015,121.145},
				{0.002,0.00415,121.145}
		};
		
		Kryo kryo = new Kryo();
		kryo.setRegistrationRequired(false);
		kryo.addDefaultSerializer(double[][].class,DoubleSerializer.class);
		Output output = new Output(new ByteArrayOutputStream());
		
		kryo.writeObject(output, arr);
		byte[] barr = output.toBytes();
		
		
		double[][] searr = getDesObj(barr);
 	}

	private static double[][] getDesObj(byte[] barr) {
		Kryo kryo = new Kryo();
		kryo.setRegistrationRequired(false);
		kryo.addDefaultSerializer(double[][].class,DoubleSerializer.class);
		Input i = new Input(barr);
		double[][] darr = kryo.readObject(i, double[][].class);
		System.out.println(darr[1][1]);
		return darr;
	}

}
