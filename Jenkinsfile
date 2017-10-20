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

@Library('ucd_demo')
import createApplicationSnapshotInUrbanCode
import deployApplicationWithUrbanCode
import publishVersionToUrbanCode
import runCucumberTest
import runMvn

import com.icct.ucd.DeployApplication
import com.icct.ucd.DeployComponent
import com.icct.ucd.UrbanCodeConfiguration

pipeline
{
	agent any
	
	environment
	{
		UCDCONFIG = new UrbanCodeConfiguration('ucd_demo', 'https://ucd-server:8443', 'UCD-admin')
		COMPONENT = new DeployComponent('hello-service', "${WORKSPACE}/hello-service/target")
		APP = new DeployApplication('hello-world', 'Deploy all to Tomcat')
	}

	stages
	{
		stage('Build')
		{
			steps
			{
				dir('hello-service')
				{
					runMvn 'package'
				}
			}
		}
		
		stage('Publish')
		{
			steps
			{
				script
				{
					APP.addComponentVersion(COMPONENT, "${BUILD_NUMBER}")
				}
				publishVersionToUrbanCode UCDCONFIG, COMPONENT, APP.name, "${BUILD_NUMBER}"
			}
		}
		
		stage('Deploy')
		{
			steps
			{
				deployApplicationWithUrbanCode UCDCONFIG, APP, 'Dev'
			}
		}
		
		stage('Test')
		{
			steps
			{
				git 'file:///usr/demo/hello-test'
				runCucumberTest 'demo', 'test'
			}
		}
		
		stage('Snapshot')
		{
			steps
			{
				createApplicationSnapshotInUrbanCode 'hello-world', 'Dev', "hello.service${BUILD_NUMBER}"
			}
		}
	}
}
