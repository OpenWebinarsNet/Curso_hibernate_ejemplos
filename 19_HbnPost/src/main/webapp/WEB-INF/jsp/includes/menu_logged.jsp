
<li role="presentation"
	${not empty param.inicio ? 'class="active"' : '' }><a href="/">Inicio</a></li>
<li role="presentation"
	${not empty param.submit ? 'class="active"' : '' }><a
	href="/submit">Escribir un post</a></li>
<li role="presentation"
	${not empty param.autores ? 'class="active"' : '' }><a
	href="/autores">Autores</a></li>		
<li role="presentation">
	<div class="btn-group" style="padding-top: 5px;">
          <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
           ${param.usuario}&nbsp;<span class="caret"></span>
          </button>
          <ul class="dropdown-menu" role="menu">
            <li><a href="/logout">Salir</a></li>
          </ul>
        </div>
</li>

