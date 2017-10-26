<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>.:&nbsp;S&nbsp;I&nbsp;T&nbsp; - ICE SAMAMBAIA :.</title>
        <link rel="SHORTCUT ICON" href="jsp/arquivosDeConfiguracaoDePagina/IMAGENS/bbb.ico" type="image/x-icon">
        <style type="text/css">
</style>
        <style type="text/css">
           body
            {
                background-color: #FFFFFF;
                color: #000000;
            }
        </style>
        
    </head>

    <body >
        <div id="wb_Login1" style="position:absolute; left:675px; top:142px; width:284px; height:127px; z-index:1;" align="center">
<c:url value="/Login.do" var="urlLogin"/>
            <form method="post" action="${urlLogin}" >
                <table cellspacing="4" cellpadding="0" style="background-color:#EFF6FF;border-color:#BFDBFF;border-width:1px;border-style:solid;color:#006BF5;font-family:Verdana;font-size:11px;width:284px;height:127px;">
                    <tr>
                        <td colspan="2" align="center" height="17px" style="background-color:#BFDBFF;color:#006BF5;">Acesso ao sistema</td>
                    </tr>
                    <tr>
                        <td align="right" height="20px" width="119px" height="13px">Usu&aacute;rio:</td>
                        <td align="left"><input name="loginUser" type="text" style="width:100px;height:18px;background-color:#FFFFFF;border-color:#BFDBFF;border-width:1px;border-style:solid;color:#006BF5;font-family:Verdana;font-size:11px;"></td>
                    </tr>
                    <tr>
                        <td align="right" height="20px">Senha:</td>
                        <td align="left"><input name="senhaUser" type="password" style="width:100px;height:18px;background-color:#FFFFFF;border-color:#BFDBFF;border-width:1px;border-style:solid;color:#006BF5;font-family:Verdana;font-size:11px;"></td>
                    </tr>
                    <tr>
                        <td align="right" height="20px">Tipo de acesso:</td>                        
                        <td align="left" height="20px">
                        <select name="tipoAcesso">
 						<option value="votante">&nbsp;Membros&nbsp;</option>
  						<option value="congregante">&nbsp;Congregantes&nbsp;</option>
 						</select>                              
                        </td>
                    </tr>

                    <tr>
                        <td>&nbsp;</td><td align="left" valign="bottom"><input type="submit" value="Login" style="color:#006BF5;background-color:#FFFFFF;border-color:#BFDBFF;border-width:1px;border-style:solid;font-family:Verdana;font-size:11px;width:70px;height:20px;"></td>
                    </tr>
                </table>
                <script type="submit">
                    var ajax = new myAjax(  {contentLoading: "Aguarde, carregando..."});
                    ajax.load("jsp/arquivosDeInicioIndex/index.jsp", "ID da pagina");
                </script>
            </form>
        </div>
            
         <object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" width="541" height="130" id="FlashID" title="bannerInterno">
            <param name="movie" value="jsp/arquivosDeConfiguracaoDePagina/IMAGENS/animateframes_2.swf">
            <param name="quality" value="high">
            <param name="wmode" value="opaque">
            <param name="swfversion" value="8.0.35.0">
            <!-- This param tag prompts users with Flash Player 6.0 r65 and higher to download the latest version of Flash Player. Delete it if you don’t want users to see the prompt. -->
            <param name="expressinstall" value="Scripts/expressInstall.swf">
            <!-- Next object tag is for non-IE browsers. So hide it from IE using IECC. -->
            <!--[if !IE]>-->
            <object type="application/x-shockwave-flash" data="jsp/arquivosDeConfiguracaoDePagina/IMAGENS/animateframes_2.swf" width="250" height="130">
                <!--<![endif]-->
                <param name="quality" value="high">
                <param name="wmode" value="opaque">
                <param name="swfversion" value="8.0.35.0">
                <param name="expressinstall" value="Scripts/expressInstall.swf">
                <!-- The browser displays the following alternative content for users with Flash Player 6.0 and older. -->
                <div>
                    <h4>O conte&uacute;do desta p&aacute; requer a nova vers&atilde;o do Adobe Flash Player.</h4>
                    <p><a href="http://www.adobe.com/go/getflashplayer"><img src="http://www.adobe.com/images/shared/download_buttons/get_flash_player.gif" alt="Get Adobe Flash player" width="112" height="33" /></a></p>
                </div>
                <!--[if !IE]>-->
            </object>
            <!--<![endif]-->
        </object>
        

        
        <br/><br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <img src="jsp/arquivosDeConfiguracaoDePagina/IMAGENS/placa_branca_ices.jpg" />
        <BR/><BR/><BR/><BR/><BR/>
        <table width="650" border="0" bgcolor="#BFDBFF">
            <tr>
                <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&copy;2017 SIT - Sistema Integrado de Tesouraria - &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
            </tr>
            </table>
        <p>&nbsp;</p>
<html/>