package cn.itcast.a_helloworld;

import java.util.List;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;

public class HelloWorld {
	
	private ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
	
	/**
	 * 部署流程定义文件
	 */
	@Test
	public void deploymentProcessDefinition(){
		Deployment deployment = processEngine.getRepositoryService().createDeployment().name("helloworld入门程序").addClasspathResource("diagrams/helloworld.bpmn").addClasspathResource("diagrams/helloworld.png").deploy();
		System.out.println(deployment.getId());
		System.out.println(deployment.getName());
		System.out.println(deployment.getDeploymentTime());
	}
	
	/**
	 * 启动流程实例
	 */
	@Test
	public void startProcessInstance(){
		String processDefinitionKey = "helloworld";
		ProcessInstance processInstance = processEngine.getRuntimeService().startProcessInstanceByKey(processDefinitionKey);
		System.out.println("流程实例ID："+processInstance.getId());
		System.out.println("流程定义ID："+processInstance.getProcessDefinitionId());
	}
	
	/**
	 * 查询当前人的个人任务
	 */
	@Test
	public void findMyPersonalTask(){
		String assignee = "王五";
		List<Task> list = processEngine.getTaskService().createTaskQuery().taskAssignee(assignee).list();
		if(list!=null && list.size()>0){
			for(Task task:list){
				System.out.println("任务ID:"+task.getId());
				System.out.println("任务名称:"+task.getName());
				System.out.println("任务创建时间:"+task.getCreateTime());
				System.out.println("任务办理人:"+task.getAssignee());
				System.out.println("流程实例ID:"+task.getProcessInstanceId());
				System.out.println("执行对象ID:"+task.getExecutionId());
				System.out.println("流程定义ID:"+task.getProcessDefinitionId());
				System.out.println("####################################################################################");
			}
		}
		
	}
	
	
	/**
	 * 完成我的任务
	 */
	@Test
	public void completeMyPersonalTask(){
		String taskId = "302";
		processEngine.getTaskService().complete(taskId);
		
		System.out.println("完成任务Id："+taskId);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
