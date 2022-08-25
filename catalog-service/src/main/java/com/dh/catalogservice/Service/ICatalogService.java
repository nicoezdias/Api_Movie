package com.dh.catalogservice.Service;

import com.dh.catalogservice.Model.CatalogDto;

public interface ICatalogService {

    CatalogDto getCatalogByGenre(String genere);
}
