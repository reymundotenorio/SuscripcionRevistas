/*Crear Base de Datos*/

Create database Revista;

/*Usar Base de Datos*/

Use Revista;


/*Tablas*/

Create Table Revista(
ID_Revista int not null auto_increment, -- Serial
Primary Key (ID_Revista),
Titulo Nvarchar (50) not null,
Cuota  Decimal (20,2) not null,
Matricula Decimal (20,2) not null,
Imagen_Revista Text not null,
Estado_Revista Nvarchar (10) default 'Activo' not null,
Check(Estado_Revista in ('Activo','Inactivo')),
Check(Cuota > 0),
Check (Matricula > 0)
);

Create Table Suscriptor(
ID_Suscriptor int not null auto_increment,/* unsigned not null auto_increment primary key,*/
Primary Key (ID_Suscriptor), 
Nombres Nvarchar (50) not null,
Apellidos Nvarchar (50) not null,
Direccion Nvarchar (200) not null,
Imagen_Suscriptor Text not null,
Estado_Suscriptor Nvarchar (10) default 'Activo' not null,
Check(Estado_Suscriptor in ('Activo','Inactivo'))
);


Create Table Suscripcion(
ID_Suscripcion int not null auto_increment,
Primary Key (ID_Suscripcion),
ID_Suscriptor int not null,
ID_Revista int not null,
Foreign Key (ID_Suscriptor) References Suscriptor(ID_Suscriptor),
Foreign Key  (ID_Revista) References Revista(ID_Revista),
Fecha Date not null,
#Fecha Datetime default current_timestamp not null,
Estado Nvarchar (10) default 'Activo' not null,
Check (Estado in ('Activo', 'Inactivo'))
);


Create Table Pago (
ID_Pago int not null auto_increment,
Primary Key (ID_Pago),
ID_Suscripcion int not null,
Foreign Key (ID_Suscripcion) References Suscripcion(ID_Suscripcion),
Fecha Datetime default current_timestamp not null,
No_Cuotas int not null,
Check(No_Cuotas > 0)
);


/*Procedimientos Almacenados*/

# Call AgregarRevista ('Ingenieria', 500, 250);
#Select * from Revista


Create Procedure AgregarRevista(
IN Titulo Nvarchar (50), IN Cuota Decimal (20,2), IN Matricula Decimal (20,2), Imagen_Revista Text
)
Insert Into revista
(Titulo,
Cuota,
Matricula,
Imagen_Revista
)
Values(Titulo, Cuota, Matricula, Imagen_Revista);


Create Procedure ModificarRevista(
IN ID_Revista int, IN Titulo Nvarchar (50), IN Cuota Decimal (20,2), IN Matricula Decimal (20,2), Imagen_Revista Text
)
Update revista
set Titulo = Titulo,
Cuota = Cuota,
Matricula = Matricula,
Imagen_Revista = Imagen_Revista
Where ID_Revista = ID_Revista
;

Create Procedure Activar_Revista(
IN ID_Revista int
)
Update revista
set Estado_Revista = 'Activo'
Where ID_Revista = ID_Revista
;


Create Procedure Desactivar_Revista(
IN ID_Revista int
)
Update revista
set Estado_Revista = 'Inactivo'
Where ID_Revista = ID_Revista
;

/*----------------*/

Create Procedure AgregarSuscriptor(
IN Nombres Nvarchar (50), IN Apellidos Nvarchar (50), IN Direccion Nvarchar (200), Imagen_Suscriptor Text
)
Insert Into suscriptor
(Nombres,
Apellidos,
Direccion,
Imagen_Suscriptor
)
Values(Nombres, Apellidos, Direccion, Imagen_Suscriptor)
;

Create Procedure ModificarSuscriptor(
IN ID_Suscriptor int, IN Nombres Nvarchar (50), IN Apellidos Nvarchar (50), IN Direccion Nvarchar (200), Imagen_Suscriptor Text
)
Update suscriptor
set Nombres = Nombres,
Apellidos = Apellidos,
Direccion = Direccion,
Imagen_Suscriptor = Imagen_Suscriptor
Where ID_Suscriptor = ID_Suscriptor
;

Create Procedure Activar_Suscriptor(
IN ID_Suscriptor int
)
Update suscriptor
set Estado_Suscriptor = 'Activo'
Where ID_Suscriptor = ID_Suscriptor
;


Create Procedure Desactivar_Suscriptor(
IN ID_Suscriptor int
)
Update suscriptor
set Estado_Suscriptor = 'Inactivo'
Where ID_Suscriptor = ID_Suscriptor
;

/* ------------------------- */


Create Procedure AgregarSuscripcion(
IN ID_Suscriptor int, IN ID_Revista int, IN Fecha Date
)
Insert Into suscripcion
(ID_Suscriptor,
ID_Revista,
Fecha
)
Values(ID_Suscriptor, ID_Revista, Fecha)
;

Create Procedure ModificarSuscripcion(
IN ID_Suscripcion int, IN ID_Suscriptor int, IN ID_Revista int, Fecha Date
)
Update suscripcion
set ID_Suscriptor = ID_Suscriptor,
ID_Revista = ID_Revista,
Fecha = Fecha
Where ID_Suscripcion = ID_Suscripcion
;

Create Procedure Activar_Suscripcion(
IN ID_Suscripcion int
)
Update suscripcion
set Estado = 'Activo'
Where ID_Suscripcion = ID_Suscripcion
;


Create Procedure Desactivar_Suscripcion(
IN ID_Suscripcion int
)
Update suscripcion
set Estado = 'Inactivo'
Where ID_Suscripcion = ID_Suscripcion
;



/* ------------------------- */


Create Procedure AgregarPago(
IN ID_Suscripcion int, IN No_Cuotas int, IN Fecha Date
)
Insert Into pago
(ID_Suscripcion,
No_Cuotas,
Fecha
)
Values(ID_Suscripcion, No_Cuotas, Fecha)
;

Create Procedure Modificar_Pago(
IN ID_Pago int, IN No_Cuotas int, IN Fecha Date
)
Update pago
set ID_Suscripcion = ID_Suscripcion,
No_Cuotas = No_Cuotas,
Fecha = Fecha
Where ID_Pago = ID_Pago
;

Create Procedure Reiniciar_Pago (
)
Update pago
set No_Cuotas = 0
;


/*Triggers*/

delimiter |
Create Trigger Desactivar_Suscripcion
After Update on revista
For Each Row
Begin

If (New.Estado_Revista = 'Inactivo') Then

Update suscripcion
Set Estado = 'Inactivo'
where ID_Revista = New.ID_Revista;

End If;

End;
|
delimiter ;

/* ------------------------- */

delimiter |
Create Trigger Desactivar_Suscripcion2
After Update on suscriptor
For Each Row
Begin

If (New.Estado_Suscriptor = 'Inactivo') Then

Update suscripcion
Set Estado = 'Inactivo'
where ID_Suscriptor = New.ID_Suscriptor;

End If;

End;
|
delimiter ;

/*drop trigger Desactivar_Suscripcion2;
drop trigger Desactivar_Suscripcion;*/

/*Vistas*/

Create View SuscripcionV as
(Select S.ID_Suscripcion as 'No', S.Fecha, C.Nombres, C.Apellidos, R.Titulo, S.Estado
from suscripcion S
Inner Join suscriptor C
On S.ID_Suscriptor = C.ID_Suscriptor
Inner Join revista R
On S.ID_Revista = R.ID_Revista
);

/* ------------------------- */

Create View SuscriptorV as
(Select S.ID_Suscriptor, S.Nombres, S.Apellidos, S.Direccion, S.Estado_Suscriptor
from suscriptor S
);

/* ------------------------- */

Create View RevistaV as
(Select V.ID_Revista, V.Titulo, V.Matricula, V.Cuota, V.Estado_Revista
from revista V
);

/* ------------------------- */

Create View CuotaV as
(Select S.ID_Suscripcion, R.Cuota
from suscripcion S
Inner Join revista R
On S.ID_Revista = R.ID_Revista
);

/* ------------------------- */

Create View PagoV as
(Select P.ID_Pago, P.Fecha, S.Nombres, S.Apellidos, S.Titulo , C.Cuota, P.No_Cuotas
from pago P
Inner Join suscripcionv S
On P.ID_Suscripcion = S.No
Inner Join CuotaV C
On P.ID_Suscripcion = C.ID_Suscripcion
);

/* ------------------------- */

Create View Reporte1 as
(Select  S.Titulo, Count(S.Titulo) as 'CantidadEjemplares'
from suscripcionv S
where S.Estado = 'Activo'
Group by S.Titulo
);

/* ------------------------- */


Create View CuotasAlDia as
(Select S.No ,sum(P.No_Cuotas) as 'NoCuotas', S.Nombres, S.Apellidos
from suscripcionv S
Inner Join pago P
On S.No = P.ID_Suscripcion
Group by S.No
);

/* ------------------------- */

Create View Reporte2 as
(Select  S.Titulo, S.Nombres, S.Apellidos, SU.Direccion, CD.NoCuotas
from suscripcionv S
Inner Join suscripcion SS
On S.No = SS.ID_Suscripcion
Inner Join suscriptor SU
On SS.ID_Suscriptor = SU.ID_Suscriptor
Inner Join cuotasaldia CD
On S.No = CD.No
#where (CD.NoCuotas >= 11) and S.Estado = 'Activo'
where S.Estado = 'Activo'
Order by S.Titulo
);

