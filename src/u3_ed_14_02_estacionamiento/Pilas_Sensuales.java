package u3_ed_14_02_estacionamiento;

public class Pilas_Sensuales {
    String VectorPila[];
    int Tope;
    String VectorAux[];
    int TopeAux;
    
    public Pilas_Sensuales(int N){
        VectorPila= new String [N];
        Tope = -1;
    }
    public void Pila_Aux(int N){        
        VectorAux=new String [N];
        TopeAux = -1;
    }
    //METODO PUSH, METER DATO
    public void Push(String dato){
        Tope++;
        VectorPila[Tope]=dato;
    }
    //METODO POP, SACAR ELEMENTO DE LA PILA
    public String Pop(){
        String sacar=VectorPila[Tope];
        Tope--;
        return sacar;
    }
    //METODO PARA COMPROBAR SI LA PILA ESTÁ VACÍA
    public boolean estaVacia(){
        return Tope == -1;//Si coincide retorna 'TRUE'
    }
    //METODO PARA SABER SI LA PILA ESTÁ LLENA
    public boolean estaLlena(){
        return VectorPila.length-1==Tope;//Si coincide retorna 'TRUE'
    }
}
