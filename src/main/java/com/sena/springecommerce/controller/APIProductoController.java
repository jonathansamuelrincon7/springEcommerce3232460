package com.sena.springecommerce.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.springecommerce.model.Producto;
import com.sena.springecommerce.service.IProductoService;
import com.sena.springecommerce.service.IUsuarioService;

@RestController
@RequestMapping("/apiproductos")
public class APIProductoController {

	@Autowired
	private IProductoService productoService;
	@Autowired
	private IUsuarioService usuarioService;

	// endpoint GET para obtener todos los productos
	@GetMapping("/list")
	public List<Producto> getAllProductos() {
		return productoService.findAll();

	}

	// Endpoint para obtener un producto por id
	@GetMapping("/Product/{id}")
	public ResponseEntity<Producto> getProductById(@PathVariable Integer id) {
		Optional<Producto> producto = productoService.get(id);
		return producto.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());

	}

}
