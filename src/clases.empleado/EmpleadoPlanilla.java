package clases.empleado;

public class EmpleadoPlanilla extends Empleado {
    
    private double salarioMensual;
    private double porcentajeAdicionalPorHoraExtra;

    public double getSalarioMensual(){
        return salarioMensual;
    }

    public void setSalariomensual(double salarioMensual){
        this.salarioMensual = salarioMensual;
    }

    public double getPorcentajeAdicionalPorHoraExtra(){
        return porcentajeAdicionalPorHoraExtra;
    }

    public void setPorcentajePorHoraExtra(double porcentajeAdicionalPorHoraExtra){
        this.porcentajeAdicionalPorHoraExtra = porcentajeAdicionalPorHoraExtra;
    }

    @override

    public void registrarDatos(){
        super.registrarDatos();

        salarioMensual = Double.parseInt(JOptionPane.showInputDialog("Ingrese el salario mensual"));
        porcentajeAdicionalPorHoraExtra = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el porcentaje adicional por ahora extra"));
    }


    public double getSalarioMensual(){
        
    }
}
