clc;
clf;
// This GUI file is generated by guibuilder version 3.0
//////////
f=figure('figure_position',[-3,0],'figure_size',[1606,877],'auto_resize','on','background',[33],'figure_name','Graphic window number %d');
//////////
delmenu(f.figure_id,gettext('File'))
delmenu(f.figure_id,gettext('?'))
delmenu(f.figure_id,gettext('Tools'))
toolbar(f.figure_id,'off')
handles.dummy = 0;
handles.rollno=uicontrol(f,'unit','normalized','BackgroundColor',[-1,-1,-1],'Enable','on','FontAngle','normal','FontName','Courier','FontSize',[15],'FontUnits','points','FontWeight','normal','ForegroundColor',[-1,-1,-1],'HorizontalAlignment','left','ListboxTop',[],'Max',[1],'Min',[0],'Position',[0.1009375,0.9014066,0.236875,0.0685934],'Relief','default','SliderStep',[0.01,0.1],'String','Devlop by 14DCO60,14DCO62,14DCO69,15DCO47','Style','text','Value',[0],'VerticalAlignment','middle','Visible','on','Tag','rollno','Callback','')

handles.Title=uicontrol(f,'unit','normalized','BackgroundColor',[-1,-1,-1],'Enable','on','FontAngle','normal','FontName','Courier','FontSize',[20],'FontUnits','points','FontWeight','normal','ForegroundColor',[-1,-1,-1],'HorizontalAlignment','left','ListboxTop',[],'Max',[1],'Min',[0],'Position',[0.5,0.9002558,0.349375,0.0673146],'Relief','default','SliderStep',[0.01,0.1],'String','**Discrete Linear Convolution**','Style','text','Value',[0],'VerticalAlignment','middle','Visible','on','Tag','head','Callback','')

handles.Xaxes= newaxes();handles.Xaxes.margins = [ 0 0 0 0];handles.Xaxes.axes_bounds = [0.05,0.1508951,0.3,0.3491049];
ax = gca();
handles.Haxes= newaxes();handles.Haxes.margins = [ 0 0 0 0];handles.Haxes.axes_bounds = [0.650625,0.1496164,0.299375,0.3503836];
ah = gca();
handles.Yaxes= newaxes();handles.Yaxes.margins = [ 0 0 0 0];handles.Yaxes.axes_bounds = [0.050625,0.6496164,0.899375,0.3017903];
ay = gca();

handles.Xvalue=uicontrol(f,'unit','normalized','BackgroundColor',[-1,-1,-1],'Enable','on','FontAngle','normal','FontName','Courier','FontSize',[15],'FontUnits','points','FontWeight','normal','ForegroundColor',[-1,-1,-1],'HorizontalAlignment','left','ListboxTop',[],'Max',[1],'Min',[0],'Position',[0.399375,0.8017903,0.20125,0.0473146],'Relief','default','SliderStep',[0.01,0.1],'String','Enter x(n)','Style','edit','Value',[0],'VerticalAlignment','middle','Visible','on','Tag','Xvalue','Callback','')
handles.Hvalue=uicontrol(f,'unit','normalized','BackgroundColor',[-1,-1,-1],'Enable','on','FontAngle','normal','FontName','Courier','FontSize',[15],'FontUnits','points','FontWeight','normal','ForegroundColor',[-1,-1,-1],'HorizontalAlignment','left','ListboxTop',[],'Max',[1],'Min',[0],'Position',[0.4,0.702046,0.2,0.0473146],'Relief','default','SliderStep',[0.01,0.1],'String','Enter h(n)','Style','edit','Value',[0],'VerticalAlignment','middle','Visible','on','Tag','Hvalue','Callback','')
handles.Yvalue=uicontrol(f,'unit','normalized','BackgroundColor',[-1,-1,-1],'Enable','on','FontAngle','normal','FontName','Courier','FontSize',[15],'FontUnits','points','FontWeight','normal','ForegroundColor',[-1,-1,-1],'HorizontalAlignment','left','ListboxTop',[],'Max',[1],'Min',[0],'Position',[0.400625,0.5012788,0.19875,0.1457801],'Relief','default','SliderStep',[0.01,0.1],'String','Y(n)','Style','edit','Value',[0],'VerticalAlignment','middle','Visible','on','Tag','Yvalue','Callback','')
handles.plotall=uicontrol(f,'unit','normalized','BackgroundColor',[-1,-1,-1],'Enable','on','FontAngle','normal','FontName','Courier','FontSize',[15],'FontUnits','points','FontWeight','normal','ForegroundColor',[-1,-1,-1],'HorizontalAlignment','center','ListboxTop',[],'Max',[1],'Min',[0],'Position',[0.400625,0.398977,0.1,0.0524297],'Relief','default','SliderStep',[0.01,0.1],'String','PLOT','Style','pushbutton','Value',[0],'VerticalAlignment','middle','Visible','on','Tag','plotall','Callback','plotall_callback(handles)')
handles.Clearall=uicontrol(f,'unit','normalized','BackgroundColor',[-1,-1,-1],'Enable','on','FontAngle','normal','FontName','Courier','FontSize',[15],'FontUnits','points','FontWeight','normal','ForegroundColor',[-1,-1,-1],'HorizontalAlignment','center','ListboxTop',[],'Max',[1],'Min',[0],'Position',[0.499375,0.4015345,0.100625,0.0498721],'Relief','default','SliderStep',[0.01,0.1],'String','Clear','Style','pushbutton','Value',[0],'VerticalAlignment','middle','Visible','on','Tag','Clearallall','Callback','Clearall_callback(handles)')


//////////
// Callbacks are defined as below. Please do not delete the comments as it will be used in coming version
//////////

function plotall_callback(handles)
//Write your callback for  plotall  here
//for x(n)
varX = get(handles.Xvalue, "String");
varX = strsplit(varX, "");
varX = strtod(varX);
sca(ax);
plot2d3(varX);
replot([0,0,10,10]);


//for h(n)
varh = get(handles.Hvalue, "String");
varh = strsplit(varh, "");
varh = strtod(varh);
sca(ah);
plot2d3(varh);
replot([0,0,10,10]);

//for y(n)
vary = convol(varh, varX);
sca(ay);
plot2d3(vary);
replot([0,0,15,50]);
handles.Yvalue.string = string(vary);
endfunction


function Clearall_callback(handles)
//Write your callback for  Clearall  here
handles.Xvalue.string = string("Enter the value x(n)");
handles.Hvalue.string = string("Enter the value h(n)");
handles.Yvalue.string = string("Convol is");

delete(ax.children);
delete(ah.children);
delete(ay.children);
endfunction
