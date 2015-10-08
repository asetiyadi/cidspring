package com.wireless.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

import org.springframework.stereotype.Service;

import com.wireless.domain.UserBean;

@Service
public class UserService 
{
	public UserBean initializeUser()
	{
		UserBean user = new UserBean();
		
		// TODO: set based on user group from AD
		user.setUserName("csrint");
		user.setChannelType(UserBean.SALES_CHANNEL_CSR);
		user.setLocationId("7197");
		
		return user;
	}
	
	public UserBean isAuthenticated(String accountName, String password)
	{
		Hashtable<String, String> env = new Hashtable<String, String>();
		
		env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		env.put(Context.PROVIDER_URL, "ldap://sanbapvmadtest1:389");
		env.put(Context.SECURITY_AUTHENTICATION, "simple");
		env.put(Context.SECURITY_PRINCIPAL, accountName + "@ADTEST.DEV1.DOM");
		env.put(Context.SECURITY_CREDENTIALS, password);
		
		DirContext ctx = null;
		NamingEnumeration results = null;
		List<String> groups = new ArrayList();
		UserBean user = new UserBean();
		
		try
		{
			ctx = new InitialDirContext(env);
			
			SearchControls controls = new SearchControls();
			controls.setSearchScope(SearchControls.SUBTREE_SCOPE);
			
			results = ctx.search("DC=ADTEST,DC=DEV1,DC=DOM", "(&(objectClass=user)(sAMAccountName=" + accountName + "))", controls);
			
			while(results.hasMoreElements())
			{
				SearchResult searchResult = (SearchResult) results.next();
				Attributes attributes = searchResult.getAttributes();
				
				Attribute attr = attributes.get("cn");
				String cn = (String) attr.get();
				
				attr = attributes.get("memberof");
				NamingEnumeration<?> enumMemberOf = attr.getAll();

				while(enumMemberOf.hasMoreElements())
				{
					String memberOf = enumMemberOf.next().toString();
					List<String> temp = Arrays.asList(memberOf.split(","));
					
					groups.add(temp.get(0).substring(3)); 
				}
				
				System.out.println("Common name: " + cn);
				System.out.println(cn + " is member of: " + groups.toString());
			}
		}
		catch(NamingException ne)
		{
			throw new RuntimeException(ne);
		}
		finally
		{
			if(results != null)
			{
				try
				{
					results.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			if(ctx != null)
			{
				try
				{
					ctx.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}
		
		return user;
	}
}
