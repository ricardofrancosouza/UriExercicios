package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import exercise.Exercicios;
import controller.Util;

public class View {

	public static void main(String[] args) {
		try {
			Object obj;
			Map<BigDecimal, String> exercicioMap = new HashMap<BigDecimal, String>();

			obj = Class.forName("exercise.Exercicios").newInstance();
			exercicioMap.putAll(Util.getExercise(obj));

			System.out.println("========== SELECIONAR EXERCICIOS =========");
			for (Map.Entry<BigDecimal, String> entry : exercicioMap.entrySet()) {
				StringBuilder strBuilder = new StringBuilder();
				strBuilder.append(entry.getKey());
				strBuilder.append(" - ");
				strBuilder.append(entry.getValue());
				System.out.println(strBuilder.toString());
			}
			StringBuilder strBuilder = new StringBuilder();
			strBuilder.append("x");
			strBuilder.append(" - ");
			strBuilder.append("Exit");
			System.out.println(strBuilder.toString());
			String exit = "";
			while (!exit.equals("x")) {
				BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
				int op = 0;
				try {
					op = Integer.parseInt(buf.readLine());
				} catch (Exception e) {
					exit = buf.readLine();
				}

				try {
					
					Util.getValue(obj, exercicioMap.get(op));
					Util.getValue(obj);
					op =0;
				} catch (Exception e) {
					System.out.println("Escolha uma opção valida");
				}

				// if (!exercicioMap.get(op).equals("")) {
				// Util.getValue(obj, exercicioMap.get(op));
				// } else {
				// System.out.println("Escolha uma opção valida");
				// }
			}

		} catch (IOException | InvocationTargetException
				| InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
