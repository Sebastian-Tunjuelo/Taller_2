#Proyecto_Taller
La idea es hacer un gestor de una tienda donde se pueda gestionar clientes, productos, ventas (factura por cada venta) implementando funciones del CRUD.
Para cada cliente se debe tener un ID, Nombre, Apellido, Email, Fecha_Creación.
Para cada producto se debe tener un ID, Nombre, Descripción, VlrUnitario y Stock.
Para cada venta (o factura) se tiene un encabezado donde se tiene Nro Venta, ID Cliente, Fecha, Hora, Subtotal, Descuento, Valor Total y un Detalle de los productos comprados donde por cada producto se tiene una línea o registro con el ID o NroItem, Nro Venta (Id encabezado) al cual pertenece, ID Producto, Cantidad, Valor, Descuento. 
Condiciones:
•	El ID para cada Cliente, es un numero entre 6 y 12 dígitos.
•	La fecha de creación del cliente no debe de ser mayor a la actual y máximo de hace 80 años
•	El ID para cada Producto y para cada Encabezado (o Factura) es una cadena de 5 Caracteres, donde cada carácter es un dígito y el ID para el primer producto registrado será 00001, los demás se generarán de manera automática siguiendo la secuencia
•	El ID para cada Detalle asociado a una factura, será un número generado automáticamente, iniciará en 1 e ira incrementando tantos detalles se asocien a una factura, pero cuando se vaya a registrar una factura nueva este debe de reinicializarse a 1.
•	Una vez se ingrese una cantidad de un producto, se debe de validar que se tenga esa disponibilidad. En caso de haberla se actualiza el stock de ese producto restando la cantidad que se va “facturar”, pero en caso de no haberla arroja un mensaje de error y muestra la cantidad disponible actualmente (stock del producto).
•	El Subtotal para cada detalle ingresado se calcula de acuerdo a la cantidad ingresada del producto por su VlrUnit
•	El Descuento para cada detalle ingresado se calculará dependiendo de la cantidad, pero se almacenará el valor a descontar del subtotal
Cantidad	% de Descuento
Menos de 10	No aplica
10 a 20	1%
21 a 30	3%
31 a 40	4%
41 a 50	5%
Más de 50	10%
•	El total para cada detalle es la resta del valor de descuento al subtotal.
•	Los valores de Fecha y hora, en la factura son automáticos y se generan al momento de crearla.
•	Al momento de registrar una venta se debe de validar si el ID del cliente ya está registrado previamente, sino mostrar un error para que se corrija el ID ingresado o se proceda con la validación.
•	Al momento de visualizar una factura se debe de ver la información de la siguiente Manera:
FACTURA DE VENTA NRO (ID ENCABEZADO)
Fecha de compra: (Fecha + Hora)
CLIENTE:	ID Cliente	(Nombre + Apellido)
DETALLES DE COMPRA
Item	Descripción	Cant	Vlr Unit	Subtotal	Dcto.	Total
						
						
						
SUBTOTAL	(Sumatoria de la columna Subtotal de la tabla Detalles de Compra)
DESCUENTO	(Sumatoria de la columna Descuento de la tabla Detalles de Compra)
TOTAL A PAGAR	SUBTOTAL - DESCUENTO
Importante aclarar que el resumen de compra corresponde a los registros en la entidad Detalle asociados a la factura y se muestra en manera de tabla, para mayor facilidad y estética. Para cada fila se tiene que el ítem es el nro de registro o ID, Descripción es el nombre del producto, Cantidad es el nro de unidades del producto a llevar, VlrUnit es el valor del producto, SubTotal es el valor neto de la línea, Descuento es el valor que se va a restar al SubTotal y el Total es el valor que el cliente va a pagar por esa cantidad de producto en esa línea. 

