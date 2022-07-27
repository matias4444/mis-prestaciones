package com.example.myapplication;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.databinding.ActivityMainBinding;

import android.view.Menu;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerItemSelectedListener, View.OnClickListener {
//

    private RecyclerView recyclerView;
    private RecyclerAdapter recyclerAdapter;
    private List<Prestaciones> prestaciones = new ArrayList<>();
    private EditText userImput;
    private ChipGroup nchipGroup;
    private CardView carVie, carVe, carVe1, carVie2;
    private RadioButton misRadio;

    //private CardView carVie;
    RadioButton rd_si_difunto;
    RadioButton rd_no_difunto;
    RadioButton rd_si_declarante;
    RadioButton rd_no_declarante;
    RadioGroup rdg_domicilioFallecido;
    EditText editTxtTCambioDomicilio;
    EditText editTxtTCambioDomicilioFallecido;

    EditText editPrestaciones;


    TextView tvFechaCatering;
    EditText edtHoraCatering;

    TextView tvFechaCremacion;
    EditText edtHoraIncineracion;


    TextView tvFechaEntradaSala1;
    EditText edtHoraEntradaSala1;


    TextView tvFechaEntradaSala2;
    EditText edtHoraEntradaSala2;

    TextView tvFechaInhumacion;
    EditText editHoraInhumacion;

    EditText edtMisaHora1;
    EditText editMisaHora2;
    EditText ediMisaHora3;

    TextView tvFechaEntradaCamara;
    EditText edtHoraEntradaCamara;

    TextView tvFechaEntradaSala3;
    EditText editHoraHoraSala3;

    TextView tvFechaTraslado;
    EditText editHoraSalidaTraslado;


    private int dia, mes, ano, hora, minutos;


    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    private View v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        recyclerView = findViewById(R.id.recyclerView);
        //recyclerView1=findViewById(R.id.recyclerView1);
        userImput = findViewById(R.id.editPrestaciones);
        nchipGroup = findViewById(R.id.idGrupoChip);
        editTxtTCambioDomicilio = findViewById(R.id.editTxtTCambioDomicilio);
        editTxtTCambioDomicilioFallecido = findViewById(R.id.editTxtTCambioDomicilioFallecido);
        carVie = findViewById(R.id.carVie);
        carVe = findViewById(R.id.carVe);
        carVe1 = findViewById(R.id.carVe1);
        carVie2 = findViewById(R.id.carVie2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);



         /*
        CAMBIO DE DOMICILIO DIFUNTO
        */
        rd_si_difunto = (RadioButton) findViewById(R.id.rd_si_difunto);
        rd_no_difunto = (RadioButton) findViewById(R.id.rd_no_difunto);
         /*
        CAMBIO DE DOMICILIO DECLARANTE
        */
        rd_si_declarante = (RadioButton) findViewById(R.id.rd_si_declarante);
        rd_no_declarante = (RadioButton) findViewById(R.id.rd_no_declarante);


        //editTxtTCambioDomicilio =(EditText)findViewById(R.id.editTxtTCambioDomicilio);
        // rdg_domicilioDeclarante =(RadioGroup)findViewById(R.id.rdg_domicilioDeclarante);


        // Borrar caja de texto una vez pulsado
        editPrestaciones = (EditText) findViewById(R.id.editPrestaciones);
        tvFechaCatering = (TextView) findViewById((R.id.id_fechaCatering));
        edtHoraCatering = (EditText) findViewById(R.id.editTextHoraCatering);

        tvFechaCremacion = (TextView) findViewById(R.id.idFechaCremacion);
        edtHoraIncineracion = (EditText) findViewById(R.id.editHoraIncineracion);

        tvFechaEntradaSala1 = (TextView) findViewById(R.id.tvFechaEntradaSala1);
        edtHoraEntradaSala1 = (EditText) findViewById(R.id.edtHoraEntradaSala1);

        tvFechaEntradaSala2 = (TextView) findViewById(R.id.tvFechaEntradaSala2);
        edtHoraEntradaSala2 = (EditText) findViewById(R.id.editEntradaSala2);

        tvFechaInhumacion = (TextView) findViewById(R.id.tvFechaInhumacion);
        editHoraInhumacion = (EditText) findViewById(R.id.editHoraInhumacion);

        edtMisaHora1 = (EditText) findViewById(R.id.edtMisaHora1);
        editMisaHora2 = (EditText) findViewById(R.id.editMisaHora2);
        ediMisaHora3 = (EditText) findViewById(R.id.MisaHora3);

        //tvFechaEntradaCamara =(TextView)findViewById(R.id.tvFechaEntradaCamara);
        //edtHoraEntradaCamara = (EditText)findViewById(R.id.edtHoraEntradaCamara);

        tvFechaEntradaSala3 = (TextView) findViewById(R.id.tvFechaEntradaSala3);
        editHoraHoraSala3 = (EditText) findViewById(R.id.editHoraHoraSala3);

        tvFechaTraslado = (TextView) findViewById(R.id.tvFechaTraslado);
        editHoraSalidaTraslado = (EditText) findViewById(R.id.editHoraSalidaTraslado);



        /*
        CLIK BOTON DECLARANTE
        */

        //rd_si_declarante.setOnClickListener(this);
        //rd_no_declarante.setOnClickListener(this);


        // CLIK BOTONES DIA Y HORA

        tvFechaCatering.setOnClickListener(this);
        edtHoraCatering.setOnClickListener(this);

        tvFechaCremacion.setOnClickListener(this);
        edtHoraIncineracion.setOnClickListener(this);

        tvFechaEntradaSala1.setOnClickListener(this);
        edtHoraEntradaSala1.setOnClickListener(this);


        tvFechaEntradaSala2.setOnClickListener(this);
        edtHoraEntradaSala2.setOnClickListener(this);

        tvFechaInhumacion.setOnClickListener(this);
        editHoraInhumacion.setOnClickListener(this);


        edtMisaHora1.setOnClickListener(this);
        editMisaHora2.setOnClickListener(this);
        ediMisaHora3.setOnClickListener(this);

        rd_si_declarante.setOnClickListener(this);
        rd_no_declarante.setOnClickListener(this);
        rd_si_difunto.setOnClickListener(this);
        rd_no_difunto.setOnClickListener(this);


        tvFechaEntradaSala3.setOnClickListener(this);
        editHoraHoraSala3.setOnClickListener(this);

        tvFechaTraslado.setOnClickListener(this);
        editHoraSalidaTraslado.setOnClickListener(this);


        //rdg_domicilioFallecido.setOnCheckedChangeListener((RadioGroup.OnCheckedChangeListener) this);

        //Funcion Lista de Prestaciones
        getPrestaciones();
        //onRadioButtonClicked(v);
        recyclerAdapter = new RecyclerAdapter(this, prestaciones);
        recyclerView.setAdapter(recyclerAdapter);


        userImput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {


            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                String userImput = s.toString();
                List<Prestaciones> NewPrestaciones = new ArrayList<>();

                for (com.example.myapplication.Prestaciones prestaciones : prestaciones) {
                    if (prestaciones.getPrestaciones().contains(userImput)) {
                        NewPrestaciones.add(prestaciones);
                    }
                }

                recyclerAdapter = new RecyclerAdapter(MainActivity.this, NewPrestaciones);
                recyclerView.setAdapter(recyclerAdapter);

            }


            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        setSupportActionBar(binding.toolbar);

        //binding.fab.setOnClickListener(new View.OnClickListener() {
        //@Override
        // public void onClick(View view) {
        //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
        //.setAction("Action", null).show();
    }


    // });
    // }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /*@Override
    public boolean onOptionsItemSelected(MenuItem item) {

        //noinspection SimplifiableIfStatement
       switch (item.getItemId()){
           case R.id.idTaxis:
               Toast.makeText(getApplicationContext(), "Taxis",Toast.LENGTH_SHORT).show();
               break;
           case R.id.idRecordatorio:
               Toast.makeText(getApplicationContext(), "Recordatorio",Toast.LENGTH_SHORT).show();
               break;
           case R.id.idconjuntaCremacion:
               Toast.makeText(getApplicationContext(), "Cremacion Conjunta",Toast.LENGTH_SHORT).show();
               break;
               case R.id.idCremacionMiembro:
               Toast.makeText(getApplicationContext(), "Cremacion Miembro",Toast.LENGTH_SHORT).show();
               break;
           case R.id.idMarcapaso:
               Toast.makeText(getApplicationContext(), "Marcapaso",Toast.LENGTH_SHORT).show();
               break;
           case R.id.idToqueCampana:
               Toast.makeText(getApplicationContext(), "Toque Campana",Toast.LENGTH_SHORT).show();
               break;
           case R.id.idApertura:
               Toast.makeText(getApplicationContext(), "Apertura",Toast.LENGTH_SHORT).show();
               break;

       }
     //  default;
        return super.onOptionsItemSelected(item);
    }*/

    /*@Override
    /*public boolean onSupportNavigateUp() {
       /* NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }*/

    /*RadioGroup rg = (RadioGroup) findViewById(R.id.rd_domicilioFallecido);

    View.OnClickListener(new void OnCheckedChangeListener()
    {
        public void onCheckedChanged(RadioGroup onCheckedChanged, int checkedId)
        {
            switch(checkedId)
            {
                case R.id.rd_si_difunto:
                    // TODO Something
                    break;
                case R.id.rd_no_difunto:
                    // TODO Something
                    break;
            }
        }
    };*/


    /*
     boolean misRadio = ((RadioButton) v).isChecked();
        switch (v.getId()) {
            case R.id.rd_si_declarante:
                if (misRadio)
                    // Pirates are the best
                    carVe1.setVisibility(View.GONE);
                editTxtTCambioDomicilio.setVisibility(View.GONE);
                editTxtTCambioDomicilio.setText("");
                break;

            case R.id.rd_no_declarante:
                if (misRadio)
                    // Ninjas rule
                    carVe1.setVisibility(View.VISIBLE);
                editTxtTCambioDomicilio.setVisibility(View.VISIBLE);
                break;
            case R.id.rd_si_difunto:
                if (misRadio)
                    // Pirates are the best
                    carVe.setVisibility(View.GONE);
                editTxtTCambioDomicilioFallecido.setVisibility(View.GONE);
                editTxtTCambioDomicilioFallecido.setText("");
                break;
            case R.id.rd_no_difunto:
                if (misRadio)
                    // Ninjas rule
                    carVe.setVisibility(View.VISIBLE);
                editTxtTCambioDomicilioFallecido.setVisibility(View.VISIBLE);
                break;
        }
     */

    @Override
    public void onClick(View v) {

        if (v == tvFechaCatering) {
            final Calendar c = Calendar.getInstance();
            dia = c.get(Calendar.DAY_OF_MONTH);
            mes = c.get(Calendar.MONTH);
            ano = c.get(Calendar.YEAR);
            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfyear, int dayOfMonth) {
                    tvFechaCatering.setText(dayOfMonth + "/" + (monthOfyear + 1) + "/" + year);

                }
            }, ano, mes, dia);
            datePickerDialog.show();
        }


        if (v == edtHoraCatering) {
            final Calendar c = Calendar.getInstance();
            hora = c.get(Calendar.HOUR_OF_DAY);
            minutos = c.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfday, int minute) {
                    edtHoraCatering.setText(hourOfday + ":" + minute);

                }
            }, hora, minutos, true);
            timePickerDialog.show();
        }



        if (v == tvFechaCremacion) {
            final Calendar c = Calendar.getInstance();
            dia = c.get(Calendar.DAY_OF_MONTH);
            mes = c.get(Calendar.MONTH);
            ano = c.get(Calendar.YEAR);
            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfyear, int dayOfMonth) {
                    tvFechaCremacion.setText(dayOfMonth + "/" + (monthOfyear + 1) + "/" + year);

                }
            }, ano, mes, dia);
            datePickerDialog.show();
        }

    if (v == edtHoraIncineracion) {
                final Calendar c = Calendar.getInstance();
                hora = c.get(Calendar.HOUR_OF_DAY);
                minutos = c.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfday, int minute) {
                        edtHoraIncineracion.setText(hourOfday + ":" + minute);

                    }
                }, hora, minutos, true);
                timePickerDialog.show();
            }


        if (v == tvFechaEntradaSala1) {
            final Calendar c = Calendar.getInstance();
            dia = c.get(Calendar.DAY_OF_MONTH);
            mes = c.get(Calendar.MONTH);
            ano = c.get(Calendar.YEAR);
            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfyear, int dayOfMonth) {
                    tvFechaEntradaSala1.setText(dayOfMonth + "/" + (monthOfyear + 1) + "/" + year);

                }
            }, ano, mes, dia);
            datePickerDialog.show();
        }

        if (v == tvFechaEntradaSala2) {
            final Calendar c = Calendar.getInstance();
            dia = c.get(Calendar.DAY_OF_MONTH);
            mes = c.get(Calendar.MONTH);
            ano = c.get(Calendar.YEAR);
            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfyear, int dayOfMonth) {
                    tvFechaEntradaSala2.setText(dayOfMonth + "/" + (monthOfyear + 1) + "/" + year);

                }
            }, ano, mes, dia);
            datePickerDialog.show();
        }





        if (v == edtHoraEntradaSala1) {
            final Calendar c = Calendar.getInstance();
            hora = c.get(Calendar.HOUR_OF_DAY);
            minutos = c.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfday, int minute) {
                    edtHoraEntradaSala1.setText(hourOfday + ":" + minute);

                }
            }, hora, minutos, true);
            timePickerDialog.show();
        }


        if (v == edtHoraEntradaSala2) {
            final Calendar c = Calendar.getInstance();
            hora = c.get(Calendar.HOUR_OF_DAY);
            minutos = c.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfday, int minute) {
                    edtHoraEntradaSala2.setText(hourOfday + ":" + minute);

                }
            }, hora, minutos, true);
            timePickerDialog.show();
        }


        if (v == edtMisaHora1) {
            final Calendar c = Calendar.getInstance();
            hora = c.get(Calendar.HOUR_OF_DAY);
            minutos = c.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfday, int minute) {
                    edtMisaHora1.setText(hourOfday + ":" + minute);

                }
            }, hora, minutos, true);
            timePickerDialog.show();
        }


        if (v == editMisaHora2) {
            final Calendar c = Calendar.getInstance();
            hora = c.get(Calendar.HOUR_OF_DAY);
            minutos = c.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfday, int minute) {
                    editMisaHora2.setText(hourOfday + ":" + minute);

                }
            }, hora, minutos, true);
            timePickerDialog.show();
        }

        if (v == ediMisaHora3) {
            final Calendar c = Calendar.getInstance();
            hora = c.get(Calendar.HOUR_OF_DAY);
            minutos = c.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfday, int minute) {
                    ediMisaHora3.setText(hourOfday + ":" + minute);

                }
            }, hora, minutos, true);
            timePickerDialog.show();
        }




        if (v == tvFechaInhumacion) {
            final Calendar c = Calendar.getInstance();
            dia = c.get(Calendar.DAY_OF_MONTH);
            mes = c.get(Calendar.MONTH);
            ano = c.get(Calendar.YEAR);
            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfyear, int dayOfMonth) {
                    tvFechaInhumacion.setText(dayOfMonth + "/" + (monthOfyear + 1) + "/" + year);

                }
            }, ano, mes, dia);
            datePickerDialog.show();
        }



        if (v == editHoraInhumacion) {
            final Calendar c = Calendar.getInstance();
            hora = c.get(Calendar.HOUR_OF_DAY);
            minutos = c.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfday, int minute) {
                    editHoraInhumacion.setText(hourOfday + ":" + minute);

                }
            }, hora, minutos, true);
            timePickerDialog.show();
        }

        if (v == tvFechaEntradaCamara) {
            final Calendar c = Calendar.getInstance();
            dia = c.get(Calendar.DAY_OF_MONTH);
            mes = c.get(Calendar.MONTH);
            ano = c.get(Calendar.YEAR);
            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfyear, int dayOfMonth) {
                    tvFechaEntradaCamara.setText(dayOfMonth + "/" + (monthOfyear + 1) + "/" + year);

                }
            }, ano, mes, dia);
            datePickerDialog.show();
        }

        if (v == edtHoraEntradaCamara) {
            final Calendar c = Calendar.getInstance();
            hora = c.get(Calendar.HOUR_OF_DAY);
            minutos = c.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfday, int minute) {
                    edtHoraEntradaCamara.setText(hourOfday + ":" + minute);

                }
            }, hora, minutos, true);
            timePickerDialog.show();
        }

        if (v == tvFechaEntradaSala3) {
            final Calendar c = Calendar.getInstance();
            dia = c.get(Calendar.DAY_OF_MONTH);
            mes = c.get(Calendar.MONTH);
            ano = c.get(Calendar.YEAR);
            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfyear, int dayOfMonth) {
                    tvFechaEntradaSala3.setText(dayOfMonth + "/" + (monthOfyear + 1) + "/" + year);

                }
            }, ano, mes, dia);
            datePickerDialog.show();
        }

        if (v == editHoraHoraSala3) {
            final Calendar c = Calendar.getInstance();
            hora = c.get(Calendar.HOUR_OF_DAY);
            minutos = c.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfday, int minute) {
                    editHoraHoraSala3.setText(hourOfday + ":" + minute);

                }
            }, hora, minutos, true);
            timePickerDialog.show();
        }



        if (v == tvFechaTraslado) {
            final Calendar c = Calendar.getInstance();
            dia = c.get(Calendar.DAY_OF_MONTH);
            mes = c.get(Calendar.MONTH);
            ano = c.get(Calendar.YEAR);
            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfyear, int dayOfMonth) {
                    tvFechaTraslado.setText(dayOfMonth + "/" + (monthOfyear + 1) + "/" + year);

                }
            }, ano, mes, dia);
            datePickerDialog.show();
        }



        if (v == editHoraSalidaTraslado) {
            final Calendar c = Calendar.getInstance();
            hora = c.get(Calendar.HOUR_OF_DAY);
            minutos = c.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfday, int minute) {
                    editHoraSalidaTraslado.setText(hourOfday + ":" + minute);

                }
            }, hora, minutos, true);
            timePickerDialog.show();
        }


        }

        private List<String> chips = new ArrayList<>();
    @Override
    public void onItemSeled(Prestaciones prestaciones) {
        String prestacion = prestaciones.getPrestaciones();
        if (chips.contains(prestacion)) {
            //Si el chip ya está añàdido, no se hace nada.
        } else {
            Chip chip= new Chip(this);
            chips.add(prestacion);

            chip.setText(prestaciones.getPrestaciones());
            chip.setChipIcon(ContextCompat.getDrawable(this, prestaciones.getPicId()));
            chip.setCloseIconVisible(true);
            chip.setOnCloseIconClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    nchipGroup.removeView(chip);
                    chips.remove(prestacion);
                    }
            });

            Toast.makeText(this, prestacion, Toast.LENGTH_LONG).show();
            nchipGroup.addView(chip);
            nchipGroup.setVisibility(View.VISIBLE);
            carVie2.setVisibility(View.VISIBLE);
            userImput.setText("");
        }


    }

    private void getPrestaciones()
    {
        List<String> Names =Arrays.asList(getResources().getStringArray(R.array.Prestaciones));

        int ImageId=(R.drawable.ic_baseline_done_24);

        int count = 0;
        for (String Name: Names){
            prestaciones.add(new Prestaciones(Name, ImageId) );

            count++;

        }

    }

    }

