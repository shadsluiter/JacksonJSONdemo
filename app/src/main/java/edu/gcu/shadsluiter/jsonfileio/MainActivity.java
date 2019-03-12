package edu.gcu.shadsluiter.jsonfileio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    Button btn_load, btn_save, btn_addcar, btn_clearlist, btn_fourcars;
    TextView tv_output;
    CarList list = new CarList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_load = findViewById(R.id.btn_load);
        btn_save = findViewById(R.id.btn_save);
        tv_output = findViewById(R.id.tv_output);
        btn_addcar = findViewById(R.id.btn_addcar);
        btn_clearlist = findViewById(R.id.btn_clearlist);
        btn_fourcars = findViewById(R.id.btn_fourcars);

        tv_output.setText(list.toString());

        btn_addcar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Car c1 = new Car(2010, "Corvette");
                list.getCarList().add(c1);
                Toast.makeText(MainActivity.this, "Added " + c1.toString(), Toast.LENGTH_SHORT).show();
                tv_output.setText(list.toString());
            }
        });

        btn_fourcars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Car c1 = new Car(2020, "Ford");
                Car c2 = new Car(1993, "Chevy");
                Car c3 = new Car(1982, "Dodge");
                Car c4 = new Car(2019, "Buik");
                list.getCarList().add(c1);
                list.getCarList().add(c2);
                list.getCarList().add(c3);
                list.getCarList().add(c4);
                tv_output.setText(list.toString());
            }
        });

        btn_clearlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.setCarList(new ArrayList<Car>());
                tv_output.setText(list.toString());
            }
        });


        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            DataService dataService = new DataService(v.getContext());
            dataService.writeList(list, "cars.txt");

            }
        });


        btn_load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataService dataService = new DataService(v.getContext());
                list =  dataService.readList("cars.txt");

                tv_output.setText(list.toString());
            }
        });


    }
}
