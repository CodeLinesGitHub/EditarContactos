package es.codelines.editarcontactos;

import android.support.design.widget.TextInputEditText;
import android.widget.DatePicker;

/**
 * Created by abraham on 7/2/17.
 */

public class Datos {

    public TextInputEditText nombre_completo;
    public DatePicker fecha_nacimiento;
    public TextInputEditText telefono;
    public TextInputEditText email;
    public TextInputEditText descripcion_contacto;

    public Datos(TextInputEditText nombre_completo, DatePicker fecha_nacimiento, TextInputEditText telefono, TextInputEditText email, TextInputEditText descripcion_contacto) {
        this.nombre_completo = nombre_completo;
        this.fecha_nacimiento = fecha_nacimiento;
        this.telefono = telefono;
        this.email = email;
        this.descripcion_contacto = descripcion_contacto;
    }

    public TextInputEditText getNombre_completo() {
        return nombre_completo;
    }

    public void setNombre_completo(TextInputEditText nombre_completo) {
        this.nombre_completo = nombre_completo;
    }

    public DatePicker getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(DatePicker fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public TextInputEditText getTelefono() {
        return telefono;
    }

    public void setTelefono(TextInputEditText telefono) {
        this.telefono = telefono;
    }

    public TextInputEditText getEmail() {
        return email;
    }

    public void setEmail(TextInputEditText email) {
        this.email = email;
    }

    public TextInputEditText getDescripcion_contacto() {
        return descripcion_contacto;
    }

    public void setDescripcion_contacto(TextInputEditText descripcion_contacto) {
        this.descripcion_contacto = descripcion_contacto;
    }
}
