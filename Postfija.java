import static javax.swing.JOptionPane.*;
public class Postfija{
 
   public static int opPrec(char c){
      int n=0;
      switch(c){
         case '^' : n = 4;
            break;
         case '*' : n = 3;
         case '/' : n = 3;
            break;
         case '+' : n = 2;
         case '-' : n = 2;
            break;
         case '(' : n = 5;
            break;
        
      }
      return n;
   }
   public static boolean validaEx(String expresion){
      int cont=0;
      boolean esValida=true;
      Pila<Character> pila1 = new Pila<Character>();
      for(int i=0;i<expresion.length();i++){
         if(expresion.charAt(i)=='('){
            cont++;
            pila1.push(expresion.charAt(i));
         }
         else if(expresion.charAt(i)==')'){
            if(cont>0){
               pila1.pop();
            }
            cont--;
         }
          //showMessageDialog(null,cont);
      }
            
      if(pila1.getTope()==null&&cont==0){
         return true;//showMessageDialog(null,"Expresion correcta");
      }
      
      else{
         return false;//showMessageDialog(null,"Expresion incorrecta");
      }
   }  //validaEx----------------------------------

   public static void main(String[]args){
      Pila<Character> pila1 = new Pila<Character>();
      Pila<Character> pila2 = new Pila<Character>();
      ColaG<String> cola1 = new ColaG<String>();
      String n="0123456789ABCDEXY";
      String cad=showInputDialog(null,"Inserte la expresion");;///(10+5*10+3)*3///6*5^(4+3*6)+5*8^(4*7)//(6+2)*3/2^2-4//(2+4+3)*3/2///6*(2/5*7+1)
      cad=cad.replace("[","(");
      cad=cad.replace("]",")");
      cad=cad.replace("{","(");
      cad=cad.replace("}",")");
   
      String infi=cad;
      String op="";
      cad=cad+"$";
      cad=cad.replace(" ","");
      //showMessageDialog(null,cad);
      char c;
      int j=0;
      if(validaEx(cad)){
      
         for(int i=0;i<cad.length();i++){
         
            int cont=0;
            c=cad.charAt(i);
            c=cad.charAt(i);
            
            
            if(n.indexOf(c)!=-1){
            
               //cola1.insertar(c+"");
                          
               op=op+c;                  
            }
            
            else{
            
               
               if(!op.equals("")){
               // showMessageDialog(null,op);
                  cola1.insertar(op);
               }
               op="";
               if(c!=')'){
               
                  pila1.mostrar();
                  if(pila1.estaVacia()){
                     
                     pila1.push(c);
                     pila2.push(c);
                    
                    
                     //showMessageDialog(null,"Tope : "+pila1.tope());
                      
                  
                  }
                  else{
                       
                     if(opPrec(c)>opPrec(pila1.tope())){
                        //showMessageDialog(null,"Condicion mayor que"+"\n"+"c = "+c+" Tope = "+pila1.tope());
                       
                        pila1.push(c);
                        
                     
                                            
                     }
                     
                     else if(opPrec(c)<opPrec(pila1.tope())){
                        if(pila1.tope()!='('){
                           if(opPrec(c)==opPrec(pila1.tope())){
                                  
                              while(pila1.getTope()!=null&&opPrec(c)==opPrec(pila1.tope())){
                                 if(pila1.tope()!='('){
                                 
                                    cola1.insertar(pila1.tope().toString());
                                 
                                 }
                                
                                 pila1.pop();
                              
                              }
                           
                           }
                        
                          
                           while(pila1.getTope()!=null&&opPrec(c)<=opPrec(pila1.tope())){
                              if(pila1.tope()!='('){
                              
                              
                                 if(opPrec(c)<=opPrec(pila1.tope())){
                                 
                                    cola1.insertar(pila1.tope().toString());
                                 } 
                              
                              
                              
                              } 
                              else{
             
                               break;
                              }
                              
                              pila1.pop();
                           }
                        
                           pila1.push(c);
                         
                        }
                        
                        else{                         
                           if(pila1.tope()!='('){
                           
                           
                              cola1.insertar(pila1.tope().toString());
                              pila1.pop();
                           }
                           
                           pila1.push(c);
                        
                        
                        
                        }
                                               
                        
                     
                     
                     } 
                     
                     else if(opPrec(c)==opPrec(pila1.tope())){
                          
                        while(pila1.getTope()!=null&&opPrec(c)==opPrec(pila1.tope())){
                           if(pila1.tope()!='('){
                              cola1.insertar(pila1.tope().toString());
                           }
                            else{
             
                            break;
                           }
                              
                           pila1.pop();
                         
                        }
                        
                        pila1.push(c);
                     } 
                    
                   
                                    
                     
                                        
                  
                  
                  }
                 
               
               }
               
               if(c==')'){
                  
                  pila1.mostrar();
                  while(pila1.getTope()!=null){
                          
                     if(pila1.tope()!='('){
                        cola1.insertar(pila1.tope().toString());
                     }
                     if(pila1.tope()=='('){
                        pila1.pop();
                       break;
                     }
                         
                        
                     pila1.pop();
                  
                  
                  
                  }
                 // pila1.vaciar();
                     
               
               }  
               
                
            }
            
           
          
          
           
         }  
             
         
      
      
         cola1.mostrar();
      
      //showMessageDialog(null,cola1.frente());
         String operando="";
         Pila<Float> pilaOp = new Pila<Float>();
         float result=0;
         float n1,n2=0;
         String post="";
         
         
         while(cola1.frente()!=null){
            post=post+cola1.frente()+" ";
            switch(cola1.frente()){
               case "^" : 
                  pilaOp.mostrar();
                  n1=pilaOp.tope();
                  pilaOp.pop();
                  n2=pilaOp.tope();
                  pilaOp.pop();
                  result=(float)Math.pow(n2,n1);
                  pilaOp.push(result);
                                         
                  break;
               case "*" :
                  pilaOp.mostrar();
                  n1=pilaOp.tope();
                  pilaOp.pop();
                  n2=pilaOp.tope();
                  pilaOp.pop();
                  result=n1*n2;
                  pilaOp.push(result);
                      
                  break;
               case "/" : 
                  pilaOp.mostrar();
                  n1=pilaOp.tope();
                  pilaOp.pop();
                  n2=pilaOp.tope();
                  pilaOp.pop();
                  result=n2/n1;
                  pilaOp.push(result);
                   
                  break;
               case "+" :
                  pilaOp.mostrar();
                  n1=pilaOp.tope();
                  pilaOp.pop();
                  n2=pilaOp.tope();
                  pilaOp.pop();
                  result=n1+n2;
                  pilaOp.push(result);
                  
                  break;
               case "-" : 
                  pilaOp.mostrar();
                  n1=pilaOp.tope();
                  pilaOp.pop();
                  n2=pilaOp.tope();
                  pilaOp.pop();
                  result=n2-n1;
                  pilaOp.push(result);
                    
                  break;
               default:
                    
                  pilaOp.push(Float.parseFloat(cola1.frente()));                     
                  break;
                
            }
            
              
            cola1.quitar();
              
         }
          
       
         showMessageDialog(null,"Infija : "+infi+"\nPostfija : "+post+"\nResultado : "+pilaOp.tope()+"\nHecho por: Ricardo Alonso Villa Osuna");
      }
         
      else{
         showMessageDialog(null,"Expresión Invalidad");
      }  
     
       
      
      
      
   }//main
}//class
//Autor: Ricardo Alonso Villa Osuna