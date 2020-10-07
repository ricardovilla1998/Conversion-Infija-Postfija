public class ColaG<T>{ 
 private NodoG<T>ini;
 private NodoG<T>fin;
   
   ColaG(){
    ini=null;
    fin=null;
   }//constructor---------------
   
   public boolean estaVacia(){
      return ini==null;
   }//estaVacia----------------
     public NodoG<T> getInicio(){
     return ini;
  }//getIncio--------------------------------
   public void mostrar(){
      if(estaVacia()){
      System.out.println("la lista esta vacia");
 
      }//if 
    else{
      String datos=new String();// es igual String="";
      NodoG<T> actual=ini;
   
    while(actual!=null){
      datos += actual.getDato() + " ";
      actual = actual.getSig();
      }//while
      System.out.println("Elementos: "+datos);
     actual=null;   
      }//else
   }//mostrar----------------------------------------
   
   public void insertar(T valor){
      NodoG<T> nuevo;
 
   if(estaVacia()){
   //cuando no hay elementos....
   nuevo=new NodoG<T>(valor,null);
   ini=nuevo;
   fin=nuevo;
   }else{
  
   nuevo=new NodoG<T>(valor,null);
    fin.setSig(nuevo);
    fin=nuevo;
  }
   nuevo=null;

   }//insertar-------------------------------------------
   
   public void quitar(){
      NodoG<T> actual;
       if(estaVacia()){
         System.out.println("Imposible eliminar, lista vacia");
       }
       else{
         
         if(ini.getSig()==null){
           //Solo existe un elemento
           ini=null;          
         }
         else{
          //Existe mas de un elemento
          actual=ini;
          ini=ini.getSig();
          actual.setSig(null);
          actual=null;
         }
       }
    }//quitar------------------------------*/
      public void quitarFinal(){
      NodoG<T> actual;
       if(estaVacia()){
         System.out.println("Imposible eliminar, lista vacia");
       }
       else{
         
         if(ini.getSig()==null){
           //Solo existe un elemento
           ini=null;          
         }
         else{
          //Existe mas de un elemento
          actual=ini;
          ini=ini.getSig();
          actual.setSig(null);
          actual=null;
         }
       }
    }//quitar------------------------------*/
    
   //Mostrar al usuario el primer elemento de la cola// 
   public T frente(){
     if(estaVacia()){
         System.out.println("Cola vacia");
         return null;
       }
      
    else{
     return ini.getDato();
    }
  
   }//frente----------------------------------
    
    
}//class
