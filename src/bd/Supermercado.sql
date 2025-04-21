
-- Crear la base de datos
CREATE DATABASE supermercado;
USE supermercado;

SHOW TABLES;
DESC Categoria;
SELECT * FROM categoria;


-- Tabla de Categorías
CREATE TABLE categoria(
    categoria_id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    descripcion VARCHAR(255),
    activo BOOLEAN DEFAULT TRUE,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
 
RENAME TABLE proveedore TO provedor;

-- Tabla de Proveedores
CREATE TABLE provedor(
    proveedor_id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    contacto VARCHAR(100),
    telefono VARCHAR(20),
    email VARCHAR(100),
    direccion VARCHAR(255),
    activo BOOLEAN DEFAULT TRUE,
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Tabla de Productos (sin código de barras)
CREATE TABLE producto(
    producto_id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion VARCHAR(255),
    precio_compra DECIMAL(10, 2) NOT NULL,
    precio_venta DECIMAL(10, 2) NOT NULL,
    stock_minimo INT DEFAULT 10,
    categoria_id INT,
    proveedor_id INT,
    activo BOOLEAN DEFAULT TRUE,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (categoria_id) REFERENCES categoria(categoria_id) ON DELETE RESTRICT ON UPDATE CASCADE,
    FOREIGN KEY (proveedor_id) REFERENCES proveedore(proveedor_id) ON DELETE RESTRICT ON UPDATE CASCADE
);

-- Tabla de Clientes
CREATE TABLE cliente(
    cliente_id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    telefono VARCHAR(20),
    email VARCHAR(100) UNIQUE,
    direccion VARCHAR(255),
    fecha_nacimiento DATE,
    password VARCHAR(255) NOT NULL,
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    activo BOOLEAN DEFAULT TRUE
);

-- Tabla de Roles
CREATE TABLE roles(
    rol_id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL UNIQUE,
    descripcion VARCHAR(255)
);

-- Tabla de Empleados (sin documento)
CREATE TABLE empleado(
    empleado_id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    telefono VARCHAR(20),
    email VARCHAR(100) UNIQUE,
    direccion VARCHAR(255),
    fecha_contratacion DATE NOT NULL,
    salario DECIMAL(10, 2),
    rol_id INT,
    usuario VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    activo BOOLEAN DEFAULT TRUE,
    FOREIGN KEY (rol_id) REFERENCES roles(rol_id) ON DELETE RESTRICT ON UPDATE CASCADE
);

-- Tabla de Ventas
CREATE TABLE venta(
    venta_id INT AUTO_INCREMENT PRIMARY KEY,
    fecha_venta TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    total DECIMAL(10, 2) NOT NULL,
    descuento DECIMAL(10, 2) DEFAULT 0,
    impuesto DECIMAL(10, 2) DEFAULT 0,
    cliente_id INT,
    empleado_id INT NOT NULL,
    metodo_pago ENUM('Efectivo', 'Tarjeta', 'Transferencia', 'Otro'),
    estado ENUM('Completada', 'Anulada', 'Pendiente') DEFAULT 'Completada',
    FOREIGN KEY (cliente_id) REFERENCES cliente(cliente_id) ON DELETE RESTRICT ON UPDATE CASCADE,
    FOREIGN KEY (empleado_id) REFERENCES empleado(empleado_id) ON DELETE RESTRICT ON UPDATE CASCADE
);

-- Tabla de Detalles de Venta
CREATE TABLE detalles_venta (
    detalle_id INT AUTO_INCREMENT PRIMARY KEY,
    venta_id INT NOT NULL,
    producto_id INT NOT NULL,
    cantidad INT NOT NULL,
    precio_unitario DECIMAL(10, 2) NOT NULL,
    subtotal DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (venta_id) REFERENCES venta(venta_id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (producto_id) REFERENCES producto(producto_id) ON DELETE RESTRICT ON UPDATE CASCADE
);

-- Tabla de Inventario
CREATE TABLE inventario (
    inventario_id INT AUTO_INCREMENT PRIMARY KEY,
    producto_id INT NOT NULL,
    cantidad INT NOT NULL DEFAULT 0,
    fecha_actualizacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (producto_id) REFERENCES producto(producto_id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- Tabla de Permisos
CREATE TABLE permisos (
    permiso_id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL UNIQUE,
    descripcion VARCHAR(255)
);

-- Relación muchos a muchos entre roles y permisos
CREATE TABLE roles_permisos (
    rol_id INT NOT NULL,
    permiso_id INT NOT NULL,
    PRIMARY KEY (rol_id, permiso_id),
    FOREIGN KEY (rol_id) REFERENCES roles(rol_id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (permiso_id) REFERENCES permisos(permiso_id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- Índices para rendimiento
CREATE INDEX idx_productos_nombre ON producto(nombre);
CREATE INDEX idx_productos_categoria ON producto(categoria_id);
CREATE INDEX idx_ventas_fecha ON venta(fecha_venta);
CREATE INDEX idx_ventas_cliente ON venta(cliente_id);
CREATE INDEX idx_ventas_empleado ON venta(empleado_id);
CREATE INDEX idx_detalles_venta_producto ON detalles_venta(producto_id);
