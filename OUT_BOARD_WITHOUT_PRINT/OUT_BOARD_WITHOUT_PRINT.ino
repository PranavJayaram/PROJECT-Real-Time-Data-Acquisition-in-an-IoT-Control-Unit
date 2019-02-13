char command;
String string;
boolean ledon = false;
#define led 6
#define relay1 2
#define relay2 3
#define relay3 4
#define relay4 5
#define relay5 6
#define relay6 7
#define relay7 8
#define relay8 9


void setup()
{
  Serial.begin(9600);
  pinMode(led, OUTPUT);
  pinMode(relay1, OUTPUT);
  pinMode(relay2, OUTPUT);
  pinMode(relay3, OUTPUT);
  pinMode(relay4, OUTPUT);
  pinMode(relay5, OUTPUT);
  pinMode(relay6, OUTPUT);
  pinMode(relay7, OUTPUT);
  pinMode(relay8, OUTPUT);
}
void loop()
{
  Serial.flush();
if (Serial.available() > 0)
  {string = "";}
  while(Serial.available() > 0)
  {    
    command = ((byte)Serial.read());
    if(command == ':')
    {
      break;
    }
    else
    {
      string += command;
    }
    delay(1);
  }
if(string == "TO")
{
    ledOn();
    ledon = true;
}
if(string =="TF")
{
  ledOff();
  ledon = false;
}


if(string == "RSON1")
{
     digitalWrite(relay1, LOW);
    delay(500);
}
if(string =="RSOFF1")
{
     digitalWrite(relay1,HIGH);
    delay(500);
}

if(string == "RSON2")
{
    digitalWrite(relay2, LOW);
    delay(500);
}
if(string =="RSOFF2")
{
    digitalWrite(relay2, HIGH);
   delay(500);
}

if(string == "RSON3")
{
    digitalWrite(relay3,LOW );
   delay(500);
}
if(string =="RSOFF3")
{
    digitalWrite(relay3, HIGH);
   delay(500);
}

if(string == "RSON4")
{
   digitalWrite(relay4, LOW);
   delay(500);
}
if(string =="RSOFF4")
{
   digitalWrite(relay4, HIGH);
   delay(500);

}

if(string == "RSON5")
{
    digitalWrite(relay5, LOW);
   delay(500);

}
if(string =="RSOFF5")
{
   digitalWrite(relay5, HIGH);
   delay(500);

}

if(string == "RSON6")
{
    digitalWrite(relay6, LOW);
   delay(500);
  
}
if(string =="RSOFF6")
{
    digitalWrite(relay6, HIGH);
   delay(500);

}

if(string == "RSON7")
{
    digitalWrite(relay7, LOW);
   delay(500);
  
}
if(string =="RSOFF7")
{
    digitalWrite(relay7, HIGH);
   delay(500);
    
}

if(string == "RSON8")
{
   digitalWrite(relay8, LOW);
   delay(500);

}
if(string =="RSOFF8")
{
   digitalWrite(relay8, HIGH);
   delay(500);
   
}


//if ((string.toInt()>=0)&&(string.toInt()<=HIGH))
//{
//  if (ledon==true)
//  {
//    digitalWrite(led, string.toInt());
//    Serial.println(string); //debug
//   delay(500);
//  }
//}
}
void ledOn()
{
    analogWrite(led, 255);
   delay(10);
}
 void ledOff()
{
    analogWrite(led, 0);
   delay(10);
}
