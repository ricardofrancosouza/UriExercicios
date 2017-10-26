package controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import Annotation.Tipo;

public class Util {
	public static Object getValue(final Object obj) {
		try {
			Class<?> clazz = obj.getClass();
			for (Method method : clazz.getDeclaredMethods()) {
				if (method.isAnnotationPresent(Tipo.class)) {
					Tipo anotation = method.getAnnotation(Tipo.class);
					if (anotation.calculo()) {
						int paramentros = method.getParameters().length;
						if (paramentros > 0) {
							if (method.getName().equals("calcTimeGame")) {
								int hr1 = 0, hr2 = 0;
								try {
									BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
									try{
									hr1 = Integer.parseInt(buf.readLine());
									hr2 = Integer.parseInt(buf.readLine());
									}catch(Exception e){
										System.out.println("Insira Numero");
									}
								//	String[] args = new String[paramentros];
									
									int qtdHors = (int) method.invoke(obj, hr1, hr2);
									StringBuilder resBuilder = new StringBuilder();
									resBuilder.append("Tempo do Jogo: ");
									resBuilder.append(qtdHors);
									
									System.out.println(resBuilder.toString());
								//	method.invoke(obj, [])
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						}
					}
				}
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static Object getValue(final Object obj, String exercise) {
		try {
			Class<?> clazz = obj.getClass();
			for (Method method : clazz.getDeclaredMethods()) {
				if (method.isAnnotationPresent(Tipo.class)) {
					Tipo anotation = method.getAnnotation(Tipo.class);
					if (anotation.calculo()) {
						int paramentros = method.getParameters().length;
						if (paramentros > 0) {
							if (method.getName().equals("calcTimeGame") && "calcTimeGame".equals(exercise) ) {
								int hr1 = 0, hr2 = 0;
								try {
									System.out.println("Insira Hora 1");
									hr1 = System.in.read();
									System.out.println("Insira Hora 2");
									hr2 = System.in.read();
								//	String[] args = new String[paramentros];
									
									int qtdHors = (int) method.invoke(obj, hr1, hr2);
									StringBuilder resBuilder = new StringBuilder();
									resBuilder.append("Tempo do Jogo: ");
									resBuilder.append(qtdHors);
									
									System.out.println(resBuilder.toString());
								//	method.invoke(obj, [])
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						}
					}
				}
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		return null;
	}


	public static Map<BigDecimal, String> getExercise(Object obj)
			throws InvocationTargetException, IllegalAccessException {
		Map<BigDecimal, String> exercicioMap = new HashMap<BigDecimal, String>();

		try {
			Class clazz = obj.getClass();
			int index = 1;
			for (Method m : clazz.getDeclaredMethods()) {
				exercicioMap.put(BigDecimal.valueOf(index), m.getName());
					
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();

		}
		return exercicioMap;
	}
	public static Object createNewInstance(Class clazz) {
		Constructor<?> construtor;
		try {
			construtor = clazz.getConstructors()[0];
			Object obj = construtor.newInstance();
			return obj;
		} catch (InstantiationException | IllegalAccessException
				| InvocationTargetException | SecurityException
				| IllegalArgumentException e) {
			e.printStackTrace();
		}

		return null;
	}

}
