package com.example.akkodis.infraestructure.service;

import com.example.akkodis.infraestructure.model.PricesEntity;
import com.example.akkodis.infraestructure.repository.IpricesRepository;
import com.example.akkodis.application.utils.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Comparator;



@Service
public class PriceServiceImpl implements PriceService {
    @Autowired
    IpricesRepository repository;

    /**
     * Obtiene el precio por filtros de fecha, identificador de producto e identificador de cadena.
     *
     * @param date      Fecha de aplicación del precio
     * @param productId Identificador de producto
     * @param brandId   Identificador de cadena
     * @return Entidad PricesEntity correspondiente al precio filtrado por fecha, o null si no se encuentra ningún precio
     */
    @Override
    public PricesEntity getPriceByFilters(String date, int productId, int brandId) {
        return repository.findByBrandIdAndProductId(productId, brandId)
            .stream()
            .filter(p -> Tools.convertToDate(p.getEnd_Date()).isAfter(Tools.convertToDate(date))
                && Tools.convertToDate(p.getStart_Date()).isBefore(Tools.convertToDate(date)))
            .min(Comparator.naturalOrder())
            .orElse(null);
    }
}
