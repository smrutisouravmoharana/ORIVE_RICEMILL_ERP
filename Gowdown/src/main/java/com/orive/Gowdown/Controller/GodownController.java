package com.orive.Gowdown.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.orive.Gowdown.Dto.Gowdown;
import com.orive.Gowdown.Service.GowdownService;


@RestController
@RequestMapping(value = "/gowdown")
public class GodownController {
	
	private Logger logger=LoggerFactory.getLogger(GodownController.class);

	@Autowired
	private GowdownService gowdownService;
	
	  @PostMapping(value = "/save")
	    public ResponseEntity<Gowdown> createGowdown(@RequestBody Gowdown gowdown) {
	        Gowdown created = gowdownService.createGowdown(gowdown);
	        return new ResponseEntity<>(created, HttpStatus.CREATED);
	    }

	    @GetMapping(value = "/get")
	    public ResponseEntity<List<Gowdown>> getAllGowdown() {
	        List<Gowdown> gowdowns = gowdownService.getAllGowdown();
	        return new ResponseEntity<>(gowdowns, HttpStatus.OK);
	    }

	    @GetMapping("/get/{godownId}")
	    public ResponseEntity<List<Gowdown>> getGowdownByIds(@PathVariable List<Long> godownId) {
	        List<Gowdown> gowdowns = gowdownService.getGodownById(godownId);
	        return new ResponseEntity<>(gowdowns, HttpStatus.OK);
	    }

	    @PutMapping("/update/{godownId}")
	    public ResponseEntity<Gowdown> updateGowdown(
	            @PathVariable Long godownId, @RequestBody Gowdown updatedDTO) {
	        Gowdown updated = gowdownService.updateGowdown(godownId, updatedDTO);
	        return new ResponseEntity<>(updated, HttpStatus.OK);
	    }

	    @DeleteMapping("/delete/{godownId}")
	    public ResponseEntity<Void> deleteGowdown(@PathVariable Long godownId) {
	        gowdownService.deleteGodown(godownId);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
}
