package C_Vuelos;
import java.time.LocalDate;

public class CertificadoCOVID {
    private boolean vacunado;
    private boolean positivo;
    private boolean testValido;
    private LocalDate fechaExpedicion;

    public CertificadoCOVID(){
    }

    public CertificadoCOVID(boolean vacunado, boolean positivo, boolean testValido) {
        this.vacunado = vacunado;
        this.positivo = positivo;
        this.testValido = testValido;
    }

    public void setVacunado(boolean vacunado) {
        this.vacunado = vacunado;
    }
    public void setPositivo(boolean positivo) {
        this.positivo = positivo;
    }
    public void setTestValido(boolean testValido) {
        this.testValido = testValido;
    }

    public boolean isVacunado() {
        return vacunado;
    }
    public boolean isPositivo() {
        return positivo;
    }
    public boolean isTestValido() {
        return testValido;
    }

    public boolean certificadocovid (){


        LocalDate hoy = LocalDate.now();


        long dias = java.time.temporal.ChronoUnit.DAYS.between (fechaExpedicion, hoy); //se calcula la diferencia entre dias

        if (vacunado||positivo||testValido && (dias < 90)){
            return true;
        }
        return false;
    }


    @Override
    public String toString() {
        return "CertificadoCOVID{" +
                "vacunado=" + vacunado +
                ", positivo=" + positivo +
                ", testValido=" + testValido +
                '}';
    }
}