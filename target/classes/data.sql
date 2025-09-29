INSERT INTO clientes (nombre, apellido, correo, create_at) VALUES 
('Juan', 'Pérez', 'juan.perez@email.com', '2024-02-01'),
('Luisa', 'Ramírez', 'luisa.ramirez@email.com', '2024-02-02'),
('Pedro', 'Sánchez', 'pedro.sanchez@email.com', '2024-02-03'),
('Ana', 'Gómez', 'ana.gomez@email.com', '2024-02-04'),
('Carlos', 'Díaz', 'carlos.diaz@email.com', '2024-02-05');

INSERT INTO producto (nombre, descripcion, p_unitario, stock) VALUES
('Teclado', 'Teclado mecánico RGB', '199.99', '50'),
('Mouse', 'Mouse inalámbrico ergonómico', '149.99', '120'),
('Laptop', 'Intel i7, 16GB RAM, SSD 512GB', '3499.99', '10'),
('Monitor', 'Monitor 27" 4K', '999.99', '25'),
('Auriculares', 'Auriculares Bluetooth', '299.99', '80');

INSERT INTO factura (id_cliente, subtotal, descuento_total, valor_total, fecha_compra) VALUES
(1, 349.98, 49.98, 300.00, '2024-03-01'),
(2, 3499.99, 0.00, 3499.99, '2024-03-02'),
(3, 149.99, 0.00, 149.99, '2024-03-03'),
(4, 1299.98, 99.98, 1200.00, '2024-03-04'),
(5, 299.99, 0.00, 299.99, '2024-03-05');

INSERT INTO detalle (id_factura, id_producto, cantidad, valor, descuento_unitario) VALUES
(1, 1, 1, 199.99, 25.00),
(1, 2, 1, 149.99, 24.98),
(2, 3, 1, 3499.99, 0.00),
(3, 2, 1, 149.99, 0.00),
(4, 4, 1, 999.99, 49.99),
(4, 5, 1, 299.99, 49.99),
(5, 5, 1, 299.99, 0.00);
