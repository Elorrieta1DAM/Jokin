
package ud4_f1_andergallego;

import java.util.Scanner;


public class UD4_F1_AnderGallego {

    public static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        String [] Pilotos=new String[]{"Vettel","Alonso","Raikk","Hamil","Button","Webber","Massa"};
        String [] Circuitos=new String[]{"Aus","Mal","Chi","Bah","Mont","Mon","Can","Sil"};
        int [][]ArrayClasificacion=new int[Pilotos.length][Circuitos.length];
        menu(Pilotos,Circuitos,ArrayClasificacion);
    }
    public static int menu(String[] Pilotos,String[] Circuitos,int ArrayClasificacion[][]){
        int op;
        System.out.println("MENU\n");
        System.out.println("1. Introducir clasificación de la carrera");
        System.out.println("2. Mostrar información actual");
        System.out.println("3. Clasificación de pilotos");
        System.out.println("4. Salir");
        System.out.print("Introduzca la opcion deseada:");
        op=sc.nextInt();
        if(op<1|op>4){
            System.out.println("Opcion incorrecta introduzca un valor entre 1 y 4.");
            op=menu(Pilotos,Circuitos,ArrayClasificacion);
        }else{
        switch(op){
            case 1:
                System.out.println("Opcion elegida 1");
                ClasificacionCarrera(Pilotos,Circuitos,ArrayClasificacion);
                break;
            case 2:
                System.out.println("Opcion elegida 2");
                mostrarInformacion(Pilotos,Circuitos,ArrayClasificacion);
                break;
            case 3:
                System.out.println("Opcion elegida 3");
                ClasificacionPilotos(Pilotos,Circuitos,ArrayClasificacion);
                break;
            case 4:
                System.out.println("Opcion elegida 4. Salir");
                break;
        }
        }
        return op;              
    }
    public static int[][] ClasificacionCarrera(String[] Pilotos,String[] Circuitos,int ArrayClasificacion[][]){
        int op;
        System.out.println("1. Australia");
        System.out.println("2. Malasia");
        System.out.println("3. China");
        System.out.println("4. Bahrein");
        System.out.println("5. Montmeló");
        System.out.println("6. Monaco");
        System.out.println("7. Canada");
        System.out.println("8. Silverstone");
        System.out.print("Seleccione el gran premio del que desea guardar la informacion: ");
        op=sc.nextInt();
        System.out.println();
        
       
                for(int col=0;col<ArrayClasificacion[0].length;col++){
                    System.out.println("Clasificacion del GP de "+Circuitos[(op-1)]+" :");
                    for(int fila=0;fila<ArrayClasificacion.length;fila++){
                        System.out.print(Pilotos[(fila)]+": ");
                        ArrayClasificacion[fila][op-1]=sc.nextInt();
                }
                System.out.println();
                menu(Pilotos,Circuitos,ArrayClasificacion);
                //break;                             
        }
        return (ArrayClasificacion);
    }
    public static void mostrarInformacion(String[] Pilotos,String[] Circuitos,int ArrayClasificacion[][]){
        System.out.println("Opcion elegida 2");
        System.out.println("Mostrar informacion actual");
        System.out.print("\t");
        for(int fila=0;fila<Circuitos.length;fila++){            
            System.out.print("\t"+Circuitos[fila]);
        }
        System.out.println();
        for(int fila=0;fila<ArrayClasificacion.length;fila++){
            System.out.print(Pilotos[fila]+"\t\t");
            for(int col=0;col<ArrayClasificacion[0].length;col++){
                System.out.print(ArrayClasificacion[fila][col]+"\t");
            }
            System.out.println();
        }
        System.out.println();
        menu(Pilotos,Circuitos,ArrayClasificacion);
    }
    public static int[] ClasificacionPilotos(String[] Pilotos,String[] Circuitos,int ArrayClasificacion[][]){
        int []posiciones=new int[Pilotos.length];
        int []puntos=new int[Pilotos.length];
        System.out.println("Clasificacion de pilotos actual");
        for(int fila=0;fila<ArrayClasificacion.length;fila++){
            for(int col=0;col<ArrayClasificacion[0].length;col++){                
                posiciones[fila]=ArrayClasificacion[fila][col];
                if(posiciones[fila]==1){
                    puntos[fila]=12;
                }else if(posiciones[fila]==2){
                    puntos[fila]=8;
                }
                else if(posiciones[fila]==3){
                    puntos[fila]=6;
                }
                else if(posiciones[fila]==4){
                    puntos[fila]=4;
                }
                else if(posiciones[fila]==5){
                    puntos[fila]=3;
                }
                else if(posiciones[fila]==6){
                    puntos[fila]=2;
                }
                else if(posiciones[fila]==7){
                    puntos[fila]=1;
                }
                puntos[fila]+=puntos[fila];
            }
            System.out.println(Pilotos[fila]+": "+puntos[fila]);
            
        }
        menu(Pilotos,Circuitos,ArrayClasificacion);
        return (puntos);
    }
}
