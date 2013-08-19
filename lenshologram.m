la=0.533e-6;
nx=-539:540;
ny=-959:960;
nnx=ones(1,1920);
nny=ones(1080,1);
xh=nx'*nnx*6.4e-6;
yh=nny*ny*6.4e-6;
z=1.0;

% degree in radian
% xyh=exp(+i*0*2*pi/la/z*(xh.^2+yh.^2)).*exp(-i*2*pi/la*8/360*xh).*exp(-i*2*pi/la*8/360*yh);

% cylindrical
xoff=0.00;
theta=3/180*pi;
% ====++++ these are testing formula CYLINDRICAL ++++ =====================
% xyh=exp(j*1*pi/la/z*((xh-xoff).^2));
%  xyh=exp(j*1*pi/la/z*((xh-xoff).^2)).*exp(j*2*pi/la*cos(theta)*yh);
%  xyh=exp(j*1*pi/la/z*((xh-xoff).^2)).*exp(j*2*pi/la*cos(theta)*yh);
% ====---- these are testing formula CYLINDRICAL ---- =====================
% THIS IS MINE
% CYLINDRICAL use following expression
% xyh=exp(j*1*pi/la/z*((yh-xoff).^2)).*exp(j*2*pi/la*cos(theta)*xh);

% lens
xoff=0.00;
yoff=0.00;
% THIS IS MINE
% LENS use following expression
% xyh=exp(+j*1*pi/la/z*((xh-xoff).^2+(yh-yoff).^2));

% mirror
theta=90/180*pi;
phy=0.02/180*pi;
% MIRROR use following expression
xyh=exp(j*2*pi/la*sin(phy)*(xh*cos(theta)+yh*sin(theta)));

% original form
% anglejdc=angle(xyh);

% add pi to move (-pi, pi) to (0, 2pi)
anglejdc=angle(xyh);
allzeros=ones(size(anglejdc))*0;
nanglejdc=2*pi*(anglejdc < allzeros);
xanglejdc=anglejdc+nanglejdc;
angle2gray=round(xanglejdc/2/pi*255);

% the original form
% angle2gray=round(anglejdc/2/pi*255);

hologram=angle2gray;
hologram8=uint8(hologram);

%hologram=255-round(((NFjdc+conj(NFjdc))/2+1)*127.5);
%hologram8=uint8(hologram);
imwrite(hologram8,'hologramlens.bmp')
 