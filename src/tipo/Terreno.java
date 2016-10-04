
package tipo;

import imovel.Imovel;


public class Terreno extends Imovel {

    public double dimensaoFrente;
    public double dimensaoLado;

    public Terreno(double dimensaoFrente, double dimensaoLado, String logradouro,
            int numero, String bairro, String cidade, String descricao, 
            double areaTotal, double valor) {
        super(logradouro, numero, bairro, cidade, descricao, areaTotal, valor);
        this.dimensaoFrente = dimensaoFrente;
        this.dimensaoLado = dimensaoLado;
    }
 
 

public double getDimensaoFrente(){
    return dimensaoFrente;
}

public void setDimensaoFrente(double dimensaoFrente){
    this.dimensaoFrente = dimensaoFrente;
}

public double getDimensaoLado(){
    return dimensaoLado;
}

public void setDimensaoLado(double dimensaoLado){
    this.dimensaoLado = dimensaoLado;
}
        

public String toString(){
    //colocar ' super.toString() + ' depois do return
    return "Dimensão da Frente: " + getDimensaoFrente() + "\n Dimensão do Lado: " + getDimensaoLado();
}

 }