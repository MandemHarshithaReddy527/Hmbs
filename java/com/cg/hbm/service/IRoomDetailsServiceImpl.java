/*package com.cg.hbm.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hbm.dao.IRoomDetailsRepository;
import com.cg.hbm.entites.RoomDetails;

@Service("")
public class IRoomDetailsServiceImpl implements IRoomDetailsService{
	
	@Autowired
	IRoomDetailsRepository uDao;

	@Override
	public List<RoomDetails> addRoomDetails(RoomDetails roomDetails) {
		uDao.saveAndFlush(roomDetails);
		return uDao.findAll();
	}

	@Override
	public RoomDetails updateRoomDetails(RoomDetails roomDetails) {
		uDao.saveAndFlush(roomDetails);
		return roomDetails;
	}

	@Override
	public List<RoomDetails> removeRoomDetails(int room_id){
		uDao.deleteById(room_id);
		return uDao.findAll();
	}

	@Override
	public List<RoomDetails> showAllRoomDetails() {
		return uDao.findAll();
	}

	@Override
	public RoomDetails showRoomDetails(int id) {
	Optional<RoomDetails>obj=uDao.findById(id);
	if(obj.isPresent())
	{
		return  obj.get();
	}
	else
		return null;
	}

	/*
	 * @Override public User showRoomDetails(Integer room_id) {
	 * if(uDao.findById(room_id).isPresent()) { return uDao.findById(user_id).get();
	 * } else { return null; }
	 * 
	 * }
	 */

	
//}
package com.cg.hbm.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hbm.entites.RoomDetails;
import com.cg.hbm.exceptions.*;
import com.cg.hbm.dao.IRoomDetailsRepository;

@Service
public class IRoomDetailsServiceImpl implements IRoomDetailsService{
	@Autowired
	IRoomDetailsRepository iDao;

	@Override
	public RoomDetails addRoomDetails(RoomDetails roomDetails) {
		return iDao.save(roomDetails);
	}

	@Override
	public RoomDetails updateRoomDetails(RoomDetails roomDetails) {
		return iDao.saveAndFlush(roomDetails);
	}

	@Override
	public RoomDetails removeRoomDetails(RoomDetails roomDetails) {
		iDao.deleteById(roomDetails.getRoom_id());
		return roomDetails;
	}

	@Override
	public List<RoomDetails> showAllRoomDetails() {
		return iDao.findAll();
	}

	@Override
	public RoomDetails showRoomDetails(int roomDetails_id) {
		return iDao.findById(roomDetails_id).get();
	}

}
