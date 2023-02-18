import java.awt.*;
import java.util.Queue;
import java.util.Scanner;
public class Main {

    static Scanner sc;

    static QueueBank queue;
    public static void main(String[] args) {


        System.out.println("Bienvenido a Bancolombia");
        sc = new Scanner(System.in);
        queue = new QueueBank();

        int op = 1;
        do{
            op = Menu();
            executeOp(op);
        }while (op != 5);



    }

    public static int Menu(){
        System.out.println("Escoja una opcion: \n"+
                "1. Dar turno \n" +
                "2. Mostrar turno actual\n"+
                "3. Pasar turno\n" +
                "4. Seguir turno\n" +
                "5. salir");
        int op = sc.nextInt();

        return op;
    }

    public static void executeOp(int op){

        switch (op){

            case 1:
                queue.addTurnLast();
                System.out.println("--> Su turno es " + queue.getLast().getNumTurn());
                break;

            case 2:
                if(queue.getFirst() != null){
                    System.out.println("--> Turno actual: " + queue.getActualTurn().getNumTurn());
                } else {
                    System.out.println("No hay turnos aun. Dirijase a la opcion 1 para tomar el primer turno");
                }

                break;

            case 3:
                if(queue.getActualTurn() != null){
                    queue.passTurn();
                    System.out.println("--> Nuevo turno: " + queue.getActualTurn().getNumTurn());
                } else{
                    System.out.println("No hay turnos");
                }

                break;

            case 4:

                queue.nextTurn();
                System.out.println("--> Nuevo turno: " + queue.getActualTurn().getNumTurn());

                break;

            case 5:
                System.out.println("Hasta luego, vuelva pronto");
        }
    }
}