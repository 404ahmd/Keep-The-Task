package com.ahmadibrahim.keepthetask;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.ahmadibrahim.keepthetask.Model.Task;
import com.ahmadibrahim.keepthetask.Operations.TaskOperations;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private Button btnAdd;
    private TaskOperations taskOperations;
    private List<Task> taskList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listViewTugas);
        btnAdd = findViewById(R.id.btnTambah);

        taskOperations = new TaskOperations(this);
        taskOperations.open();


    }
}