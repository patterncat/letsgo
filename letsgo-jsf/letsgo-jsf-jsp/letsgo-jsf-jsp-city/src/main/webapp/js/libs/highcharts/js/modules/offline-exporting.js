/*
 Highcharts JS v5.0.3 (2016-11-18)
 Client side exporting module

 (c) 2015 Torstein Honsi / Oystein Moseng

 License: www.highcharts.com/license
*/
(function(h){"object"===typeof module&&module.exports?module.exports=h:h(Highcharts)})(function(h){(function(b){function v(d,b){var c=r.getElementsByTagName("head")[0],a=r.createElement("script");a.type="text/javascript";a.src=d;a.onload=b;a.onerror=function(){console.error("Error loading script",d)};c.appendChild(a)}var h=b.merge,e=b.win,t=e.navigator,r=e.document,z=b.each,A=e.URL||e.webkitURL||e,B=/Edge\/|Trident\/|MSIE /.test(t.userAgent),C=B?150:0;b.CanVGRenderer={};b.downloadURL=function(d,b){var c=
r.createElement("a"),a;if(t.msSaveOrOpenBlob)t.msSaveOrOpenBlob(d,b);else if(void 0!==c.download)c.href=d,c.download=b,c.target="_blank",r.body.appendChild(c),c.click(),r.body.removeChild(c);else try{if(a=e.open(d,"chart"),void 0===a||null===a)throw"Failed to open window";}catch(u){e.location.href=d}};b.svgToDataUrl=function(d){var b=-1<t.userAgent.indexOf("WebKit")&&0>t.userAgent.indexOf("Chrome");try{if(!b&&0>t.userAgent.toLowerCase().indexOf("firefox"))return A.createObjectURL(new e.Blob([d],{type:"image/svg+xml;charset-utf-16"}))}catch(c){}return"data:image/svg+xml;charset\x3dUTF-8,"+
encodeURIComponent(d)};b.imageToDataUrl=function(b,f,c,a,u,l,k,m,p){var d=new e.Image,g,q=function(){setTimeout(function(){var e=r.createElement("canvas"),n=e.getContext&&e.getContext("2d"),x;try{if(n){e.height=d.height*a;e.width=d.width*a;n.drawImage(d,0,0,e.width,e.height);try{x=e.toDataURL(f),u(x,f,c,a)}catch(D){g(b,f,c,a)}}else k(b,f,c,a)}finally{p&&p(b,f,c,a)}},C)},n=function(){m(b,f,c,a);p&&p(b,f,c,a)};g=function(){d=new e.Image;g=l;d.crossOrigin="Anonymous";d.onload=q;d.onerror=n;d.src=b};
d.onload=q;d.onerror=n;d.src=b};b.downloadSVGLocal=function(d,f,c,a){function u(b,a){a=new e.jsPDF("l","pt",[b.width.baseVal.value+2*a,b.height.baseVal.value+2*a]);e.svgElementToPdf(b,a,{removeInvalid:!0});return a.output("datauristring")}function l(){q.innerHTML=d;var c=q.getElementsByTagName("text"),e=q.getElementsByTagName("svg")[0].style;z(c,function(a){z(["font-family","font-size"],function(b){!a.style[b]&&e[b]&&(a.style[b]=e[b])});a.style["font-family"]=a.style["font-family"]&&a.style["font-family"].split(" ").splice(-1)});
c=u(q.firstChild,0);b.downloadURL(c,w);a&&a()}var k,m,p=!0,y,g=f.libURL||b.getOptions().exporting.libURL,q=r.createElement("div"),n=f.type||"image/png",w=(f.filename||"chart")+"."+("image/svg+xml"===n?"svg":n.split("/")[1]),h=f.scale||1,g="/"!==g.slice(-1)?g+"/":g;if("image/svg+xml"===n)try{t.msSaveOrOpenBlob?(m=new MSBlobBuilder,m.append(d),k=m.getBlob("image/svg+xml")):k=b.svgToDataUrl(d),b.downloadURL(k,w),a&&a()}catch(x){c()}else"application/pdf"===n?e.jsPDF&&e.svgElementToPdf?l():(p=!0,v(g+"jspdf.js",
function(){v(g+"rgbcolor.js",function(){v(g+"svg2pdf.js",function(){l()})})})):(k=b.svgToDataUrl(d),y=function(){try{A.revokeObjectURL(k)}catch(x){}},b.imageToDataUrl(k,n,{},h,function(d){try{b.downloadURL(d,w),a&&a()}catch(D){c()}},function(){var f=r.createElement("canvas"),u=f.getContext("2d"),l=d.match(/^<svg[^>]*width\s*=\s*\"?(\d+)\"?[^>]*>/)[1]*h,k=d.match(/^<svg[^>]*height\s*=\s*\"?(\d+)\"?[^>]*>/)[1]*h,m=function(){u.drawSvg(d,0,0,l,k);try{b.downloadURL(t.msSaveOrOpenBlob?f.msToBlob():f.toDataURL(n),
w),a&&a()}catch(E){c()}finally{y()}};f.width=l;f.height=k;e.canvg?m():(p=!0,v(g+"rgbcolor.js",function(){v(g+"canvg.js",function(){m()})}))},c,c,function(){p&&y()}))};b.Chart.prototype.getSVGForLocalExport=function(d,e,c,a){var f=this,l,k=0,m,p,h,g,q=function(b,d,c){++k;c.imageElement.setAttributeNS("http://www.w3.org/1999/xlink","href",b);k===l.length&&a(f.sanitizeSVG(m.innerHTML))};b.wrap(b.Chart.prototype,"getChartHTML",function(a){var b=a.apply(this,Array.prototype.slice.call(arguments,1));m=
this.container.cloneNode(!0);return b});f.getSVGForExport(d,e);l=m.getElementsByTagName("image");try{if(l.length)for(h=0,g=l.length;h<g;++h)p=l[h],b.imageToDataUrl(p.getAttributeNS("http://www.w3.org/1999/xlink","href"),"image/png",{imageElement:p},d.scale,q,c,c,c);else a(f.sanitizeSVG(m.innerHTML))}catch(n){c()}};b.Chart.prototype.exportChartLocal=function(d,e){var c=this,a=b.merge(c.options.exporting,d),f=function(){if(!1===a.fallbackToExportServer)if(a.error)a.error();else throw"Fallback to export server disabled";
else c.exportChart(a)};(B&&"image/svg+xml"!==a.type||"application/pdf"===a.type)&&c.container.getElementsByTagName("image").length?f():c.getSVGForLocalExport(a,e,f,function(c){b.downloadSVGLocal(c,a,f)})};h(!0,b.getOptions().exporting,{libURL:"https://code.highcharts.com/5.0.3/lib/",buttons:{contextButton:{menuItems:[{textKey:"printChart",onclick:function(){this.print()}},{separator:!0},{textKey:"downloadPNG",onclick:function(){this.exportChartLocal()}},{textKey:"downloadJPEG",onclick:function(){this.exportChartLocal({type:"image/jpeg"})}},
{textKey:"downloadSVG",onclick:function(){this.exportChartLocal({type:"image/svg+xml"})}},{textKey:"downloadPDF",onclick:function(){this.exportChartLocal({type:"application/pdf"})}}]}}})})(h)});
