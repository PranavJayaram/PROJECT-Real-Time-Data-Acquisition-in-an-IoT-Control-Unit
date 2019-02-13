#include <HCMAX7219.h>
#include "SPI.h"
#include "DHT.h"
#define DHTTYPE DHT11 
const int sensorMin = 0;     
const int sensorMax = 1024;  
#define LOAD 7

DHT dht[5]{{2, DHTTYPE},{3, DHTTYPE},{4, DHTTYPE},{5, DHTTYPE},{6, DHTTYPE}};
HCMAX7219 HCMAX7219(LOAD);

void setup() {

  Serial.begin(9600);  
  dht[1].begin();dht[2].begin();dht[3].begin();dht[4].begin();dht[5].begin();
   // delay(1000);

}
void loop() {
  HCMAX7219.Clear();

  int i;int h[5],t[5],havg,tavg,arrSend[15];
  int ta,ha,remt,remh;
  int sensorReading1 = analogRead(A0);
  int sensorReading2 = analogRead(A1);
  int range1 = map(sensorReading1, sensorMin, sensorMax, 0, 3);
  int range2 = map(sensorReading2, sensorMin, sensorMax, 0, 3);
  arrSend[0]=1;
     if ((range1==0) || (range1==1))
    {  
    //  Serial.println("** Distant or Close Fire at Sensor 1 **");
      arrSend[13]=1;
    }
    else
    {
      arrSend[13]=0;
    }
    if ((range2==0) || (range2==1))
    {  
     // Serial.println("** Distant or Close Fire at Sensor 2 **");
      arrSend[14]=1;
    }
     else
    {
      arrSend[14]=0;
    }
   
    
      for(i=0;i<5;i++)
    {
        h[i] = dht[i].readHumidity();
        t[i] = dht[i].readTemperature();
        arrSend[i+1]=t[i];
        arrSend[i+6]=h[i];
        if (isnan(t[i]) || isnan(h[i]))
         {
          t[i]=h[i]=0;
           //Serial.print("Failed to read from DHT at Sensor =");
           //Serial.print(i+1);
         }
    }

        tavg=(t[0]+t[1]+t[2]+t[3]+t[4])/5;
  
        havg=(h[0]+h[1]+h[2]+h[3]+h[4])/5;

        arrSend[11]=tavg;
        
        arrSend[12]=havg;

  //Serial.println("The Combined array is = ");
  for(i=0;i<15;i++)
  {
       Serial.print(arrSend[i]);Serial.print(" ");
       if(i==10){Serial.print("Tavg=");}
       if(i==11){Serial.print("Havg=");}
  }
    Serial.println();
    ta=0;ha=0;
    while(arrSend[11]!=0)
    {
      
        remt = arrSend[11]%10;
        ta = ta*10 + remt;
        arrSend[11] /= 10;

    }
        while(arrSend[12]!=0)
    {
      
        remh = arrSend[12]%10;
        ha = ha*10 + remh;
        arrSend[12] /= 10;

    }
    
//    Serial.println(ta);
//    Serial.println(ha);
HCMAX7219.Refresh();
    HCMAX7219.print7Seg("guah",4);HCMAX7219.print7Seg(ha,8);
    HCMAX7219.print7Seg("gua7",12);HCMAX7219.print7Seg(ta,16);
    delay(1000);
    HCMAX7219.Refresh();
}
