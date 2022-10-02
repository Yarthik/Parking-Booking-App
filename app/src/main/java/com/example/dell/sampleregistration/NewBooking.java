package com.example.dell.sampleregistration;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class NewBooking extends Activity {

    Button b;
    EditText e1;
    EditText e2;
    EditText e3;
   static int count=1;
    Button Button1;
    Button B1;
    Button B2;
    Button B3;
    Button B4;
    Button B5;
    Button B6;
    Button B25;
    String s="";
    String s1="";
    String s2="";
    SQLiteDatabase db;
    static String date="aa";
    AutoCompleteTextView languages;
    AutoCompleteTextView languages1;
    AutoCompleteTextView languages0;
    //private DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_booking);
        //mDatabase = FirebaseDatabase.getInstance().getReference();

        Bundle usernamedata=getIntent().getExtras();
        if(usernamedata==null)
            return;
        /*
        if(getIntent().hasExtra("DATE"))
        {
            date=usernamedata.getString("DATE");
            e1.setText(date);
        }
        else
        {
            Toast.makeText(getBaseContext(),"Not found date",Toast.LENGTH_LONG).show();
        }*/

        Button1=(Button)findViewById(R.id.Button1);
        B1=(Button)findViewById(R.id.B1);
        B2=(Button)findViewById(R.id.B2);
        B3=(Button)findViewById(R.id.B3);
        B4=(Button)findViewById(R.id.B4);
        B5=(Button)findViewById(R.id.B5);
        B6=(Button)findViewById(R.id.B6);
        B25=(Button)findViewById(R.id.B25);
     //   e1=(EditText)findViewById(R.id.E1);



        String[] items2 = new String[]{"1/10/2019","2/10/2019","3/10/2019","4/10/2019","5/10/2019","6/10/2019","7/10/2019","8/10/2019"
                ,"9/10/2019","10/10/2019","11/10/2019","12/10/2019","13/10/2019","14/10/2019","15/10/2019","16/10/2019"
                ,"17/10/2019","18/10/2019","19/10/2019","20/10/2019","21/10/2019","22/10/2019","23/10/2019","24/10/2019"
                ,"25/10/2019","26/10/2019","27/10/2019","28/10/2019","29/10/2019","30/10/2019","31/10/2019","1/11/2019","2/11/2019","3/11/2019","4/11/2019","5/11/2019","6/11/2019","7/11/2019","8/11/2019"
                ,"9/11/2019","10/11/2019","11/11/2019","12/11/2019","13/11/2019","14/11/2019","15/11/2019","16/11/2019"
                ,"17/11/2019","18/11/2019","19/11/2019","20/11/2019","21/11/2019","22/11/2019","23/11/2019","24/11/2019"
                ,"25/11/2019","26/11/2019","27/11/2019","28/11/2019","29/11/2019","30/11/2019",
                "1/12/2019","2/12/2019","3/12/2019","4/12/2019","5/12/2019","6/12/2019","7/12/2019","8/12/2019"
                ,"9/12/2019","10/12/2019","11/12/2019","12/12/2019","13/12/2019","14/12/2019","15/12/2019","16/12/2019"
                ,"17/12/2019","18/12/2019","19/12/2019","20/12/2019","21/12/2019","22/12/2019","23/12/2019","24/12/2019"
                ,"25/12/2019","26/12/2019","27/12/2019","28/12/2019","29/12/2019","30/12/2019","31/12/2019"
        };
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items2);
        languages0 = (AutoCompleteTextView) findViewById(R.id.languages0);
        //Set the number of characters the user must type before the drop down list is shown
        languages0.setThreshold(1);
        //Set the adapter
        languages0.setAdapter(adapter2);
      /*  e2=(EditText)findViewById(R.id.E2);
        e3=(EditText)findViewById(R.id.E3);*/
        String[] items = new String[]{"1:00am", "1:00pm","2:00am", "2:00pm","3:00am", "3:00pm"
                ,"4:00am", "4:00pm","5:00am", "5:00pm","6:00am", "6:00pm","7:00am", "7:00pm","8:00am", "8:00pm",
                "9:00am", "9:00pm","10:00am", "10:00pm"
                ,"11:00am", "11:00pm","0:00am", "12:00pm"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
       languages1= (AutoCompleteTextView) findViewById(R.id.languages1);
        //Set the number of characters the user must type before the drop down list is shown
        languages1.setThreshold(1);
        //Set the adapter
        languages1.setAdapter(adapter);

        String[] items1 = new String[]{"1hrs", "2hrs", "3hrs","4hrs","5hrs","6hrs","7hrs","8hrs","9hrs","10hrs","11hrs","12hrs"};
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items1);
        languages = (AutoCompleteTextView) findViewById(R.id.languages);
        //Set the number of characters the user must type before the drop down list is shown
        languages.setThreshold(1);
        //Set the adapter
        languages.setAdapter(adapter1);
        B1.setEnabled(false);
        B2.setEnabled(false);
        B3.setEnabled(false);
        B4.setEnabled(false);
        B5.setEnabled(false);
        B6.setEnabled(false);
        final Context context=this;
        try
        {
            db=openOrCreateDatabase("Booking",SQLiteDatabase.CREATE_IF_NECESSARY,null);
            db.execSQL("CREATE TABLE book1 (id integer PRIMARY KEY AUTOINCREMENT, date text, time text , duration text , uname text )");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        Button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle usernamedata=getIntent().getExtras();
                if(usernamedata==null)
                    return;
                String username="";
                if(getIntent().hasExtra("UserName"))
                {
                    username=usernamedata.getString("UserName");
                }
                else
                {
                    Toast.makeText(getBaseContext(),"Not found username",Toast.LENGTH_LONG).show();
                }
                //final String date=usernamedata.getString("DATE");
                  //e1.setText(date);
                s = languages0.getText().toString();
                s1 = languages1.getText().toString();
                s2 = languages.getText().toString();
                //String s3=e3.getText().toString();
                //db.execSQL("INSERT INTO log VALUES (s)");

                ContentValues values = new ContentValues();
                //values.put("id",s);
                values.put("date", s);
                values.put("time", s1);
                values.put("duration", s2);
                values.put("uname",username);
                //values.put("booked","notbooked");
                if ((db.insert("book1", null, values)) != -1) {
                    Toast.makeText(NewBooking.this, "Inserted...", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(NewBooking.this, "Error...", Toast.LENGTH_LONG).show();
                }


                    //Intent i=new Intent(context,Admin.class);
                    //startActivity(i);
                    B1 = (Button) findViewById(R.id.B1);
                    B2 = (Button) findViewById(R.id.B2);
                    B3 = (Button) findViewById(R.id.B3);
                    B4 = (Button) findViewById(R.id.B4);
                    B5 = (Button) findViewById(R.id.B5);
                    B6 = (Button) findViewById(R.id.B6);
                    B1.setEnabled(true);
                    B2.setEnabled(true);
                    B3.setEnabled(true);
                    B4.setEnabled(true);
                    B5.setEnabled(true);
                    B6.setEnabled(true);
             }
        });
        //B25.setOnClickListener(new V);
    }

    public void onB1Click(View v)
    {
        Bundle usernamedata=getIntent().getExtras();
        if(usernamedata==null)
            return;
        final String username=usernamedata.getString("UserName");

        final Context context=this;
        try
        {
            db=openOrCreateDatabase("Bookin",SQLiteDatabase.CREATE_IF_NECESSARY,null);
            db.execSQL("CREATE TABLE book2 (id integer PRIMARY KEY AUTOINCREMENT, date text, time text , duration text , uname text ,slot text )");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        //db.execSQL("INSERT INTO log VALUES (s)");
        String Slot1="slot1";
        ContentValues values = new ContentValues();
        //values.put("id",s)
        // ;
        s = languages0.getText().toString();
        s1 = languages1.getText().toString();
        s2 =languages.getText().toString();
        //db=openOrCreateDatabase("Bookin", SQLiteDatabase.CREATE_IF_NECESSARY,null);
        // Cursor c= db.rawQuery("SELECT  *  FROM parking WHERE username = ?"+username,null);
        Cursor c=db.rawQuery("SELECT * FROM book2 WHERE date = ? and time = ? and slot =? ", new String[] {s , s1 , "slot1"});

       int d=0;

        while(!c.isAfterLast())
        {
            d++;
            c.moveToNext();
        }
        if(d==0) {
            values.put("date", s);
            values.put("time", s1);
            values.put("duration", s2);
            values.put("uname", username);
            values.put("slot", "slot1");
            //values.put("booked","notbooked");
            if ((db.insert("book2", null, values)) != -1) {
                Toast.makeText(NewBooking.this, "Inserted. By B1", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(NewBooking.this, "Error. By B1", Toast.LENGTH_LONG).show();
            }

            languages0.setText("");
            languages1.setText("");
            languages.setText("");
            //B1.setBackgroundColor(getResources().getColor(R.color.));
            B1.setBackgroundColor(Color.GREEN);
            //B1.setEnabled(false);
            B2.setEnabled(false);
            B3.setEnabled(false);
            B4.setEnabled(false);
            B5.setEnabled(false);
            B6.setEnabled(false);
        }
        else
        {
            B1.setBackgroundColor(Color.RED);
            Toast.makeText(NewBooking.this, "Slot Already Booked try another slot", Toast.LENGTH_LONG).show();
        }
    }
    public void B2Clicked(View v)
    {

        Bundle usernamedata=getIntent().getExtras();
        if(usernamedata==null)
            return;
        final String username=usernamedata.getString("UserName");

        final Context context=this;
        try
        {
            db=openOrCreateDatabase("Bookin",SQLiteDatabase.CREATE_IF_NECESSARY,null);
            db.execSQL("CREATE TABLE book2 (id integer PRIMARY KEY AUTOINCREMENT, date text, time text , duration text , uname text ,slot text )");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        //db.execSQL("INSERT INTO log VALUES (s)");
        String Slot1="slot1";
        ContentValues values = new ContentValues();
        //values.put("id",s)
        // ;
        s = languages0.getText().toString();
        s1 = languages1.getText().toString();
        s2 = languages.getText().toString();
        //db=openOrCreateDatabase("Bookin", SQLiteDatabase.CREATE_IF_NECESSARY,null);
        // Cursor c= db.rawQuery("SELECT  *  FROM parking WHERE username = ?"+username,null);
        Cursor c=db.rawQuery("SELECT * FROM book2 WHERE date = ? and time = ? and slot =? ", new String[] {s , s1 , "slot2"});

        int d=0;

        while(!c.isAfterLast())
        {
            d++;
            c.moveToNext();
        }
        if(d==0) {
            values.put("date", s);
            values.put("time", s1);
            values.put("duration", s2);
            values.put("uname", username);
            values.put("slot", "slot2");
            //values.put("booked","notbooked");
            if ((db.insert("book2", null, values)) != -1) {
                Toast.makeText(NewBooking.this, "Inserted. By B2", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(NewBooking.this, "Error. By B2", Toast.LENGTH_LONG).show();
            }

            languages0.setText("");
            languages1.setText("");
            languages.setText("");
            //B1.setBackgroundColor(getResources().getColor(R.color.));
            B2.setBackgroundColor(Color.GREEN);
            B1.setEnabled(false);
            //B2.setEnabled(false);
            B3.setEnabled(false);
            B4.setEnabled(false);
            B5.setEnabled(false);
            B6.setEnabled(false);
        }
        else
        {
            B2.setBackgroundColor(Color.RED);
            Toast.makeText(NewBooking.this, "Slot Already Booked try another slot", Toast.LENGTH_LONG).show();
        }
    }
    public void B3Clicked(View v)
    {
        Bundle usernamedata=getIntent().getExtras();
        if(usernamedata==null)
            return;
        final String username=usernamedata.getString("UserName");

        final Context context=this;
        try
        {
            db=openOrCreateDatabase("Bookin",SQLiteDatabase.CREATE_IF_NECESSARY,null);
            db.execSQL("CREATE TABLE book2 (id integer PRIMARY KEY AUTOINCREMENT, date text, time text , duration text , uname text ,slot text )");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        //db.execSQL("INSERT INTO log VALUES (s)");
        String Slot1="slot1";
        ContentValues values = new ContentValues();
        //values.put("id",s)
        // ;
        s = languages0.getText().toString();
        s1 = languages1.getText().toString();
        s2 = languages.getText().toString();
        //db=openOrCreateDatabase("Bookin", SQLiteDatabase.CREATE_IF_NECESSARY,null);
        // Cursor c= db.rawQuery("SELECT  *  FROM parking WHERE username = ?"+username,null);
        Cursor c=db.rawQuery("SELECT * FROM book2 WHERE date = ? and time = ? and slot =? ", new String[] {s , s1 , "slot3"});

        int d=0;

        while(!c.isAfterLast())
        {
            d++;
            c.moveToNext();
        }
        if(d==0) {
            values.put("date", s);
            values.put("time", s1);
            values.put("duration", s2);
            values.put("uname", username);
            values.put("slot", "slot3");
            //values.put("booked","notbooked");
            if ((db.insert("book2", null, values)) != -1) {
                Toast.makeText(NewBooking.this, "Inserted. By B3", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(NewBooking.this, "Error. By B3", Toast.LENGTH_LONG).show();
            }

            languages0.setText("");
            languages1.setText("");
            languages.setText("");
            //B1.setBackgroundColor(getResources().getColor(R.color.));
            B3.setBackgroundColor(Color.GREEN);
            B1.setEnabled(false);
            B2.setEnabled(false);
            //B3.setEnabled(false);
            B4.setEnabled(false);
            B5.setEnabled(false);
            B6.setEnabled(false);
        }
        else
        {
            B3.setBackgroundColor(Color.RED);
            Toast.makeText(NewBooking.this, "Slot Already Booked try another slot", Toast.LENGTH_LONG).show();
        }
    }
    public void B4Clicked(View v)
    {
        Bundle usernamedata=getIntent().getExtras();
        if(usernamedata==null)
            return;
        final String username=usernamedata.getString("UserName");

        final Context context=this;
        try
        {
            db=openOrCreateDatabase("Bookin",SQLiteDatabase.CREATE_IF_NECESSARY,null);
            db.execSQL("CREATE TABLE book2 (id integer PRIMARY KEY AUTOINCREMENT, date text, time text , duration text , uname text ,slot text )");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        //db.execSQL("INSERT INTO log VALUES (s)");
        String Slot1="slot1";
        ContentValues values = new ContentValues();
        //values.put("id",s)
        // ;
        s = languages0.getText().toString();
        s1 = languages1.getText().toString();
        s2 = languages.getText().toString();
        //db=openOrCreateDatabase("Bookin", SQLiteDatabase.CREATE_IF_NECESSARY,null);
        // Cursor c= db.rawQuery("SELECT  *  FROM parking WHERE username = ?"+username,null);
        Cursor c=db.rawQuery("SELECT * FROM book2 WHERE date = ? and time = ? and slot =? ", new String[] {s , s1 , "slot4"});

        int d=0;

        while(!c.isAfterLast())
        {
            d++;
            c.moveToNext();
        }
        if(d==0) {
            values.put("date", s);
            values.put("time", s1);
            values.put("duration", s2);
            values.put("uname", username);
            values.put("slot", "slot4");
            //values.put("booked","notbooked");
            if ((db.insert("book2", null, values)) != -1) {
                Toast.makeText(NewBooking.this, "Inserted. By B4", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(NewBooking.this, "Error. By B4", Toast.LENGTH_LONG).show();
            }

            languages0.setText("");
            languages.setText("");
            languages1.setText("");
            //B1.setBackgroundColor(getResources().getColor(R.color.));
            B4.setBackgroundColor(Color.GREEN);
            B1.setEnabled(false);
            B2.setEnabled(false);
            B3.setEnabled(false);
            //B4.setEnabled(false);
            B5.setEnabled(false);
            B6.setEnabled(false);
        }
        else
        {
            B4.setBackgroundColor(Color.RED);
            Toast.makeText(NewBooking.this, "Slot Already Booked try another slot", Toast.LENGTH_LONG).show();
        }
    }
    public void B5Clicked(View v)
    {
        Bundle usernamedata=getIntent().getExtras();
        if(usernamedata==null)
            return;
        final String username=usernamedata.getString("UserName");

        final Context context=this;
        try
        {
            db=openOrCreateDatabase("Bookin",SQLiteDatabase.CREATE_IF_NECESSARY,null);
            db.execSQL("CREATE TABLE book2 (id integer PRIMARY KEY AUTOINCREMENT, date text, time text , duration text , uname text ,slot text )");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        //db.execSQL("INSERT INTO log VALUES (s)");
        String Slot1="slot1";
        ContentValues values = new ContentValues();
        //values.put("id",s)
        // ;
        s = languages0.getText().toString();
        s1 = languages1.getText().toString();
        s2 = languages.getText().toString();
        //db=openOrCreateDatabase("Bookin", SQLiteDatabase.CREATE_IF_NECESSARY,null);
        // Cursor c= db.rawQuery("SELECT  *  FROM parking WHERE username = ?"+username,null);
        Cursor c=db.rawQuery("SELECT * FROM book2 WHERE date = ? and time = ? and slot =? ", new String[] {s , s1 , "slot5"});

        int d=0;

        while(!c.isAfterLast())
        {
            d++;
            c.moveToNext();
        }
        if(d==0) {
            values.put("date", s);
            values.put("time", s1);
            values.put("duration", s2);
            values.put("uname", username);
            values.put("slot", "slot5");
            //values.put("booked","notbooked");
            if ((db.insert("book2", null, values)) != -1) {
                Toast.makeText(NewBooking.this, "Inserted. By B5", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(NewBooking.this, "Error. By B5", Toast.LENGTH_LONG).show();
            }

            languages0.setText("");
            languages1.setText("");
            languages.setText("");
            //B1.setBackgroundColor(getResources().getColor(R.color.));
            B5.setBackgroundColor(Color.GREEN);
            B1.setEnabled(false);
            B2.setEnabled(false);
            B3.setEnabled(false);
            B4.setEnabled(false);
            //B5.setEnabled(false);
            B6.setEnabled(false);
        }
        else
        {
            B5.setBackgroundColor(Color.RED);
            Toast.makeText(NewBooking.this, "Slot Already Booked try another slot", Toast.LENGTH_LONG).show();
        }
    }
    public void B6Clicked(View v)
    {
        Bundle usernamedata=getIntent().getExtras();
        if(usernamedata==null)
            return;
        final String username=usernamedata.getString("UserName");

        final Context context=this;
        try
        {
            db=openOrCreateDatabase("Bookin",SQLiteDatabase.CREATE_IF_NECESSARY,null);
            db.execSQL("CREATE TABLE book2 (id integer PRIMARY KEY AUTOINCREMENT, date text, time text , duration text , uname text ,slot text )");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        //db.execSQL("INSERT INTO log VALUES (s)");
        String Slot1="slot1";
        ContentValues values = new ContentValues();
        //values.put("id",s)
        // ;
        s = languages0.getText().toString();
        s1 = languages1.getText().toString();
        s2 =languages.getText().toString();
        //db=openOrCreateDatabase("Bookin", SQLiteDatabase.CREATE_IF_NECESSARY,null);
        // Cursor c= db.rawQuery("SELECT  *  FROM parking WHERE username = ?"+username,null);
        Cursor c=db.rawQuery("SELECT * FROM book2 WHERE date = ? and time = ? and slot =? ", new String[] {s , s1 , "slot6"});

        int d=0;

        while(!c.isAfterLast())
        {
            d++;
            c.moveToNext();
        }
        if(d==0) {
            values.put("date", s);
            values.put("time", s1);
            values.put("duration", s2);
            values.put("uname", username);
            values.put("slot", "slot6");
            //values.put("booked","notbooked");
            if ((db.insert("book2", null, values)) != -1) {
                Toast.makeText(NewBooking.this, "Inserted. By B6", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(NewBooking.this, "Error. By B6", Toast.LENGTH_LONG).show();
            }

            languages0.setText("");
            languages1.setText("");
            languages.setText("");
            //B1.setBackgroundColor(getResources().getColor(R.color.));
            B6.setBackgroundColor(Color.GREEN);
            B1.setEnabled(false);
            B2.setEnabled(false);
            B3.setEnabled(false);
            B4.setEnabled(false);
            B5.setEnabled(false);
            //B6.setEnabled(false);
        }
        else
        {
            B6.setBackgroundColor(Color.RED);
            Toast.makeText(NewBooking.this, "Slot Already Booked try another slot", Toast.LENGTH_LONG).show();
        }
    }
    public void onCalenderClick(View v)
    {

            Intent intentHome=new Intent(getApplicationContext(),Date.class);
            startActivity(intentHome);


    }


}
