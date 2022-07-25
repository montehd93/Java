package application;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Program {
	public static void main(String[] args) {

		List<String> list = new ArrayList<>();

		list.add("Maria");
		list.add("ALEX");
		list.add("BOB");
		list.add("Anna");
		list.add(2, "Marco");

		//Lista o tamanho da lista.
		System.out.println(list.size());

		//Remove o elemento podendo ser o nome ou posição no array.
		list.remove("Anna");
		for (String x : list) {
			System.out.println(x);
		}

		System.out.println("----------------------------");
		// Remover palavras com base na função lambda e o caracteres passado.
		list.removeIf(x -> x.charAt(0) == 'M'); 
		for (String x : list) {
			System.out.println(x);
		}
		System.out.println("----------------------------");
		//Encontra se possui e a posição da palavra
		System.out.println("Index of Bob: " + list.indexOf("BOB")); 
		System.out.println("Index of Marco: " + list.indexOf("Marco"));
		System.out.println("----------------------------");
		//Filtra todos as palavras com o caractere na pos 0
		List<String> result = list.stream().filter(x -> x.charAt(0) == 'A').collect(Collectors.toList()); 
		for (String x : result) {
			System.out.println(x);
		}
		System.out.println("----------------------------");
		// Encontrar o primeiro elemento com o caractere na pos 0, caso não irá retornar null
		String name = list.stream().filter(x -> x.charAt(0) == 'A').findFirst().orElse(null); 
		System.out.println(name);
	}
}
