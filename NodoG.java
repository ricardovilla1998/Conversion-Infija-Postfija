public class NodoG<T>{
   private T dato;
   private NodoG<T> sig;
   
   NodoG(T dato,NodoG<T> sig){
      this.dato = dato;
      this.sig = sig;
   }
   
   public void setDato(T dato){
      this.dato = dato;
   }
   
   public T getDato(){
      return dato;
   }
   
   public void setSig(NodoG<T> sig){
      this.sig=sig;      
   }
   
   public NodoG<T> getSig(){
      return sig;
   }
   
   
}//class