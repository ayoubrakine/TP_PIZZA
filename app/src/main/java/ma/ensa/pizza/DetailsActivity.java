package ma.ensa.pizza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URI;

public class DetailsActivity extends AppCompatActivity {

 //   public static String ID="ID";
//    public static String NBRINGREDIENTS="NBRINGREDIENTS";

//    public static String DUREE="DUREE";

    public static String NOM="NOM";
    public static String DETAISINGRED="DETAISINGRED";
    public static String DESCRIPTION="DESCRIPTION";
    public static String PREPARATION="PREPARATION";
    public static String IMAGE="IMAGE";





     private ImageView imageselected;
     private EditText nomitemselected ;
     private EditText detaisingreditemselected ;
     private EditText descriptionitemselected ;
     private EditText preparationitemselected ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        ImageButton imageButton = findViewById(R.id.partage);
        final String num = "+212642665231";
        final String text = "Hello RAKINE";

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://api.whatsapp.com/send?phone=" + num + "&text=" + text;

                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));
                    startActivity(intent);
                } catch (ActivityNotFoundException e) {
                    // Gérez l'exception si WhatsApp n'est pas installé.
                    Toast.makeText(DetailsActivity.this, "WhatsApp is not installed!", Toast.LENGTH_SHORT).show();
                }
            }
        });



        nomitemselected = findViewById(R.id.nom);
        detaisingreditemselected = findViewById(R.id.detaisingredients);
        descriptionitemselected = findViewById(R.id.description);
        preparationitemselected = findViewById(R.id.preparation);
        imageselected = findViewById(R.id.photo);

        Intent i = getIntent();

        String nameee = i.getStringExtra(NOM);
        String detailsss = i.getStringExtra(DETAISINGRED);
        String descriptionnn = i.getStringExtra(DESCRIPTION);
        String preparationnn = i.getStringExtra(PREPARATION);


        int photoId = i.getIntExtra("IMAGE", R.drawable.time);
        //int logo = Integer.parseInt(IMAGE);

        //int imageee = i.getIntExtra(logo);


        nomitemselected.setText(nameee);
        detaisingreditemselected.setText(detailsss);
        descriptionitemselected.setText(descriptionnn);
        preparationitemselected.setText(preparationnn);

        imageselected.setImageResource(photoId);








    }

    private boolean isAppInstalled(String packageName) {
        PackageManager packageManager = getPackageManager();
        boolean isInstalled;

        try {
            packageManager.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES);
            isInstalled = true;
        } catch (PackageManager.NameNotFoundException e) {
            isInstalled = false;
            e.printStackTrace();
        }
        return isInstalled;
    }
}