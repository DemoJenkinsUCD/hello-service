/*
 *    Copyright 2017 Information Control Company
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.icct.demo.hello.service;

import java.io.Serializable;

public class Message implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private String salutation;
	private String audience;
	
	public Message(String salutation, String audience)
	{
		this.salutation = salutation;
		this.audience = audience;
	}
	
	public String getSalutation() 
	{
		return salutation;
	}
	
	public void setSalutation(String salutation) 
	{
		this.salutation = salutation;
	}
	
	public String getAudience() 
	{
		return audience;
	}
	
	public void setAudience(String audience) 
	{
		this.audience = audience;
	}
}
