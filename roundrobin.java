package ejercicio2Daw;

import java.util.UUID;
import java.util.ArrayList;
public class roundrobin {
UUID pid;
String PX;
long creacion;
long modificacion;
int quantum;
int prioridad;


	public roundrobin(String PX, int numeroproceso) {
	super();
	this.pid = UUID.randomUUID();
	this.PX = PX +numeroproceso;
	this.creacion = System.currentTimeMillis();
	this.modificacion = this.creacion;
	this.quantum = (int)(Math.random()*100)+1;
	this.prioridad = (int)(Math.random()*9);
}
	public void ejecucion() {
		System.out.println("Ejecutandose proceso :"+PX);
		modificacion= System.currentTimeMillis();
		quantum--;
	}
	
	public boolean finalproceso() {
		return quantum <= 0;
	}
	public int getPrioridad() {
		return prioridad;
	}

	public static void main(String[] args) {
		ArrayList<roundrobin> colaprioridad = new ArrayList<>();
		
		for(int i=1;i<=50;i++) {
			roundrobin proceso =new roundrobin("P",i);
			colaprioridad.add(proceso);
		}
		
		int prioridadActual= 0;
		while (!colaprioridad.isEmpty()) {
			roundrobin procesoActual =colaprioridad.remove(0);
			procesoActual.ejecucion();
			if(!procesoActual.finalproceso()){
				colaprioridad.add(procesoActual);
			}
			prioridadActual = (prioridadActual +1) %9;
		}
		if(colaprioridad.isEmpty()) {
			System.out.println("Todos los procesos se han completado");
			System.out.println("Prioridad actual: "+prioridadActual);
		}else
		{System.out.println("No se han completado todos los procesos");
		System.out.println("Prioridad actual: "+prioridadActual);}
	}
	
}
