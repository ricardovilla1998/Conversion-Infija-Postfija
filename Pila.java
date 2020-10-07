public class Pila<T>{
   private NodoG<T>tope;
   
   Pila(){
      tope = null;
   }//constructor---------------
   
   public void setTope(NodoG<T>tope){
      this.tope = tope;
   }//setTope------------------
   
   public NodoG<T> getTope(){
      return tope;
   }//getTope-------------------
   
   public boolean estaVacia(){
      return tope==null;
   }//estaVacia----------------
   
   public void mostrar(){
      if(estaVacia()){
      System.out.println("La pila esta vacia");
 
      }//if 
    else{
      String datos=new String();// es igual String="";
      NodoG<T> actual= tope;
   
    while(actual!=null){
      datos += actual.getDato() + " ";
      actual = actual.getSig();
      }//while
      System.out.println("Elementos: "+datos);
     actual=null;   
      }//else
   }//mostrar----------------------------------------
   
   //Metodo para poner elementos en la pila//
   public void push(T valor){
      NodoG<T> nuevo;
      if(estaVacia()){
       //Cuando no hay elementos
       nuevo=new NodoG<T>(valor,null);
      }
      else{
       nuevo=new NodoG<T>(valor,tope);//El nuevo nodo será el primero
       //ini=nuevo;
      }
       tope=nuevo;
       nuevo=null;//Liberar memoria de nuevo

   }//push-------------------------------------------
   
   public void pop(){
      NodoG<T> actual;
       if(estaVacia()){
         System.out.println("Imposible eliminar, lista vacia");
       }
       else{
         
         if(tope.getSig()==null){
           //Solo existe un elemento
           tope=null;          
         }
         else{
          //Existe mas de un elemento
          actual=tope;
          tope=tope.getSig();
          actual.setSig(null);
          actual=null;
         }
       }
    }//pop------------------------------
    
   public  T tope(){
      return tope.getDato();
   }
  
  public void vaciar(){
      for(int i=0;tope!=null;i++){
       pop();
      }
      
   }//getTope-------------------

   
}//class