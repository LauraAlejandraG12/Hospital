package clases_empleado;

import javax.swing.JOptionPane;

public class Medico extends EmpleadoPlanilla{
    
    private String especialidad;
    private int numeroDeConsultorio;

    public String getEspecialidad(){
        return especialidad;
    }

    public void setEspecialidad(String especialidad){
        this.especialidad = especialidad;
    }

    public int getNumeroDeConsultorio(){
        return numeroDeConsultorio;
    }

    public void setNumeroDeConsultario(int numeroDeConsultorio){
        this.numeroDeConsultorio = numeroDeConsultorio;
    }


    @Override 
    public void registrarDatos(){
        super.registrarDatos();

        especialidad = JOptionPane.showInputDialog("Ingrese su especialidad");
        numeroDeConsultorio = Integer.parseInt(JOptionPane.showInputDialog("Numero consultario"));
    }


    public void imprimirDatosPersona(String datos){
        super.imprimirDatosPersona(datos);

        datos = "Especialidad: " + especialidad + "\n";
        datos += "Numero de consultorio: " + numeroDeConsultorio + "\n";

        System.out.println(datos);
    }
}
