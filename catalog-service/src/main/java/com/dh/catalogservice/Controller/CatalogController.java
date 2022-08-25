package com.dh.catalogservice.Controller;

import com.dh.catalogservice.Model.CatalogDto;
import com.dh.catalogservice.Service.ICatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@RestController
@RequestMapping("/catalogs")
public class CatalogController {

	@Value("${server.port}")
	private String port;

	private ICatalogService catalogService;

	@Autowired
	public CatalogController(ICatalogService catalogService) {
		this.catalogService = catalogService;
	}

	@GetMapping("/{genre}")
	ResponseEntity<CatalogDto> getCatalogByGenre(@PathVariable String genre, HttpServletResponse response) {
		CatalogDto playlistDTO = catalogService.getCatalogByGenre(genre);
		response.addHeader("port", port);
		return Objects.isNull(playlistDTO)
				? new ResponseEntity<>(HttpStatus.NOT_FOUND)
				: new ResponseEntity<>(playlistDTO, HttpStatus.OK);
	}
}
