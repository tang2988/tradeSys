﻿/*
Copyright (c) 2003-2013, CKSource - Frederico Knabben. All rights reserved.
For licensing, see LICENSE.html or http://ckeditor.com/license
*/

(function(){var a=(function(){var f={jY:'D03E1XW',_:{},status:'unloaded',basePath:(function(){var i=window.CKFINDER_BASEPATH||'';if(!i){var j=document.getElementsByTagName('script');for(var k=0;k<j.length;k++){var l=j[k].src.match(/(^|.*[\\\/])CKFINDER(?:_basic)?(?:_v2)?(?:_source)?.js(?:\?.*)?$/i);if(l){i=l[1];break;}}}if(i.indexOf('://')== -1)if(i.indexOf('/')===0)i=location.href.match(/^.*?:\/\/[^\/]*/)[0]+i;else i=location.href.match(/^[^\?]*\/(?:)/)[0]+i;return i;})(),getUrl:function(i){if(i.indexOf('://')== -1&&i.indexOf('/')!==0)i=this.basePath+i;if(this.jY&&i.charAt(i.length-1)!='/')i+=(i.indexOf('?')>=0?'&':'?')+'t='+this.jY;return i;}},g=window.CKFINDER_GETURL;if(g){var h=f.getUrl;f.getUrl=function(i){return g.call(f,i)||h.call(f,i);};}return f;})();function b(f){return a.instances[f];};var c={callback:1,selectThumbnailActionFunction:1,selectActionFunction:1};a.jd=function(){var h=this;var f={};for(var g in h){if(!h.hasOwnProperty(g))continue;if(typeof h[g]=='function'&& !c[g]||typeof h[g]=='undefined')continue;f[g]=h[g];}if(h.callback)f.callback=h.callback;return f;};a.lj=function(f){var i=this;f=f||i.basePath;var g='';if(!f||f.length===0)f=CKFinder.DEFAULT_basePath;if(f.substr(f.length-1,1)!='/')f+='/';f+='ckfinder.html';var h;if(i.hh){h=i.hh;if(typeof h=='function')h=h.toString().match(/function ([^(]+)/)[1];g+='?action=js&amp;func='+h;}if(i.jx){g+=g?'&amp;':'?';g+='data='+encodeURIComponent(i.jx);}if(i.disableThumbnailSelection){g+=g?'&amp;':'?';g+='dts=1';}else if(i.lH||i.hh){h=i.lH||i.hh;if(typeof h=='function')h=h.toString().match(/function ([^(]+)/)[1];g+=g?'&amp;':'?';g+='thumbFunc='+h;if(i.nm)g+='&amp;tdata='+encodeURIComponent(i.nm);else if(!i.lH&&i.jx)g+='&amp;tdata='+encodeURIComponent(i.jx);}if(i.startupPath){g+=g?'&amp;':'?';g+='start='+encodeURIComponent(i.startupPath+(i.startupFolderExpanded?':1':':0'));}if(i.rememberLastFolder!==undefined&& !i.rememberLastFolder){g+=g?'&amp;':'?';g+='rlf=0';}if(i.id){g+=g?'&amp;':'?';g+='id='+encodeURIComponent(i.id);}if(i.skin){g+=g?'&amp;':'?';g+='skin='+encodeURIComponent(i.skin);}return f+g;};function d(f){var i=this;i.id=f.name;var g=f.element.getDocument().getWindow().$,h=a.oC.getWindow().$;i.inPopup= ! !(g&&g.opener);i.inIframe= !i.inPopup&&g!=h.top&&g.frameElement.nodeName.toLowerCase()=='iframe';i.inFrame= !i.inPopup&&g!=h.top&&g.frameElement.nodeName.toLowerCase()=='frame';i.inUrlPopup= ! !(i.inPopup&&h.opener);};function e(f,g,h){g.on('appReady',function(i){i.removeListener();f.document=g.document.$;f.folders=g.folders;f.files=g.aG['filesview.filesview'].data().files;f.basketFiles=g.basketFiles;f.resourceTypes=g.resourceTypes;f.connector=g.connector;f.lang=g.lang;f.langCode=g.langCode;f.config=g.config;g.aG['foldertree.foldertree'].on('afterAddFolder',function(j){j.removeListener();if(h)h(f);},f);},f,null,999);};d.prototype={_:{},addFileContextMenuOption:function(f,g,h){var i=b(this.id),j='FileContextMenu_'+f.command;i.bD(j,{exec:function(k){var l=k.aG['filesview.filesview'].tools.dH();g(k.cg,l);}});f.command=j;if(!f.group)f.group='file1';i.gp(j,f);i.aG['filesview.filesview'].on('beforeContextMenu',function m(k){if(h){var l=h(this.tools.dH());if(l)k.data.bj[j]=l== -1?a.aY:a.aS;}else k.data.bj[j]=a.aS;});},disableFileContextMenuOption:function(f,g){var h=b(this.id),i=g?'FileContextMenu_'+f:f,j=function l(k){delete k.data.bj[i];};h.aG['filesview.filesview'].on('beforeContextMenu',j);return function(){h.aG['filesview.filesview'].removeListener('beforeContextMenu',j);};},addFolderContextMenuOption:function(f,g,h){var i=b(this.id),j='FolderContextMenu_'+f.command;i.bD(j,{exec:function(k){g(k.cg,k.aV);}});f.command=j;if(!f.group)f.group='folder1';i.gp(j,f);i.aG['foldertree.foldertree'].on('beforeContextMenu',function m(k){if(h){var l=h(this.app.aV);if(l)k.data.bj[j]=l== -1?a.aY:a.aS;}else k.data.bj[j]=a.aS;});},disableFolderContextMenuOption:function(f,g){var h=b(this.id),i=g?'FolderContextMenu_'+f:f,j=function l(k){delete k.data.bj[i];};h.aG['foldertree.foldertree'].on('beforeContextMenu',j);return function(){h.aG['foldertree.foldertree'].removeListener('beforeContextMenu',j);};},addFolderDropMenuOption:function(f,g,h){var i=b(this.id),j='FolderDropMenu_'+f.command;i.bD(j,{exec:function(l){g(l.cg,l.cK.oa());}});f.command=j;var k=new a.iD(i,j,f);i.aG['foldertree.foldertree'].on('beforeDropMenu',function m(l){if(h?h.call(i.cg,l.data.folder):1)l.data.iG[j]=k;});},disableFolderDropMenuOption:function(f,g){var h=b(this.id),i=g?'FolderDropMenu_'+f:f,j=function l(k){delete k.data.iG[i];};h.aG['foldertree.foldertree'].on('beforeDropMenu',j);return function(){h.aG['foldertree.foldertree'].removeListener('beforeDropMenu',j);};},getSelectedFile:function(){return b(this.id).aG['filesview.filesview'].tools.dH();},getSelectedFiles:function(){return b(this.id).aG['filesview.filesview'].tools.oO();},getSelectedFolder:function(){return b(this.id).aV;},setUiColor:function(f){return b(this.id).setUiColor(f);},destroy:function(f){b(this.id).destroy();f&&f();},openDialog:function(f,g){var j=this;var h=new a.dom.document(window.document).getHead(),i=b(j.id).document.getWindow();if(j.inFrame||j.inPopup||j.inIframe)a.document=b(j.id).document;return b(j.id).openDialog(f,g,h);},openMsgDialog:function(f,g){b(this.id).msgDialog(f,g);},openConfirmDialog:function(f,g,h){b(this.id).fe(f,g,h);},openInputDialog:function(f,g,h,i){b(this.id).hs(f,g,h,i);},openSkippedFilesDialog:function(f,g,h,i){b(this.id).skippedFilesDialog(f,g,h,i);},addTool:function(f){return b(this.id).plugins.tools.addTool(f);},addToolPanel:function(f){return b(this.id).plugins.tools.addToolPanel(f);},removeTool:function(f){b(this.id).plugins.tools.removeTool(f);},showTool:function(f){b(this.id).plugins.tools.showTool(f);},hideTool:function(f){b(this.id).plugins.tools.hideTool(f);},getResourceType:function(f){return b(this.id).getResourceType(f);},log:function(f){a.log.apply(a.log,arguments);},getLog:function(){return a.mZ();},emptyBasket:function(){b(this.id).execCommand('TruncateBasket');},replaceUploadForm:function(f,g,h,i){var j=b(this.id);if(!i)i=10;if(i>=(j.dC||20))return;j.dC=i;j.aG['formpanel.formpanel'].on('beforeUploadFileForm',function(k){if(k.data.step!=2)return;if(i>j.dC)return;k.cancel(true);var l=this.data(),m=k.data.folder;try{if(l.dc=='upload')this.oW('requestUnloadForm',function(){this.app.cS('upload').bR(a.aS);});else{if(this.data().dc)this.oW('requestUnloadForm');if(!h)this.eh.removeClass('show_border');this.oW('requestLoadForm',{html:f,command:'upload'});g&&g();}}catch(n){this.oW('failedUploadFileForm',k.data);this.oW('afterUploadFileForm',k.data);throw a.ba(n);}});return{hide:function(){j.oW('requestUnloadForm',function(){j.cS('upload').bR(a.aS);});}};},resizeFormPanel:function(f){var g=b(this.id);if(typeof f=='undefined'){g.document.getById('panel_view').setStyle('height','');g.document.getById('panel_widget').setStyle('height','');}else{var h=Math.min(f,Math.max(90,g.document.getById('main_container').$.offsetHeight-300));g.document.getById('panel_view').setStyle('height',h+'px');g.document.getById('panel_widget').setStyle('height',h-3+'px');}g.layout.ea(true);},refreshOpenedFolder:function(){var f=b(this.id),g=f.aG['filesview.filesview'].tools.currentFolder();f.oW('requestSelectFolder',{folder:g});},selectFile:function(f){var g=b(this.id);g.oW('requestSelectFile',{file:f,scrollTo:1});},closePopup:function(){if(!this.inPopup)return;b(this.id).element.getDocument().getWindow().$.close();},openFolder:function(f,g){var h=b(this.id);g=g.replace(/\/$/,'');f=f.toLowerCase();for(var i=0;i<h.folders.length;i++){var j=h.folders[i];if(j.getPath().replace(/\/$/,'')==g&&f==j.type.toLowerCase()){h.oW('requestSelectFolder',{folder:j});h.oW('requestShowFolderFiles',{folder:j});return;}}},setUiColor:function(f){b(this.id).setUiColor(f);},execCommand:function(f){b(this.id).execCommand(f);}};(function(){window.CKFinder=function(g,h){if(g)for(var i in g){if(!g.hasOwnProperty(i))continue;if(typeof g[i]=='function'&&i!='callback')continue;this[i]=g[i];}this.callback=h;};function f(g){var h=1;while(CKFinder._.instanceConfig[h])h++;CKFinder._.instanceConfig[h]=g;return h;};CKFinder.prototype={create:function(g){var h='ckf'+Math.random().toString().substr(2,9);document.write('<span id="'+h+'"></span>');g=a.tools.extend(a.jd.call(this),g,true);var i=a.replace(h,g,CKFinder);this.api=i.cg;return i.cg;},appendTo:function(g,h){h=a.tools.extend(a.jd.call(this),h,true);var i=a.appendTo(g,h,CKFinder);this.api=i.cg;return i.cg;},replace:function(g,h){h=a.tools.extend(a.jd.call(this),h,true);var i=a.replace(g,h,CKFinder);this.api=i.cg;return i.cg;},popup:function(g,h){var q=this;g=g||'80%';h=h||'70%';if(typeof g=='string'&&g.length>1&&g.substr(g.length-1,1)=='%')g=parseInt(window.screen.width*parseInt(g,10)/100,10);if(typeof h=='string'&&h.length>1&&h.substr(h.length-1,1)=='%')h=parseInt(window.screen.height*parseInt(h,10)/100,10);if(g<200)g=200;if(h<200)h=200;var i=parseInt((window.screen.height-h)/2,10),j=parseInt((window.screen.width-g)/2,10),k='location=no,menubar=no,toolbar=no,dependent=yes,minimizable=no,modal=yes,alwaysRaised=yes,resizable=yes,width='+g+',height='+h+',top='+i+',left='+j,l=a.env.webkit?'about:blank':'',m=window.open(l,'CKFinderpopup',k,true);if(!m)return false;q.width=q.height='100%';var n='<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd"><html><head><title>CKFinder 2</title><style type="text/css">body, html, iframe, #ckfinder { margin: 0; padding: 0; border: 0; width: 100%; height: 100%; overflow: hidden; }</style></head><body></body></html>',o=new a.dom.document(m.document);o.$.open();if(a.env.isCustomDomain())o.$.domain=window.document.domain;o.$.write(n);o.$.close();try{var p=navigator.userAgent.toLowerCase();if(p.indexOf(' chrome/')== -1){m.moveTo(j,i);m.resizeTo(g,h);}m.focus();return q.appendTo(o.bH());}catch(r){return q.appendTo(o.bH());}return false;}};CKFinder._={};CKFinder._.instanceConfig=[];CKFinder.lang={};CKFinder.version='2.3.1';CKFinder.revision='2516';CKFinder.addPlugin=function(g,h,i){var j={bM:i||[]};if(typeof h=='function')h={appReady:h};for(var k in h){if(!h.hasOwnProperty(k))continue;if(k!='connectorInitialized'&&k!='uiReady')j[k]=h[k];}j.bz=function(l){if(l.config.readOnly&&j.readOnly===false)return null;if(h.connectorInitialized)l.on('connectorInitialized',function(m){var n=h.connectorInitialized;if(n)n.call(n,l.cg,m.data.xml);},null,null,1000);if(h.connectorResponse)l.on('connectorResponse',function(m){var n=h.connectorResponse;if(n)n.call(n,l.cg,m.data.xml);});if(h.galleryCallback)l.on('launchGallery',function(m){var n=h.galleryCallback;if(n)m.data.bx=n.call(n,l.cg,m.data.selected,m.data.files);});if(h.uiReady)l.on('uiReady',function(){var m=h.uiReady;m.call(m,l.cg);},null,null,1000);if(h.appReady)l.on('appReady',function(){var m=h.appReady;m.call(m,l.cg);},null,null,1000);};a.plugins.add(g,j);};CKFinder.getPluginPath=function(g){return a.plugins.getPath(g);};CKFinder.addExternalPlugin=function(g,h,i){a.plugins.tR(g,h,i);};CKFinder.setPluginLang=function(g,h,i){a.plugins.rX(g,h,i);};CKFinder.dialog={add:function(g,h){if(typeof h=='function')h=a.tools.override(h,function(i){return function(j){return i(j.cg);};});a.dialog.add(g,h);}};CKFinder.tools={};CKFinder.env={};CKFinder.dom={};CKFinder.create=function(g,h,i,j,k){var l;if(g!==null&&typeof g==='object'){l=new CKFinder();for(var m in g)l[m]=g[m];}else{l=new CKFinder();l.basePath=g;if(h)l.width=h;if(i)l.height=h;if(j)l.selectActionFunction=j;if(k)l.callback=k;}return l.create();};CKFinder.popup=function(g,h,i,j,k){var l;if(g!==null&&typeof g==='object'){l=new CKFinder();for(var m in g)l[m]=g[m];}else{l=new CKFinder();l.basePath=g;if(j)l.selectActionFunction=j;if(k)l.callback=k;}return l.popup(h,i);};CKFinder.setupFCKeditor=function(g,h,i,j){var k,l;if(h!==null&&typeof h==='object'){l=f(h);k=new CKFinder();for(var m in h){k[m]=h[m];if(m=='width'){var n=k[m]||800;if(typeof n=='string'&&n.length>1&&n.substr(n.length-1,1)=='%')n=parseInt(window.screen.width*parseInt(n,10)/100,10);g.Config.LinkBrowserWindowWidth=n;g.Config.ImageBrowserWindowWidth=n;g.Config.FlashBrowserWindowWidth=n;}else if(m=='height'){var o=k[m]||600;if(typeof o=='string'&&o.length>1&&o.substr(o.length-1,1)=='%')o=parseInt(window.screen.height*parseInt(o,10)/100,10);g.Config.LinkBrowserWindowHeight=o;g.Config.ImageBrowserWindowHeight=o;g.Config.FlashBrowserWindowHeight=o;}}}else{k=new CKFinder();k.basePath=h;}var p=k.basePath;if(p.substr(0,1)!='/'&&p.indexOf('://')== -1)p=document.location.pathname.substring(0,document.location.pathname.lastIndexOf('/')+1)+p;p=a.lj.call(k,p);var q=p.indexOf('?')!== -1?'&':'?';if(l){p+=q+'configId='+l;q='&';}g.Config.LinkBrowserURL=p;g.Config.ImageBrowserURL=p+q+'type='+(i||'Images');g.Config.FlashBrowserURL=p+q+'type='+(j||'Flash');var r=p.substring(0,1+p.lastIndexOf('/'));g.Config.LinkUploadURL=r+'core/connector/'+CKFinder.config.connectorLanguage+'/connector.'+CKFinder.config.connectorLanguage+'?command=QuickUpload&type=Files';g.Config.ImageUploadURL=r+'core/connector/'+CKFinder.config.connectorLanguage+'/connector.'+CKFinder.config.connectorLanguage+'?command=QuickUpload&type='+(i||'Images');g.Config.FlashUploadURL=r+'core/connector/'+CKFinder.config.connectorLanguage+'/connector.'+CKFinder.config.connectorLanguage+'?command=QuickUpload&type='+(j||'Flash');};CKFinder.setupCKEditor=function(g,h,i,j){if(g===null){for(var k in CKEDITOR.instances)CKFinder.setupCKEditor(CKEDITOR.instances[k],h,i,j);CKEDITOR.on('instanceCreated',function(t){CKFinder.setupCKEditor(t.editor,h,i,j);});return;}var l,m;if(h!==null&&typeof h==='object'){m=f(h);l=new CKFinder();for(var n in h){l[n]=h[n];if(n=='width'){var o=l[n]||800;if(typeof o=='string'&&o.length>1&&o.substr(o.length-1,1)=='%')o=parseInt(window.screen.width*parseInt(o,10)/100,10);g.config.filebrowserWindowWidth=o;}else if(n=='height'){var p=l[n]||600;if(typeof p=='string'&&p.length>1&&p.substr(p.length-1,1)=='%')p=parseInt(window.screen.height*parseInt(p,10)/100,10);g.config.filebrowserWindowHeight=p;}}}else{l=new CKFinder();l.basePath=h;}var q=l.basePath;if(q.substr(0,1)!='/'&&q.indexOf('://')== -1)q=document.location.pathname.substring(0,document.location.pathname.lastIndexOf('/')+1)+q;q=a.lj.call(l,q);var r=q.indexOf('?')!== -1?'&':'?';if(m){q+=r+'configId='+m;r='&';}g.config.filebrowserBrowseUrl=q;g.config.filebrowserImageBrowseUrl=q+r+'type='+(i||'Images');g.config.filebrowserFlashBrowseUrl=q+r+'type='+(j||'Flash');var s=q.substring(0,1+q.lastIndexOf('/'));g.config.filebrowserUploadUrl=s+'core/connector/'+CKFinder.config.connectorLanguage+'/connector.'+CKFinder.config.connectorLanguage+'?command=QuickUpload&type=Files';g.config.filebrowserImageUploadUrl=s+'core/connector/'+CKFinder.config.connectorLanguage+'/connector.'+CKFinder.config.connectorLanguage+'?command=QuickUpload&type='+(i||'Images');g.config.filebrowserFlashUploadUrl=s+'core/connector/'+CKFinder.config.connectorLanguage+'/connector.'+CKFinder.config.connectorLanguage+'?command=QuickUpload&type='+(j||'Flash');};})();if(!a.event){a.event=function(){};a.event.du=function(f,g){var h=a.event.prototype;for(var i in h){if(f[i]==undefined)f[i]=h[i];}};a.event.prototype=(function(){var f=function(h){var i=h.kk&&h.kk()||h._||(h._={});return i.cC||(i.cC={});},g=function(h){this.name=h;this.dF=[];};g.prototype={mi:function(h){for(var i=0,j=this.dF;i<j.length;i++){if(j[i].fn==h)return i;}return-1;}};return{on:function(h,i,j,k,l){var m=f(this),n=m[h]||(m[h]=new g(h));if(n.mi(i)<0){var o=n.dF;if(!j)j=this;if(isNaN(l))l=10;var p=this,q=function(s,t,u,v){var w={name:h,jN:this,application:s,data:t,jO:k,stop:u,cancel:v,removeListener:function(){p.removeListener(h,i);}};i.call(j,w);return w.data;};q.fn=i;q.nT=l;for(var r=o.length-1;r>=0;r--){if(o[r].nT<=l){o.splice(r+1,0,q);return;}}o.unshift(q);}},oW:(function(){var h=false,i=function(){h=true;},j=false,k=function(l){j=l?2:true;};return function w(l,m,n,o){if(typeof m=='function'){o=m;m=null;}else if(typeof n=='function'){o=n;n=null;}if(l!='mousemove')a.log('[EVENT] '+l,m,o);var p=f(this)[l],q=h,r=j;h=j=false;if(p){var s=p.dF;if(s.length){s=s.slice(0);for(var t=0;t<s.length;t++){var u=s[t].call(this,n,m,i,k);if(typeof u!='undefined')m=u;if(h||j&&j!=2)break;}}}var v=j||(typeof m=='undefined'?false: !m||typeof m.result=='undefined'?m:m.result);if(typeof o==='function'&&j!=2)v=o.call(this,j,m)||v;h=q;j=r;return v;};})(),cr:function(h,i,j){var k=this.oW(h,i,j);delete f(this)[h];return k;},removeListener:function(h,i){var j=f(this)[h];if(j){var k=j.mi(i);if(k>=0)j.dF.splice(k,1);}},mF:function(){var h=f(this);for(var i=0;i<h.length;i++)h[i].dF=[];},rC:function(h){var i=f(this)[h];return i&&i.dF.length>0;}};})();}if(!a.application){a.kZ=0;a.fc=1;a.qE=2;a.application=function(f,g,h,i){var j=this;j._={instanceConfig:f,element:g};j.ff=h||a.kZ;a.event.call(j);j.iI(i);};a.application.replace=function(f,g,h){var i=f;if(typeof i!='object'){i=document.getElementById(f);if(!i){var j=0,k=document.getElementsByName(f);while((i=k[j++])&&i.tagName.toLowerCase()!='textarea'){}}if(!i)throw '[CKFINDER.application.replace] The element with id or name "'+f+'" was not found.';}return new a.application(g,i,a.fc,h);};a.application.appendTo=function(f,g,h){if(typeof f!='object'){f=document.getElementById(f);if(!f)throw '[CKFINDER.application.appendTo] The element with id "'+f+'" was not found.';}return new a.application(g,f,a.qE,h);};a.application.prototype={iI:function(){var f=a.application.eb||(a.application.eb=[]);f.push(this);},oW:function(f,g,h){return a.event.prototype.oW.call(this,f,g,this,h);},cr:function(f,g,h){return a.event.prototype.cr.call(this,f,g,this,h);}};a.event.du(a.application.prototype,true);}if(!a.env){a.env=(function(){var f=navigator.userAgent.toLowerCase(),g=window.opera,h={ie:
