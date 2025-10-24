package com.uwu.cliente.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.uwu.cliente.Entity.detalle;

@Repository
public interface detalleRepository extends JpaRepository<detalle,Long> {

    //devuelve los detalles de una factura
    //el : es para que la consulta espere ese valor
    //el param digamos que dice que use el valor que tiene:
    @Query("SELECT d FROM detalle d WHERE d.factura.nro_Venta = :facturaId")
    List<detalle> findByFacturaId(@Param("facturaId") Long facturaId);
}
