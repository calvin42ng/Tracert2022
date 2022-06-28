int x1 = 1010;
int y1 = 400;
int speedx1= 2;
int speedy1= 4;

int x2 = 980;
int y2 = 340;
int speedx2= 2;
int speedy2 = 5;

int x3 = 328;
int y3 = 268;
int speedx3= 7;
int speedy3= 2;

int x4 = 255;
int y4 = 250;
int speedx4= 3;
int speedy4 = 1;

int x5 = 220;
int y5 = 200;
int speedx5= 1;
int speedy5 = 2;

int x6 = 240;
int y6 = 215;
int speedx6= 1;
int speedy6 = 2;

void setup(){
  size(1280, 720);
  
}

void draw(){
  background(255);
  fill(0);
  ellipse(1010, 400, 7, 7);
  ellipse(1060, 500, 7, 7);
  ellipse(980, 340, 7, 7);
  ellipse(328, 268, 7, 7); 
  ellipse(255, 250, 7, 7);
  ellipse(220, 200, 7, 7);
  ellipse(240, 215, 7, 7); 
  
  ellipse(x1, y1, 5, 5);
  x1 += speedx1;
  y1 += speedy1;
  if(x1 > 1060 || x1 < 1010)
    speedx1 *= -1;
  if(y1 > 500 || y1 < 400)
    speedy1 *= -1;


  ellipse(x2, y2, 5, 5);
  x2 += speedx2;
  y2 += speedy2;
  if(x2 > 1060 || x2 < 980)
    speedx2 *= -1;
  if(y2 > 500 || y2 < 340)
    speedy2 *= -1;  
  

  ellipse(x3, y3, 5, 5);
  x3 += speedx3;
  y3 += speedy3;
  if(x3 > 980 || x3 < 328)
    speedx3 *= -1;
  if(y3 > 340 || y3 < 268)
    speedy3 *= -1;   


  ellipse(x4, y4, 5, 5);
  x4 += speedx4;
  y4 += speedy4;
  if(x4 > 328 || x4 < 255)
    speedx4 *= -1;
  if(y4 > 268 || y4 < 250)
    speedy4 *= -1;  


  ellipse(x5, y5, 5, 5);
  x5 += speedx5;
  y5 += speedy5;
  if(x5 > 255 || x5 < 220)
    speedx5 *= -1;
  if(y5 > 250 || y5 < 200)
    speedy5 *= -1; 
    

  ellipse(x6, y6, 5, 5);
  x6 += speedx6;
  y6 += speedy6;
  if(x6 > 255 || x6 < 240)
    speedx6 *= -1;
  if(y6 > 250 || y6 < 215)
    speedy6 *= -1;     
}
