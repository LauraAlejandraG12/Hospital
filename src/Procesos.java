import javax.print.attribute.standard.JobHoldUntil;
import javax.swing.JOptionPane;

import clases.CitaMedica;
import clases.ModeloDatos;
import clases.Paciente;
import clases_empleado.EmpleadoEventual;
import clases_empleado.EmpleadoPlanilla;
import clases_empleado.Medico;

public class Procesos {
    
    ModeloDatos miModeloDatos;

    public Procesos(){
        miModeloDatos = new ModeloDatos();
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
            opcion= Integer.parseInt(JOptionPane.showInputDialog(menu));
            switch(opcion){
                case 1: registrarPaciente(); break;
                case 2: registrarEmpleado(); break;
                case 3: registrarCitaMedica(); break;
                case 4: imprimirInformacion(); break;
                case 5: System.out.println("El sistema ha terminado!"); break;

                default: System.out.println("No existe el codigo, verifique nuevamente.");
                break;
            } 
        } while (opcion != 5);
    }

    private void registrarPaciente(){
        Paciente miPaciente = new Paciente();
        miPaciente.registrarDatos();

        miModeloDatos.registrarPersona(miPaciente);
    }

    private void registrarEmpleado(){
        String menuTipoEmpleado = "Registro de Empleado\n";
        menuTipoEmpleado += "1. Empleado eventual\n";
        menuTipoEmpleado += "2. Empleado por planilla\n";
        menuTipoEmpleado += "Selecione el tipo de empleado a registrar\n";

        int tipoEmpleado = Integer.parseInt(JOptionPane.showInputDialog(menuTipoEmpleado));

        switch(tipoEmpleado){
            case 1:

            EmpleadoEventual miEmpleadoEventual = new EmpleadoEventual();
            miEmpleadoEventual.registrarDatos();
            miModeloDatos.registrarPersona(miEmpleadoEventual);
            
            break;

            case 2:

            String resp = JOptionPane.showInputDialog("Ingrese, si es un medico, de lo contrario es otro tipo de empleado");
            if(resp.equalsIgnoreCase("si")) {

            Medico miMedico = new Medico();
            miMedico.registrarDatos();
            miModeloDatos.registrarPersona(miMedico);

        } else {
            EmpleadoPlanilla miEmpleadoPlanilla = new EmpleadoPlanilla();
            miModeloDatos.registrarPersona(miEmpleadoPlanilla);
        }

        break;

        default: System.out.println("El tipo de empleado no es validom intentelo de nuevo");
    }
}


private void imprimirInformacion(){
    String menuImprimir = "MENU IMPRESIONES\n";
    menuImprimir += "1. Listar Paciente\n";
    menuImprimir += "2. Listar Empleados eventuales\n";
    menuImprimir += "3. Listar Empleados por planillas\n";
    menuImprimir += "4. Listar medicos\n";
    menuImprimir += "5. Listar citas programadas" + "\n";
    menuImprimir += "Ingrese una opcion\n";

    System.out.println("**********************************************************************");

    int opcion = Integer.parseInt(JOptionPane.showInputDialog(menuImprimir));

    switch (opcion){
        case 1: miModeloDatos.imprimirPacientes();
        break;
    case 2: miModeloDatos.imprimirEmpleadosEventuales();
        break;
    case 3: miModeloDatos.imprimirEmpleadosPorPlanilla();
        break;
    case 4: miModeloDatos.imprimirMedicos();
        break;

    case 5: miModeloDatos.imprimirCitasMedicasProgramadas(); break;

    default:
        System.out.println("No existe esa opción");
        break;
    }
}


    public void registrarCitaMedica(){
        String documentoPaciente = JOptionPane.showInputDialog("Ingrese el documento del paciente");

        Paciente pacienteEncontrado = miModeloDatos.consultarPacientePorDocumento(documentoPaciente);

        if(pacienteEncontrado != null){
            String nombreMedico=JOptionPane.showInputDialog("Ingrese el nombre del medico");
            Medico medicoEncontrado = miModeloDatos.consultarMedicoPorNombre(nombreMedico);

            if(medicoEncontrado != null){
                String servicio = JOptionPane.showInputDialog("Ingrese el servicio o motivo de la consulta");
                String fechaConsulta = JOptionPane.showInputDialog("Ingrese la fecha de la consulta");
                String horaConsulta = JOptionPane.showInputDialog("Ingrese la hora de consulta");

                String lugar = "Lac tia sera en el consultorio " + medicoEncontrado.getNumeroDeConsultorio();
                CitaMedica miCita = new CitaMedica(pacienteEncontrado, medicoEncontrado, servicio, fechaConsulta, horaConsulta, lugar);
                miModeloDatos.registrarCitaMedica(miCita);
            }else{
                System.out.println("El medico no se encuentra registrado en el sistema.");
            }
        } else{
            System.out.println("El paciente no se encuentra registrado en el sistema");
        }
    }

}