package com.adl.main.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adl.main.model.PlayerModel;
import com.adl.main.repository.PlayerRepository;

@RestController //Sudah sepaket controller dan response body.
public class TestingController {
	@Autowired
	PlayerRepository playerRepo;

	@GetMapping("/")
	public List<PlayerModel> getAllPlayer() {
		PlayerModel player = new PlayerModel();
		List<PlayerModel> lstPlayer = playerRepo.findAll();
		
		return lstPlayer;
	}
	
	@GetMapping("/{username}") //menggunakan anotasi PathVariabel
	public PlayerModel getPlayerUsername(@PathVariable("username") String username) {
		PlayerModel player = playerRepo.getPlayerUsername(username);
		
		return player;
	}
	
	@GetMapping("/search") //menggunakan anotasi RequestParam 
	public PlayerModel getPlayerUsernameRequest(@RequestParam(value="username") String username) {
		PlayerModel player = playerRepo.getPlayerUsername(username);
		
		return player;
	}
	
	@GetMapping("/kelas/{kelas}") //menggunakan anotasi PathVariabel
	public List<PlayerModel> getPlayerKelas(@PathVariable("kelas") String kelas) {
			PlayerModel player = new PlayerModel();
			List<PlayerModel> lstPlayer = playerRepo.getPlayerKelas(kelas);
			
			return lstPlayer;
	}
	
	@GetMapping("/searchkelas") //menggunakan anotasi RequestParam 
	public List<PlayerModel> getPlayerKelasRequest(@RequestParam(value="kelas") String kelas) {
		PlayerModel player = new PlayerModel();
		List<PlayerModel> lstPlayer = playerRepo.getPlayerKelas(kelas);
		
		return lstPlayer;
	}

//	@GetMapping("/")
//	public String testMethod() {
//		return "wadidaw";
//	}
	
//	@GetMapping("/")
//	public ResponseEntity<String> testMethod1() {
//		//return ResponseEntity.internalServerError().body("Couldn't access internal server error");
//		
//		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body("Mantap");
//	}
	
//	@GetMapping("/")
//	public ResponseEntity<List<PlayerModel>> getAllPlayer() {
//		PlayerModel player = new PlayerModel();
//		List<PlayerModel> lstPlayer = new ArrayList<PlayerModel>();
//		player.setKelas("Super");
//		player.setLevel("20");
//		player.setUsername("DragonKnight");
//		lstPlayer.add(player);
//		
//		PlayerModel player2 = new PlayerModel();
//		player2.setKelas("Common");
//		player2.setLevel("10");
//		player2.setUsername("Warrior");
//		lstPlayer.add(player2);
//		
//		return (ResponseEntity<List<PlayerModel>>)ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(lstPlayer);
//}
	
}