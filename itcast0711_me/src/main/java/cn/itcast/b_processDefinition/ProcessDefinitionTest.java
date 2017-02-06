package cn.itcast.b_processDefinition;

import java.io.File;
import java.io.FileInputStream;
import java.util.zip.ZipInputStream;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.Deployment;
import org.junit.Test;

public class ProcessDefinitionTest {

private ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
	
	/**
	 * 部署流程定义文件
	 */
	@Test
	public void deploymentProcessDefinition_classpath(){
		Deployment deployment = processEngine.getRepositoryService().createDeployment().name("流程定义").addClasspathResource("diagrams/helloworld.bpmn").addClasspathResource("diagrams/helloworld.png").deploy();
		System.out.println(deployment.getId());
		System.out.println(deployment.getName());
		System.out.println(deployment.getDeploymentTime());
	}
	
	/**部署流程定义*/
	@Test
	public void saveNewDeploye() {
		try {
			
			String url = "E:/workspaces/SYSWIN_ACTIVITI/itcast0711/target/classes/diagrams/test3.zip";
			//2：将File类型的文件转化成ZipInputStream流
			File file = new File(url);
			
			ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(file));
			processEngine.getRepositoryService().createDeployment()//创建部署对象
							.name("测试啊")//添加部署名称
							.addZipInputStream(zipInputStream)//
							.deploy();//完成部署
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
