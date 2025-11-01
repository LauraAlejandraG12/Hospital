package clases;

import clases_empleado.*;

public class CitaMedica {
    
    private Paciente paciente;
    private Medico medico;
    private String servicio;
    private String fechaConsulta;
    private String horaConsulta;
    private String lugar;


    public CitaMedica(Paciente paciente, Medico medico, String servicio, String fechaConulta, String horaConsulta, String lugar){
        this.paciente = paciente;
        this.medico = medico;
        this.servicio = servicio;
        this.fechaConsulta = fechaConulta;
        this.horaConsulta = horaConsulta;
        this.lugar = lugar;
    }

    public String informacionCitaMedica(){

        String datosCita = "<< INFORMACION CITA MEDICA>>\n";
        datosCita += "Paciente: " + paciente.getNombre()+"\n";
        datosCita += "Medico: " + medico.getNombre()+"\n";
        datosCita += "Motivo de consulta: " + servicio +"\n";
        datosCita += "Fecha consulta: " + fechaConsulta+"\n";
        datosCita += "Hora consulta: " + horaConsulta + "\n";
        datosCita += "Lugar: " + lugar +"\n";

        return datosCita;

    }

    public Paciente getPaciente(){
        return paciente;
    }

    public void setPaciente(Paciente paciente){
        this.paciente = paciente;
    }

    public Medico getMedico(){
        return medico;

    }

    public void setMedico(Medico medico){
        this.medico = medico;
    }

    public String getServicio(){
        return servicio;
    }

    public String getFechaConsulta(){
        return fechaConsulta;
    }

    public String getHoraConsulta(){
        return horaConsulta;
    }

    public String getLugar(){
        return lugar;
    }

}
