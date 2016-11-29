package com.example.memecreator;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.Random;

public class MainActivity extends ActionBarActivity implements TopSectionFragment.TopSectionListener {
    private static final String TAG = "MainActivity";
   ImageView ll2;
    Button button;
    private static int IMG_RESULT = 1;
    String ImageDecode;
    ImageView imageViewLoad;
    Button LoadImage;
    Intent intent;
    String[] FILE;
    private static final int CAMERA_REQUEST = 1888;
    private ImageView imageView;
    public static ImageView imageView2;
int pic;
    public static Bitmap meme_image;
    String listItem;
    RelativeLayout ll;

    Button button11;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button11 = (Button) findViewById(R.id.dialog);

        // Capture button clicks
        button11.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {


                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);


                builder.setTitle("Add any pic you like");


                builder.setMessage("Select from Gallery Camera or our list :)");


                //Button One : Yes

                imageViewLoad = (ImageView) findViewById(R.id.imageView1);

                builder.setPositiveButton("Gallery", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Opening Gallery", Toast.LENGTH_LONG).show();
                        intent = new Intent(Intent.ACTION_PICK,
                                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                        startActivityForResult(intent, IMG_RESULT);


                    }
                });

                //this.imageView = (ImageView)this.findViewById(R.id.imageView1);


                //Button Two : No
                builder.setNegativeButton("Camera", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Opening Camera", Toast.LENGTH_LONG).show();
                        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivityForResult(cameraIntent, CAMERA_REQUEST);

                    }
                });


                //Button Three : Neutral
                builder.setNeutralButton("List", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Opening List", Toast.LENGTH_LONG).show();
                        Intent myIntent = new Intent(MainActivity.this,
                                ListCustom.class);
                        startActivity(myIntent);

                    }
                });


                AlertDialog diag = builder.create();
                diag.show();
            }
        });


       /* imageViewLoad = (ImageView) findViewById(R.id.imageView1);
        LoadImage = (Button)findViewById(R.id.button1);
        LoadImage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                intent = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                startActivityForResult(intent, IMG_RESULT);

            }
        });*/

        this.imageView = (ImageView) this.findViewById(R.id.imageView1);
        /*Button photoButton = (Button) this.findViewById(R.id.camera);
        photoButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            }
        });*/


        // Locate the button in activity_main.xml
       /* button = (Button) findViewById(R.id.button2);

        // Capture button clicks
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(MainActivity.this,
                        ListCustom.class);
                startActivity(myIntent);


                     }
        });*/


        Button button1 = (Button) findViewById(R.id.save);
        ll2 = (ImageView) findViewById(R.id.imageView1);
        button1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
               /*View z = (ImageView) findViewById(R.id.imageView1);
                z.setDrawingCacheEnabled(true);
                int totalHeight = z.getHeight();
                int totalWidth = z.getWidth();
                z.layout(0, 0, totalWidth, totalHeight);
                z.buildDrawingCache(true);
                Bitmap bm = Bitmap.createBitmap(z.getDrawingCache());
                z.setDrawingCacheEnabled(false);
                Toast.makeText(MainActivity.this, "Taking Screenshot", Toast.LENGTH_SHORT).show();
                MediaStore.Images.Media.insertImage(getContentResolver(), bm, null, null);*/
// image naming and path  to include sd card  appending name you choose for file
                Toast.makeText(MainActivity.this, "Image Saved", Toast.LENGTH_LONG).show();

                Date now = new Date();
                android.text.format.DateFormat.format("yyyy-MM-dd_hh:mm:ss", now);

                try {
                    // image naming and path  to include sd card  appending name you choose for file
                    String mPath = Environment.getExternalStorageDirectory().toString() + "/IIITDMEMES" + now + ".jpg";

                    // create bitmap screen capture


                    View v1 = getWindow().getDecorView().getRootView();
                    v1.setDrawingCacheEnabled(true);
                    Bitmap bitmap = Bitmap.createBitmap(v1.getDrawingCache());
                    v1.setDrawingCacheEnabled(false);

                    File imageFile = new File(mPath);

                    FileOutputStream outputStream = new FileOutputStream(imageFile);
                    int quality = 100;
 Bitmap bitmap = Bitmap.createBitmap(v1.getDrawingCache(),120,840,850,1080);
                System.out.println("Height"+bitmap.getHeight());
                    System.out.println("width"+bitmap.getWidth());

                    //bitmap=scaleBitmap(bitmap,1000,500);
                  //bitmap=Bitmap.createBitmap(bitmap, -200, -200, 200,300);
                   /* if (bitmap.getWidth() == bitmap.getHeight()){

                        bitmap = Bitmap.createBitmap(
                                bitmap,bitmap.getWidth()/2 - bitmap.getHeight(),
                                0,
                                bitmap.getHeight(),
                                bitmap.getHeight()
                        );

                    }else{

                        bitmap = Bitmap.createBitmap(
                                bitmap,
                                0,
                                bitmap.getHeight() - bitmap.getWidth()/2,
                                bitmap.getWidth(),
                                bitmap.getWidth()
                        );
                    }*/
                    bitmap.compress(Bitmap.CompressFormat.JPEG, quality, outputStream);

                    outputStream.flush();
                    outputStream.close();

                    openScreenshot(imageFile);
                } catch (Throwable e) {
                    // Several error may come out with file handling or OOM
                    e.printStackTrace();
                }
            }
        });
    }

    public static Bitmap scaleBitmap(Bitmap bitmap, int wantedWidth, int wantedHeight) {
        Bitmap output = Bitmap.createBitmap(wantedWidth, wantedHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);
        Matrix m = new Matrix();
        m.setScale((float) wantedWidth / bitmap.getWidth(), (float) wantedHeight / bitmap.getHeight());
        canvas.drawBitmap(bitmap, m, new Paint());

        return output;
    }


            private void openScreenshot(File imageFile) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                Uri uri = Uri.fromFile(imageFile);
                intent.setDataAndType(uri, "image/*");
                startActivity(intent);
            }
    public Bitmap takeScreenshot() {
        View rootView = findViewById(R.id.imageView1).getRootView();
        rootView.setDrawingCacheEnabled(true);
        return rootView.getDrawingCache();

    }

    public void saveBitmap(Bitmap bitmap) {

        String root = Environment.getExternalStorageDirectory().toString();
        File newDir = new File(root + "/MapCards");
        newDir.mkdirs();
        Random gen = new Random();
        int n = 10000;
        n = gen.nextInt(n);
        String fotoname = "Photo-"+ n +".jpg";
        File file = new File(newDir, fotoname);
        if (file.exists ()) file.delete ();
        try {
            FileOutputStream fos = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            fos.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            Log.e("GREC", e.getMessage(), e);
        } catch (IOException e) {
            Log.e("GREC", e.getMessage(), e);
        }
    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {

            if (requestCode == IMG_RESULT && resultCode == RESULT_OK
                    && null != data) {


                Uri URI = data.getData();
                String[] FILE = { MediaStore.Images.Media.DATA };


                Cursor cursor = getContentResolver().query(URI,
                        FILE, null, null, null);

                cursor.moveToFirst();

                int columnIndex = cursor.getColumnIndex(FILE[0]);
                ImageDecode = cursor.getString(columnIndex);
                cursor.close();

                imageViewLoad.setImageBitmap(BitmapFactory
                        .decodeFile(ImageDecode));

            }
        } catch (Exception e) {
            Toast.makeText(this, "Please try again", Toast.LENGTH_LONG)
                    .show();
        }

        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(photo);
        }

    }



    // This gets called by the Top Fragment when the user clicks the button
    @Override
    public void createMeme(String top, String bottom) {

        BottomPictureFragment bottomFragment = (BottomPictureFragment)getSupportFragmentManager().findFragmentById(R.id.fragment2);
        bottomFragment.setMemeText(top, bottom);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


        @Override
    public void onStart()
    {
        super.onStart();
        Log.d(TAG, "Inside OnStart");
    }

    @Override
    public void onPause()
    {
        super.onPause();
        Log.d(TAG,"Inside OnPause");

    }

    @Override
    public void onResume(){
        super.onResume();
        Log.d(TAG,"Inside OnREsume");
        //Bundle bundle = this.getIntent().getExtras();
       /* pic = bundle.getInt("image");
       imageView2 = (ImageView) findViewById(R.id.imageView1);
        imageView2.setImageResource(R.drawable.image);*/

    }

    @Override
    public void onStop(){
        super.onStop();
        Log.d(TAG, "Inside OnSTop");

    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "Inside OnDestroy");
    }

}


