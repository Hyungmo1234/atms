package com.attmng.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.attmng.domain.AttendanceVO;
import com.attmng.dto.AttendanceDTO;

@Service
public interface AttendanceDAO {
   public AttendanceVO AttendancePOST(AttendanceDTO dto) throws Exception;
   public List<AttendanceVO> AttendanceGET(String sessionID, String month, int deleteFlag) throws Exception;
   //public List<AttendanceVO> ExcelGet(String sessionID, String date) throws Exception;
}