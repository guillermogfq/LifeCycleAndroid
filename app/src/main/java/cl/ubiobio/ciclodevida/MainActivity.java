package cl.ubiobio.ciclodevida;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private TextView txt;
    public String sLog = "";
    public SharedPreferences sp;
    public SharedPreferences.Editor edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = findViewById(R.id.txt);

        sp = getSharedPreferences(getString(R.string.sp), MODE_PRIVATE);
        sLog = sp.getString("key","");

        edit = sp.edit();

        setStatus("onCreate");
    }

    @Override
    protected void onStart(){
        super.onStart();
        setStatus("onStart");
    }

    @Override
    protected void onResume(){
        super.onResume();
        setStatus("onResume");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        setStatus("onRestart");
    }

    @Override
    protected void onPause(){
        super.onPause();
        setStatus("onPause");
    }

    @Override
    protected void onStop(){
        super.onStop();
        setStatus("onStop");
        edit.putString("key", sLog);
        edit.commit();
    }

    public String getStringTime(){
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat dtf = new SimpleDateFormat("HH:mm:ss");
        return dtf.format(cal.getTime()).toString();
    }

    public void setStatus(String sEvent){
        if(sEvent.equalsIgnoreCase("onCreate")){
            sLog += "=======================\n";
        }

        sLog += "Estoy en " + sEvent + " y son las " + getStringTime() + "\n";
        txt.setText(sLog);
    }
}
