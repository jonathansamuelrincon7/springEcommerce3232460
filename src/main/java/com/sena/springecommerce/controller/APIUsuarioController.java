package com.sena.springecommerce.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.springecommerce.model.Usuario;
import com.sena.springecommerce.service.IUsuarioService;

@RestController
@RequestMapping("/apiusuarios")
public class APIUsuarioController {

	@Autowired
	private IUsuarioService usuarioService;

	@GetMapping("/list")
	public List<Usuario> getAllUsuarios() {
		return usuarioService.findAll();
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<Usuario> getUsuarioById(@PathVariable Integer id) {
		Optional<Usuario> usuario = usuarioService.findById(id);
		return usuario.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@PostMapping("/create")
	public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario) {
		usuario.setRol("User");
		Usuario savedUsuario = usuarioService.save(usuario);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedUsuario);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Usuario> updateUsuario(@PathVariable Integer id, @RequestBody Usuario userDetails) {
		Optional<Usuario> usuario = usuarioService.findById(id);
		if (!usuario.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		Usuario existingUser = usuario.get();
		existingUser.setNombre(userDetails.getNombre());
		existingUser.setEmail(userDetails.getEmail());
		existingUser.setPassword(userDetails.getPassword());
		existingUser.setDireccion(userDetails.getDireccion());
		existingUser.setTelefono(userDetails.getTelefono());
		existingUser.setRol(userDetails.getRol());

		usuarioService.update(existingUser);
		return ResponseEntity.ok(existingUser);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteUsuario(@PathVariable Integer id) {
		Optional<Usuario> usuario = usuarioService.findById(id);
		if (!usuario.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		usuarioService.delete(id);
		return ResponseEntity.ok().build();
	}
}
