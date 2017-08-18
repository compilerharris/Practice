clc();
clf();
disp("Discrete linear coreelation Auto And cross")
x=[1 2 3 0 1]
disp("x:-")
disp(x);
y=[1 2 6]
disp("y:-");
disp(y);
c=xcorr(x,y);
a=xcorr(x,x);
disp("c:-");
disp(c);
subplot(121);
plot2d3(c);
title("Cross correlation")
replot([0,0,10,25])
disp("a:-");
disp(a);
subplot(122);
plot2d3(a);
title("Auto correlation")
replot([0,0,10,18])
