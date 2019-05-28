package com.attmng.dao;

import java.util.List;

public interface MemberInformationDAO {
	public List getMembersInfo() throws Exception;
	public List getMemberInfo(String name) throws Exception;
}
