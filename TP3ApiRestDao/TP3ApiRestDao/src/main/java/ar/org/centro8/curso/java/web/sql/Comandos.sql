use negocioWeb;
select * from clientes;
select * from articulos;

select 
    c.id idCliente,nombre,apellido,fenaci,tipoDocumento,numeroDocumento, telefono, email, comentarios, 
    idDireccion,calle,numero,piso,depto,torre,codigoPostal,ciudad,provincia,pais
    from clientes c join direcciones d on c.idDireccion = d.id;

create view V_articulos as
    select
    id,nombre,descripcion,tipo,especieRecomendada,costo,precio,stock,stockMinimo,stockMaximo,comentarios,activo from articulos;

select * from V_articulos;
