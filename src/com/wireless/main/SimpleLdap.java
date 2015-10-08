package com.wireless.main;

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

public class SimpleLdap {

	public static void main(String[] args) 
	{
		Hashtable<String, String> env = new Hashtable<String, String>();
		
		String accountName = "djamesmgr";
		
		env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		env.put(Context.PROVIDER_URL, "ldap://sanbapvmadtest1:389");
		env.put(Context.SECURITY_AUTHENTICATION, "simple");
		
		env.put(Context.SECURITY_PRINCIPAL, accountName + "@ADTEST.DEV1.DOM");
		//env.put(Context.SECURITY_PRINCIPAL, "ISRADAdmin@ADTEST.DEV1.DOM,ou=system");
		//env.put(Context.SECURITY_PRINCIPAL, "uid=ISRADAdmin@ADTEST.DEV1.DOM,ou=system");
		//env.put(Context.SECURITY_PRINCIPAL, "sAMAccountName=ISRADAdmin@ADTEST.DEV1.DOM,ou=system");
		
		env.put(Context.SECURITY_CREDENTIALS, "Sp0tcast");
		
		//env.put(Context.SECURITY_PRINCIPAL, "uid=csrint@ADTEST.DEV1.DOM,ou=Cricket");
		//env.put(Context.SECURITY_CREDENTIALS, "Sp0tcast");
		
		DirContext ctx = null;
		NamingEnumeration results = null;
		List<String> groups = new ArrayList();
		
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
	}

}
