package clases.empleado;

public class EmpleadoEventual extends Empleado {

    private double honorariosPorHora;
    private String fechaTerminoContrato;
     
    public double getHonorariosPorHora(){
        return honorariosPorHora;
    }

    public void setHonorariosPorHora(double honorariosPorHora){
        this.honorariosPorHora = honorariosPorHora;
    }

    public String getFechaTerminoContrato(){
        return fechaTerminoContrato;
    }
    
    public void setFechaTerminoContrato(String fechaTerminoContrato){
        this.fechaTerminoContrato = fechaTerminoContrato;
    }

    @override
    public void registrarDatos();

    super.registrarDatos();

    honorariosPorHora = Double.parseInt(JOptionPane.showInputDialog("Ingrese el salario mensual"));
    fechaTerminoContrato = JOptionPane.showInputDialog("Ingrese fecha nacimiento (dd/mm/aaaa)");
}
