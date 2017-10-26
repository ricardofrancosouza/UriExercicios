package exercise;

import java.sql.Timestamp;

import Annotation.Tipo;

public class Exercicios {
	@Tipo(calculo = true)
	public  int calcTimeGame(int hr1, int hr2){
		Timestamp hr1Times = new Timestamp(0);
		Timestamp hr2Times = new Timestamp(0);
		hr1Times.setHours(hr1);
	    hr2Times.setHours(hr2);
	    int respTime = hr1Times.getHours() - hr2Times.getHours();
		return respTime;
	}
}
