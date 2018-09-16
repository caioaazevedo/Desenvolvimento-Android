package com.example.caioalmeida.festafimdeano;

import android.content.Intent;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.textToday = findViewById(R.id.textToday);
        this.mViewHolder.textDaysLeft = findViewById(R.id.textLeft);
        this.mViewHolder.buttonConfirm = findViewById(R.id.buttonConfirm);

        this.mViewHolder.buttonConfirm.setOnClickListener(this);

        mSecurityPreferences = new SecurityPreferences(this);

        this.verifyPresence();
    }

    @Override
    public void onClick(View v) {

        String presence = this.mSecurityPreferences.getStorageString(FimDeAnoConstants.PRESENCE);

        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra(FimDeAnoConstants.PRESENCE, presence);
        startActivity(intent);
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
