package com.example.recycleview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleview.model.Cat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner sp  ;
    private EditText name,price,subs ;
    private Button btn ;
    private RecyclerView rev ;
    private List<Cat> catList =new ArrayList() ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
       initSpinner();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCat();
               initRecylceView();
            }
        });
    }

    private void init(){
        sp=findViewById(R.id.sp) ;
        name=findViewById(R.id.namepr);
        price=findViewById(R.id.pricepr);
        subs=findViewById(R.id.subspr);
        btn =findViewById(R.id.add) ;
        rev=findViewById(R.id.rev);

    }

    private void initRecylceView(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rev.setLayoutManager(layoutManager);
        CartAdapter adapter =  new CartAdapter(catList,this);
        rev.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void initSpinner(){
        List<String> catSpin = new ArrayList<>();
        catSpin.add("1");
        catSpin.add("2");
        catSpin.add("3");
        catSpin.add("4");
        catSpin.add("5");
        catSpin.add("6");
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,catSpin);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        sp.setAdapter(adapter);
    }

    private void addCat(){
        Cat cat = new Cat(1,"","","");
        cat.setName(name.getText().toString());
        cat.setPrice(price.getText().toString());
        cat.setSubs(subs.getText().toString());
       sp.setOnItemSelectedListener(this);

       int i  = sp.getSelectedItemPosition();
       if(i==0) cat.setImage(R.drawable.anh1);
       if(i==1) cat.setImage(R.drawable.anh2);
       if(i==2) cat.setImage(R.drawable.anh3);
       if(i==3) cat.setImage(R.drawable.anh4);
       if(i==4) cat.setImage(R.drawable.anh5);
       if(i==5) cat.setImage(R.drawable.anh6);

       catList.add(cat);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),"Selected : "+item,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}
