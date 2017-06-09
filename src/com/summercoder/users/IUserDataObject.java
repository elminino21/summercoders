package com.summercoder.users;

public interface IUserDataObject 
{
	void setUserInfo(User user);
	User loadUser(long index);
	User loadUser(String password, String email);
}
