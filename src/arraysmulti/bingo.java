/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraysmulti;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author santiago
 */
public class bingo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Carton[] Partida;
    //    Carton[] Partidacopia;
        Random r = new Random();
        boolean linea=false;
        int[] bolas = new int[99];
        int n, num = -1;
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca o numero de xogadores");
        n = sc.nextInt();
        Partida = new Carton[n];
    //    Partidacopia=Partida.clone();
        for (int i = 0; i < n; i++) {
            Partida[i] = new Carton();
            Partida[i].mostrarCarton();
            System.out.println();
        }
        boolean ganador = false;
        int i = 0;
        while ((ganador == false) && (i < 99)) {
            num = (int) r.nextInt(99) + 1;
            while (Partida[0].existe2(num,bolas)) {
                num = (int) r.nextInt(99) + 1;
            }
            System.out.print(num + " ");
            bolas[i] = num;
            i++;
            

            for (int j = 0; j < n; j++) {
                 Partida[j].comprobarCarton(num);
                 if (linea==false){
                 if (Partida[j].comprobarGanadorLinea1()||Partida[j].comprobarGanadorLinea2()||Partida[j].comprobarGanadorLinea3()){
                      System.out.println("Canta linea o xogador :" + j);
                      linea=true;
                     }
                 }
                if (Partida[j].comprobarGanador()) {
                    ganador = true;
                    System.out.println("o ganador e o xogador :" + j);
                    break;
                }

            }
        }
        System.out.println(Arrays.toString(bolas));
        
     /*   for (int x = 0; x < n; x++) {

            Partidacopia[x].mostrarCarton();
            System.out.println();
        }*/
    }
}

// TODO code application logic here

