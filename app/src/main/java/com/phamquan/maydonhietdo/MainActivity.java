package com.phamquan.maydonhietdo;import android.content.Intent;import android.os.Bundle;import android.support.v7.app.AppCompatActivity;import android.view.View;import android.view.Menu;import android.view.MenuItem;import com.phamquan.maydonhietdo.domoi.PersonInfo;import com.phamquan.maydonhietdo.hoso.ListResume;import com.phamquan.maydonhietdo.other.AboutUs;import com.phamquan.maydonhietdo.other.Guideline;public class MainActivity extends AppCompatActivity {    @Override    protected void onCreate(Bundle savedInstanceState) {        super.onCreate(savedInstanceState);        setContentView(R.layout.activity_main);    }    public void onClick(View view) {        switch (view.getId()) {            case R.id.btnNewPerson:                openPersonInfo();                break;            case R.id.btnResume:                openHoSo();                break;            case R.id.btnGuideline:                openGuideline();                break;            case R.id.btnAboutUs:                openAboutUs();                break;            case R.id.btnExit:                finish();                System.exit(0);                break;        }    }    @Override    public boolean onCreateOptionsMenu(Menu menu) {        // Inflate the menu; this adds items to the action bar if it is present.        getMenuInflater().inflate(R.menu.menu_main, menu);        return true;    }    public void openPersonInfo() {        Intent intent = new Intent(MainActivity.this, PersonInfo.class);        startActivity(intent);    }    public void openAboutUs() {        Intent intent = new Intent(MainActivity.this, AboutUs.class);        startActivity(intent);    }    public void openGuideline() {        Intent intent = new Intent(MainActivity.this, Guideline.class);        startActivity(intent);    }    public void openHoSo() {        Intent intent = new Intent(MainActivity.this, ListResume.class);        startActivity(intent);    }    @Override    public boolean onOptionsItemSelected(MenuItem item) {        int id = item.getItemId();        //noinspection SimplifiableIfStatement        if (id == R.id.action_settings) {            return true;        }        return super.onOptionsItemSelected(item);    }}