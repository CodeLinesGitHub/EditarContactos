package es.codelines.editarcontactos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DetalleContacto extends AppCompatActivity {

    public TextView _nombreCompleto, _fechaNacimiento, _telefono, _email, _descripcionContacto;
    public String _dia, _mes, _ano;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);

        Bundle parametros = getIntent().getExtras();

        String nombre_completo      = parametros.getString(getResources().getString(R.string.nombre_completo));
        String dia                  = parametros.getString("dia");
        String mes                  = parametros.getString("mes");
        String ano                  = parametros.getString("ano");
        String fecha_nacimiento     = dia + "/" + mes + "/" + ano;
        String telefono             = parametros.getString(getResources().getString(R.string.telefono));
        String email                = parametros.getString(getResources().getString(R.string.email));
        String descripcion_contacto = parametros.getString(getResources().getString(R.string.descripcion_contacto));

        _nombreCompleto         = (TextView) findViewById(R.id.tvNombre);
        _fechaNacimiento        = (TextView) findViewById(R.id.tvNFecha);
        _telefono               = (TextView) findViewById(R.id.tvNTelefono);
        _email                  = (TextView) findViewById(R.id.tvNEmail);
        _descripcionContacto    = (TextView) findViewById(R.id.tvNDescripcion);
        _dia                    = dia;
        _mes                    = String.valueOf(Integer.parseInt(mes)-1);
        _ano                    = ano;

        _nombreCompleto.setText(nombre_completo);
        _fechaNacimiento.setText(fecha_nacimiento);
        _telefono.setText(telefono);
        _email.setText(email);
        _descripcionContacto.setText(descripcion_contacto);
    }

    public void onClickButton(View v) {

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(getResources().getString(R.string.tv_nombre), _nombreCompleto.getText());
        intent.putExtra("dia", _dia);
        intent.putExtra("mes", _mes);
        intent.putExtra("ano", _ano);
        intent.putExtra(getResources().getString(R.string.tv_n_telefono), _telefono.getText());
        intent.putExtra(getResources().getString(R.string.tv_n_email), _email.getText());
        intent.putExtra(getResources().getString(R.string.tv_n_descripcion), _descripcionContacto.getText());
        startActivity(intent);
    }
}
