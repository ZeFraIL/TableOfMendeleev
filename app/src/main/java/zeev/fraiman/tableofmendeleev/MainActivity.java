package zeev.fraiman.tableofmendeleev;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ElementAdapter adapter;
    private ExecutorService executorService;
    private Handler mainHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        adapter = new ElementAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        executorService = Executors.newSingleThreadExecutor();
        mainHandler = new Handler(Looper.getMainLooper());

        loadPeriodicTableData();
        
        recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "CLICK", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void loadPeriodicTableData() {
        executorService.execute(() -> {
            try {
                File file = new File(getFilesDir(), "periodic_table.json");
                if (!file.exists()) {
                    downloadPeriodicTable(file);
                }

                String jsonString = readFile(file);
                List<Element> elements = parseElements(jsonString);

                mainHandler.post(() -> adapter.updateElements(elements));
            } catch (Exception e) {
                mainHandler.post(() ->
                        Toast.makeText(MainActivity.this,
                                "Error loading data: " + e.getMessage(),
                                Toast.LENGTH_LONG).show()
                );
            }
        });
    }

    private void downloadPeriodicTable(File file) throws IOException {
        URL url = new URL("https://raw.githubusercontent.com/Bowserinator/Periodic-Table-JSON/master/PeriodicTableJSON.json");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        try (InputStream input = connection.getInputStream();
             OutputStream output = new FileOutputStream(file)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = input.read(buffer)) != -1) {
                output.write(buffer, 0, length);
            }
        } finally {
            connection.disconnect();
        }
    }

    private String readFile(File file) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
        }
        return content.toString();
    }

    private List<Element> parseElements(String jsonString) throws JSONException {
        List<Element> elements = new ArrayList<>();
        JSONObject json = new JSONObject(jsonString);
        JSONArray elementsArray = json.getJSONArray("elements");

        for (int i = 0; i < elementsArray.length(); i++) {
            JSONObject elementJson = elementsArray.getJSONObject(i);
            Element element = new Element();

            element.setName(elementJson.optString("name"));
            element.setAppearance(elementJson.optString("appearance"));
            element.setAtomic_mass(elementJson.optDouble("atomic_mass"));
            element.setBoil(elementJson.optDouble("boil"));
            element.setCategory(elementJson.optString("category"));
            element.setColor(elementJson.optString("color"));
            element.setDensity(elementJson.optDouble("density"));
            element.setDiscovered_by(elementJson.optString("discovered_by"));
            element.setMelt(elementJson.optDouble("melt"));
            element.setMolar_heat(elementJson.optDouble("molar_heat"));
            element.setNamed_by(elementJson.optString("named_by"));
            element.setNumber(elementJson.optInt("number"));
            element.setPeriod(elementJson.optInt("period"));
            element.setPhase(elementJson.optString("phase"));
            element.setSummary(elementJson.optString("summary"));
            element.setSymbol(elementJson.optString("symbol"));
            element.setXpos(elementJson.optInt("xpos"));
            element.setYpos(elementJson.optInt("ypos"));
            element.setElectron_configuration(elementJson.optString("electron_configuration"));
            element.setElectron_configuration_semantic(elementJson.optString("electron_configuration_semantic"));
            element.setElectron_affinity(elementJson.optDouble("electron_affinity"));
            element.setElectronegativity_pauling(elementJson.optDouble("electronegativity_pauling"));

            if (elementJson.has("shells")) {
                JSONArray shellsArray = elementJson.getJSONArray("shells");
                ArrayList<Integer> shells = new ArrayList<>();
                for (int j = 0; j < shellsArray.length(); j++) {
                    shells.add(shellsArray.getInt(j));
                }
                element.setShells(shells);
            }

            if (elementJson.has("ionization_energies")) {
                JSONArray energiesArray = elementJson.getJSONArray("ionization_energies");
                ArrayList<Double> energies = new ArrayList<>();
                for (int j = 0; j < energiesArray.length(); j++) {
                    energies.add(energiesArray.getDouble(j));
                }
                element.setIonization_energies(energies);
            }

            elements.add(element);
        }
        return elements;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        executorService.shutdown();
    }
}