package com.example.caioalmeida.festafimdeano;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import com.example.caioalmeida.festafimdeano.constants.FimDeAnoConstants;
import com.example.caioalmeida.festafimdeano.util.SecurityPreferences;

public class DetailsActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();
    private SecurityPreferences mSecurityPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        this.mSecurityPreferences = new SecurityPreferences(this);

        this.mViewHolder.checkParticipate = findViewById(R.id.checkParticipate);

        this.mViewHolder.checkParticipate.setOnClickListener(this);

        this.loadDataFromActivity();
    }

    @Override
    public void onClick(View v) {
        if (mViewHolder.checkParticipate.isChecked()) {
            this.mSecurityPreferences.storeString(FimDeAnoConstants.PRESENCE, FimDeAnoConstants.WILL_GO);
        } else {
            this.mSecurityPreferences.storeString(FimDeAnoConstants.PRESENCE, FimDeAnoConstants.WONT_GO);
        }
    }

    private void loadDataFromActivity() {
        Bundle extra = getIntent().getExtras();
        if (extra != null) {
            String presences = extra.getString(FimDeAnoConstants.PRESENCE);
            if (presences.equals(FimDeAnoConstants.WILL_GO)) {
                this.mViewHolder.checkParticipate.setChecked(true);
            } else {
                this.mViewHolder.checkParticipate.setChecked(false);
            }
        }
    }

    private static class ViewHolder {
        CheckBox checkParticipate;
    }
}
