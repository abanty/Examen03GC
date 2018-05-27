package examen03.android.examen03gc.Views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.support.v7.app.ActionBar;
import examen03.android.examen03gc.Presentators.DBHelper;
import examen03.android.examen03gc.R;

public class RegistrarActivity extends AppCompatActivity {


    private Button guardarbtn, cancelarbtn, listusu,listtabusu;
    private EditText txtnom, numcel;

    DBHelper helper = new DBHelper(this,"DB1",null,1);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        setContentView(R.layout.activity_registrar);
        SetupActionBar();

        listusu = (Button) findViewById(R.id.listu);
        txtnom = (EditText) findViewById(R.id.txtnombres);
        numcel = (EditText) findViewById(R.id.ntelefono);

//        guardarbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                helper.abrirbd();
//                helper.registrar(
//                        String.valueOf(txtnom.getText()),
//                        String.valueOf(numcel.getText()));
//                helper.cerrarbd();
//
//                Toast.makeText(RegistrarActivity.this, "Registro realizado satisfactoriamente", Toast.LENGTH_SHORT).show();
//
//            }
//        });

//        listtabusu.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent listtabu = new Intent(getApplicationContext(),MainActivity.class);
//                startActivity(listtabu);
//            }
//        });


        listusu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent listu = new Intent(getApplicationContext(),ListarActivity.class);
                startActivity(listu);
            }
        });



}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.check) {
            helper.abrirbd();
            helper.registrar(
                    String.valueOf(txtnom.getText()),
                    String.valueOf(numcel.getText()));
            helper.cerrarbd();

            Toast.makeText(RegistrarActivity.this, "Registro realizado satisfactoriamente", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

     private void SetupActionBar(){

        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("Agregar un Contacto");
        }


    }

}
