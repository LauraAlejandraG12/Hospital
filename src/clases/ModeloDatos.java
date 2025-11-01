package clases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import clases_empleado.*;

public class ModeloDatos {

    HashMap<String, Paciente> pacientesMap;
    HashMap<String, EmpleadoPlanilla> empleadosPlanillaMap;
    HashMap<String, EmpleadoEventual> empleadosEventualMap;
    HashMap<String, Medico> medicosMap;
    ArrayList<CitaMedica> citasList;

    public ModeloDatos() {
        pacientesMap = new HashMap<String, Paciente>();
        empleadosPlanillaMap = new HashMap<String, EmpleadoPlanilla>();
        medicosMap = new HashMap<String, Medico>();
        empleadosEventualMap = new HashMap<String, EmpleadoEventual>();
        citasList = new ArrayList<CitaMedica>();
    }

    //errores con try-catch
    public void registrarPersona(Paciente miPaciente) {
       
        try {
        if (miPaciente == null) {
            throw new NullPointerException("No se puede registrar un paciente nulo.");
        }
        if (pacientesMap.containsKey(miPaciente.getNumeroDeDNI())) {
            System.out.println("Ya existe un paciente con ese documento.");
        } else {
            pacientesMap.put(miPaciente.getNumeroDeDNI(), miPaciente);
            System.out.println("Paciente registrado correctamente.");
        }
    } catch (Exception e) {
        System.out.println("Error al registrar el paciente: " + e.getMessage());
    }
    }

    public void registrarPersona(EmpleadoPlanilla miEmpPlanilla) {
        if (empleadosPlanillaMap.containsKey(miEmpPlanilla.getNumeroDeDNI())) {
            System.out.println("Ya existe un empleado por planilla con el documento " + miEmpPlanilla.getNumeroDeDNI());
        } else {
            empleadosPlanillaMap.put(miEmpPlanilla.getNumeroDeDNI(), miEmpPlanilla);
            System.out.println(
                    "Se ha registrado el empleado por planilla " + miEmpPlanilla.getNombre() + " satisfactoriamente");
        }
    }

    public void registrarPersona(EmpleadoEventual miEmpEventual) {
        if (empleadosEventualMap.containsKey(miEmpEventual.getNumeroDeDNI())) {
            System.out.println("Ya existe un empleado eventual con el documento " + miEmpEventual.getNumeroDeDNI());
        } else {
            empleadosEventualMap.put(miEmpEventual.getNumeroDeDNI(), miEmpEventual);
            System.out.println(
                    "Se ha registrado el empleado eventual " + miEmpEventual.getNombre() + " satisfactoriamente");
        }
    }

    public void registrarPersona(Medico miMedico) {
        if (medicosMap.containsKey(miMedico.getNumeroDeDNI())) {
            System.out.println("Ya existe un médico con el documento " + miMedico.getNumeroDeDNI());
        } else {
            medicosMap.put(miMedico.getNumeroDeDNI(), miMedico);
            System.out.println("Se ha registrado el médico " + miMedico.getNombre() + " satisfactoriamente");
        }
    }

    public void imprimirPacientes() {
        String msj = "PACIENTES REGISTRADOS\n";

        if (pacientesMap.isEmpty()) {
            System.out.println("No existen pacientes registrados.");
        }

        Iterator<String> iterator = pacientesMap.keySet().iterator();
        while (iterator.hasNext()) {
            String clave = iterator.next();
            pacientesMap.get(clave).imprimirDatosPersona(msj);
        }
    }

    public void imprimirEmpleadosEventuales() {
        String msj = "EMPLEADOS EVENTUALES REGISTRADOS\n";

        for (String clave : empleadosEventualMap.keySet()) {
            empleadosEventualMap.get(clave).imprimirDatosPersona(msj);
        }
    }

    //imprimir medicos en planilla
    public void imprimirEmpleadosPorPlanilla(List<Empleado> empleados, List<Medico> medicos) {
    if (empleados.isEmpty() && medicos.isEmpty()) {
        System.out.println("No existen empleados por planilla, ni médicos registrados.");
        return;
    }

    System.out.println(" Empleados por planilla:");
    for (Empleado e : empleados) {
        System.out.println(e);
    }

    System.out.println("\n Médicos registrados:");
    for (Medico m : medicos) {
        System.out.println(m);
    }
}

    public void imprimirMedicos() {
        String msj = "MEDICOS REGISTRADOS\n";
        // System.out.println("key = " + elemento.getKey() + ", Value = " +
        // elemento.getValue());
        // medicosMap.get(elemento.getKey()).imprimirDatosPersona(msj);
        if (medicosMap.isEmpty()) {
            System.out.println("No existen médicos registrados.");
            return;
        }
        for (Map.Entry<String, Medico> elemento : medicosMap.entrySet()) {
            elemento.getValue().imprimirDatosPersona(msj);
        }
    }

    //consulta de pacientes por documento
    public Paciente consultarPacientePorDocumento(String documentoPaciente) {
        if (pacientesMap.isEmpty()) {
            System.out.println("No hay pacientes registrados en el sistema.");
            return null;
        }

        if (pacientesMap.containsKey(documentoPaciente)) {
            return pacientesMap.get(documentoPaciente);
        } else {
            System.out.println("No se encontro el paciente con el documento: " + documentoPaciente);
            return null;
        }
    }


    public Medico consultarMedicoPorNombre(String nombreMedico) {
        if (medicosMap.isEmpty()) {
            System.out.println("No hay medicos registrados en el sistema.");
            return null;
        }

        if (nombreMedico == null || nombreMedico.trim().isEmpty()) {
            System.out.println("Debe ingresar un nombre válido para realizar la búsqueda.");
            return null;
        }

        for (Medico medico : medicosMap.values()) {
            if (medico.getNombre().equalsIgnoreCase(nombreMedico)) {
                System.out.println("Médico encontrado: " + medico.getNombre());
                return medico;
            }
        }

        System.out.println("No se encontró un médico con el nombre: " + nombreMedico);
        return null;
    }

    public void registrarCitaMedica(CitaMedica miCita) {

        if (miCita == null) {
            System.out.println("No se puede registrar una cita nula.");
            return;
        }

        if (citasList == null) {
            citasList = new ArrayList<>();
        }
        citasList.add(miCita);
        System.out.println("Se ha registrado la cita correctamente\n");
        System.out.println(miCita.informacionCitaMedica());
    }

    public void imprimirCitasMedicasProgramadas() {
        String msj = "CITAS MEDICAS PROGRAMADAS\n";
        CitaMedica miCita = null;

        System.out.println(msj + "\n");

        if (citasList.size() > 0) {
            for (int i = 0; i < citasList.size(); i++) {
                miCita = citasList.get(i);
                System.out.println(miCita.informacionCitaMedica());
            }
        } else {
            System.out.println("No existen citas programadas");
        }
    }

}
