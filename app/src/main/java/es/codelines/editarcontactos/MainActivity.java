package es.codelines.editarcontactos;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public TextInputEditText tietNombreCompleto;
    public DatePicker tietFechaNacimiento;
    public TextInputEditText tietTelefono;
    public TextInputEditText tietEmail;
    public TextInputEditText tietDescripcionContacto;
    public Button btnGuardar;

    public int dia;
    public int mes;
    public int year;
    public String stringDia;
    public String stringMes;
    public String stringYear;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle parametrosReturn = getIntent().getExtras();

        tietNombreCompleto      = (TextInputEditText) findViewById(R.id.etNombreCompleto);
        tietFechaNacimiento     = (DatePicker) findViewById(R.id.datePicker);
        tietTelefono            = (TextInputEditText) findViewById(R.id.etTelefono);
        tietEmail               = (TextInputEditText) findViewById(R.id.etEmail);
        tietDescripcionContacto = (TextInputEditText) findViewById(R.id.etDescripcion);
        btnGuardar              = (Button) findViewById(R.id.buttonGuardar);

        if (parametrosReturn != null) {
            String nombre_completo      = parametrosReturn.getString(getResources().getString(R.string.tv_nombre));
            String _dia                 = parametrosReturn.getString("dia");
            String _mes                 = parametrosReturn.getString("mes");
            String _ano                 = parametrosReturn.getString("ano");
            String telefono             = parametrosReturn.getString(getResources().getString(R.string.tv_n_telefono));
            String email                = parametrosReturn.getString(getResources().getString(R.string.tv_n_email));
            String descripcion_contacto = parametrosReturn.getString(getResources().getString(R.string.tv_n_descripcion));

            tietNombreCompleto.setText(nombre_completo);
            tietFechaNacimiento.init(Integer.parseInt(_ano), Integer.parseInt(_mes), Integer.parseInt(_dia), null);
            tietTelefono.setText(telefono);
            tietEmail.setText(email);
            tietDescripcionContacto.setText(descripcion_contacto);
        }

        btnGuardar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        dia = tietFechaNacimiento.getDayOfMonth();
        mes = tietFechaNacimiento.getMonth()+1;
        year = tietFechaNacimiento.getYear();

        stringDia = String.valueOf(dia);
        stringMes = String.valueOf(mes);
        stringYear = String.valueOf(year);

        Intent intent = new Intent(this, DetalleContacto.class);
        intent.putExtra(getResources().getString(R.string.nombre_completo), tietNombreCompleto.getText().toString());
        intent.putExtra("dia", stringDia);
        intent.putExtra("mes", stringMes);
        intent.putExtra("ano", stringYear);
        intent.putExtra(getResources().getString(R.string.telefono), tietTelefono.getText().toString());
        intent.putExtra(getResources().getString(R.string.email), tietEmail.getText().toString());
        intent.putExtra(getResources().getString(R.string.descripcion_contacto), tietDescripcionContacto.getText().toString());
        startActivity(intent);
    }
}
