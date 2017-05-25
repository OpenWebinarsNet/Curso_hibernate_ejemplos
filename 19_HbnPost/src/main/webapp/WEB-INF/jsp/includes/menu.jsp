
<li role="presentation"
	${not empty param.inicio ? 'class="active"' : '' }><a href="/">Inicio</a></li>
<li role="presentation"
	${not empty param.autores ? 'class="active"' : '' }><a
	href="/autores">Autores</a></li>		
<li role="presentation"
	${not empty param.login ? 'class="active"' : '' }><a
	href="/signin">Login</a></li>

