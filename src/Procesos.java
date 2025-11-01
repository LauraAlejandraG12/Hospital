import javax.swing.JOptionPane;

public class Procesos {
    

    public Procesos(){
        presentarMenuOpciones();
    }

    private void presentarMenuOpciones(){
        
        String menu = "MENÚ HOSPITAL\n\n";
        menu += "1. Registrar paciente\n";
        menu += "2. Registrar empleado\n";
        menu += "3. Registrar cita medica\n";
        menu += "4. Imprimir información\n";
        menu += "5. Salir\n\n";
        menu += "Ingrese una opcion\n";


        int opcion = 0;

        do{
            opcion= Integer.parseInt(JOptionPane.showInputDialog("menu"));
            switch(opcion){
                case 1: registrarPaciente(); break;
                case 2: registrarEmpleado(); break;
                case 3: registrarCitaMedica(); break;
                case 4: imprimirInformacion(); break;
                case 5: System.out.prinltn("El sistema ha terminado!"); break;

                default: System.out.println("No existe el codigo, verifique nuevamente.");
                break;
            } 
        } while (opcion != 5);
    }

    private void registrarPaciente(){

    }

    private void registrarEmpleado(){
        
    }
}
