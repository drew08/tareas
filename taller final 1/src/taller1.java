
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

import org.w3c.dom.Node;


//Andrew Rincon G.
//258051




public class taller1 {
	
	// metodo mergeSort para arraylist

	public static ArrayList<Integer> mergeSort(ArrayList<Integer> ListaEnDesorden)
	{
		if(ListaEnDesorden.size() <= 1)
		{
			return ListaEnDesorden;
		}
		ArrayList<Integer> ListaOrdenada = new ArrayList<Integer>();

		ArrayList<Integer> Izquierda = new ArrayList<Integer>();
		ArrayList<Integer> Derecha = new ArrayList<Integer>();
		int mitad = ListaEnDesorden.size()/2;
		//Splits the array into ListaEnDesorden size lists of size one
		for(int i = 0; i < ListaEnDesorden.size(); i++)
		{
			if(i < mitad)
			{
				Izquierda.add(ListaEnDesorden.get(i));
			}
			else
			{
				Derecha.add(ListaEnDesorden.get(i));
			}
		}
		Izquierda = mergeSort(Izquierda); 
		Derecha = mergeSort(Derecha);
		//combina las listas
		ListaOrdenada = merge(Izquierda, Derecha);
		return ListaOrdenada;
	}

	public static ArrayList<Integer> merge(ArrayList<Integer> Izquierda, ArrayList<Integer> Derecha)
	{
		ArrayList<Integer> mergedList = new ArrayList<Integer>();
		while(Izquierda.size() > 0 || Derecha.size() > 0)
		{
			if(Izquierda.size() > 0 && Derecha.size() > 0)
			{
				if(Izquierda.get(0) < Derecha.get(0))
				{
					mergedList.add(Izquierda.get(0));
					Izquierda.remove(0);
				}
				else
				{
					mergedList.add(Derecha.get(0));
					Derecha.remove(0);
				}
			}
			else if(Izquierda.size() > 0)
			{
				mergedList.add(Izquierda.get(0));
				Izquierda.remove(0);
			}
			else if(Derecha.size() > 0)
			{
				mergedList.add(Derecha.get(0));
				Derecha.remove(0);
			}
		}
		return mergedList;
	}
	
	
	
	// metodos taller.......................................................................................
	
	// metodo 1 ............
	
	 public static void sort(ArrayList<Integer> List, int start, int end){
		 
		  ArrayList<Integer> sublist = new ArrayList<Integer>();
		 
		  sublist = new ArrayList<Integer>(List.subList(start,end));
		 		 		 	 
		  System.out.println(mergeSort(sublist));
     	
      }
     
	// metodo 2 ............
     public static void sort(ArrayList<Integer> List, int start, int end, Comparator c){
    	 
    	  ArrayList<Integer> sublist = new ArrayList<Integer>();
		 
		  sublist = new ArrayList<Integer>(List.subList(start,end));
		 		 		 	 
		  System.out.println(mergeSort(sublist,c));
    	     	     	 
      }
     
  // metodo 3 ............
     public static void randomize(ArrayList<Integer> List, int start, int end){
     	 	 
    	  ArrayList<Integer> sublist = new ArrayList<Integer>();
		 
		  sublist = new ArrayList<Integer>(List.subList(start,end));
		  
		  Collections.shuffle(sublist);
		 		 		 	 
		  System.out.println(sublist);
    	 	 
      }
     //..................mergeSort con comparator....................................................................................
     
     
     private static ArrayList<Integer> mergeSort(ArrayList<Integer> List, Comparator c )
     {
    	 ArrayList<Integer> tempArray = new ArrayList<Integer>();
    	 
     	for (int i = 0; i < List.size(); i++)
     		tempArray.add(null);
     	
     	mergeSort(List,tempArray,0,List.size()-1,c);
     	return tempArray;
     }
     
     private static void mergeSort(ArrayList<Integer> a, ArrayList<Integer> tempArray,
             int Izquierda, int Derecha, Comparator c)
  {
  	if( Izquierda < Derecha )
  	{
  	int centro = ( Izquierda + Derecha ) / 2;
  	mergeSort( a, tempArray, Izquierda, centro,c );
  	mergeSort( a, tempArray, centro + 1, Derecha,c );
  	merge( a, tempArray, Izquierda, centro + 1, Derecha,c );
  	}
  }
     @SuppressWarnings("unchecked")
	private static ArrayList<Integer> merge( ArrayList<Integer> a, ArrayList<Integer> tempArray, int posIzquierda, int PosDerecha, int finalDer,
     		Comparator<Integer> c )
     	{
     		int finalIzq = PosDerecha - 1;
     		int tempPos = posIzquierda;
     		int elementos = finalDer - posIzquierda + 1;

     		//loop principal
     		while( posIzquierda <= finalIzq && PosDerecha <= finalDer )
     			if( c.compare(a.get(posIzquierda),a.get(PosDerecha)) <= 0 )
     				tempArray.set(tempPos++, a.get(posIzquierda++));
     			else
     				tempArray.set(tempPos++, a.get(PosDerecha++));

     		while( posIzquierda <= finalIzq ) //  copia resto de la primera mitad
     			tempArray.set(tempPos++, a.get(posIzquierda++));
     		while( PosDerecha <= finalDer ) //  copia resto de la segunta mitad
     			tempArray.set(tempPos++, a.get(PosDerecha++));

     		for( int i = 0; i < elementos; i++, finalDer-- ) {// Copia tempArray de vuelta
     			a.set(finalDer, tempArray.get(finalDer));
     		}
     		return tempArray;
     		}
     //fin merge comparator
     
     public static <T> void accumulate(T element1,T element2){
 				 
 		ArrayList<T> out = new ArrayList<T>();
 		
 		out.add(element1);
 		out.add(element2);
 		
 		String listString = "";

 		for (T s : out)
 		{
 		    listString += s ;
 		}

 		System.out.println(listString);
 		 	   
 	}
     
     
    public static void printIndexes(ArrayList<Integer> L,ArrayList<Integer> P){
			
    	for (int s : P)
 		{
 
    		if( s < 0 || s >= L.size() ){
    	         throw new IndexOutOfBoundsException
    	            ( "index = " + s + "  size = " + L.size() );
    		}
    		
    		System.out.println(L.get(s));
    		
    		
 		}

     }
    
    public static ArrayList<Integer> union(ArrayList<Integer> a1, ArrayList<Integer> a2) {
		ArrayList<Integer> u = new ArrayList<Integer>(a1.size() + a2.size());
		
		
		for(int i = 0; i<a1.size(); i++){
			for(int j = 0; j<a2.size(); j++) {
				
				if(a2.contains(a1.get(i))){
					
					u.add(a2.get(i));  }
				
				
				else{
						
					u.add(a1.get(i));
					u.add(a2.get(i));
					
					}
					
				}
				
			}
		return u;
		}
		
    public boolean contains1(int item, ArrayList<Integer> list){
		for (int i=0; i< list.size(); i++)
			if (list.get(i).equals(item)) return true;
		return false;
	}
    
    public static ArrayList<Integer>  union2(ArrayList<Integer> a1, ArrayList<Integer> a2)
    
    {
    
    	ArrayList<Integer> union = new ArrayList<>();
    	union.addAll(a1);

    	for(Integer e: a2){
    	    if(!union.contains(e))
    	    	union.add(e);
    	}
		return union;
    }

    public static ArrayList<Integer> interseccion(ArrayList<Integer> lista1, ArrayList<Integer> lista2) {
		ArrayList<Integer> interseccion = new ArrayList<Integer>();
		for(int i = 0; i<lista1.size(); i++) {
			
			
			int x = lista1.get(i);
			
			boolean similar = false;
			int a  = 0;
			
			while(!similar && a < lista2.size()    ) {
				if (lista2.get(a)==x)
					similar = true;
				a++;
			}
			if (similar)
				interseccion.add(x);
		}
		
		return interseccion;
	}

    
//    public void dfs()
//    {
//    	//DFS uses Stack data structure
//    	Stack s=new Stack();
//    	s.push(this.rootNode);
//    	rootNode.visited=true;
//    	printNode(rootNode);
//    	while(!s.isEmpty())
//    	{
//    		Node n=(Node)s.peek();
//    		Node child=getUnvisitedChildNode(n);
//    		if(child!=null)
//    		{
//    			child.visited=true;
//    			printNode(child);
//    			s.push(child);
//    		}
//    		else
//    		{
//    			s.pop();
//    		}
//    	}
//    	//Clear visited property of nodes
//    	clearNodes();
//    }

	public static void main(String[] args) 
	{
		
		ArrayList<Integer> num = new ArrayList<Integer>();
		 
        num.add(2);
        num.add(3);
        num.add(1);
        num.add(9);
//        num.add(5);
//        num.add(7);
//        num.add(8);
        
        ArrayList<Integer> num2 = new ArrayList<Integer>();
        
        num2.add(8);
        num2.add(9);
        num2.add(13);
        num2.add(16);
        
               	   	 
	    Comparator<Integer> comp = new Comparator<Integer>() 
	    		
	    {
	    				    	
		      public int compare(Integer d1, Integer d2) {
		        return d1.compareTo(d2);
		      }
		    };

		   // union(num,num2);
		    
		  //  interseccion(num,num2);
		    
		    System.out.println(union2(num,num2));
		   // System.out.println(interseccion(num,num2));
		    
//		    System.out.println("lista original(desordenada): "+ num);
//		    
//		    
//		    System.out.println("lista ordenada metodo 1:  ");
//		    sort(num , 4, 7);
//		    
//		    System.out.println("lista orden comparator (metodo 2):  ");
//		    sort(num , 0, 5,comp);
//	    
//		    System.out.println("lista orden aleatorio (metodo 3):  ");
//		    
//		    randomize(num , 4, 7);
//		    
//		    System.out.println("metodo accumulate:   ");
//		    		  		   
//		    accumulate(123,344);
		    
		    //_____________________________________________________________________________________________--
		    
		  //  printIndexes(num,num2);
		    
		   
		      		 	    
   }



	

	}

