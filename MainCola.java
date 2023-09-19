package colaOperacionesafuncionales;

public class MainCola {
	public static void main(String[] args) {
		//Prueba con una cola de enteros
		Colafuncional<Integer> colaenteros= new Colafuncional<>();
		  colaenteros.enqueue(1);
	        colaenteros.enqueue(2);
	        colaenteros.enqueue(3);
	        colaenteros.enqueue(4);
	        colaenteros.enqueue(5);

	        // Test de las operaciones de Colafuncional
	        Colafuncional<Integer> filtered = colaenteros.filter(x -> x % 2 == 0);
	        System.out.println("Filtered Queue: " + filtered.getItems());

	        Colafuncional<Integer> mapped = colaenteros.map(x -> x * 2);
	        System.out.println("Mapped Queue: " + mapped.getItems());

	        Integer foundItem = colaenteros.find(x -> x == 3);
	        System.out.println("Found Item: " + foundItem);

	        int index = colaenteros.findIndex(x -> x == 4);
	        System.out.println("Index of 4: " + index);

	        Integer lastItem = colaenteros.findLast(x -> x % 2 == 0);
	        System.out.println("Last Even Item: " + lastItem);

	        int lastIndex = colaenteros.findLastIndex(x -> x % 2 == 0);
	        System.out.println("Last Even Item Index: " + lastIndex);

	        System.out.println("ForEach:");
	        colaenteros.forEach(System.out::println);

	        Colafuncional<Integer> sortedQueue = colaenteros.sort(Integer::compareTo);
	        System.out.println("Sorted Queue: " + sortedQueue.getItems());
}
