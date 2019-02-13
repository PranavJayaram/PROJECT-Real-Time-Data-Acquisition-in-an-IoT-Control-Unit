package com.led.led;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.app.ProgressDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.os.AsyncTask;

import java.io.IOException;
import java.util.UUID;


public class ledControl extends ActionBarActivity {

    Button btnOn, btnOff, btnDis, btnsendhuge,rson1,rsoff1,rson2,rsoff2,rson3,rsoff3,rson4,rsoff4,rson5,rsoff5,rson6,rsoff6,rson7,rsoff7,rson8,rsoff8;
    SeekBar brightness;
    TextView lumn;
    String address = null;
    private ProgressDialog progress;
    BluetoothAdapter myBluetooth = null;
    BluetoothSocket btSocket = null;
    private boolean isBtConnected = false;
    //SPP UUID. Look for it
    static final UUID myUUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        Intent newint = getIntent();
        address = newint.getStringExtra(DeviceList.EXTRA_ADDRESS); //receive the address of the bluetooth device

        //view of the ledControl
        setContentView(R.layout.activity_led_control);

        //call the widgtes
        btnOn = (Button)findViewById(R.id.button2);
        btnOff = (Button)findViewById(R.id.button3);

        rson1 = (Button)findViewById(R.id.button7);
        rsoff1 = (Button)findViewById(R.id.button8);
        rson2 = (Button)findViewById(R.id.button9);
        rsoff2 = (Button)findViewById(R.id.button10);
        rson3 = (Button)findViewById(R.id.button11);
        rsoff3 = (Button)findViewById(R.id.button12);
        rson4 = (Button)findViewById(R.id.button13);
        rsoff4 = (Button)findViewById(R.id.button14);
        rson5 = (Button)findViewById(R.id.button15);
        rsoff5 = (Button)findViewById(R.id.button16);
        rson6 = (Button)findViewById(R.id.button17);
        rsoff6 = (Button)findViewById(R.id.button18);
        rson7 = (Button)findViewById(R.id.button19);
        rsoff7 = (Button)findViewById(R.id.button20);
        rson8 = (Button)findViewById(R.id.button21);
        rsoff8 = (Button)findViewById(R.id.button22);


        btnDis = (Button)findViewById(R.id.button4);
        btnsendhuge = (Button)findViewById(R.id.button5);
        brightness = (SeekBar)findViewById(R.id.seekBar);
        lumn = (TextView)findViewById(R.id.lumn);

        new ConnectBT().execute(); //Call the class to connect

        //commands to be sent to bluetooth
        btnOn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                turnOnLed();      //method to turn on
            }
        });

        btnOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                turnOffLed();   //method to turn off
            }
        });


        rson1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (btSocket!=null)
                {
                    try
                    {
                        btSocket.getOutputStream().write("RSON1".toString().getBytes());
                    }
                    catch (IOException e)
                    {
                        msg("Error");
                    }
                }      //method to turn on
            }
        });
        rsoff1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (btSocket!=null)
                {
                    try
                    {
                        btSocket.getOutputStream().write("RSOFF1".toString().getBytes());
                    }
                    catch (IOException e)
                    {
                        msg("Error");
                    }
                }      //method to turn on
            }
        });
        rson2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (btSocket!=null)
                {
                    try
                    {
                        btSocket.getOutputStream().write("RSON2".toString().getBytes());
                    }
                    catch (IOException e)
                    {
                        msg("Error");
                    }
                }      //method to turn on
            }
        });
        rsoff2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (btSocket!=null)
                {
                    try
                    {
                        btSocket.getOutputStream().write("RSOFF2".toString().getBytes());
                    }
                    catch (IOException e)
                    {
                        msg("Error");
                    }
                }      //method to turn on
            }
        });

        rson3.setOnClickListener(new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            if (btSocket!=null)
            {
                try
                {
                    btSocket.getOutputStream().write("RSON3".toString().getBytes());
                }
                catch (IOException e)
                {
                    msg("Error");
                }
            }      //method to turn on
        }
    });
        rsoff3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (btSocket!=null)
                {
                    try
                    {
                        btSocket.getOutputStream().write("RSOFF3".toString().getBytes());
                    }
                    catch (IOException e)
                    {
                        msg("Error");
                    }
                }      //method to turn on
            }
        });        rson4.setOnClickListener(new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            if (btSocket!=null)
            {
                try
                {
                    btSocket.getOutputStream().write("RSON4".toString().getBytes());
                }
                catch (IOException e)
                {
                    msg("Error");
                }
            }      //method to turn on
        }
    });
        rsoff4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (btSocket!=null)
                {
                    try
                    {
                        btSocket.getOutputStream().write("RSOFF4".toString().getBytes());
                    }
                    catch (IOException e)
                    {
                        msg("Error");
                    }
                }      //method to turn on
            }
        });        rson5.setOnClickListener(new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            if (btSocket!=null)
            {
                try
                {
                    btSocket.getOutputStream().write("RSON5".toString().getBytes());
                }
                catch (IOException e)
                {
                    msg("Error");
                }
            }      //method to turn on
        }
    });
        rsoff5.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (btSocket!=null)
                {
                    try
                    {
                        btSocket.getOutputStream().write("RSOFF5".toString().getBytes());
                    }
                    catch (IOException e)
                    {
                        msg("Error");
                    }
                }      //method to turn on
            }
        });        rson6.setOnClickListener(new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            if (btSocket!=null)
            {
                try
                {
                    btSocket.getOutputStream().write("RSON6".toString().getBytes());
                }
                catch (IOException e)
                {
                    msg("Error");
                }
            }      //method to turn on
        }
    });
        rsoff6.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (btSocket!=null)
                {
                    try
                    {
                        btSocket.getOutputStream().write("RSOFF6".toString().getBytes());
                    }
                    catch (IOException e)
                    {
                        msg("Error");
                    }
                }      //method to turn on
            }
        });        rson7.setOnClickListener(new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            if (btSocket!=null)
            {
                try
                {
                    btSocket.getOutputStream().write("RSON7".toString().getBytes());
                }
                catch (IOException e)
                {
                    msg("Error");
                }
            }      //method to turn on
        }
    });
        rsoff7.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (btSocket!=null)
                {
                    try
                    {
                        btSocket.getOutputStream().write("RSOFF7".toString().getBytes());
                    }
                    catch (IOException e)
                    {
                        msg("Error");
                    }
                }      //method to turn on
            }
        });        rson8.setOnClickListener(new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            if (btSocket!=null)
            {
                try
                {
                    btSocket.getOutputStream().write("RSON8".toString().getBytes());
                }
                catch (IOException e)
                {
                    msg("Error");
                }
            }      //method to turn on
        }
    });
        rsoff8.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (btSocket!=null)
                {
                    try
                    {
                        btSocket.getOutputStream().write("RSOFF8".toString().getBytes());
                    }
                    catch (IOException e)
                    {
                        msg("Error");
                    }
                }      //method to turn on
            }
        });








        btnDis.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Disconnect(); //close connection
            }
        });
        btnsendhuge.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                sendhuge(); //close connection
            }
        });



        brightness.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser==true)
                {
                    lumn.setText(String.valueOf(progress));
                    try
                    {
                        btSocket.getOutputStream().write(String.valueOf(progress).getBytes());
                    }
                    catch (IOException e)
                    {

                    }
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void Disconnect()
    {
        if (btSocket!=null) //If the btSocket is busy
        {
            try
            {
                btSocket.close(); //close connection
            }
            catch (IOException e)
            { msg("Error");}
        }
        finish(); //return to the first layout

    }


    private void turnOffLed()
    {
        if (btSocket!=null)
        {
            try
            {
                btSocket.getOutputStream().write("TF".toString().getBytes());
            }
            catch (IOException e)
            {
                msg("Error");
            }
        }
    }

    private void turnOnLed()
    {
        if (btSocket!=null)
        {
            try
            {
                btSocket.getOutputStream().write("TO".toString().getBytes());
            }
            catch (IOException e)
            {
                msg("Error");
            }
        }
    }
    private void sendhuge()
    {
        if (btSocket!=null)
        {
            try
            {
                btSocket.getOutputStream().write("MY NAME IS PRANAV IM TESTING THE BLUETOOTH APP WITH A HUGE STRING<IF YOU ARE ABLE TO READ THIS STRING IT MEANS THAT IT WORKS>>>>>THANK YOU!!!:-)".toString().getBytes());
            }
            catch (IOException e)
            {
                msg("Error");
            }
        }
    }


    // fast way to call Toast
    private void msg(String s)
    {
        Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_led_control, menu);
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

    private class ConnectBT extends AsyncTask<Void, Void, Void>  // UI thread
    {
        private boolean ConnectSuccess = true; //if it's here, it's almost connected

        @Override
        protected void onPreExecute()
        {
            progress = ProgressDialog.show(ledControl.this, "Connecting...", "Please wait!!!");  //show a progress dialog
        }

        @Override
        protected Void doInBackground(Void... devices) //while the progress dialog is shown, the connection is done in background
        {
            try
            {
                if (btSocket == null || !isBtConnected)
                {
                 myBluetooth = BluetoothAdapter.getDefaultAdapter();//get the mobile bluetooth device
                 BluetoothDevice dispositivo = myBluetooth.getRemoteDevice(address);//connects to the device's address and checks if it's available
                 btSocket = dispositivo.createInsecureRfcommSocketToServiceRecord(myUUID);//create a RFCOMM (SPP) connection
                 BluetoothAdapter.getDefaultAdapter().cancelDiscovery();
                 btSocket.connect();//start connection
                }
            }
            catch (IOException e)
            {
                ConnectSuccess = false;//if the try failed, you can check the exception here
            }
            return null;
        }
        @Override
        protected void onPostExecute(Void result) //after the doInBackground, it checks if everything went fine
        {
            super.onPostExecute(result);

            if (!ConnectSuccess)
            {
                msg("Connection Failed. Is it a SPP Bluetooth? Try again.");
                finish();
            }
            else
            {
                msg("Connected.");
                isBtConnected = true;
            }
            progress.dismiss();
        }
    }
}
