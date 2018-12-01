package scottsalvador.pons.com.ponsscottsalvadorexam2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.*;

public class MainActivity extends AppCompatActivity {

    EditText eFN,eLN,eE1,eE2,eAVG;
    FirebaseDatabase db;
    DatabaseReference root;
    ArrayList<String> keyList;
    int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = FirebaseDatabase.getInstance();
        root = db.getReference("grade");
        eFN = findViewById(R.id.FN);
        eLN = findViewById(R.id.LN);
        eE1 = findViewById(R.id.E1);
        eE2 = findViewById(R.id.E2);
        eAVG = findViewById(R.id.AVG);
        keyList = new ArrayList<String>();


        root.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot ss: dataSnapshot.getChildren()){
                    keyList.add(ss.getKey());
                    //Toast.makeText(this,"Record added to db",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    /*
    @Override
    protected void onStart(){
        super.onStart();
        root.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot ss: dataSnapshot.getChildren()){
                    //keyList.add(ss.getKey());
                    //Toast.makeText(this,"Record added to db",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    */
    public void addRecord(View v){
        try{
            String fname = eFN.getText().toString().trim();
            String lname = eLN.getText().toString().trim();
            double exam1 = Double.parseDouble(eE1.getText().toString().trim());
            double exam2 = Double.parseDouble(eE2.getText().toString().trim());

            Student sgrade = new Student(fname, lname, exam1, exam2);
            String key = root.push().getKey();
            root.child(key).setValue(sgrade);
            keyList.add(key);

            root.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    index = (int) keyList.size()-1;
                    Student stud = dataSnapshot.child(keyList.get(index)).getValue(Student.class);
                    eAVG.setText(stud.getAVG().toString());
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }catch(Exception e){
            Toast.makeText(this,"Invalid Input",Toast.LENGTH_LONG).show();
        }
    }
}
