package clases;

import java.util.HashMap;

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
}
