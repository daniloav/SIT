<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN">
<html>
    <head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>.:&nbsp;S&nbsp;I&nbsp;G&nbsp;E&nbsp;X&nbsp;:.</title>
<link rel="SHORTCUT ICON" href="Menu/IMAGENS/bbb.ico" type="image/x-icon">

<style type="text/css">
body { font: normal 62.5% verdana; }

ul.menubar{
  margin: 0px;
  padding: 0px;
  background-color: #FFFFFF; /* IE6 Bug */
  font-size: 100%;
}

ul.menubar .submenu{
  margin: 0px;
  padding: 0px;
  list-style: none;
  background-color: #FFFFFF;
  border: 1px solid #ccc;
  float:left;
}

ul.menubar ul.menu{
  display: none;
  position: absolute;
  margin: 0px;
}

ul.menubar a{
  padding: 5px;
  display:block;
  text-decoration: none;
  color: #777;
  padding: 5px;
}

ul.menu, ul.menu ul{
  margin: 0;
  padding: 0;
  border-bottom: 1px solid #ccc;
  width: 150px; /* Width of Menu Items */
  background-color: #FFFFFF; /* IE6 Bug */
}

ul.menu li{
  position: relative;
  list-style: none;
  border: 0px;
}

ul.menu li a{
  display: block;
  text-decoration: none;
  border: 1px solid #ccc;
  border-bottom: 0px;
  color: #777;
  padding: 5px 10px 5px 5px;
}

ul.menu li sup{
  font-weight:bold;
  font-size:7px;
  color: red;
}

/* Fix IE. Hide from IE Mac \*/
* html ul.menu li { float: left; height: 1%; }
* html ul.menu li a { height: 1%; }
/* End */

ul.menu ul{
  position: absolute;
  display: none;
  left: 149px; /* Set 1px less than menu width */
  top: 0px;
}

ul.menu li.submenu ul { display: none; } /* Hide sub-menus initially */

ul.menu li.submenu { background: transparent url(arrow.gif) right center no-repeat; }

ul.menu li a:hover { color: #E2144A; }

</style>

<script type="text/javascript">
function horizontal() {

   var navItems = document.getElementById("menu_dropdown").getElementsByTagName("li");

   for (var i=0; i< navItems.length; i++) {
      if(navItems[i].className == "submenu")
      {
         if(navItems[i].getElementsByTagName('ul')[0] != null)
         {
            navItems[i].onmouseover=function() {this.getElementsByTagName('ul')[0].style.display="block";this.style.backgroundColor = "#f9f9f9";}
            navItems[i].onmouseout=function() {this.getElementsByTagName('ul')[0].style.display="none";this.style.backgroundColor = "#FFFFFF";}
         }
      }
   }

}

</script>

</head>

    <body onload="horizontal();mueveReloj();">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br/><br/><br/><br/>

        
        <center>
            <ul id="menu_dropdown" class="menubar">

   <li class="submenu"><a href="arquivosDeInicioIndex/index.jsp">Home</a></li>
   <li class="submenu"><a href="#">Manter Usuários</a>
      <ul class="menu">
        <li><a href="manterUsuarios/manterUsuariosInserirForm.jsp">Adicionar Usuarios</a></li>
        <li><a href="manterUsuarios/manterUsuariosAlterarForm.jsp">Alterar Usuarios</a></li>
        <li><a href="manterUsuarios/manterUsuariosPesquisarPorNomeForm.jsp">Consultar Usuarios</a></li>
        <li><a href="manterUsuarios/manterUsuariosExcluirForm.jsp">Excluir Usuarios</a></li>
      </ul>
   </li>

   <li class="submenu"><a href="#">Manter Dizimos</a>
      <ul class="menu">
        <li><a href="manterDizimos/manterDizimosInserirFormNomeMembro.jsp">Inserir registro de Dizimo Por Nome</a></li>
        <li><a href="manterDizimos/manterDizimosInserirFormIdMembro.jsp">Inserir registro de Dizimo por ID</a></li>
        <li><a href="#">Alterar registro de dizimo</a></li>
        <li><a href="#">Consultar registro de dizimo por nome</a></li>
        <li><a href="#">Excluir Registro de dizimo</a></li>
        </ul>
   </li>

   <li class="submenu"><a href="#">Manter Fornecedores</a>
      <ul class="menu">
        <li><a href="manterFornecedores/manterFornecedoresInserirForm.jsp">Adicionar Fornecedor</a></li>
        <li><a href="#">Alterar fornecedor</a></li>
        <li><a href="#">Consultar fornecedor por nome<sup>novo</sup></a></li>
        <li><a href="#">Excluir fornecedor</a></li>
      </ul>
   </li>

   <li class="submenu"><a href="#">Manter Membros</a>
      <ul class="menu">        
        <li><a href="manterMembros/manterMembrosInserirForm.jsp">Adicionar Membro</a></li>
        <li><a href="manterMembros/manterMembrosAlterarForm.jsp">Alterar membros</a></li>        
        <li><a href="manterMembros/manterMembrosExcluirForm.jsp">Excluir Membro</a></li>
         <li><a href="manterMembros/manterMembrosPesquisarPorNomeForm.jsp">Consultar membros por nome</a></li>
      </ul>
   </li>
                <li class="submenu"><a href="#">Manter Ofertas</a>
      <ul class="menu">
        <li><a href="#">Registrar Oferta</a></li>
        <li><a href="#">Alterar registro de oferta</a></li>
        <li><a href="#">Exlcuir registro de oferta</a></li>
        <li><a href="#">Consultar registro de oferta</a></li>

      </ul>
   </li>
                   <li class="submenu"><a href="#">Manter Saídas</a>
      <ul class="menu">
        <li><a href="manterSaidas/manterSaidas/manterSaidasIndex.jsp">Registrar saída</a></li>
        <li><a href="#">Alterar registro de saída</a></li>
        <li><a href="#">Exlcuir registro de saída</a></li>
        <li><a href="#">Consultar registro de saída</a></li>

      </ul>
   </li>
             <li class="submenu"><a href="#">Relatorios</a>
      <ul class="menu">
        <li><a href="#">Relatorios</a></li>
      </ul>
   </li>


</ul><%@include file="../arquivosDeConfiguracaoDePagina/relogio.html"%>
        </center>
</body>
</html>
