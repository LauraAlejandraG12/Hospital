package clases;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import clases_empleado.*;


public class ModeloDatos {

    HashMap<String, Paciente> pacientesMap;
    HashMap<String, EmpleadoPlanilla> empleadosPlanillaMap;
    HashMap<String, EmpleadoEventual> empleadosEventualMap;
    HashMap<String, Medico> medicosMap;

    public ModeloDatos() {
        pacientesMap = new HashMap<String, Paciente>();
        empleadosPlanillaMap = new HashMap<String, EmpleadoPlanilla>();
        medicosMap = new HashMap<String, Medico>();
        empleadosEventualMap = new HashMap<String, EmpleadoEventual>();
    }

    public void registrarPersona(Paciente miPaciente) {
        pacientesMap.put(miPaciente.getNumeroDeDNI(), miPaciente);
        System.out.println("Se ha registrado el paciente " + miPaciente.getNombre() + " satisfactoriamente");
    }

    public void registrarPersona(EmpleadoPlanilla miEmpPlanilla) {
        empleadosPlanillaMap.put(miEmpPlanilla.getNumeroDeDNI(), miEmpPlanilla);
        System.out.println("Se ha registrado el empleado por planilla " + miEmpPlanilla.getNombre() + " satisfactoriamente");
    }

    public void registrarPersona(EmpleadoEventual miEmpEventual) {
        empleadosEventualMap.put(miEmpEventual.getNumeroDeDNI(), miEmpEventual);
        System.out.println("Se ha registrado el empleado eventual " + miEmpEventual.getNombre() + " satisfactoriamente");
    }

    public void registrarPersona(Medico miMedico) {
        medicosMap.put(miMedico.getNumeroDeDNI(), miMedico);
        System.out.println("Se ha registrado el médico " + miMedico.getNombre() + " satisfactoriamente");
    }


    public void imprimirPacientes(){
        String msj="PACIENTES REGISTRADOS\n";
        Iterator<String> iterator = pacientesMap.keySet().iterator();

        while(iterator.hasNext()){
            String clave = iterator.next();
            pacientesMap.get(clave).imprimirDatosPersona(msj);
        }
    }

    public void imprimirEmpleadosEventuales(){
        String msj="EMPLEADOS EVENTUALES REGISTRADOS\n";

        for(String clave : empleadosEventualMap.keySet()){
            empleadosEventualMap.get(clave).imprimirDatosPersona(msj);
        }
    }


    public void imprimirEmpleadosPorPlanilla(){
        String msj = "EMPLEADOS POR PLANILLA REGISTRADOS\n";

        for(EmpleadoPlanilla empleadoPlanilla : empleadosPlanillaMap.values()){
            empleadoPlanilla.imprimirDatosPersona(msj);
        }
    }


    public void imprimirMedicos(){
        String msj = "MEDICOS REGISTRADOS\n";

        for(Map.Entry<String, Medico> elemento : medicosMap.entrySet()){
            // System.out.println("key = " + elemento.getKey() + ", Value = " + elemento.getValue());
            // medicosMap.get(elemento.getKey()).imprimirDatosPersona(msj);
            elemento.getValue().imprimirDatosPersona(msj);
        }
    }

}
