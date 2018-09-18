package com.example.caioalmeida.festafimdeano;

import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.caioalmeida.festafimdeano.constants.FimDeAnoConstants;
import com.example.caioalmeida.festafimdeano.util.SecurityPreferences;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ViewHolder mViewHolder = new ViewHolder();
    private SecurityPreferences mSecurityPreferences;
    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.textToday = findViewById(R.id.textToday);
        this.mViewHolder.textDaysLeft = findViewById(R.id.textLeft);
        this.mViewHolder.buttonConfirm = findViewById(R.id.buttonConfirm);

        this.mViewHolder.buttonConfirm.setOnClickListener(this);

        this.mViewHolder.textToday.setText(SIMPLE_DATE_FORMAT.format(Calendar.getInstance().getTime()));

        mSecurityPreferences = new SecurityPreferences(this);

        String daysLeft = String.format("%s %s", String.valueOf(this.getDaysLeftToEndOfYear()), getString(R.string.dias));

        this.mViewHolder.textDaysLeft.setText(daysLeft);
    }

    @Override
    protected void onResume(){
        super.onResume();
        this.verifyPresence();
    }

    @Override
    public void onClick(View v) {

        String presence = this.mSecurityPreferences.getStorageString(FimDeAnoConstants.PRESENCE);

        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra(FimDeAnoConstants.PRESENCE, presence);
        startActivity(intent);
    }

    private int getDaysLeftToEndOfYear(){
        Calendar calendarToday = Calendar.getInstance();
        int today = calendarToday.get(Calendar.DAY_OF_YEAR);

        Calendar calendarLastDay = Calendar.getInstance();
        int dayDecember31 = calendarLastDay. getActualMaximum(Calendar.DAY_OF_YEAR);

        return dayDecember31 - today;
    }

    private void verifyPresence(){
        String presence = this.mSecurityPreferences.getStorageString(FimDeAnoConstants.PRESENCE);

        if(presence.equals("")){
            this.mViewHolder.buttonConfirm.setText(R.string.naoConfirmado);
        } else if(presence.equals(FimDeAnoConstants.WILL_GO)) {
            this.mViewHolder.buttonConfirm.setText(R.string.sim);
        } else {
            this.mViewHolder.buttonConfirm.setText(R.string.nao);
        }
    }

    private static class ViewHolder{
        TextView textToday;
        TextView textDaysLeft;
        Button buttonConfirm;
    }
}
