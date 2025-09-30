INSERT INTO clientes (id_cliente, nombre, apellido, correo, create_at, estado) VALUES
(1, 'Juan',  'Perez',  'juan.perez@example.com',  '2025-09-01', true),
(2, 'Ana',   'Gomez',  'ana.gomez@example.com',   '2025-08-20', true),
(3, 'Carlos','Lopez',  'carlos.lopez@example.com','2025-07-15', false);

INSERT INTO producto (id_producto, nombre, descripcion, p_unitario, stock, estado) VALUES
(1, 'Camiseta', 'Camiseta algodón talla M',    45000.00, 10, true),
(2, 'Pantalon', 'Pantalón jeans talla 32',     80000.00,  5, true),
(3, 'Gorra',    'Gorra visera plana',          25000.00, 20, true),
(4, 'Chaqueta', 'Chaqueta térmica talla L',   150000.00,  2, true);


INSERT INTO factura (id_cliente, subtotal, descuento_Total, valor_total, fecha_compra) VALUES
(1, 115000.00, 5000.00, 110000.00, '2025-09-30'),
(2, 230000.00, 15000.00, 215000.00, '2025-09-29');

INSERT INTO detalle (id_factura, id_producto, cantidad, valor, descuento_Unitario, subtotal, total) VALUES
( 1, 1, 2.0, 45000.00,   0.00,  90000.00,  90000.00),   
( 1, 3, 1.0, 25000.00, 5000.00, 25000.00, 20000.00),    
( 2, 2, 1.0, 80000.00,   0.00,  80000.00,  80000.00),   
( 2, 4, 1.0,150000.00,15000.00,150000.00,135000.00);    
