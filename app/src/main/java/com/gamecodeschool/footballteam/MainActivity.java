package com.gamecodeschool.footballteam;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    Spinner spinnerProvince;
    TextView txtTeams;
    Button btnShowTeams;

    Map<String, String> provinceTeams = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerProvince = findViewById(R.id.spinnerProvince);
        txtTeams = findViewById(R.id.txtTeams);
        btnShowTeams = findViewById(R.id.btnShowTeams);

        String[] provinces = {
                "Eastern Cape",
                "Free State",
                "Gauteng",
                "KwaZulu-Natal",
                "Limpopo",
                "Mpumalanga",
                "North West",
                "Northern Cape",
                "Western Cape"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                provinces
        );

        spinnerProvince.setAdapter(adapter);

        // TEAMS DATA (Professional grouping)
        provinceTeams.put("Gauteng",
                "Mamelodi Sundowns\nOrlando Pirates\nKaizer Chiefs\nSuperSport United");

        provinceTeams.put("KwaZulu-Natal",
                "AmaZulu FC\nGolden Arrows\nRoyal AM");

        provinceTeams.put("Western Cape",
                "Cape Town City FC\nStellenbosch FC\nAjax Cape Town");

        provinceTeams.put("Eastern Cape",
                "Chippa United");

        provinceTeams.put("Free State",
                "Marumo Gallants");

        provinceTeams.put("Limpopo",
                "Polokwane City\nBaroka FC");

        provinceTeams.put("Mpumalanga",
                "TS Galaxy");

        provinceTeams.put("North West",
                "Platinum City Rovers");

        provinceTeams.put("Northern Cape",
                "NC Professionals FC");

        btnShowTeams.setOnClickListener(v -> {

            String selectedProvince =
                    spinnerProvince.getSelectedItem().toString();

            String teams =
                    provinceTeams.get(selectedProvince);

            if (teams == null) {
                txtTeams.setText("No teams available for this province.");
            } else {
                txtTeams.setText(teams);
            }
        });
    }
}