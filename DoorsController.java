package com.example;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DoorsController {
	
	DoorsDao doorsDao = new DoorsDao();

    @GetMapping("/doors/{id}")
    public ModelAndView doorsPageById(@PathVariable int id) throws ClassNotFoundException, SQLException {
        ModelAndView mav = new ModelAndView();
        try {
            Doors doors = doorsDao.getById(id);
            if (doors != null) {
                mav.setViewName("single-door");
                mav.addObject("doo", doors);
            }
            else {
                mav.setViewName("errorPage");
                mav.addObject("errorMessage", "Door with ID " + id + " not found!");
            }
        } catch (SQLException | ClassNotFoundException e) {
            mav.setViewName("errorPage");
            mav.addObject("errorMessage", "Door with ID " + id + " not found!");
        }
        return mav;
    }
   
    
	@GetMapping("/doors")
	public ModelAndView getAllDoors() throws ClassNotFoundException, SQLException{
		ModelAndView mav=new ModelAndView("doors");
		try {
			ArrayList<Doors> doors=doorsDao.getAllDoors();
			if(doors != null) {
				mav.addObject("doors", doors);
			}
			else {
			     mav.setViewName("emptyList");
	             mav.addObject(" Nu au fost gasite elemente in baza de date!");
			}
		}
		catch (SQLException e) {
			mav.setViewName("emptyList");
            mav.addObject(" Nu au fost gasite elemente in baza de date!");
        }
		
		return mav;
	}
	
	
	@GetMapping("/doors/create")
	public ModelAndView createDoors() {
		return new ModelAndView("createDoors");
	}
	@PostMapping("/doors/create")
	public ModelAndView createDoors(@RequestParam String material, @RequestParam double height, @RequestParam double width, @RequestParam Date installationDate) throws SQLException, IOException {
	Doors doors=new Doors(material,height,width,installationDate);
	doorsDao.insertDoor(doors);
	
	ModelAndView mav=new ModelAndView("doors");
	ArrayList<Doors> doors=doorsDao.getAllDoors();
	mav.addObject("doors", doors);
	return mav;
	}
}
