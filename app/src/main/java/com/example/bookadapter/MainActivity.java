package com.example.bookadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    String myArr[] = {"Как приручить дракона","1 + 1","Ненси дрю","Звездочка","Холодное сердце","Кунфу панда","Город героев","Смешарики","Эверест"};
    ListView listView1, listView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView1 = findViewById(R.id.listView);
        listView2 = findViewById(R.id.hardListView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,R.layout.item_list, myArr);
        listView1.setAdapter(adapter);

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"Adapt1 "+myArr[position],Toast.LENGTH_SHORT).show();
            }
        });


        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Зверополис", "Мультик"));
        movies.add(new Movie("Тачки", "Мультик"));
        movies.add(new Movie("Алиса в стране чудес", "Фильм"));
        movies.add(new Movie("Жихарка", "Короткометражка"));
        movies.add(new Movie("Лунтик", "Мультик"));
        movies.add(new Movie("Гарри Поттер", "Фильм"));
        movies.add(new Movie("Хранители снов", "Мультик"));
        movies.add(new Movie("Рапунцель", "Мультик"));
        movies.add(new Movie("Фантастические твари", "Фильм"));
        movies.add(new Movie("Гарфилд", "Фильм"));

        final ArrayList<HashMap<String,Object>> allMovies = new ArrayList<>();
        HashMap<String, Object> map;
        for (int i = 0; i < movies.size(); i++) {
            map = new HashMap<>();
            map.put("name",movies.get(i).name);
            map.put("type",movies.get(i).type);
            allMovies.add(map);
        }

        String[] from = {"name","type"};
        int[] to = {R.id.name, R.id.type};
        SimpleAdapter hardAdapter = new SimpleAdapter(this, allMovies, R.layout.item_for_simple_adapter,from,to);
        listView2.setAdapter(hardAdapter);

        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"Adapt2 "+allMovies.get(position).get("name"),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
