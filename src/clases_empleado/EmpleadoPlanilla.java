package clases_empleado;

import javax.swing.JOptionPane;

public class EmpleadoPlanilla extends Empleado {
    
    private double salarioMensual;
    private double porcentajeAdicionalPorHoraExtra;

    public double  getSalarioMensual(){
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

    @Override

    public void registrarDatos(){
        super.registrarDatos();

        salarioMensual = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el salario mensual"));
        porcentajeAdicionalPorHoraExtra = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el porcentaje adicional por ahora extra"));
    }


    public void imprimirDatosPersona(String datos){
        super.imprimirDatosPersona(datos);

        datos = "Salario Mensual: " + salarioMensual + "\n";
        datos += "Porcentaje adicional por hora extra: " + porcentajeAdicionalPorHoraExtra + "\n";

        System.out.println(datos);
    }


    
}
