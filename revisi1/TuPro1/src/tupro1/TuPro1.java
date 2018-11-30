/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tupro1;
import static java.lang.Math.PI;
import static java.lang.Math.exp;
import java.util.Random;

/**
 *
 * @author alea's
 */
public class TuPro1{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        double parm = 1;
        double newState1 = 0;//new state x1
        double newState2 = 0;//new state x2
        double T=100;
        double PI =3.14;
        double bsfx1 = newState1;
        double bsfx2 = newState2;
        double bsf = 0;
        double newEval = 0;
        double curEval;
        
        curEval = getNilai(newState1, newState2);
        while (T>=0.1){
            newState1 = ranGen();
            newState2 = -1*ranGen();
            newEval = getNilai(newState1, newState2);
            if(newEval < curEval){
                curEval = newEval;
                bsf = newEval;
                bsfx1 = newState1;
                bsfx2 = newState2;
            }
            else{
                double deltaEval = Math.pow(exp(1), -(newEval - curEval)/T);
                double ran = Math.random();
                if(deltaEval>ran){
                    curEval = newEval;
                }
            }
            T = 0.998*T;
        }
        System.out.println("Hasil Perhitungan");
        System.out.println("x1 : "+ bsfx1);
        System.out.println("x2 : "+ bsfx2);
        System.out.println("f(x1,x2) = " + bsf);
            
    }
    //function f(x1,x2)
    private static double getNilai(double newState1, double newState2) {
        double hasil;
        hasil = -1*(Math.sin(Math.toRadians(newState1))*Math.cos(Math.toRadians(newState2))*Math.exp(1-Math.sqrt(Math.pow(newState1,2)+Math.pow(newState2,2))/PI));       
        return hasil;
    }
    //return random double antar -10 sampai 10
     private static double ranGen() {
        Random rand = new Random();
        double number = rand.nextInt(10) ;
        number += rand.nextDouble();
        return number;
    }

}
