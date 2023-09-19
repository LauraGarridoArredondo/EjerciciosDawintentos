package colaOperacionesafuncionales;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.ArrayList;
import java.util.Comparator;

public class Colafuncional <T> {

	private List<T> cola =new ArrayList<>();
	
	public void enqueue(T proceso) {
		cola.add(proceso);
	}
	
	public T dequeue() {
		if(cola.isEmpty()) {
			return cola.remove(0);
		}
		else {
			return null;
		}
	}
	
	public List<T> traerProcesos(){
		return cola;
	}
	
	//Funcion Filter
	public Colafuncional<T> filter(Predicate <T> condicion){
		System.out.println("Filtra en base a una condicion y devuelve una lista con los elementos que pasan esta condicion");
		Colafuncional<T> resultado= new Colafuncional<>();
		cola.stream().filter(condicion).forEach(resultado::enqueue);
		return resultado;
	}
	
	//Funcion Map
	public <R> Colafuncional<R> map(Function <T,R> mapper){
	System.out.println("Devuelve una lista con los elementos transformado a traves de la funcion");
	Colafuncional<R> resultado = new Colafuncional<>();
	cola.stream().map(mapper).forEach(resultado::enqueue);
	return resultado;
		
	}
	
	//Funcion Find
	
	public T find(Predicate <T> condicion) {
		System.out.println("Devuelve el elemento que cumple con una condicion, si no null");
		return cola.stream().filter(condicion).findFirst().orElse(null);
	}
	
	//Funcion FindIndex
	
	public int findIndex(Predicate <T> condicion) {
		System.out.println("Devuelve el indide del elemento que cumple una condicion, si no -1.");
		int index= -1;
		for(int i=0; i<cola.size(); i++) {
			if(condicion.test(cola.get(i))) {
				index = i;
				break;
			}
		}
		return index;
	}

	//Funcion FindLast
	public T findLast(Predicate<T> condicion) {
		System.out.println("Devuelve el ultimo elemento que cumple una condicion, si no null");
		for (int i= cola.size() -1;i>=0;i--) {
			if (condicion.test(cola.get(i))) {
				return cola.get(i);
			}
		}
		return null;
	}
	
	//Funcion FindLastIndex
	
	public int findLastIndex(Predicate<T> condicion) {
		System.out.println("Devuelbe el ultimo elemento que cumple una condicion, si no -1");
		int index =-1;
		for(int i = cola.size() -1; i >=0; i--) {
			if(condicion.test(cola.get(i))) {
				index= i;
				break;
			}
		}
		return index;
	}
	
	//Funcion ForEach
	public void forEach(Consumer<T> accion) {
		System.out.println("Ejecuta una funcoin por cada elemento de la lista");
		cola.forEach(accion);
	}
	
	//Funcion Sort
	
	public Colafuncional<T> sort(Comparator <T> comparador){
		System.out.println("Devuelbe la lista ordenada en base a una condicion");
		Colafuncional<T> resultado= new Colafuncional<>();
		cola.stream().sorted(comparador).forEach(resultado::enqueue);
		return resultado;
	}
	
}
