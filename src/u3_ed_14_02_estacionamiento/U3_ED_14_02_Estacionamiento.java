package u3_ed_14_02_estacionamiento;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class U3_ED_14_02_Estacionamiento {

    public static void main(String[] args) throws IOException {
        BufferedReader teclado=new BufferedReader(new InputStreamReader(System.in));
        int N;
        int op;
        int cont=-1;
        String Placa;
        String Buscar;
        
        System.out.println(":.:Programa Estacionamiento:.:");        
        
        do{
            System.out.println("¿Cuántos espacios tiene el estacionamiento?");
            N=Integer.parseInt(teclado.readLine());
            if(N < 1){
                    System.err.println("Error, por favor intente de nuevo");
            }
        }while(N < 1);
        
        Pilas_Sensuales pila1=new Pilas_Sensuales(N);
        pila1.Pila_Aux(N);
        
        do{
            System.out.println("\n\t.:\tMenú\t:.");
            System.out.println("1.-Estacionar Auto\t        2.-Retirar Auto\n3.-Visualizar Estacionamiento\t0.-Salir");
            op=Integer.parseInt(teclado.readLine());

            switch(op){            
                default:
                    System.err.println("El número que usted marcó, no existe. Favor de verificarlo.\n");
                    break;
                //Salir
                case 0:
                    System.out.println("Gracias por usar el programa\n¡Hasta luego!");
                    break;
                case 1:
                    System.out.println("1.-Estacionar auto");
                    if(pila1.estaLlena()){
                        System.err.println("Lo lamentamos, pero el estacionamiento está lleno\n");
                    }else{
                        do{
                            System.out.println("Digite la placa sin espacios ni caracteres especiales"
                                    + "\n(7 caracteres alfanuméricos)");
                            Placa=teclado.readLine();
                            if(Placa.length() != 7){
                                System.err.println("Verifique que la longitud de la placa sea la correcta");
                            }
                        }while(Placa.length() != 7);
                        pila1.Push(Placa);
                    }
                    break;
                case 2:
                    System.out.println("2.-Retirar Auto");
                    if(pila1.estaVacia()){
                        System.err.println("El estacionamiento está vacío\n");
                    }else{                        
                        do{
                            System.out.println("Digite la placa del auto que desea buscar"
                                    + "\n(Sin espacios ni caracteres especiales)");
                            Buscar=teclado.readLine();                        
                            if(Buscar.length() != 7){
                                System.err.println("Verifique que la longitud de la placa sea la correcta");
                            }
                        }while(Buscar.length() != 7);
                        //Pop
                        for (int i = pila1.Tope; i >= 0; i--) {                            
                            if(Buscar.equalsIgnoreCase(pila1.VectorPila[i])){
                                System.out.println("Auto con placa "+Buscar+" salió");
                                pila1.Pop();
                            }else{
                                cont++;
                                pila1.VectorAux[cont]=pila1.VectorPila[i];
                                pila1.Pop();
                                System.out.println("["+pila1.VectorAux[cont]+"]\t");
                            }
                        }
                        for (int i = cont; i >= 0; i--) {
                            pila1.Push(pila1.VectorAux[i]);                                   
                        }
                        cont=-1;
                    }                    
                    break;
                case 3:
                    System.out.println("3.-Visualizar Estacionamiento");
                    if(pila1.estaVacia()){
                        System.err.println("El estacionamiento está vacío\n");
                    }else{                        
                        for (int i = pila1.Tope; i >= 0; i--) {
                            System.out.print("["+pila1.VectorPila[i]+"]\t");
                        }
                        System.out.println();
                    }
                    break;
            }
        }while(op!=0);
    }
    
}
